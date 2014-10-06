package model;

import model.service.AccountService;
import model.service.MainServiceBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/test/beanConfiguration-test.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class AccountCheckTest extends AbstractJUnit4SpringContextTests
{
	private MainServiceBean mainServiceBean;


	@Before
	public void setUp() throws Exception {
		mainServiceBean = (MainServiceBean) this.applicationContext.getBean("mainServiceBean");


		AccountService accountService = mainServiceBean.getAccountService();
		accountService.removeAll();


	}

	@After
	public void tearDown() throws Exception {

		AccountService accountService = this.mainServiceBean.getAccountService();
		accountService.removeAll();
	}

	@Test
	public void isWorkingAuthentication(){
		mainServiceBean.getAccountService().create( "konto1" );
		mainServiceBean.getAccountService().create( "konto2" );
		mainServiceBean.getAccountService().create( "konto3" );

		AccountCheck accountCheck=new AccountCheck(mainServiceBean.getAccountService().getAll());
		assertTrue( accountCheck.authenticate( "konto1" ) );
		assertTrue( !accountCheck.authenticate( "dupa" ) );

	}


}
