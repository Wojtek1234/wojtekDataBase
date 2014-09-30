package model.service;

import model.entity.AccountEntity;
import model.entity.CategoryEntity;
import model.entity.OfferEntity;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/test/beanConfiguration-test.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class MainServiceBeanTest extends AbstractJUnit4SpringContextTests {

	private static final String TEST_NAME_ACCOUNT = "kontoTestowe";
	private static final String TEST_NAME_CATEGORY = "kategoriaTestowa";
	private static final String TEST_NAME_OFFER = "kategoriaTestowa";


	private MainServiceBean mainServiceBean;

	@org.junit.Before
	public void setUp() throws Exception {
		mainServiceBean = (MainServiceBean) this.applicationContext.getBean("mainServiceBean");

		CategoryService categoryService = mainServiceBean.getCategoryService();
		AccountService accountService = mainServiceBean.getAccountService();
		OfferService offerService = mainServiceBean.getOfferService();
		offerService.removeAll();
		accountService.removeAll();
		categoryService.removeAll();


	}

	@After
	public void tearDown() throws Exception {
		CategoryService categoryService = mainServiceBean.getCategoryService();
		AccountService accountService = mainServiceBean.getAccountService();
		OfferService offerService = mainServiceBean.getOfferService();
		offerService.removeAll();
		accountService.removeAll();
		categoryService.removeAll();
	}

	@Test
	public void testAccountServiceBean() {


		AccountService accountService = mainServiceBean.getAccountService();
		accountService.create(TEST_NAME_ACCOUNT);
		AccountEntity account = accountService.getAll().get(0);
		assertThat(account.getName(), equalTo(TEST_NAME_ACCOUNT));
		accountService.remove(account);
	}


	@Test
	public void testCategoryServiceBean() {


		CategoryService categoryService = mainServiceBean.getCategoryService();
		categoryService.create(TEST_NAME_CATEGORY);

		categoryService.create(TEST_NAME_CATEGORY + "dwa");
		CategoryEntity category = categoryService.getAll().get(0);
		CategoryEntity category2 = categoryService.getAll().get(1);
		assertThat(category.getName(), equalTo(TEST_NAME_CATEGORY));
		assertNotSame(category.getId(), category2.getId());


		categoryService.remove(category);
		categoryService.remove(category2);
	}

	@Test(expected = javax.persistence.PersistenceException.class)
	public void setTestNameCategory() throws javax.persistence.PersistenceException {
		CategoryService categoryService = mainServiceBean.getCategoryService();
		categoryService.create(TEST_NAME_CATEGORY);
		categoryService.create(TEST_NAME_CATEGORY);
	}


	@Test
	public void testOfferServiceBean() {
		OfferService offerService = mainServiceBean.getOfferService();
		CategoryEntity category = createCategory(TEST_NAME_CATEGORY);
		AccountEntity account = createAccount(TEST_NAME_ACCOUNT);

		java.sql.Timestamp data = java.sql.Timestamp.valueOf("2010-10-10 09:00:00 +00:00");
		OfferEntity offerEntity = offerService.create(TEST_NAME_OFFER, account, category, data, 100);
		CategoryEntity category2 = createCategory(TEST_NAME_CATEGORY + "2");

		OfferEntity offerEntity1 = offerService.create(TEST_NAME_OFFER, account, category2, data, 100);

		assertEquals(offerEntity.getAccountEntity().getId(), offerEntity1.getAccountEntity().getId());
		assertNotSame(offerEntity.getCategoryEntity().getId(), offerEntity1.getCategoryEntity().getId());
	}


	private CategoryEntity createCategory(String name) {
		return mainServiceBean.getCategoryService().create(name);
	}

	private AccountEntity createAccount(String name) {
		return mainServiceBean.getAccountService().create(name);
	}


}