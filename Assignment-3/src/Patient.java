public class Patient {
	private int patientID;
	private String name;
	private String surname;
	private String number;
	private String address;
	
	public Patient(int patientID, String name,String surname, String number, String address) {
		
		this.patientID = patientID;
		this.name = name;
		this.surname= surname;
		this.number = number;
		this.address = address;
	}
	
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public String getName() {
		return name;
	}
	public String getSurame() {
		return surname;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
