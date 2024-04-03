package org.example.searchservice.repository;

import org.example.searchservice.entity.BrandCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandCategoryRepository extends JpaRepository<BrandCategory,Long> {
    List<BrandCategory> findByTypeStartingWith(String start);
}
