
public abstract class ExaminationDecorator implements Examination {
	protected Examination examination;
	
	
	public ExaminationDecorator(Examination exam) {
		
		this.examination=exam;
		
	}
	@Override
	public String addoperation() {
		return examination.addoperation();
		
	}
	@Override
	public int cost() {
		return examination.cost();
	}
	
	
}
