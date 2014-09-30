package model.service;

import javax.inject.Inject;

/**
 * Created by w.maciejewski on 2014-09-29.
 */
public class WojtekService {


    private AccountService accountService;
    private CategoryService categoryService;
    private OfferService offerService;

    public AccountService getAccountService()
    {
        return this.accountService;
    }

    @Inject
    public void setAccountService( AccountService accountService )
    {
        this.accountService = accountService;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }
    @Inject
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Inject
    public OfferService getOfferService() {
        return offerService;
    }
}
