package model.service.base;

import java.util.List;

/**
 * Created by w.maciejewski on 2014-09-29.
 */
public interface serviceInteface<T> {

    T create( String name );


    List<T> getAll();

    T getById( Long id );

    T getByName( String name );

    void refresh( List<T> entityList );

    void remove( T entity );

    boolean contains( T entity );
}
