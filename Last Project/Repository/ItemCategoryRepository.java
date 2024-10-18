package com.pos.repository;

import com.pos.entity.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Long> {

    // Find category by name (case-insensitive)
    Optional<ItemCategory> findByCategoryNameIgnoreCase(String categoryName);

    // Check if a category exists by name (case-insensitive)
    boolean existsByCategoryNameIgnoreCase(String categoryName);

    // Custom query to find all categories whose name contains a certain string (case-insensitive)
    @Query("SELECT c FROM ItemCategory c WHERE LOWER(c.categoryName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<ItemCategory> searchByCategoryName(@Param("name") String name);
}
