
public class FacultyMember extends ResearchAssistant{
	private int ssBenefits= getBaseSalary()*135/100;
	
	public FacultyMember(String name, String registerNumber, String position, int yearOfStart, HoursForWeek hours) {
		super(name, registerNumber, position, yearOfStart, hours);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSsBenefits() {
		
		return ssBenefits;
	}
	
	//method calculate the fee according the rules, maximum 8 hours extra courses 
	public int addCourseFee() {
		int extraHours=0;
		if(hours.getWeek1()<49) {
			extraHours+=hours.getWeek1()-40;
		}
		if(hours.getWeek1()>48) {
			extraHours+=8;
		}
		if(hours.getWeek2()<49) {
			extraHours+=hours.getWeek2()-40;
		}
		if(hours.getWeek2()>48) {
			extraHours+=8;
		}
		if(hours.getWeek3()<49) {
			extraHours+=hours.getWeek3()-40;
		}
		if(hours.getWeek3()>48) {
			extraHours+=8;
		}
		if(hours.getWeek4()<49) {
			extraHours+=hours.getWeek4()-40;
		}
		if(hours.getWeek4()>48) {
			extraHours+=8;
		}
		return extraHours*20;	
	}
	
	
	@Override
	public int earnings(){
		return getBaseSalary()+getSsBenefits()+getSeverancePay()+addCourseFee();
	}

}
