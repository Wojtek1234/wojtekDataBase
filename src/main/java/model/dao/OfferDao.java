package model.dao;

import model.dao.base.BaseDao;
import model.entity.OfferEntity;

/**
 * Created by w.maciejewski on 2014-09-30.
 */
public class OfferDao extends BaseDao<OfferEntity> {
	public OfferDao(Class<OfferEntity> clazz){super(clazz);}
}