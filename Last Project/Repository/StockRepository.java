package com.pos.repository;

import com.pos.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    // Find stock by item ID
    Optional<Stock> findByItemId(Long itemId);

    // Find all stocks where quantity is less than the specified value
    List<Stock> findByQuantityLessThan(int quantity);

    // Find stocks by item ID and quantity greater than a certain value
    @Query("SELECT s FROM Stock s WHERE s.item.id = :itemId AND s.quantity > :minQuantity")
    List<Stock> findByItemIdAndQuantityGreaterThan(@Param("itemId") Long itemId, @Param("minQuantity") int minQuantity);

    // Find all stocks for items belonging to a specific category
    @Query("SELECT s FROM Stock s WHERE s.item.itemCategory.id = :categoryId")
    List<Stock> findByCategoryId(@Param("categoryId") Long categoryId);

    // Find all stocks with zero quantity
    List<Stock> findByQuantityEquals(int quantity);

    // Find all stocks sorted by quantity in ascending order
    List<Stock> findAllByOrderByQuantityAsc();
}
