package model.service;

import javax.inject.Inject;

/**
 * Created by w.maciejewski on 2014-09-29.
 */
public class WojtekService {


    private AccountService accountService;


    public AccountService getAccountService()
    {
        return this.accountService;
    }

    @Inject
    public void setAccountService( AccountService accountService )
    {
        this.accountService = accountService;
    }

}
