package bag;

import java.util.HashMap;
import java.util.Map;

public class Bag<T> {
	//Define underlying map to implement bag
	private Map<T,Integer> items;
	
	//Constructor initializes items as HashMap
	public Bag() {
		items = new HashMap<>();
	}
	
	//Method that adds an item to the bag
	public void add(T item) {
		//Check if item already exists in bag; if so, increment the count
		if(items.containsKey(item)) {
			items.put(item,  items.get(item)+1);
		}
		//else, add item with count 1
		else {
			items.put(item,  1);
		}
	}
	
	//Method that removes one occurrence of an item from the bag
	public void remove(T item) {
		//Check if item exists in bag
		if(items.containsKey(item)){
			//Check if count is greater than 1; if so, decrement count
			if(items.get(item) > 1) {
				items.put(item, items.get(item) - 1);
			}
			//if count is 1, remove item
			else {
				items.remove(item);
			}
		}
	}
	
	//Method that returns true if an item exists in the bag
	public boolean contains(T item) {
		//Check if item exists in bag
		return items.containsKey(item);
	}
	
	//Method that returns the number of occurrences of an item in the bag
	public int count(T item) {
		return items.getOrDefault(item, 0);
	}
	
	public Map<T, Integer> getItems(){
		return items;
	}

}
