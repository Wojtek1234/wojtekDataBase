package model.views_model;

import controll.tables.OfferTableModel;

import java.util.Observable;

/**
 * Created by w.maciejewski on 2014-10-07.
 */
public class TableViewModel extends Observable
{
	private OfferTableModel offerTableModel;



	public OfferTableModel getOfferTableModel()
	{
		return offerTableModel;
	}

	public void setOfferTableModel( OfferTableModel offerTableModel )
	{
		this.offerTableModel = offerTableModel;
		updateObserver();
	}


	public void updateObserver(){
		setChanged();
		this.notifyObservers(offerTableModel);
	}

}
