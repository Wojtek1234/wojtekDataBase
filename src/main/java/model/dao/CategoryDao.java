package model.dao;

import model.dao.base.BaseDao;
import model.entity.CategoryEntity;

/**
 * Created by w.maciejewski on 2014-09-30.
 */

public class CategoryDao extends BaseDao<CategoryEntity> {
    public CategoryDao(Class<CategoryEntity> clazz) {
        super(clazz);
    }
}


