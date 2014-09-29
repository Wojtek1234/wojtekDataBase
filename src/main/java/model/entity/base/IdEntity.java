package model.entity.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by w.maciejewski on 2014-09-29.
 */
@MappedSuperclass
public abstract class IdEntity implements EntityBasicInterface  {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seq" )
    private Long id;

    @Override
    public final Long getId()
    {
        return this.id;
    }

    @Override
    public final void setId( Long id )
    {
        this.id = id;
    }
}
