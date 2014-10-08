package model.views_model;

import model.entity.Offer;

import java.util.Observable;

/**
 * Created by w.maciejewski on 2014-10-08.
 */
public class OfferViewModel extends Observable
{

	
	public void setOffer(Offer offer){
		updateObserver(offer);
	}
	private void updateObserver(Offer offer){
		setChanged();
		this.notifyObservers(offer);
	}
}
