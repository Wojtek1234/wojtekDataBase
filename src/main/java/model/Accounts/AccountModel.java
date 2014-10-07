package model.Accounts;

/**
 * Created by w.maciejewski on 2014-10-07.
 */
public class AccountModel
{


	private String name;

	public AccountModel( String name )
	{
		this.name=name;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	@Override
	public final int hashCode()
	{
		int result;
		result = 18;
		result = 32 * result + this.getName().length()+ this.getName().hashCode();
		return result;
	}

	@Override
	public boolean equals(Object other){

		if(other instanceof AccountModel){
			if(((AccountModel)other).getName().equals( this.name )) return true;
			else return false;
		}
		else return false;

	}


}
