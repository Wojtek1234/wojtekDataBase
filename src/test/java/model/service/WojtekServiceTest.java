package model.service;

import model.entity.AccountEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "classpath:/test/beanConfiguration-test.xml" } )
@Transactional
public class WojtekServiceTest extends AbstractJUnit4SpringContextTests {

    private static final String TEST_NAME = "kontoTestowe";

    @Test
    public void testServiceBean(){
        WojtekService wojtekService=(WojtekService)this.applicationContext.getBean("wojtekServiceBean");

        AccountService accountService = wojtekService.getAccountService();
        accountService.create( TEST_NAME );
        AccountEntity account = accountService.getAll().get( 0 );
        assertThat( account.getName(), equalTo( TEST_NAME ) );

        accountService.remove(account);
    }

}