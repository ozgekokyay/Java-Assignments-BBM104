

public class Chief extends Worker{
	private int dayPay=125; //daily fee
	private int overWorkPay=15; //hourly fee of over work
	private int maxOverWork=48; // maximum working hours in a week
	
	public Chief(String name, String registerNumber, String position, int yearOfStart, HoursForWeek hours) {
		super(name, registerNumber, position, yearOfStart, hours);
		// TODO Auto-generated constructor stub
	}
	
	//return the dayPay of Chief class
	public int getDayPay() {
		return dayPay;
	}

	//return the maxOverWork of Chief class
	public int getMaxOverWork() {
		return maxOverWork;
	}

	//return the overWorkPay of Chief class
	public int getOverWorkPay() {
		return overWorkPay;
	}

	
	
	
	
	

}
