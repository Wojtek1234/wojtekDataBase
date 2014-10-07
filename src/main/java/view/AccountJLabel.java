package view;

import model.Accounts.CurrentAccount;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by w.maciejewski on 2014-10-06.
 */
public class AccountJLabel extends JLabel implements Observer
{
	private JButton button;
	public AccountJLabel( String s, JButton addOfferButton )
	{
		super(s);
		this.button=addOfferButton;
	}

	@Override public void update( Observable observable, Object o )
	{
		if(o instanceof CurrentAccount)
		{

			if(!((CurrentAccount)o).isLogged()){
				this.button.setEnabled( false );
				this.setText( "Hello Guest");
			}else
			{
				this.setText( "Hello " + ((CurrentAccount)o).getName() );
				this.button.setEnabled( true );
			}
		}

	}
}
