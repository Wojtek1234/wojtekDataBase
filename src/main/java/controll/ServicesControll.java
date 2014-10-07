package controll;

import model.entity.Category;
import model.entity.Offer;
import model.service.AccountService;
import model.service.CategoryService;
import model.service.MainServiceBean;
import model.service.OfferService;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by w.maciejewski on 2014-10-06.
 */
public class ServicesControll
{
	private final MainServiceBean mainServiceBean;
	private final CategoryService categoryService;
	private final AccountService accountService;
	private final OfferService offerService;
	
	public ServicesControll( ApplicationContext context )
	{
		 mainServiceBean = (MainServiceBean)context.getBean( "mainServiceBean" );


		 categoryService = mainServiceBean.getCategoryService();
		 accountService = mainServiceBean.getAccountService();
		 offerService = mainServiceBean.getOfferService();
	
	}
	
	
	public List<Category> getCategorys(){
		return categoryService.getAll();
	}
	
	public ArrayList<Offer> getOffersByCategory( String name ){
		return new ArrayList<Offer>( categoryService.getOffersByCategory(name) );
	}
	public ArrayList<Offer> getOffersByCategory( String name,int pocz,int ilosc ){
		return new ArrayList<Offer>( categoryService.getOffersByCategory(name,pocz,ilosc) );
	}









}
