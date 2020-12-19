import java.io.IOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PatientImpl implements PatientDao{
	private List<Patient> patients;
	private final String filename="patient.txt";
	private String[] patientFile;
	
	public PatientImpl() {
		this.patients= new ArrayList<>();
		this.patientFile=readFile(filename);
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
	
	public void create() {
		for(String lines: patientFile) {
			String[] words= lines.split("\t");
			
			String[] names= words[1].split(" "); //words[1]= name surname
			int id=Integer.parseInt(words[0]);
			
			addPatient(new Patient(id,names[0],names[1],words[2],words[3]));
			
		}
		
	}
	
	@Override
	public Patient getByID(int ID) {
		for(int i=0; i<patients.size(); i++) {
			if(patients.get(i).getPatientID()== ID) {
				return patients.get(i);
			}
			
		}
		return patients.get(0);
		
		
	}
	
	@Override
	public void deleteByID(int ID) { // delete a single entry from ﬁle
		for(int i=0; i<patients.size(); i++) {
			if(patients.get(i).getPatientID()== ID) {
				patients.remove(i);
			}
			
		}
	}
	
	
	@Override
	public void addPatient (Patient patient) { // add or update an entry
		
		patients.add(patient);
		
	}
	
	@Override
	public List<Patient> getListSortedbyName(){ // get all entries

	
		patients.sort(Comparator.comparing(Patient::getName));
		return patients;
	
	}
	public List<Patient> getListSortedbyID(){ // get all entries

		
		patients.sort(Comparator.comparing(Patient::getPatientID));
		return patients;
	
	}

}
