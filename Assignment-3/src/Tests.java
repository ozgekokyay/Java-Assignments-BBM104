
public class Tests extends ExaminationDecorator {

	public Tests(Examination examination) {
		super(examination);
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public String addoperation() {
		return super.addoperation()+"tests ";
	}
	
	@Override
	public int cost() {
		return examination.cost()+ 7;
	}

}
