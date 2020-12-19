import java.util.ArrayList;
import java.util.List;
public class Admission {
	
	private int admissionID;
	private int patientID;
	private ArrayList<Examination> inpatientList;
	private ArrayList<Examination> outpatientList;
	private ArrayList<Examination> patientList;
	
	
	public Admission(int admissionID, int patientID) {
		
		this.admissionID = admissionID;
		this.patientID = patientID;
		this.inpatientList= new ArrayList<>();
		this.outpatientList=new ArrayList<>();
		this.patientList=new ArrayList<>();
		
		
	}	
	

	public ArrayList<Examination> getPatientList() {
		return patientList;
	}


	public void setPatientList(ArrayList<Examination> patientList) {
		this.patientList = patientList;
	}


	public ArrayList<Examination> getOutpatientList() {
		return outpatientList;
	}


	public void setOutpatientList(ArrayList<Examination> outpatientList) {
		this.outpatientList = outpatientList;
	}


	public ArrayList<Examination> getInpatientList() {
		return inpatientList;
	}

	public void setInpatientList(ArrayList<Examination> inpatientList) {
		this.inpatientList = inpatientList;
	}

	public int getAdmissionID() {
		return admissionID;
	}
	public void setAdmissionID(int admissionID) {
		this.admissionID = admissionID;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	
	
	

}
