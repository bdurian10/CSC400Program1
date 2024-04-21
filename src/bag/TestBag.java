package bag;

//Class for testing my implementation of the Bag ADT
public class TestBag {
	
	public static void main(String[] args) {
		
		Bag<String> words = new Bag<>();
		
		//Add strings to bag, including duplicates
		words.add("Hello");
		words.add("Hello");
		words.add("World");
		words.add("California");
		words.add("Tabletop");
		words.add("tabletop");
		words.add("California");
		words.add("Hello");
		
		//Print items in Bag
		System.out.println(words.getItems());
		
		/*Test contains method
		 *A more effective test would only execute the print statement
		 *if the result differed from the expected outcome. 
		 *I chose to print all results for the purpose of this assignment
		 */
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
	}

}
