package model.service;

import model.dao.AccountDao;
import model.entity.Account;
import model.entity.Offer;
import model.service.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by w.maciejewski on 2014-09-29.
 */

@Service
public class AccountService extends BaseService<Account,AccountDao> {
    private AccountDao accountDao;

    public AccountService()
    {
    }

    @Override
	@Transactional
    protected AccountDao getBaseDao()
    {
        return this.accountDao;
    }

    @Override
    @Transactional
    public Account create(String name)
    {
        return this.accountDao.create( new Account( name ) );
    }

    @Inject
    public void setAccountDao( AccountDao accountDao )
    {
        this.accountDao = accountDao;
    }


	@Transactional
	public Set<Offer> getOffersByAccount(String name){
		Set<Offer> offers=accountDao.getByName( name ).getOffers();
		Set<Offer> returnOffers=new HashSet<>(  );
		for(Offer off:offers){
			returnOffers.add( off );
		}
		return returnOffers;
	}

	@Transactional
	public Set<Offer> getOffersByAccount(long ID){

		Set<Offer> offers=accountDao.getById( ID ).getOffers();
		Set<Offer> returnOffers=new HashSet<>(  );
		for(Offer off:offers){
			returnOffers.add( off );
		}
		return returnOffers;

	}

	@Transactional
	public Set<Offer> getOffersByAccount(long ID,int number){

		Set<Offer> offers=accountDao.getById( ID ).getOffers();
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
	public Set<Offer> getOffersByAccount(String name,int number){

		Set<Offer> offers=accountDao.getByName( name ).getOffers();
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
	public Set<Offer> getOffersByAccount(String name,int number,int startNumber){

		Set<Offer> offers=accountDao.getByName( name ).getOffers();
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
	public Set<Offer> getOffersByAccount(long ID,int number,int startNumber){

		Set<Offer> offers=accountDao.getById( ID ).getOffers();
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
