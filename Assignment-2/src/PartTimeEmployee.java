
public class PartTimeEmployee extends Personnel{
	private int hourPay=18; //hourly fee

	public PartTimeEmployee(String name, String registerNumber, String position, int yearOfStart, HoursForWeek hours) {
		super(name, registerNumber, position, yearOfStart, hours);
		// TODO Auto-generated constructor stub
	}
	
	// method for calculate total working hours min 10 hour and max 20 hours weekly
	public int hourOfWork() {
		int totalHours=0;
		if(hours.getWeek1()<=20 && hours.getWeek1()>=10) {
			totalHours+= hours.getWeek1();
		}
		if(hours.getWeek1()>20) {
			totalHours+=20;
		}
		if(hours.getWeek2()<=20 && hours.getWeek2()>=10) {
			totalHours+= hours.getWeek2();
		}
		if(hours.getWeek2()>20) {
			totalHours+=20;
		}
		if(hours.getWeek3()<=20 && hours.getWeek3()>=10) {
			totalHours+= hours.getWeek3();
		}
		if(hours.getWeek3()>20) {
			totalHours+=20;
		}
		if(hours.getWeek4()<=20 && hours.getWeek4()>=10) {
			totalHours+= hours.getWeek4();
		}
		if(hours.getWeek4()>20) {
			totalHours+=20;
		}
		return totalHours*hourPay;
	}
	@Override
	public int earnings() {
		return hourOfWork()+getSeverancePay();
	}
	@Override
	public String toString() {
		return String.format( "%s%s : %d%s%n", 
				super.toString(),
				"Total Salary",earnings(),".00");		
	}

}
