package model.service;

import model.dao.OfferDao;
import model.entity.AccountEntity;
import model.entity.CategoryEntity;
import model.entity.OfferEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by w.maciejewski on 2014-09-30.
 */
public  class OfferService {

    protected OfferDao getBaseDao() {
        return null;
    }
    private OfferDao offerDao;
    @Transactional
    public OfferEntity create(String name,AccountEntity accountEntity,CategoryEntity categoryEntity, Timestamp experiedDate,
                              double minimalPrice) {
         return  this.offerDao.create(new OfferEntity(name,accountEntity,categoryEntity,experiedDate,minimalPrice));
    }

    public List<OfferEntity> getAll()
    {
        return this.offerDao.getAll();
    }



    public OfferEntity getById( Long id )
    {
        return this.offerDao.getById( id );
    }

    @Transactional
    public void removeById( long id )
    {
        this.offerDao.removeById( id );
    }

    @Transactional
    public void remove( OfferEntity offerEntity )
    {
        this.offerDao.remove( offerEntity );
    }

    @Inject
    public void setBookDao( OfferDao bookDao )
    {
        this.offerDao = bookDao;
    }

    @Transactional
    public void refresh( List<OfferEntity> entityList )
    {
        for( OfferEntity entity : entityList )
        {
            this.offerDao.update( entity );
        }

        final List<OfferEntity> dbEntityList = this.offerDao.getAll();
        for( OfferEntity offerEntity : dbEntityList )
        {
            if( !entityList.contains( offerEntity ) )
            {
                this.offerDao.remove( offerEntity );
            }
        }
    }

    public void removeAll() {
        this.offerDao.removeAll();
    }
}
