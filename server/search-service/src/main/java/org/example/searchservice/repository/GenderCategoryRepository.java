package org.example.searchservice.repository;

import org.example.searchservice.entity.GenderCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenderCategoryRepository extends JpaRepository<GenderCategory,Long> {
    List<GenderCategory> findByTypeStartingWith(String start);
}
