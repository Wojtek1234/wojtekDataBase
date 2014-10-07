package model.Accounts;

import model.entity.Account;

import java.util.HashMap;
import java.util.List;

/**
 * Created by w.maciejewski on 2014-10-06.
 */
public class AccountCheck
{	
	private HashMap<AccountModel,Account> accountsMap;
	
	public AccountCheck(List<Account> accounts){
		accountsMap=new HashMap<>(  );
		for(Account account:accounts ){
			AccountModel accountModel=new AccountModel( account.getName() );
			accountsMap.put( accountModel,account );
		}

		
	}

	public boolean authenticate( AccountModel accountModel )
	{

		return ((this.accountsMap.containsKey( accountModel )));

	}
}
