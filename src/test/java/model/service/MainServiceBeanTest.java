package model.service;

import model.entity.Account;
import model.entity.Category;
import model.entity.Offer;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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
		CategoryService categoryService = this.mainServiceBean.getCategoryService();
		AccountService accountService = this.mainServiceBean.getAccountService();
		OfferService offerService = this.mainServiceBean.getOfferService();
		offerService.removeAll();
		accountService.removeAll();
		categoryService.removeAll();
	}

	@Test
	public void testAccountServiceBean() {


		AccountService accountService = this.mainServiceBean.getAccountService();
		accountService.create(TEST_NAME_ACCOUNT);
		Account account = accountService.getAll().get(0);
		assertThat(account.getName(), equalTo(TEST_NAME_ACCOUNT));
		accountService.remove(account);
	}


	@Test
	public void testCategoryServiceBean() {


		CategoryService categoryService = this.mainServiceBean.getCategoryService();
		categoryService.create(TEST_NAME_CATEGORY);

		categoryService.create(TEST_NAME_CATEGORY + "dwa");
		Category category = categoryService.getAll().get(0);
		Category category2 = categoryService.getAll().get(1);
		assertThat(category.getName(), equalTo(TEST_NAME_CATEGORY));
		assertNotSame(category.getId(), category2.getId());


		categoryService.remove(category);
		categoryService.remove(category2);
	}

	@Test(expected = javax.persistence.PersistenceException.class)
	public void setTestNameCategory() throws javax.persistence.PersistenceException {
		CategoryService categoryService = this.mainServiceBean.getCategoryService();
		categoryService.create(TEST_NAME_CATEGORY);
		categoryService.create(TEST_NAME_CATEGORY);
	}


	@Test
	public void testOfferServiceBean() {
		OfferService offerService = mainServiceBean.getOfferService();
		Category category = createCategory(TEST_NAME_CATEGORY);
		Account account = createAccount(TEST_NAME_ACCOUNT);

		java.sql.Timestamp data = java.sql.Timestamp.valueOf("2010-10-10 09:00:00");
		Offer offer = offerService.create(TEST_NAME_OFFER, account, category, data, 100,null);
		Category category2 = createCategory(TEST_NAME_CATEGORY + "2");

		Offer offer1 = offerService.create(TEST_NAME_OFFER, account, category2, data, 100,null);

		assertEquals( offer.getAccount().getId(), offer1.getAccount().getId());
		assertNotSame( offer.getCategory().getId(), offer1.getCategory().getId());
	}
	@Test
	public void testAccountServiceFunctions(){

		String testName1="test1",testName2="test2";
		Account account = createAccount(testName1);
		Account account2 = createAccount(testName2);

		AccountService accountService = this.mainServiceBean.getAccountService();
		Account accountTest1=accountService.getByName( testName1 );
		assertEquals(  account,accountTest1);
		Account accountTest2=accountService.getById( account2.getId() );
		assertEquals(  account2,accountTest2);





	}

	@Test
	public void testCategoryServiceFunctions(){

		String testName1="test1",testName2="test2";
		Category account = createCategory( testName1 );
		Category account2 = createCategory( testName2 );

		CategoryService categoryService = this.mainServiceBean.getCategoryService();
		Category accountTest1=categoryService.getByName( testName1 );
		assertEquals(  account,accountTest1);
		Category accountTest2=categoryService.getById( account2.getId() );
		assertEquals(  account2,accountTest2);

	}

	@Test
	public void testOfferServiceFunction(){

		Category category = createCategory(TEST_NAME_CATEGORY);
		Account account = createAccount(TEST_NAME_ACCOUNT);

		java.sql.Timestamp data = java.sql.Timestamp.valueOf("2010-10-10 09:00:00");

		String testName1="test1";

		Offer offer=mainServiceBean.getOfferService().create( testName1,account,category,data,1000,null);
		Offer offer2=mainServiceBean.getOfferService().getByName( testName1 );
		assertEquals( offer,offer2 );

	}


	@Test

	public void testGetOffersByCategory(){
		CategoryService categoryService=this.mainServiceBean.getCategoryService();
		String test="test1";
		Category category1=categoryService.create(test);
		String test2="test2";
		Category category2=categoryService.create( test2);
		Account account=createAccount( TEST_NAME_ACCOUNT );
		
		java.sql.Timestamp data = java.sql.Timestamp.valueOf("2010-10-10 09:00:00");
		double price=100;
		
		OfferService offerService=mainServiceBean.getOfferService();


		Set<Offer> offers = new HashSet<>();
		Set<Offer> offers2 = new HashSet<>();

		Set<Offer> offersFromCategory = new HashSet<>();
		Set<Offer> offersFromCategory2 = new HashSet<>();



		offers.add( offerService.create( "1",account,category1,data,price,null ) );
		offers.add( offerService.create( "2",account,category1,data,price ,null));
		offers.add( offerService.create( "3", account, category1, data, price ,null) );
		offers2.add( offerService.create( "4", account, category2, data, price ,null) );
		offers2.add( offerService.create( "5", account, category2, data, price ,null) );
		offers2.add( offerService.create( "6", account, category2, data, price,null ) );


		offersFromCategory=categoryService.getOffersByCategory( category1.getName() );
		offersFromCategory2=categoryService.getOffersByCategory( category2.getName() );

		assertEquals( offers, offersFromCategory );

		assertEquals(offers2,offersFromCategory2);


	}

	@Test

	public void testGetOffersByAccount(){
		CategoryService categoryService=mainServiceBean.getCategoryService();
		AccountService accountService=mainServiceBean.getAccountService();
		String test="test1";

		String test2="test2";
		Category category=categoryService.create( TEST_NAME_CATEGORY);
		Account account=createAccount( test );
		Account account2=createAccount( test2 );

		java.sql.Timestamp data = java.sql.Timestamp.valueOf("2010-10-10 09:00:00");
		double price=100;

		OfferService offerService=mainServiceBean.getOfferService();


		Set<Offer> offers = new HashSet<>();
		Set<Offer> offers2 = new HashSet<>();

		Set<Offer> offersFromCategory = new HashSet<>();
		Set<Offer> offersFromCategory2 = new HashSet<>();



		offers.add( offerService.create( "1",account,category,data,price ,null) );
		offers.add( offerService.create( "2",account,category,data,price ,null));
		offers.add( offerService.create( "3", account, category, data, price ,null) );
		offers2.add( offerService.create( "4", account2, category, data, price,null ) );
		offers2.add( offerService.create( "5", account2, category, data, price,null ) );
		offers2.add( offerService.create( "6", account2, category, data, price ,null) );


		offersFromCategory=accountService.getOffersByAccount( account.getName() );
		offersFromCategory2=accountService.getOffersByAccount( account2.getName() );

		assertEquals( offers, offersFromCategory );

		assertEquals(offers2,offersFromCategory2);


	}
	@Test
	public void testAdandReadImages(){
		Account account=createAccount( TEST_NAME_ACCOUNT);
		Category category=createCategory( TEST_NAME_CATEGORY );
		java.sql.Timestamp data = java.sql.Timestamp.valueOf("2010-10-10 09:00:00");
		double price=100;
		BufferedImage img=createImage();
		OfferService offerService=mainServiceBean.getOfferService();
		offerService.create( "1",account,category,data,price ,img);

		Offer offer=offerService.getAll().get( 0 );
		BufferedImage img1=offer.getImage();

		assertTrue( bufferedImagesEqual(img,img1) );

	}

	boolean bufferedImagesEqual(BufferedImage img1, BufferedImage img2) {
		if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
			for (int x = 0; x < img1.getWidth(); x++) {
				for (int y = 0; y < img1.getHeight(); y++) {
					if (img1.getRGB(x, y) != img2.getRGB(x, y))
						return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

	private BufferedImage createImage()
	{
		try
		{
			return ImageIO.read( getClass().getResourceAsStream( "/img/logo.png" ) );
		}
		catch( IOException e )
		{
			e.printStackTrace();
			return null;
		}

	}

	/*
		@Test
		public void testEfficiency(){
			CategoryService categoryService=mainServiceBean.getCategoryService();
			OfferService offerService=mainServiceBean.getOfferService();
			AccountService accountService=mainServiceBean.getAccountService();
			java.sql.Timestamp data = java.sql.Timestamp.valueOf("2010-10-10 09:00:00");
			double price=100;

			for(int i=0;i<20;i++){


			}
		}
	*/
	private Category createCategory(String name) {
		return mainServiceBean.getCategoryService().create(name);
	}

	private Account createAccount(String name) {
		return mainServiceBean.getAccountService().create(name);
	}


}
