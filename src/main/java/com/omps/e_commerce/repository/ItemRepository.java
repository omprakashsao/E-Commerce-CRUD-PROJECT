package com.omps.e_commerce.repository;

import com.omps.e_commerce.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class responsible for storing and managing items.
 *
 * This implementation uses in-memory storage (ArrayList),
 * so data will be lost when the application restarts.
 */
@Repository
public class ItemRepository {

    // In-memory list acting as database
    private final List<Item> items = new ArrayList<>();

    // Counter to generate unique IDs for items
    private Long idCounter = 1L;

    /**
     * Saves a new item into storage.
     * Automatically assigns an ID.
     */
    public Item save(Item item) {
        item.setId(idCounter++); // generate ID
        items.add(item);         // store item
        return item;
    }

    /**
     * Finds an item by its ID.
     * Returns null if not found.
     */
    public Item findById(Long id) {
        return items.stream()
                .filter(i -> i.getId().equals(id)) // match ID
                .findFirst()
                .orElse(null); // return null if not found
    }

    /**
     * Returns all stored items.
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * Deletes an item by ID.
     *
     * @return true if item removed, false otherwise
     */
    public boolean deleteById(Long id) {
        return items.removeIf(i -> i.getId().equals(id));
    }
}
