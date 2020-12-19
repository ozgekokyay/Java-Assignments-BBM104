

public class Main {
	public static void main(String[] args) {

		// take arguments of the name of txt file to run the program
		String shoppingList= args[0];
		String priceList= args[1];
		
		Price price= new Price(priceList); // creates a price class from readed txt
		
		Shopping shopping =new Shopping(shoppingList, price); // creates a shopping class
		
		
	}
}	
	
		
		
		
		
		
		
		

	