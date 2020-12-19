import java.io.*;

import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class CommandExecutor {
	private String[] input;
	PatientDao patientDao= new PatientImpl();
	AdmissionDao admissionDao=new AdmissionImpl();
	
	public CommandExecutor(String name) {
		this.input=readFile(name);
		inputExecutor();
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
	//inputExecutor() reads file and execute commands 
	public void inputExecutor() {
		try {
		     FileWriter out = new FileWriter("output8.txt");
		     		      
		    
		
			for(String lines: this.input) {
				
				String[] words=lines.split(" ");
				String command= words[0];
				
				switch(command) {
					case "AddPatient":
						String[] word=lines.split(" ",6);
						out.write(addPatient(word));					
						break;
					case "ListPatients":
						out.write(listPatients(words));
						break;
					case "RemovePatient":
						
						out.write(removePatient(words));
						break;
					case "CreateAdmission":
						out.write(createAdmission(words));
						break;
					
					case "AddExamination":
						String[] word1=lines.split(" ",4);
						out.write(addExamination(word1));
						break;
					
					case "TotalCost": 
						out.write(totalCost(words)); 
						break;									
				}
			}
		out.close();
	} catch (IOException e) {
		 System.out.println("An error occurred.");
		 e.printStackTrace();
		 }
	}
	
	public String addPatient(String[] words) {
		
		int ID=Integer.parseInt(words[1]);
		
		Patient patient=new Patient(ID,words[2],words[3],words[4],words[5]);
		
		
		patientDao.addPatient(patient);
		updatePatient();
		
		String result="Patient "+patient.getPatientID()+" "+patient.getName()+" added\n";
		return result;
		
		
		
	}
	public void updatePatient() { //update patient file when every command readed
		
	    String result="";
	    try {
		      FileWriter out = new FileWriter("patientout19.txt");
		      for(Patient patient : patientDao.getListSortedbyID()) {
		    	  result= result+ patient.getPatientID()+"\t"+patient.getName()+" "+patient.getSurame()+"\t"+patient.getNumber()+"\t\nSORUN\n "+patient.getAddress()+"\n";
		      }
		      out.write(result);
		      out.close();
	     }catch (IOException e) {
			 System.out.println("An error occurred.");
			 e.printStackTrace();
			 }	
	    
	    
	}
	public String removePatient(String[] words) { //removes patient by id from admission and patient data
		int ID=Integer.parseInt(words[1]);
		
		Patient patient= patientDao.getByID(ID);
				
		String result= "Patient "+patient.getPatientID()+" "+patient.getName()+" removed\n";
		
		patientDao.deleteByID(ID);
		admissionDao.removeAdmission(ID);
		updateAdmission();
		updatePatient();
		return result;		
		
	}
	
	public String createAdmission(String[] words) {
		
		int aID=Integer.parseInt(words[1]);
		int pID=Integer.parseInt(words[2]);
		Admission admission= new Admission(aID,pID);
		admissionDao.createAdmission(admission);
		
		updateAdmission();
		String result="Admission "+aID+" created\n";
		return result;
		
	}
	public void updateAdmission() { /// update admission file when every command readed
		
	    String result="";
	    try {
		      FileWriter out = new FileWriter("admissionout.txt");
		      for(Admission admission: admissionDao.getAdmissionList()) {
		    	  result= result+admission.getAdmissionID()+"\t"+admission.getPatientID()+"\n";
		    	  for(Examination examination: admission.getPatientList() ) {
		    		  result= result+ examination.addoperation()+"\n";
		    	  }
		    }
		      out.write(result);
		      out.close();
	    	}catch (IOException e) {
			 System.out.println("An error occurred.");
			 e.printStackTrace();
			 }	 
	    
	    
	}
	public String addExamination(String[] words) {
		int admissionID=Integer.parseInt(words[1]);
		String result= "";
		if((words[2]).equals("Inpatient")){
			String[] operations= words[3].split(" ");
			
			Examination inpatient = new Inpatient(); //creates inpatient examination 
			
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
			
		//add examination to the list of admissions	
		admissionDao.getAdmission(admissionID).getInpatientList().add(inpatient); 

		admissionDao.getAdmission(admissionID).getPatientList().add(inpatient);
		result="Inpatient examination added to admission "+ admissionID+"\n";
		
		}
		
		if((words[2]).equals("Outpatient")){
			
			String[] operations= words[3].split(" ");
			//creates outpatient examination 
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
				if(str.equals("measurements")) {
					outpatient=new Measurement(outpatient);
										
				}		
			}
			admissionDao.getAdmission(admissionID).getOutpatientList().add(outpatient);

			admissionDao.getAdmission(admissionID).getPatientList().add(outpatient);
			result="Outpatient examination added to admission "+ admissionID+"\n";
		}
		updateAdmission();
		return result;
	
	  }
	
	  public String totalCost(String[] words) {
		  String result= "TotalCost for admission "+ words[1]+"\n"; 
		  int admissionID=Integer.parseInt(words[1]); 
		  int inpatientCost=0; 
		  int outpatientCost=0; 
		  int cost=0;
		  
		  //calculates cost of inpatient examinations
		  int size=admissionDao.getAdmission(admissionID).getInpatientList().size();
		  for(int i=0; i<size; i++) { 
			  inpatientCost= admissionDao.getAdmission(admissionID).getInpatientList().get(i).cost();
			  result=result+"\t"+admissionDao.getAdmission(admissionID).getInpatientList().get(i).addoperation()+inpatientCost+"$\n";
			  cost= cost+ inpatientCost;
		  } 
		  
		  //calculates cost of outpatient examinations
		  int size2=admissionDao.getAdmission(admissionID).getOutpatientList().size();
		  for(int i=0; i<size2; i++) { 
			  outpatientCost= admissionDao.getAdmission(admissionID).getOutpatientList().get(i).cost();
			  result=result+"\t"+admissionDao.getAdmission(admissionID).getOutpatientList().get(i).addoperation()+outpatientCost+"$\n";
			  cost= cost+ outpatientCost;
		  } 
		  result= result+ "\tTotal: "+cost+"$\n";
	  
		  return result;
	  
	  
	  }
	  
	public String listPatients(String[] words) {
		String result= "Patient List:\n";
		for(Patient patient : patientDao.getListSortedbyName()) {
			//result= result+ patient.getPatientID()+" "+patient.getName()+" "+patient.getSurame()+" "+patient.getNumber()+" "+patient.getAddress()+"\n";
			result=";";
		}
		return result;
	}
	

}
