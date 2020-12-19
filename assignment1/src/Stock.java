

public class Stock {

	// the stock class includes all attributes of the products
	private String productName;
	private String membership;
	private String dateStart;
	private String dateFinish;
	private double price;
	
	
	public Stock(String productName, String membership, String dateStart, String dateFinish, double price) {//
		this.productName=productName;
		this.membership=membership;
		this.dateStart=dateStart;
		this.dateFinish=dateFinish;
		this.price=price;
	}
	public void setProductName(String productName) {
		this.productName=productName;
		
	}
	public String getProductName() {
		return this.productName;
	}
	public void setMembership(String membership) {
		this.membership=membership;
	}
	public String getMembership() {
		return this.membership;
	}
	public void setDateStart(String dateStart) {
		this.dateStart=dateStart;
	}
	public String getDateStart() {
		return this.dateStart;
	}
	public void setDateFinish(String dateFinish) {
		this.dateFinish=dateFinish;
	}
	public String getDateFinish() {
		return this.dateFinish;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public double getPrice() {
		return this.price;
	}

}
