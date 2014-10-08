package controll.ActionListeners;

import controll.ServicesControll;
import controll.tables.OfferTableModel;
import model.CreateArrayOfCatNames;
import model.views_model.TableViewModel;
import view.CategoryDialogChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by w.maciejewski on 2014-10-07.
 */
public class ShowByCategoryAL implements ActionListener
{
	private JFrame parent;
	private String[] categorys;
	private TableViewModel tableViewModel;
	private ServicesControll servicesControll;
	public ShowByCategoryAL( JFrame parent, ServicesControll servicesControll, TableViewModel tableViewModel ){
		this.parent=parent;
		this.servicesControll=servicesControll;
		createCategorys( servicesControll );
		this.tableViewModel=tableViewModel;
	}

	private String[] createCategorys( ServicesControll servicesControll )
	{
		CreateArrayOfCatNames createArrayOfCatNames=new CreateArrayOfCatNames(servicesControll.getCategorys());
		return createArrayOfCatNames.getStrings();
	}

	@Override public void actionPerformed( ActionEvent actionEvent )
	{
		this.categorys=createCategorys(servicesControll);
		CategoryDialogChooser categoryDialog=new CategoryDialogChooser( parent,categorys );
		categoryDialog.setModal( true );
		categoryDialog.setVisible( true );

		if(categoryDialog.doProceed()){

			proccedToTable( categoryDialog );
		}

	}

	private void proccedToTable( CategoryDialogChooser categoryDialog )
	{

		OfferTableModel offerTableModel=new OfferTableModel(servicesControll.getOffersByCategory( categoryDialog
				.getCategoryString(), tableViewModel.getCurrent_number(), tableViewModel.getShowAtOnce() ));

		tableViewModel.setOfferTableModel( offerTableModel );
	}

}
