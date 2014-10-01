package model.dao;

import model.dao.base.BaseDao;
import model.entity.Category;

/**
 * Created by w.maciejewski on 2014-09-30.
 */

public class CategoryDao extends BaseDao<Category> {
    public CategoryDao(Class<Category> clazz) {
        super(clazz);
    }
}


