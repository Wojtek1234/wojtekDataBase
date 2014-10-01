package model.entity;

import model.entity.base.Base;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by w.maciejewski on 2014-09-30.
 */

@Entity
@Table( name = "category" )
@SequenceGenerator( name = "seq", sequenceName = "seq_category" )
@AttributeOverride(name = "id", column = @Column( name = "category_id" ) )
public class Category extends Base
{





    @Column( name = "category_name" )
    private String name;

	@OneToMany( mappedBy = "category", cascade = CascadeType.MERGE)
	private Set<Offer> offers = new HashSet<>();


	public void setOffers(Set<Offer> offerEntities){this.offers=offerEntities;}
	public Set<Offer> getOffers(){return this.offers;}



	public Category(){
        super();
    }
    public Category( String name ){
        this.name=name;
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
        if( !(object instanceof Category) )
            return false;
        final Category category = (Category)object;
        return category.getName().equals( this.name ) && category.getId().equals( this.getId() ) ;
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
