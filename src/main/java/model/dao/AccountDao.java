package model.dao;

import model.dao.base.BaseDao;
import model.entity.AccountEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by w.maciejewski on 2014-09-29.
 */
@Repository
public class AccountDao extends BaseDao<AccountEntity> {
    public AccountDao(Class<AccountEntity> clazz){super(clazz);}
}
