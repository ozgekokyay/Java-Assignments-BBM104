
public class Imaging extends ExaminationDecorator{

	public Imaging(Examination examination) {
		super(examination);
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public String addoperation() {
		return super.addoperation()+"imaging ";
	}
	@Override
	public int cost() {
		return super.cost()+ 10;
	}
	
}
