package com.ItemDTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCategoryDTO {
    private Long id;

    @NonNull
    private String categoryName;

    // Constructor without the 'id' field for cases where the ID might be auto-generated
    public ItemCategoryDTO(@NonNull String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ItemCategoryDTO{" +
               "id=" + id +
               ", categoryName='" + categoryName + '\'' +
               '}';
    }
}
