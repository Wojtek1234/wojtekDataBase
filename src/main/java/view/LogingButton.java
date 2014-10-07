package view;

import model.Accounts.CurrentAccount;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by w.maciejewski on 2014-10-07.
 */
public class LogingButton extends JButton implements Observer
{
	public LogingButton( String s )
	{
		super( s );
	}

	@Override public void update( Observable observable, Object o )
	{
		if( o instanceof CurrentAccount )
			if(((CurrentAccount)o).isLogged())	this.setText( "Log off" );
			else this.setText( "Log in" );
	}
}




