package com.manage.item.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
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
		Item created = itemService.addITem(item);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}

	@GetMapping
	public ResponseEntity<?> getAllItems() {
		List<Item> items = itemService.getAllItems();
		if(items.isEmpty()){
			return ResponseEntity.ok(Map.of(
				"message", "No items found. Please add some items.",
				"items", items
			));
		}
		return ResponseEntity.ok(items);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> addItemById(@PathVariable int id) {
		Item item = itemService.getItemById(id);
		if (item == null)
			return ResponseEntity.status(404).body("Item not found");
		return ResponseEntity.ok(item);
	}

}
