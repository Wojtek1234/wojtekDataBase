package model.service;

import model.dao.AccountDao;
import model.entity.Account;
import model.service.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

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
}
