package model.OfferCreateModel;

import java.awt.image.BufferedImage;
import java.sql.Timestamp;

/**
 * Created by w.maciejewski on 2014-10-08.
 */
public class OfferTemplate
{
	private String accountName;
	private String offerName;
	private String categoryName;
	private double price;
	private java.sql.Timestamp date;
	private BufferedImage image;


	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName( String accountName )
	{
		this.accountName = accountName;
	}

	public String getCategoryName()
	{
		return categoryName;
	}

	public void setCategoryName( String categoryName )
	{
		this.categoryName = categoryName;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice( double price )
	{
		this.price = price;
	}

	public java.sql.Timestamp getDate()
	{
		return date;
	}

	public void setDate( Timestamp date )
	{
		this.date = date;
	}

	public BufferedImage getImage()
	{
		return image;
	}

	public void setImage( BufferedImage image )
	{
		this.image = image;
	}

	public String getOfferName()
	{
		return offerName;
	}

	public void setOfferName( String offerName )
	{
		this.offerName = offerName;
	}
}
