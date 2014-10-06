package view;

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
		if(o instanceof String)
		{
			this.setText( "Hello "+(String)o );
			this.button.setEnabled( true );
		}
		if(o.equals( null )){
			this.button.setEnabled( false );
		}
	}
}
