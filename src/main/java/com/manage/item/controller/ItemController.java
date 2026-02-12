package com.manage.item.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manage.item.model.Item;
import com.manage.item.service.ItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/items")
public class ItemController {

	private final ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@PostMapping
	public ResponseEntity<Item> addItem(@Valid @RequestBody Item item) {
		return ResponseEntity.ok(itemService.addITem(item));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> addItemById(@PathVariable int id) {
		Item item = itemService.getItemById(id);
		if (item == null)
			return ResponseEntity.status(404).body("Item not found");
		return ResponseEntity.ok(item);
	}

}
