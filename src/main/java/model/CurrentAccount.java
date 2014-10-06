package model;

import java.util.Observable;

/**
 * Created by w.maciejewski on 2014-10-06.
 */
public class CurrentAccount extends Observable
{
	private static volatile CurrentAccount instance = null;

	private boolean isLogged=false;
	private String accountName;

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

	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName( String accountName )
	{

		this.accountName = accountName;
		setChanged();
		this.notifyObservers(accountName);
	}


}
