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
	
	public int size() {
		int size = 0;
		for(int value : getItems().values()) {
			size += value;
		}
		return size;
	}
	
	public void merge(Bag<T> otherBag) {
		otherBag.getItems().forEach((key, value) -> items.merge(key, value, (oldValue, newValue) -> oldValue + newValue));
	}
	
	public Bag<T> distinct(){
		Bag<T> distinctBag = new Bag<>();
		for(T item : items.keySet()) {
			distinctBag.add(item);
		}
		return distinctBag;
	}
	
	//Main Method for testing
	public static void main(String[] args) {
			
			Bag<String> words = new Bag<>();
			Bag<String> words2 = new Bag<>();
			
			//Add strings to words, including duplicates
			words.add("Hello");
			words.add("Hello");
			words.add("World");
			words.add("California");
			words.add("Tabletop");
			words.add("tabletop");
			words.add("California");
			words.add("Hello");
			
			//Add strings to words2
			words2.add("Hello");
			words2.add("Hello");
			words2.add("World");
			words2.add("Counter");
			
			//Print items in words
			System.out.println("Words Contains: " + words.getItems());
			System.out.println("Words Size: " + words.size() + "\n");
			
			//Print items in words2
			System.out.println("Words2 Contains: " + words2.getItems());
			System.out.println("Words2 Size: " + words2.size() + "\n");
			
			//Test merging of words and words2
			System.out.println("Merging Words with Words2...");
			words.merge(words2);
			System.out.println("Merged Bag Contents: " + words.getItems() + "\n");
			
			//Create distinctBag from words
			Bag<String> distinctBag = words.distinct();
			System.out.println("Creating distinctBag from Words...");
			System.out.println("Distinct Entries in Words: " + distinctBag.getItems());
			
			/*Testing for Module 1
			 *Test contains method
			 *A more effective test would only execute the print statement
			 *if the result differed from the expected outcome. 
			 *I chose to print all results for the purpose of this assignment
			 
			System.out.println("****Testing Contains Method****");
			System.out.println("Bag contains: Hello. Expected: true. Result: " + words.contains("Hello"));
			System.out.println("Bag contains: Hotdog. Expected: false. Result: " + words.contains("Hotdog"));
			System.out.println("Bag contains: California. Expected: true. Result: " + words.contains("California"));
			System.out.println("Bag contains: Tabletop. Expected: true. Result: " + words.contains("Tabletop"));
			System.out.println("Bag contains: tabletop. Expected: true. Result: " + words.contains("tabletop"));
			System.out.println();
			
			//Test count method
			System.out.println("****Testing Count Method****");
			System.out.println("Count of Hello: " + words.count("Hello"));
			System.out.println("Count of California: " + words.count("California"));
			System.out.println("Count of Tabletop: " + words.count("Tabletop"));
			System.out.println("Count of tabletop: " + words.count("tabletop"));
			System.out.println("Count of Jet: " + words.count("Jet"));
			System.out.println();
			
			//Test Remove Method
			System.out.println("****Testing Remove Method****");
			words.remove("Hello");
			System.out.println("Bag after removal of Hello: " + words.getItems());
			System.out.println("Bag contains: Hello. Expected: true. Result: " + words.contains("Hello"));
			System.out.println("Count of Hello: " + words.count("Hello"));
			words.remove("Tabletop");
			System.out.println("Bag after removal of Tabletop: " + words.getItems());
			System.out.println("Bag contains: Tabletop. Expected: false. Result: " + words.contains("Tabletop"));
			System.out.println("Count of Tabletop: " + words.count("Tabletop"));
			*/
		}

}
