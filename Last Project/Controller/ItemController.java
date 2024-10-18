package Security.Controller;


package com.pos.controller;

import com.pos.dto.ItemDTO;
import com.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/items")
@Validated
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Create a new item
    @PostMapping
    public ResponseEntity<ItemDTO> addItem(@Valid @RequestBody ItemDTO itemDTO) {
        ItemDTO createdItem = itemService.addItem(itemDTO);
        return ResponseEntity.status(201).body(createdItem);  // Return 201 Created for POST
    }

    // Get all items
    @GetMapping
    public ResponseEntity<List<ItemDTO>> getItems() {
        List<ItemDTO> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    // Get an item by ID
    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Long id) {
        ItemDTO item = itemService.getItemById(id);
        return ResponseEntity.ok(item);
    }

    // Update an existing item
    @PutMapping("/{id}")
    public ResponseEntity<ItemDTO> updateItem(@PathVariable Long id, @Valid @RequestBody ItemDTO itemDTO) {
        ItemDTO updatedItem = itemService.updateItem(id, itemDTO);
        return ResponseEntity.ok(updatedItem);
    }

    // Delete an item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();  // Return 204 No Content for DELETE
    }
}
