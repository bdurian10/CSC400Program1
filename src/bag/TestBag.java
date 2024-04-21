package bag;

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
		
		System.out.println(words.getItems());
		
	}

}
