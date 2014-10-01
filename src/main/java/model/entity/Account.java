package model.entity;

import model.entity.base.Base;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by w.maciejewski on 2014-09-29.
 */
@Entity
@Table( name = "account" )
@SequenceGenerator( name = "seq", sequenceName = "seq_account" )
@AttributeOverride(name = "id", column = @Column( name = "account_id" ) )
public class Account extends Base
{



    @Column( name = "account_name" )
    private String name;

	@OneToMany( mappedBy = "account", cascade = CascadeType.MERGE)
	private Set<Offer> offers = new HashSet<>();


	public void setOffers(Set<Offer> offerEntities){this.offers=offerEntities;}
	public Set<Offer> getOffers(){return this.offers;}



    public Account()
    {
        super();
    }

    public Account( String name )
    {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public final boolean equals( Object object )
    {
        if( !(object instanceof Account) )
            return false;
        final Account account = (Account)object;
        return account.getName().equals( this.name ) && account.getId().equals( this.getId() );

    }

    @Override
    public final int hashCode()
    {
        int result;
        result = 18;
        result = 32 * result + this.getId().intValue();
        return result;
    }

    @Override
    public final String toString()
    {
        return String.format( "%1$s %2$s %2$s %3$s", this.getId(), this.getName(), this.getCreated(),
                this.getModified() );
    }
}
