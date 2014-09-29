package model.dao.base;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by w.maciejewski on 2014-09-29.
 */

@Repository
public class BaseDao<T> {


    @PersistenceContext( )
    protected EntityManager entityManager;


    protected Class<T> clazz;

    protected BaseDao()
    {
        super();
    }

    public BaseDao( Class<T> clazz )
    {
        super();
        this.clazz = clazz;
    }

    public boolean contains( T entity )
    {
        return this.entityManager.contains( entity );
    }

    public T getById( Long id )
    {
        return this.entityManager.find( this.clazz, id );
    }

    public T getByName(String name){
        String entityName = this.clazz.getSimpleName();
        String queryText = "SELECT x from " + entityName + " x WHERE " + entityName.toLowerCase() + "_name=:name";
        final Query query = this.entityManager.createQuery( queryText );
        query.setParameter( "name", name );
        if( query.getResultList().size() == 1 )
        {
            return (T)query.getSingleResult();
        }
        else
        {
            throw new IllegalStateException( "No entities found" );
        }
    }

    public T create( T entity )
    {
        this.entityManager.persist( entity );
        this.entityManager.flush();
        return this.entityManager.merge( entity );
    }

    public void update(T entity){this.entityManager.merge(entity);}

    public void removeById( Long id )
    {
        T object = this.getById( id );
        if( object != null )
        {
            this.entityManager.remove( object );
        }
    }

    public List<T> getAll()
    {
        CriteriaQuery<T> query = this.entityManager.getCriteriaBuilder().createQuery( this.clazz );
        query.from( this.clazz );
        TypedQuery<T> typedQuery = this.entityManager.createQuery( query );
        return typedQuery.getResultList();
    }

    public void remove(T entity) {
        this.entityManager.remove( this.entityManager.contains( entity ) ? entity : this.entityManager.merge( entity ) );
    }
}
