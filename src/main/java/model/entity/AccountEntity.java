package model.entity;

import model.entity.base.BaseEntity;

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
public class AccountEntity  extends BaseEntity{


    @OneToMany( mappedBy = "account", cascade = CascadeType.MERGE)
    private Set<OfferEntity> offerSet = new HashSet<>();

    @Column( name = "account_name" )
    private String name;

    public AccountEntity()
    {
        super();
    }

    public AccountEntity( String name )
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
        if( !(object instanceof AccountEntity) )
            return false;
        final AccountEntity account = (AccountEntity)object;
        return account.getName().equals( this.name ) && account.getId().equals( this.getId() )
                && account.getCreated().equals( this.getCreated() )
                && account.getModified().equals( this.getModified() );
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
