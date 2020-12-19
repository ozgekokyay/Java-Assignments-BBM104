
public class Inpatient implements Examination {
	
	protected int admissionID;
	protected int price;
	protected String operations;

	public Inpatient() {
		
		
		setPrice(10);		
		
	}
	

	public int getAdmissionID() {
		return admissionID;
	}
	public void setAdmissionID(int admissionID) {
		this.admissionID = admissionID;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public int cost() {
		
		return price;
	}
	@Override
	public String addoperation() {
		return "Inpatient ";
		//setPrice(examination.cost());
		
	} 
}
