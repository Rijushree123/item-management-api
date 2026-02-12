package com.manage.item.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	private Integer id;
	@NotBlank(message = "Name is required")
	private String name;
	private String description;
	@NotNull(message = "Price is required")
	private Integer price;
	@NotNull(message = "Quantity is required")
	private Integer quantity;
	@NotBlank(message = "Category is required")
	private String category;

}
