package com.omps.e_commerce.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Item model representing product information.
 *
 * This class is used to transfer item data
 * between controller, service, and repository layers.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    // Unique identifier of item
    private Long id;

    // Item name must not be empty or blank
    @NotBlank(message = "Item name is required")
    private String name;

    // Item description must not be empty
    @NotBlank(message = "Item description is required")
    private String description;

    // Price is required and must be positive
    @NotNull(message = "Item price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    // Timestamp when item was created
    private LocalDateTime createdAt;
}
