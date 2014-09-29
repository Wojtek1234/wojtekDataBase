package model.dao;

import model.dao.base.BaseDao;
import model.entity.AccountEntity;

/**
 * Created by w.maciejewski on 2014-09-29.
 */
public class AccountDao extends BaseDao<AccountEntity> {
    public AccountDao(Class<AccountEntity> clazz){super(clazz);}
}
