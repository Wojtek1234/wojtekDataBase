package model.service;

import model.dao.OfferDao;
import model.entity.Account;
import model.entity.Category;
import model.entity.Offer;
import model.service.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.sql.Timestamp;

/**
 * Created by w.maciejewski on 2014-09-30.
 */
public  class OfferService extends BaseService<Offer,OfferDao>
{

	private OfferDao offerDao;

	@Override
	protected OfferDao getBaseDao() {
        return this.offerDao;
    }

    @Transactional
    public Offer create(String name,Account account,Category category, Timestamp experiedDate,
                              double minimalPrice) {
        return this.offerDao.create(new Offer( name, account, category,experiedDate,minimalPrice ));
    }


	@Inject
	public void setOfferDao(OfferDao  offerDao){this.offerDao=offerDao;}


	@Transactional
	@Override public Offer create( String name )
	{
		return null;
	}
}
