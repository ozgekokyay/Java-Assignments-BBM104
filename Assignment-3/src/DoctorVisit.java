
public class DoctorVisit extends ExaminationDecorator{
	public DoctorVisit(Examination examination) {
		super(examination);
		
	}
	
	@Override
	public int cost() {
		return examination.cost()+15;
	}
	@Override
	public String addoperation() {
		return super.addoperation()+"doctorvisit ";
	}
}
