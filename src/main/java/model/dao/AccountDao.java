package model.dao;

import model.dao.base.BaseDao;
import model.entity.Account;
import org.springframework.stereotype.Repository;

/**
 * Created by w.maciejewski on 2014-09-29.
 */
@Repository
public class AccountDao extends BaseDao<Account> {
    public AccountDao(Class<Account> clazz){super(clazz);}
}
