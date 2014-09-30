package model.entity;

import model.entity.base.BaseEntity;

import javax.persistence.*;

/**
 * Created by w.maciejewski on 2014-09-30.
 */

@Entity
@Table( name = "category" )
@SequenceGenerator( name = "seq", sequenceName = "seq_category" )
@AttributeOverride(name = "id", column = @Column( name = "category_id" ) )
public class CategoryEntity extends BaseEntity {

    @Column( name = "category_name" )
    private String name;

    public CategoryEntity(){
        super();
    }
    public CategoryEntity(String name){
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
        if( !(object instanceof CategoryEntity) )
            return false;
        final CategoryEntity categoryEntity = (CategoryEntity)object;
        return categoryEntity.getName().equals( this.name ) && categoryEntity.getId().equals( this.getId() )
                && categoryEntity.getCreated().equals( this.getCreated() )
                && categoryEntity.getModified().equals( this.getModified() );
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
