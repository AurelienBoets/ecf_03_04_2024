package org.example.searchservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="gender_category")
public class GenderCategory implements Category{
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
