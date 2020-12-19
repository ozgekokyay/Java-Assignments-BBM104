
public class Security extends Personnel{
	private int foodMoney=10; // daily money for food 
	private int transMoney=5; //daily money for transportation
	private int hourPay=10; //pay of each working hour

	
	public Security(String name, String registerNumber, String position, int yearOfStart, HoursForWeek hours) {
		super(name, registerNumber, position, yearOfStart, hours);
		
	}
	/*
	 * Method return the salary based on worked hours and adds food and tranportation money based on days
	 * a security can work max 54 hours and min 30 hours in a week
	 */
	public int hourOfWork() {
		int totalHours=0;
		int addMoney=0;
		if(hours.getWeek1()<=54 && hours.getWeek1()>=30) {
			totalHours+= hours.getWeek1();
			addMoney+= 6*(transMoney+foodMoney);
		}
		if(hours.getWeek1()>54) {
			totalHours+=54;
		}
		if(hours.getWeek2()<=54 && hours.getWeek2()>=30) {
			totalHours+= hours.getWeek2();
			addMoney+= 6*(transMoney+foodMoney);
		}
		if(hours.getWeek2()>54) {
			totalHours+=54;
		}
		if(hours.getWeek3()<=54 && hours.getWeek3()>=30) {
			totalHours+= hours.getWeek3();
			addMoney+= 6*(transMoney+foodMoney);
		}
		if(hours.getWeek3()>54) {
			totalHours+=54;
		}
		if(hours.getWeek4()<=54 && hours.getWeek4()>=30) {
			totalHours+= hours.getWeek4();
			addMoney+= 6*(transMoney+foodMoney);
		}
		if(hours.getWeek4()>54) {
			totalHours+=54;
		}
		return (totalHours*hourPay)+ addMoney;
		
	}
	@Override
	public int earnings() {
		
		return  hourOfWork()+ getSeverancePay() ;
		
	}
	
	@Override
	public String toString() {
		return String.format( "%s%s : %d%s%n", 
				super.toString(),
				"Total Salary",earnings(),".00");		
	}
	
	

}
