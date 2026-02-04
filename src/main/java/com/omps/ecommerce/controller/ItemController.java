package com.omps.ecommerce.controller;

import com.omps.ecommerce.model.Item;
import com.omps.ecommerce.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing Item resources.
 *
 * Base URL: /v1/api/items
 * Provides CRUD operations for items.
 */
@RestController
@RequestMapping("/v1/api/items")
public class ItemController {

    // Service layer handles business logic
    @Autowired
    private ItemService service;

    /**
     * Add a new item.
     *
     * @param item Item data from request body
     * @return saved item with generated ID
     */
    @PostMapping("/add")
    public ResponseEntity<?> addItem(@RequestBody @Valid Item item) {
        return ResponseEntity.ok(service.addItem(item));
    }

    /**
     * Fetch item by ID.
     * Example: GET /v1/api/items/get/1
     *
     * @param id item ID
     * @return item details
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getItem(@PathVariable Long id) {
        Item item = service.getItem(id);
        return ResponseEntity.ok(item);
    }

    /**
     * Retrieve all available items.
     *
     * @return list of items
     */
    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(service.getAllItems());
    }

    /**
     * Delete item using ID.
     * Example: DELETE /v1/api/items/delete/1
     *
     * @param id item ID
     * @return confirmation message
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
        return ResponseEntity.ok("Item deleted Successfully");
    }

    /**
     * Update existing item.
     * Example: PUT /v1/api/items/update/1
     *
     * @param id item ID
     * @param item updated item details
     * @return updated item
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Item> updateItem(
            @PathVariable Long id,
            @RequestBody @Valid Item item) {

        Item updatedItem = service.updateItem(id, item);
        return ResponseEntity.ok(updatedItem);
    }
}
