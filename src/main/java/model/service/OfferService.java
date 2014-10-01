package model.service;

import model.dao.OfferDao;
import model.entity.AccountEntity;
import model.entity.CategoryEntity;
import model.entity.OfferEntity;
import model.service.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.sql.Timestamp;

/**
 * Created by w.maciejewski on 2014-09-30.
 */
public  class OfferService extends BaseService<OfferEntity,OfferDao>
{

	private OfferDao offerDao;

	@Override
	protected OfferDao getBaseDao() {
        return this.offerDao;
    }

    @Transactional
    public OfferEntity create(String name,AccountEntity accountEntity,CategoryEntity categoryEntity, Timestamp experiedDate,
                              double minimalPrice) {
        return this.offerDao.create(new OfferEntity( name,accountEntity,categoryEntity,experiedDate,minimalPrice ));
    }


	@Inject
	public void setOfferDao(OfferDao  offerDao){this.offerDao=offerDao;}


	@Transactional
	@Override public OfferEntity create( String name )
	{
		return null;
	}
}
