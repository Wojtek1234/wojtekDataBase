package model.service;

import model.dao.CategoryDao;
import model.entity.CategoryEntity;
import model.service.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by w.maciejewski on 2014-09-30.
 */
public class CategoryService extends BaseService<CategoryEntity,CategoryDao>{

    private CategoryDao categoryDao;

    public CategoryService(){

    }
    @Override
    protected CategoryDao getBaseDao() {
        return categoryDao;
    }

    @Override
    @Transactional
    public CategoryEntity create(String name) {
        return this.categoryDao.create(new CategoryEntity(name));
    }
    @Inject
    public void setCategoryDao(CategoryDao categoryDao){
        this.categoryDao=categoryDao;
    }
}
