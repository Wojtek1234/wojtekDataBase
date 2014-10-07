package model.Accounts;

import java.util.Observable;

/**
 * Created by w.maciejewski on 2014-10-06.
 */
public class CurrentAccount extends Observable
{
	private static volatile CurrentAccount instance = null;

	private boolean isLogged=false;
	private AccountModel accountModel;

	private CurrentAccount() {
	}

	public static CurrentAccount getInstance() {
		if (instance == null) {
			synchronized (CurrentAccount.class) {
				if (instance == null) {
					instance = new CurrentAccount();
				}
			}
		}
		return instance;
	}

	public boolean isLogged()
	{
		return isLogged;
	}

	public void setLogged( boolean isLogged )
	{
		this.isLogged = isLogged;
	}

	public AccountModel getAccountModel()
	{
		return accountModel;
	}

	public void setAccountModel( AccountModel accountModel )
	{
		this.accountModel=accountModel;
		setChanged();
		this.notifyObservers(accountModel.getName());
	}


}
