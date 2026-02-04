package com.omps.e_commerce.service;

import com.omps.e_commerce.exception.ItemNotFoundException;
import com.omps.e_commerce.model.Item;
import com.omps.e_commerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementation of ItemService interface.
 *
 * This class contains business logic for managing items.
 * It communicates with the repository layer for data operations.
 */
@Service
public class ItemServiceImpl implements ItemService {

    // Repository used to access item storage
    @Autowired
    private ItemRepository repo;

    /**
     * Adds a new item and sets creation timestamp.
     */
    @Override
    public Item addItem(Item item) {
        item.setCreatedAt(LocalDateTime.now()); // set creation time
        return repo.save(item); // store item
    }

    /**
     * Retrieves item by ID.
     * Throws exception if item not found.
     */
    @Override
    public Item getItem(Long id) {
        Item item = repo.findById(id);

        if (item == null) {
            throw new ItemNotFoundException("Item not found with id: " + id);
        }

        return item;
    }

    /**
     * Returns all stored items.
     */
    @Override
    public List<Item> getAllItems() {
        return repo.findAll();
    }

    /**
     * Deletes item by ID.
     * Throws exception if item does not exist.
     */
    @Override
    public void deleteItem(Long id) {
        boolean deleted = repo.deleteById(id);

        if (!deleted) {
            throw new ItemNotFoundException("Item not found with id: " + id);
        }
    }

    /**
     * Updates an existing item's information.
     * Throws exception if item does not exist.
     */
    @Override
    public Item updateItem(Long id, Item newItem) {
        Item existing = repo.findById(id);

        if (existing == null) {
            throw new ItemNotFoundException("Item not found with id: " + id);
        }

        // Update fields
        existing.setName(newItem.getName());
        existing.setDescription(newItem.getDescription());
        existing.setPrice(newItem.getPrice());

        return existing;
    }
}
