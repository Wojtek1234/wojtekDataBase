package view;

import controll.tables.OfferTableModel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by w.maciejewski on 2014-10-07.
 */
public class TableOfOffers extends JTable implements Observer

{
	public TableOfOffers(AbstractTableModel abstractTableModel){
		super(abstractTableModel);
	}

	public TableOfOffers()
	{
		super();
	}

	@Override public void update( Observable observable, Object o )
	{
		if(o instanceof OfferTableModel){
			this.setModel( (OfferTableModel)o );
		}

	}
}
