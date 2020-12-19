import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.lang.*;

public class AdmissionImpl implements AdmissionDao {
	private List<Admission> admission;

	private final String filename="admission.txt";
	private String[] admissionFile;
	
	public AdmissionImpl() {
		this.admission= new ArrayList<>();
		this.admissionFile=readFile(filename);
		create();
		
		
	}
	
	public static String[] readFile(String path){
		try {
			int i=0;
			int length= Files.readAllLines(Paths.get(path)).size();
			String[] results= new String[length];
				for (String line: Files.readAllLines(Paths.get(path))) {
					results[i++]=line;
				}
			return results;
			
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void create(){
		/*
		 * reads admission.txt and store data
		 * 
		 * 
		 */
		
		for(String lines: admissionFile) {		
			String[] words=lines.split("\t");
			
			if(!((words[0]).equalsIgnoreCase("Inpatient") || (words[0]).equalsIgnoreCase("Outpatient"))) {
				int admissionID= Integer.parseInt(words[0]);
				int patientID= Integer.parseInt(words[1]);				
				
				admission.add(new Admission(admissionID,patientID));
				
			}
			if((words[0]).equalsIgnoreCase("Inpatient")) {
				String[] operations= words[1].split(" ");
				Examination inpatient = new Inpatient();
				for( String str: operations) {
					if(str.equals("imaging")) {
						inpatient=new Imaging(inpatient);
					}
					if(str.equals("doctorvisit")) {
						inpatient=new DoctorVisit(inpatient);
					}
					if(str.equals("tests")) {
						inpatient=new Tests(inpatient);
					}
					if(str.equals("measurements")) {
						inpatient=new Measurement(inpatient);
					}
					
				}
				
				admission.get(admission.size()-1).getInpatientList().add(inpatient);
				admission.get(admission.size()-1).getPatientList().add(inpatient);
				
			}
			if((words[0]).equalsIgnoreCase("Outpatient")) {
				String[] operations= words[1].split(" ");
				Examination outpatient = new Outpatient();
				for( String str: operations) {
					if(str.equals("imaging")) {
						outpatient=new Imaging(outpatient);
					}
					if(str.equals("doctorvisit")) {
						outpatient=new DoctorVisit(outpatient);
					}
					if(str.equals("tests")) {
						outpatient=new Tests(outpatient);
					}
					if(str.equals("measurement")) {
						outpatient=new Measurement(outpatient);
					}
					
				}
				
				admission.get(admission.size()-1).getOutpatientList().add(outpatient);
				admission.get(admission.size()-1).getPatientList().add(outpatient);
			}
						
		}		
	}
	@Override
	public Admission getAdmission(int ID) { //get admission by id
		for(Admission ad: admission) {
			if(ad.getAdmissionID()== ID) {
				return ad;
			}
		}
		return admission.get(0);
	}
	@Override
	public void createAdmission (Admission ad) { //add admission
		admission.add(ad);
	}
	
	
	@Override
	public void removeAdmission(int patientID) {//remove admission by patient id
		int size= admission.size();
		try {
			for(int i=0; i<size-1; i++) {
				if(admission.get(i).getPatientID()== patientID) {
					admission.remove(i);			
					}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Override
	public List<Admission> getAdmissionList(){
		admission.sort(Comparator.comparing(Admission::getAdmissionID));
		return admission;
	}
		

}
