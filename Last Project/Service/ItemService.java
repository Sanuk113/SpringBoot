
package com.pos.service;

import com.pos.dto.ItemDTO;
import com.pos.entity.Item;
import com.pos.entity.ItemCategory;
import com.pos.repository.ItemCategoryRepository;
import com.pos.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    public ItemDTO addItem(ItemDTO itemDTO) {
        ItemCategory category = itemCategoryRepository.findById(itemDTO.getCategoryId())
                                  .orElseThrow(() -> new RuntimeException("Category not found"));

        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setCategory(category);
        itemRepository.save(item);

        itemDTO.setId(item.getId());
        return itemDTO;
    }

    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll().stream().map(item -> {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setId(item.getId());
            itemDTO.setName(item.getName());
            itemDTO.setPrice(item.getPrice());
            itemDTO.setCategoryId(item.getCategory().getId());
            return itemDTO;
        }).collect(Collectors.toList());
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
