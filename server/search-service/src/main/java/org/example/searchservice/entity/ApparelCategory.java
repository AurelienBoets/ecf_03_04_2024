package org.example.searchservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "apparel_category")
public class ApparelCategory implements Category {
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
