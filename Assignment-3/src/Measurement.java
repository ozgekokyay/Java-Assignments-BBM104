
public class Measurement extends ExaminationDecorator {
	public Measurement(Examination examination) {
		super(examination);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String addoperation() {
		return super.addoperation()+"measurement ";
	}
	@Override
	public int cost() {
		return super.cost()+ 5;
	}

}
