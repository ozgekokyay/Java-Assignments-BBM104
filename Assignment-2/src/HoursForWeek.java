

public class HoursForWeek {
	
	private String registerNumber;
	private int week1;
	private int week2;
	private int week3;
	private int week4;

	public HoursForWeek(String reg, int week1, int week2, int week3, int week4) {
		this.registerNumber=reg;
		this.week1=week1;
		this.week2=week2;
		this.week3=week3;
		this.week4=week4;
	}
	public String getRegister() {
		return registerNumber;
	}
	
	public int getWeek1() {
		return week1;
	}
	
	public int getWeek2() {
		return week2;
	}
	
	public int getWeek3() {
		return week3;
	}
	
	public int getWeek4() {
		return week4;
	}
}
