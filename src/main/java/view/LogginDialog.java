package view;

import model.Accounts.AccountCheck;
import model.Accounts.AccountModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by w.maciejewski on 2014-10-06.
 */
public class LogginDialog extends JDialog
{
	private JTextField textFieldUserName;
	private JLabel lbUsername;	
	private JButton btnLogin;
	private JButton btnCancel;
	private boolean succeeded;
	private AccountModel accountModel;

	public  LogginDialog( JFrame frame,final AccountCheck accountCheck){
		super(frame);
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;

		lbUsername = new JLabel("Username: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbUsername, cs);

		textFieldUserName = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add( textFieldUserName, cs);


		btnLogin = new JButton("Login");

		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				 accountModel=new AccountModel(getUsername());


				if (accountCheck.authenticate(accountModel)){
					JOptionPane.showMessageDialog(LogginDialog.this,
							"Hi " + getUsername() + "! You have successfully logged in.",
							"Login",
							JOptionPane.INFORMATION_MESSAGE);
					succeeded = true;
					dispose();
				} else {
					JOptionPane.showMessageDialog(LogginDialog.this,
							"Invalid username",
							"Login",
							JOptionPane.ERROR_MESSAGE);

					textFieldUserName.setText( "" );
					succeeded = false;

				}
			}
		});

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		JPanel bp = new JPanel();
		bp.add(btnLogin);
		bp.add(btnCancel);

		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(bp, BorderLayout.PAGE_END);

		pack();
		setResizable(false);
		setLocationRelativeTo(frame);
	}

	private String getUsername() {
		return textFieldUserName.getText().trim();
	}


	public boolean isSucceeded() {
		return succeeded;
	}

	public AccountModel getAccountModel( )
	{
		return this.accountModel;
	}
}

