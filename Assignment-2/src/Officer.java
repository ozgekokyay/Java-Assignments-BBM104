

public class Officer extends ResearchAssistant {
	private int overWorkHour=20; // hourly fee for over work
	private int ssBenefits= getBaseSalary()*65/100; 

	public Officer(String name, String registerNumber, String position, int yearOfStart, HoursForWeek hours) {
		super(name, registerNumber, position, yearOfStart, hours);
		
	}
	@Override
	public int getSsBenefits() {
		
		return ssBenefits;
	}
	
	//method for calculating over work salary maximum 10 hours for a week
	
	public int overWorkSalary() {
		int totalHours=0;
		if(hours.getWeek1()<=50 && hours.getWeek1()>=40) {
			totalHours+= hours.getWeek1()-40;
		}
		if(hours.getWeek1()>50) {
			totalHours+=10;
		}
		if(hours.getWeek2()<=50 && hours.getWeek2()>=40) {
			totalHours+= hours.getWeek2()-40;
		}
		if(hours.getWeek2()>50) {
			totalHours+=10;
		}
		if(hours.getWeek3()<=50 && hours.getWeek3()>=40) {
			totalHours+= hours.getWeek3()-40;
		}
		if(hours.getWeek3()>50) {
			totalHours+=10;
		}
		if(hours.getWeek4()<=50 && hours.getWeek4()>=40) {
			totalHours+= hours.getWeek4()-40;
		}
		if(hours.getWeek4()>50) {
			totalHours+=10;
		}
		return totalHours*overWorkHour;
		
	}
	@Override	
	public int earnings() {
		return getBaseSalary()+getSsBenefits()+getSeverancePay()+overWorkSalary();
	}

}
