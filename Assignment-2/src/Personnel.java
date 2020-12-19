

//base class of every type of personnel classes
public class Personnel {
	private String name;
	private String registerNumber;
	private String position;
	private int yearOfStart;
	public HoursForWeek hours;
	public int currentYear=2020;
	

	public Personnel(String name, String registerNumber, String position, int yearOfStart, HoursForWeek hours) {
		
		this.name = name;
		this.registerNumber = registerNumber;
		this.position = position;
		this.yearOfStart = yearOfStart;
		this.hours = hours;
	}
	//method overridden in subclasses returns total salary
	public int earnings() {
		return 0;
	}
	
	//calculates severance pay for every personnel based on current year and year of start
	public int getSeverancePay() {
		return (currentYear-getYearOfStart()) *16;
		
	}
	//return personnel name
	public String getName() {
		String[] names=this.name.split(" ");
		return names[0];
	}
	//return personnel surname
	public String getSurname() {
		String[] names=this.name.split(" ");
		return names[1];
	}

	

	public String getRegisterNumber() {
		return registerNumber;
	}


	public String getPosition() {
		return position;
	}

	public int getYearOfStart() {
		return yearOfStart;
	}

	public String toString() {
		return String.format("%s : %s%n"+ "%s : %s%n"+ "%s : %s%n"+ "%s : %s%n"+ "%s : %s%n",     
		         "Name",getName(),
		         "Surname",getSurname(),
		         "Registration Number",getRegisterNumber(),
		         "Position",getPosition(),
		         "Year of Start",getYearOfStart()); 
	}
	
	
	
}
