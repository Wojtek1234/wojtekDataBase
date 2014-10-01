package model.entity.base;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by w.maciejewski on 2014-09-29.
 */
public abstract class Base extends IdEntity {

    private static final long serialVersionUID = 1L;
	protected String entityName;
    @Column( nullable = false )
    @Temporal( TemporalType.TIMESTAMP )
    private Date created;
    @Column( nullable = false )
    @Temporal( TemporalType.TIMESTAMP )
    private Date modified;

    public final Date getCreated()
    {
        return this.created;
    }

    public final void setCreated( Date created )
    {
        this.created = created;
    }

    public final Date getModified()
    {
        return this.modified;
    }

    public final void setModified( Date modified )
    {
        this.modified = modified;
    }


}
