package controll.tableListener;

import controll.tables.OfferTableModel;
import model.entity.Offer;
import model.views_model.OfferViewModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by w.maciejewski on 2014-10-08.
 */
public class TableSelectionListener implements ListSelectionListener,Observer
{
	private OfferViewModel offerViewModel;
	private List<Offer> offerList;
	public TableSelectionListener( OfferViewModel mainFrame ){
		this.offerViewModel=mainFrame;
	}


	@Override public void valueChanged( ListSelectionEvent listSelectionEvent )
	{
		ListSelectionModel model = (ListSelectionModel)listSelectionEvent.getSource();
		int firstIndex = listSelectionEvent.getFirstIndex();
		int lastIndex = listSelectionEvent.getLastIndex();
		boolean isAdjusting = model.getValueIsAdjusting();
		if(!isAdjusting){
			if (!model.isSelectionEmpty()) {

				int minIndex = model.getMinSelectionIndex();
				int maxIndex = model.getMaxSelectionIndex();
				for (int i = minIndex; i <= maxIndex; i++) {
					if (model.isSelectedIndex(i)) {
						this.offerViewModel.setOffer( this.offerList.get( i ) );
					}
				}
			}
		}

	}

	@Override public void update( Observable observable, Object o )
	{
		if(o instanceof OfferTableModel ){
			this.offerList=( (OfferTableModel)o ).getOfferList();
		}

	}
}
