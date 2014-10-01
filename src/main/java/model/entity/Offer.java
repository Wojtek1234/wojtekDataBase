package model.entity;

import model.entity.base.Base;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by w.maciejewski on 2014-09-30.
 */
@Entity
@Table( name = "offer" )
@SequenceGenerator( name = "seq", sequenceName = "seq_off" )
@AttributeOverride(name = "id", column = @Column( name = "offer_id" ) )
public class Offer extends Base
{

	@Column( name = "offer_name" )
	private String name;
	@Column( name = "offer_date" )
	private Timestamp timestamp;
	@Column( name = "offer_price" )
	private double price;


	@ManyToOne( targetEntity = Account.class, cascade = CascadeType.MERGE)
	@JoinColumn( name = "offer_account_id" )
	private Account account;

	@ManyToOne( targetEntity = Category.class )
	@JoinColumn( name = "offer_category_id" )
	private Category category;

	public Offer()
	{
	}

	public Offer( String name, Account account, Category category, Timestamp timestamp, double price )
	{
		this.name = name;
		this.account = account;
		this.category = category;
		this.timestamp=timestamp;
		this.price=price;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public void setName(String name) {

	}


	public void setAccount(Account account ) {
		this.account = account;
	}

	public void setCategory(Category category ) {
		this.category = category;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Account getAccount() {
		return account;
	}

	public Category getCategory() {
		return category;
	}


	@Override
	public final boolean equals( Object object )
	{
		if( !(object instanceof Offer) )
			return false;
		final Offer offer = (Offer)object;
		return offer.getName().equals( this.name ) && offer.getId().equals( this.getId() )
				&& offer.getAccount().equals(this.getAccount())
				&& offer.getCategory().equals( this.getCategory())
				&& offer.getPrice()==this.getPrice();

	}

	@Override
	public final int hashCode()
	{
		int result;
		result = 20;
		result = 34 * result + this.getId().intValue();
		return result;
	}

}