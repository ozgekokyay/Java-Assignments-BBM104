


public class ResearchAssistant extends Personnel{
	private final int baseSalary=2600; //base salary of research assistants, faculty members and officers
	private int ssBenefits= getBaseSalary()*105/100;
	
	



	public ResearchAssistant(String name, String registerNumber, String position, int yearOfStart, HoursForWeek hours) {
		super(name, registerNumber, position, yearOfStart, hours);
		
		
		// TODO Auto-generated constructor stub
	}


	public int getBaseSalary() {
		return baseSalary;
	}


	public int getSsBenefits() {
		return ssBenefits;
		
	}


	
	
	@Override	
	public int earnings() {
		return getBaseSalary()+getSsBenefits()+getSeverancePay();
	}
	
	
	@Override
	public String toString() {
		return String.format( "%s%s : %d%s%n", 
				super.toString(),
				"Total Salary",earnings(),".00");		
	}


}
