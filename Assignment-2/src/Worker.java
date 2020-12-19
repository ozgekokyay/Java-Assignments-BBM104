

public class Worker extends Personnel{
	private int dayOfWork=20; // worker can work on weekdays
	private int dayPay=105; // daily fee
	private int overWorkPay=11; //hourly fee of over work
	private int maxOverWork=50; //max working hours in a week

	
	public Worker(String name, String registerNumber, String position, int yearOfStart, HoursForWeek hours) {
		super(name, registerNumber, position, yearOfStart, hours);
		// TODO Auto-generated constructor stub
	}
	/*
	 * this method returns salary based on working hours
	 */
	public int overWorkSalary() {
		int totalHours=0;
		if(hours.getWeek1()<=getMaxOverWork() && hours.getWeek1()>=40) {
			totalHours+= hours.getWeek1()-40;
		}
		if(hours.getWeek1()>getMaxOverWork()) {
			totalHours+=getMaxOverWork()-40;
		}
		if(hours.getWeek2()<=getMaxOverWork() && hours.getWeek2()>=40) {
			totalHours+= hours.getWeek2()-40;
		}
		if(hours.getWeek2()>getMaxOverWork()) {
			totalHours+=getMaxOverWork()-40;
		}
		if(hours.getWeek3()<=getMaxOverWork() && hours.getWeek3()>=40) {
			totalHours+= hours.getWeek3()-40;
		}
		if(hours.getWeek3()>getMaxOverWork()) {
			totalHours+=getMaxOverWork()-40;
		}
		if(hours.getWeek4()<=getMaxOverWork() && hours.getWeek4()>=40) {
			totalHours+= hours.getWeek4()-40;
		}
		if(hours.getWeek4()>getMaxOverWork()) {
			totalHours+=getMaxOverWork()-40;
		}
		return totalHours*getOverWorkPay();
	}
	
	//this method returns salary without over work
	public int salary() {
		return getDayOfWork()*getDayPay();
	}
	@Override
	public int earnings() {
		return salary()+getSeverancePay()+overWorkSalary();
	}
	
	@Override
	public String toString() {
		return String.format( "%s%s : %d%s%n", 
				super.toString(),
				"Total Salary",earnings(),".00");		
	}
	
	public int getMaxOverWork() {
		return maxOverWork;
	}
	
	public int getDayOfWork() {
		
		return dayOfWork;
	}
	
	public int getDayPay() {
		return dayPay;
	}
	
	public int getOverWorkPay() {
		return overWorkPay;
	}
	
	

}
