package model.service.base;

import model.dao.base.BaseDao;
import model.entity.base.Base;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by w.maciejewski on 2014-09-29.
 */
@Service
public abstract class BaseService  <E extends Base, T extends BaseDao<E>> implements serviceInteface<E>{
    public BaseService()
    {
        super();
    }

    abstract protected T getBaseDao();

    @Override
    public List<E> getAll()
    {
        return this.getBaseDao().getAll();
    }

    @Override
    public E getById( Long id )
    {
        return this.getBaseDao().getById( id );
    }

    @Override
    public E getByName( String name )
    {
        return this.getBaseDao().getByName( name );
    }

    @Transactional
    @Override
    public void refresh( List<E> entityList )
    {
        //todo update on whole list : can we update only changed ?
        for( E entity : entityList )
        {
            this.getBaseDao().update( entity );
        }

        final Map<String, E> entityMap = this.createEntityMap( entityList );
        final Map<String, E> dbEntityMap = this.createEntityMap( this.getBaseDao().getAll() );

        for( Map.Entry<String, E> entry : dbEntityMap.entrySet() )
        {
            if( !entityMap.containsKey( entry.getKey() ) )
            {
                this.getBaseDao().remove( entry.getValue() );
            }
        }
    }

    private Map<String, E> createEntityMap( List<E> entityList )
    {
        Map<String, E> entityMap = new HashMap<>();
        for( E entity : entityList )
        {
            entityMap.put( entity.getName(), entity );
        }

        return entityMap;
    }

    @Transactional
    @Override
    public void remove( E entity )
    {
        this.getBaseDao().remove( entity );
    }

    @Override
    public boolean contains( E entity )
    {
        return this.getBaseDao().contains( entity );
    }

    @Transactional
    public void removeAll()
    {
        this.getBaseDao().removeAll();
    }

}
