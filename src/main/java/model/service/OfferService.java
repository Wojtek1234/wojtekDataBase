package model.service;

import model.dao.OfferDao;
import model.entity.AccountEntity;
import model.entity.CategoryEntity;
import model.entity.OfferEntity;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * Created by w.maciejewski on 2014-09-30.
 */
public  class OfferService {

    protected OfferDao getBaseDao() {
        return null;
    }

    @Transactional
    public OfferEntity create(String name,AccountEntity accountEntity,CategoryEntity categoryEntity, Timestamp experiedDate,
                              double minimalPrice) {
        return null;
    }

    public void removeAll() {
    }
}
