package model.service;

import model.dao.AccountDao;
import model.entity.AccountEntity;
import model.service.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by w.maciejewski on 2014-09-29.
 */

@Service
public class AccountService extends BaseService<AccountEntity,AccountDao> {
    private AccountDao accountDao;

    public AccountService()
    {
    }

    @Override
    protected AccountDao getBaseDao()
    {
        return this.accountDao;
    }

    @Override
    @Transactional
    public AccountEntity create(String name)
    {
        return this.accountDao.create( new AccountEntity( name ) );
    }

    @Inject
    public void setAccountDao( AccountDao accountDao )
    {
        this.accountDao = accountDao;
    }
}
