package controll.tables;

import model.entity.Offer;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by w.maciejewski on 2014-10-07.
 */
public class OfferTableModel extends AbstractTableModel
{
	private final List<Offer> offerList;

	public OfferTableModel( List<Offer> offerList )
	{
		this.offerList = offerList;
	}

	@Override public int getRowCount()
	{
		return this.offerList.size( );
	}

	@Override public int getColumnCount()
	{
		return 3;
	}

	@Override public Object getValueAt(int rowIndex, int columnIndex )
	{
		switch( columnIndex ){
			case 0:{
				return offerList.get( rowIndex ).getName();
			}

			case 1:{
				return  offerList.get( rowIndex ).getCategory().getName();
			}

			case 2:{
				return offerList.get( rowIndex ).getPrice();
			}

			default:

				break;
		}
		return  null;
	}
	public Offer getOfferAtPosition(int row){
		return this.offerList.get( row );
	}
	@Override
	public String getColumnName( int columnIndex )
	{
		switch( columnIndex ){
			case 0:{
				return "Offer";
			}

			case 1:{
				return "Category";
			}

			case 2:{
				return "Current Price";
			}

			default:

				break;
		}
		return null;
	}

	public List<Offer> getOfferList()
	{
		return offerList;
	}
}
