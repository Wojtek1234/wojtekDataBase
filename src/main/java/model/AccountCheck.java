package model;

import model.entity.Account;

import java.util.HashMap;
import java.util.List;

/**
 * Created by w.maciejewski on 2014-10-06.
 */
public class AccountCheck
{	
	private HashMap<String,Account> accountsMap;
	
	public AccountCheck(List<Account> accounts){
		accountsMap=new HashMap<>(  );
		for(Account account:accounts ){
			accountsMap.put( account.getName(),account );
		}

		
	}

	public boolean authenticate( String username )
	{
		return true;
	}
}
