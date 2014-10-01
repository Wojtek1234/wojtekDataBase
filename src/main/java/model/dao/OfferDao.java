package model.dao;

import model.dao.base.BaseDao;
import model.entity.Offer;

/**
 * Created by w.maciejewski on 2014-09-30.
 */
public class OfferDao extends BaseDao<Offer> {
	public OfferDao(Class<Offer> clazz){super(clazz);}
}