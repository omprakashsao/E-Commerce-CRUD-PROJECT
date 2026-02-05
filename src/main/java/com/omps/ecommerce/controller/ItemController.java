package com.omps.ecommerce.controller;

import com.omps.ecommerce.model.Item;
import com.omps.ecommerce.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Add a new item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Item created successfully",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400",
                    description = "Invalid input data",
                    content = @Content(mediaType = "application/json"))
    })
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
    @Operation(summary = "Get item by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Item found",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404",
                    description = "Item not found",
                    content = @Content(mediaType = "application/json"))
    })
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
    @Operation(summary = "Get all items")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "List of items returned",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/get/all")
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
    @Operation(summary = "Delete item by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Item deleted successfully",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404",
                    description = "Item not found",
                    content = @Content(mediaType = "application/json"))
    })
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
    @Operation(summary = "Update item details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Item updated successfully",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404",
                    description = "Item not found",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400",
                    description = "Invalid input",
                    content = @Content(mediaType = "application/json"))
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<Item> updateItem(
            @PathVariable Long id,
            @RequestBody @Valid Item item) {

        Item updatedItem = service.updateItem(id, item);
        return ResponseEntity.ok(updatedItem);
    }
}
