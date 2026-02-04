package com.omps.ecommerce.service;

import com.omps.ecommerce.model.Item;
import java.util.List;

/**
 * Service interface defining business operations
 * related to Item management.
 *
 * Controller interacts with this interface,
 * while actual logic is implemented in ItemServiceImpl.
 */
public interface ItemService {

    /**
     * Adds a new item to the system.
     *
     * @param item item details
     * @return saved item
     */
    Item addItem(Item item);

    /**
     * Retrieves an item by ID.
     *
     * @param id item ID
     * @return item details
     */
    Item getItem(Long id);

    /**
     * Retrieves all items.
     *
     * @return list of items
     */
    List<Item> getAllItems();

    /**
     * Deletes an item using its ID.
     *
     * @param id item ID
     */
    void deleteItem(Long id);

    /**
     * Updates an existing item.
     *
     * @param id item ID
     * @param newItem updated item data
     * @return updated item
     */
    Item updateItem(Long id, Item newItem);
}
