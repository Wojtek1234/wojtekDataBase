package model.entity;

import model.entity.base.BaseEntity;

import java.sql.Timestamp;

/**
 * Created by w.maciejewski on 2014-09-30.
 */
public class OfferEntity extends BaseEntity {

    private AccountEntity accountEntity;
    private CategoryEntity categoryEntity;
    private Timestamp timestamp;
    private double price;


    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }


    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }
}
