

public class Shopping {
	private String shoppingList;
	private Price price;
	
		
	public Shopping(String shoppingList, Price price) {
		this.shoppingList= shoppingList;
		this.price=price;		
		readFiles();
		
	}
	 

	public void sell(String command) {
		String[] words = command.split("\t",4); // split line to 4 and defines them
		int size= price.getSize(); // getSize takes length of price list for searching item information
		String name= words[0]; // name of the customer
		String membership= words[1]; // gold, bronze or silver
		String date= words[2];// date format 26.02.2020
		String[] items= words[3].split("\t"); 
		System.out.println("---"+name+"---");//prints customer name 
		
		double total=0;
		for(int j=0; j<items.length; j=j+2) {
			String itemName= items[j];
			int count = Integer.parseInt(items[j+1]);
			for(int i=0; i<size; i++) {
				double priceOfItem= count*price.stock[i].getPrice();
				
				if(dateCompare(date, price.stock[i].getDateStart(),price.stock[i].getDateFinish()) &&  membership.equals(price.stock[i].getMembership())
						&& itemName.equals(price.stock[i].getProductName())){
					/*
					 * find the correct price for item
					 */
					total= total+priceOfItem; //// add price to total
					System.out.println(itemName +"\t"+price.stock[i].getPrice()
							+ "\t"+ count+ "\t"+ priceOfItem);
					
				}			
			
			}
			
		}
		System.out.println("Total\t"+total);		
	}
	
	
	public boolean dateCompare(String dateCurrent, String dateStart, String dateEnd) {

		/*
		 * converts strings to integer and compares dates
		 */
		String[] date1 = dateCurrent.split("\\.");
		int day1=Integer.parseInt(date1[0]);
		int month1=Integer.parseInt(date1[1]);
		int year1=Integer.parseInt(date1[2]);
		
		String[] date2 = dateStart.split("\\.");
		int day2=Integer.parseInt(date2[0]);
		int month2=Integer.parseInt(date2[1]);
		int year2=Integer.parseInt(date2[2]);
		
		String[] date3 = dateEnd.split("\\.");
		int day3=Integer.parseInt(date3[0]);
		int month3=Integer.parseInt(date3[1]);
		int year3=Integer.parseInt(date3[2]);
		
		
		if(day1>=day2 && day1<=day3 && month1>=month2 && month1<=month3 && year1>=year2 && year1<=year3   )    {
			return true;
		}else {
			return false;
		}
	}
	
	
	public void readFiles() { // takes information from txt file and executes the method
		String[] lines=ReadfromFile.readFile(shoppingList);
		
		for (String line : lines) {
			if (line != null) {
				sell(line);
			}
			
		}		
	}	
}
