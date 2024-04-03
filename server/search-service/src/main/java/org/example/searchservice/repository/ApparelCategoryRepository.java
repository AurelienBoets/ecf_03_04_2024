package org.example.searchservice.repository;

import org.example.searchservice.entity.ApparelCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApparelCategoryRepository extends JpaRepository<ApparelCategory,Long> {
    List<ApparelCategory> findByTypeStartingWith(String start);
}
