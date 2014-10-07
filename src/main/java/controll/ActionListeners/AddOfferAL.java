package controll.ActionListeners;

import controll.ServicesControll;
import model.Accounts.CurrentAccount;
import model.CreateArrayOfCatNames;
import view.AddOfferDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by w.maciejewski on 2014-10-07.
 */
public class AddOfferAL implements ActionListener
{
	private final JFrame parent;
	private final String[] categorys;
	private CurrentAccount currentAccount=CurrentAccount.getInstance();
	private ServicesControll servicesControll;


	public AddOfferAL( JFrame parent ,ServicesControll servicesControll){
		this.parent=parent;
		this.servicesControll=servicesControll;
		CreateArrayOfCatNames createArrayOfCatNames=new CreateArrayOfCatNames(servicesControll.getCategorys());
		this.categorys=createArrayOfCatNames.getStrings();
	}

	@Override public void actionPerformed( ActionEvent actionEvent )
	{

		AddOfferDialog addOfferDialog=new AddOfferDialog( this.parent,this.categorys );
		addOfferDialog.setModal( true );
		addOfferDialog.setVisible( true );
	}
}
