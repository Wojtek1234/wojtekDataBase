package model.views_model;

import controll.tables.OfferTableModel;

import java.util.Observable;

/**
 * Created by w.maciejewski on 2014-10-07.
 */
public class TableViewModel extends Observable
{
	private OfferTableModel offerTableModel;
	private int current_number=0;
	private int showAtOnce=10;



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

	public int getCurrent_number()
	{
		return current_number;
	}

	public void setCurrent_number( int current_number )
	{
		this.current_number = current_number;
	}

	public int getShowAtOnce()
	{
		return showAtOnce;
	}

	public void setShowAtOnce( int showAtOnce )
	{
		this.showAtOnce = showAtOnce;
	}
}
