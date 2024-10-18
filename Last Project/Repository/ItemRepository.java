package com.pos.repository;

import com.pos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    // Find items by name (case-insensitive)
    List<Item> findByNameIgnoreCase(String name);

    // Find items by price range
    List<Item> findByPriceBetween(double minPrice, double maxPrice);

    // Custom query to find items by category id
    @Query("SELECT i FROM Item i WHERE i.itemCategory.id = :categoryId")
    List<Item> findByCategoryId(@Param("categoryId") Long categoryId);

    // Find items by name and category id
    @Query("SELECT i FROM Item i WHERE i.name LIKE %:name% AND i.itemCategory.id = :categoryId")
    List<Item> findByNameAndCategory(@Param("name") String name, @Param("categoryId") Long categoryId);

    // Find an item by ID, with optional inclusion
    Optional<Item> findById(Long id);
}
