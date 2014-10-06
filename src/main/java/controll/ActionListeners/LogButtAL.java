package controll.ActionListeners;

import model.AccountCheck;
import model.CurrentAccount;
import model.LogginDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by w.maciejewski on 2014-10-06.
 */
public class LogButtAL implements ActionListener
{
	private JFrame parent;
	private AccountCheck accountCheck;
	private final CurrentAccount currentAccount=CurrentAccount.getInstance();
	public LogButtAL(JFrame parent, AccountCheck accountCheck){
		this.parent=parent;
		this.accountCheck=accountCheck;
	}
	@Override public void actionPerformed( ActionEvent actionEvent )
	{
		LogginDialog logginDialog=new LogginDialog( parent,accountCheck );
		logginDialog.setModal( true );
		logginDialog.setVisible( true );

		if(logginDialog.isSucceeded()){

			currentAccount.setAccountName( logginDialog.getUsername() );

		}
	}
}
