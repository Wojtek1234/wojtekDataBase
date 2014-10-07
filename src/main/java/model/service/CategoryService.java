package model.service;

import model.dao.CategoryDao;
import model.entity.Category;
import model.entity.Offer;
import model.service.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by w.maciejewski on 2014-09-30.
 */
public class CategoryService extends BaseService<Category,CategoryDao>{

    private CategoryDao categoryDao;

    public CategoryService(){

    }
    @Override
    protected CategoryDao getBaseDao() {
        return categoryDao;
    }

    @Override
    @Transactional
    public Category create(String name) {
        return this.categoryDao.create(new Category(name));
    }


    @Inject
    public void setCategoryDao(CategoryDao categoryDao){
        this.categoryDao=categoryDao;
    }

	@Transactional
	public Set<Offer> getOffersByCategory(String name){
		Set<Offer> offers=categoryDao.getByName( name ).getOffers();
		Set<Offer> returnOffers=new HashSet<>(  );
		for(Offer off:offers){
			returnOffers.add( off );
		}
		return returnOffers;
	}

	@Transactional
	public Set<Offer> getOffersByCategory(long ID){

		Set<Offer> offers=categoryDao.getById( ID ).getOffers();
		Set<Offer> returnOffers=new HashSet<>(  );
		for(Offer off:offers){
			returnOffers.add( off );
		}
		return returnOffers;

	}

	@Transactional
	public Set<Offer> getOffersByCategory(long ID,int number){

		Set<Offer> offers=categoryDao.getById( ID ).getOffers();
		Set<Offer> returnOffers=new HashSet<>(  );
		int helpValue=0;
		for(Offer off:offers){
			returnOffers.add( off );
			helpValue++;
			if(helpValue==number) break;
		}
		return returnOffers;

	}
	@Transactional
	public Set<Offer> getOffersByCategory(String name,int number){

		Set<Offer> offers=categoryDao.getByName( name ).getOffers();
		Set<Offer> returnOffers=new HashSet<>(  );
		int helpValue=0;
		for(Offer off:offers){
			returnOffers.add( off );
			helpValue++;
			if(helpValue==number) break;
		}
		return returnOffers;

	}

	@Transactional
	public Set<Offer> getOffersByCategory(String name,int startNumber,int number){

		Set<Offer> offers=categoryDao.getByName( name ).getOffers();
		Set<Offer> returnOffers=new HashSet<>(  );
		int helpValue=0;
		for(Offer off:offers){

			if(helpValue<startNumber)helpValue++;
			else{
				helpValue++;
				returnOffers.add( off );
			}
			if((helpValue-startNumber)==number) break;
		}
		return returnOffers;

	}

	@Transactional
	public Set<Offer> getOffersByCategory(long ID,int startNumber,int number ){

		Set<Offer> offers=categoryDao.getById( ID ).getOffers();
		Set<Offer> returnOffers=new HashSet<>(  );
		int helpValue=0;
		for(Offer off:offers){

			if(helpValue<startNumber)helpValue++;
			else{
				helpValue++;
				returnOffers.add( off );
			}
			if((helpValue-startNumber)==number) break;
		}
		return returnOffers;

	}
}
