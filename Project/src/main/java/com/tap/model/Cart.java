package com.tap.model;

import java.util.Collection;
import java.util.HashMap;

public class Cart {
	
	private HashMap<Integer, CartItem> items;
	
	public Cart() {
		this.items = new HashMap<>();
	}
	
	public HashMap<Integer, CartItem> getItems(){
		return items;
	}
	
	public void addItem(CartItem item) {
		int item_id = item.getItemId();
		
		if(items.containsKey(item_id)) {
			
			CartItem existingItem = items.get(item_id);
			int newQuantity = item.getQuantity();
			
			int oldQuantity = existingItem.getQuantity();
			
			int sumQuantity = newQuantity+oldQuantity;
			
			existingItem.setQuantity(sumQuantity);
		}
		else {
			items.put(item_id, item);
		}
	}

	public void updateItem(int itemId, int quantity) {
		
		if(items.containsKey(itemId)) {
			if(quantity <0) {
				items.remove(itemId);
			}
			else {
				CartItem existingItem = items.get(itemId);
				existingItem.setQuantity(quantity);
			}
		}	
	}
	
	
	public void removeItem(int itemId) {
		items.remove(itemId);
	}
	
	public double getTotalPrice() {

	    double totalPrice = 0.0;

	    for (CartItem cartItem : items.values()) {
	        totalPrice += cartItem.getPrice() * cartItem.getQuantity();
	    }

	    return totalPrice;
	}
	
	
}
