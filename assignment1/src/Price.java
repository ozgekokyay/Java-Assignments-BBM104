

public class Price {
	private String priceList;
	public Stock[] stock;
	private int size=0;
	
	
	public Price(String priceList) {
		this.priceList=priceList;
		this.size= lineNumber();
		this.stock= new Stock[size]; // creates a Stock array in size of price list	
		readFiles();
		
	}
	
	public int lineNumber(){
		// find number of lines of price list
		String[] lines=ReadfromFile.readFile(priceList);
		for (String line : lines) {
			if (line !=null) {
			
				size++;
				}
		}
		return size;
	}
		
	public void readFiles() { //reads txt file
		String[] lines=ReadfromFile.readFile(priceList);
		int s=0;	
			
		for (String line : lines) {			
			String[] words = line.split("\t");
			String startDate= words[2];
			String endDate= words[3];
			double d = Double.valueOf(words[4]);

			/*
			 * creates an object of stock class that includes every attributes 
			 */
			this.stock[s]= new Stock(words[0],words[1],startDate,endDate,d);			
			s++;
		
			
		}
	}
	
	public int getSize() {
		return this.size;
	}
		
}	
	
	
	
	

	
	
	
	
	
	