package model.entity;

import model.entity.base.BaseEntity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by w.maciejewski on 2014-09-30.
 */
@Entity
@Table( name = "offer" )
@SequenceGenerator( name = "seq", sequenceName = "seq_off" )
@AttributeOverride(name = "id", column = @Column( name = "offer_id" ) )
public class OfferEntity extends BaseEntity {

	@Column( name = "offer_name" )
	private String name;
	@Column( name = "offer_date" )
	private Timestamp timestamp;
	@Column( name = "offer_price" )
	private double price;


	@ManyToOne( targetEntity = AccountEntity.class, cascade = CascadeType.MERGE)
	@JoinColumn( name = "offer_account_id" )
	private AccountEntity accountEntity;

	@ManyToOne( targetEntity = CategoryEntity.class )
	@JoinColumn( name = "offer_category_id" )
	private CategoryEntity categoryEntity;

	public OfferEntity()
	{
	}

	public OfferEntity( String name, AccountEntity accountEntity, CategoryEntity  categoryEntity,Timestamp timestamp,double price )
	{
		this.name = name;
		this.accountEntity = accountEntity;
		this.categoryEntity = categoryEntity;
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


	public void setAccountEntity(AccountEntity accountEntity) {
		this.accountEntity = accountEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
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

	public AccountEntity getAccountEntity() {
		return accountEntity;
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}


	@Override
	public final boolean equals( Object object )
	{
		if( !(object instanceof OfferEntity) )
			return false;
		final OfferEntity offerEntity = (OfferEntity)object;
		return offerEntity.getName().equals( this.name ) && offerEntity.getId().equals( this.getId() )
				&& offerEntity.getAccountEntity().equals(this.getAccountEntity())
				&& offerEntity.getCategoryEntity().equals( this.getCategoryEntity())
				&& offerEntity.getPrice()==this.getPrice();

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