package com.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDTO {
    private Long id;

    @NonNull
    private int quantity;

    @NonNull
    private Long itemId;  // to reference the Item entity

    // Constructor for creating StockDTO without the 'id' field (for new stock entries)
    public StockDTO(@NonNull int quantity, @NonNull Long itemId) {
        this.quantity = quantity;
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "StockDTO{" +
               "id=" + id +
               ", quantity=" + quantity +
               ", itemId=" + itemId +
               '}';
    }

    // Custom method for updating stock quantity
    public void updateQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }
}
