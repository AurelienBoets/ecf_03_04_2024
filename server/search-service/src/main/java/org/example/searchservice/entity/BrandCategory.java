package org.example.searchservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_brand_category")
public class BrandCategory implements Category{
    @Id
    private long id;
    private String type;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getKeyword() {
        return type;
    }
}
