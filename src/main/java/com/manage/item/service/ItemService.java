package com.manage.item.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.manage.item.model.Item;

@Service
public class ItemService {

	private List<Item> items = new ArrayList<>();
	private Integer idCounter = 1;

	public Item addITem(Item item) {
		item.setId(idCounter++);
		items.add(item);
		return item;
	}
	public List<Item> getAllItems() {
		return items;
	}
	public Item getItemById(Integer id) {
		return items.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
	}

}
