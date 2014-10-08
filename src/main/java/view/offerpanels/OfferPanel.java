package view.offerpanels;

import info.clearthought.layout.TableLayout;
import model.entity.Offer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by w.maciejewski on 2014-10-08.
 */
public class OfferPanel extends JPanel implements Observer
{
	private  JImageLabel jImageLabel;
	private  JLabel ownerLb,priceLb,ownerOfLb,priceOfLb;

	private final JButton btnBid;
	private TableLayout tableLayout;
	private double[][] size={{0.01,0.49,0.1,0.39,0.01},{0.1,0.7,0.15,0.05}};



	public OfferPanel()
	{
		this.setLayout( new TableLayout( size ));
		this.setBackground( Color.DARK_GRAY );
		try
		{
			jImageLabel=new JImageLabel(ImageIO.read( getClass().getResourceAsStream( "/nophoto.jpg" ) ) );
		
			this.add( jImageLabel,"1,1" );
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}

		GridLayout gl=new GridLayout(0,1);
		gl.setVgap( 10 );
		gl.setHgap( 10 );
		JPanel panelik = new JPanel(gl);
		panelik.setBackground( Color.DARK_GRAY );
		ownerLb=new JLabel("Owner");
		setLabel(ownerLb);
		panelik.add( ownerLb );

		ownerOfLb=new JLabel(" ");
		setLabel(ownerOfLb);
		panelik.add( ownerOfLb );

		priceLb=new JLabel("Current Price");
		setLabel(priceLb);
		panelik.add( priceLb);

		priceOfLb=new JLabel();
		setLabel(priceOfLb);
		panelik.add( priceOfLb );

		this.add(panelik,"3,1");

		btnBid=new JButton("bid");
		



		this.add( btnBid,"1,2" );
	}

	private void setLabel(JLabel lab)
	{
		lab.setForeground( Color.white );
		lab.setBorder( BorderFactory.createLineBorder( Color.black ) );
		lab.setHorizontalAlignment( JLabel.CENTER );
		lab.setVerticalAlignment( JLabel.CENTER );
	}

	private BufferedImage getPhoto(Offer offer){
		try{
			return offer.getImage();
		}catch(NullPointerException ne){
			try
			{
				return ImageIO.read( getClass().getResourceAsStream( "/nophoto.jpg" ) );
			}
			catch( IOException e )
			{
				e.printStackTrace();
				return null;
			}
		}
	}

	@Override public void update( Observable observable, Object o )
	{
		if(o instanceof Offer) setOffer((Offer)o);

	}

	private void setOffer(Offer offer){
		try{
			jImageLabel.setImg( offer.getImage() );
		}
		catch(NullPointerException ne){
			try
			{
				jImageLabel.setImg(ImageIO.read( getClass().getResourceAsStream( "/nophoto.jpg" ) ) );
				System.out.print( "tutaj" );
			}
			catch( IOException e )
			{
				e.printStackTrace();
				System.out.print( "tutaj2" );
			}
		}
		ownerOfLb.setText( offer.getAccount().getName() );
		priceOfLb.setText(String.valueOf(  offer.getPrice() ));


	}
}
