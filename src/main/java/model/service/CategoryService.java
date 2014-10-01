package model.service;

import model.dao.CategoryDao;
import model.entity.Category;
import model.service.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by w.maciejewski on 2014-09-30.
 */
public class CategoryService extends BaseService<Category,CategoryDao>{

    private CategoryDao categoryDao;

    public CategoryService(){

    }
    @Override
    protected CategoryDao getBaseDao() {
        return categoryDao;
    }

    @Override
    @Transactional
    public Category create(String name) {
        return this.categoryDao.create(new Category(name));
    }
    @Inject
    public void setCategoryDao(CategoryDao categoryDao){
        this.categoryDao=categoryDao;
    }
}
