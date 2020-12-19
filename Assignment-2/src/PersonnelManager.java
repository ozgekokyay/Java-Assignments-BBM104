
import java.util.ArrayList;
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

public class PersonnelManager {
	
	private String[] personnel; 
	private String[] monitor;
	private ArrayList<HoursForWeek> hours= new ArrayList<>();
	private ArrayList<Personnel> information= new ArrayList<>();
	
	
	/* the constructor execute readFile and personnelInformation methods
	 * readFile(String) method using parameters personnelFile and monitorFile
	 * personnelFile is the name of the file contains information of personnels
	 * monitorFile is the name of the file contains worked hours of one month
	 */
	
	public PersonnelManager(String personnelFile, String monitorFile) {
		
		this.personnel=readFile(personnelFile);
		this.monitor=readFile(monitorFile);
		personnelInformation();
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
	
	
	/*
	 * personnelInformation method creates objects from personnel classes
	 */
	public void personnelInformation() {
		
		//reads working hours and creates an arrayList of HoursForWeek class named hours
		for(String lines: this.monitor) {
			String[] word=lines.split("\t"); //[Register Number] [hours of week 1][hours of week 2][hours of week 3][hours of week 4]
			int hour1=Integer.parseInt(word[1]);
			int hour2=Integer.parseInt(word[2]);
			int hour3=Integer.parseInt(word[3]);
			int hour4=Integer.parseInt(word[4]);
			hours.add(new HoursForWeek(word[0],hour1,hour2,hour3,hour4));
							
		}
		
		for(String line: this.personnel) {
			String[] words=line.split("\t"); // [Name][Register Number][Position][Year of Start]
			int year=Integer.parseInt(words[3]);
			String position= words[2];  
			
			//create personnel object from their own class for position and pair them with working hours
			switch(position) {
				case "FACULTY_MEMBER":
					for(int i=0; i<hours.size();i++) {
						if(hours.get(i).getRegister().equals(words[1])) {
							information.add(new FacultyMember(words[0],words[1],words[2],year,hours.get(i)));
							
						}
					}					
					break;
				case "RESEARCH_ASSISTANT":
					for(int i=0; i<hours.size();i++) {
						if(hours.get(i).getRegister().equals(words[1])) {
							
							information.add(new ResearchAssistant(words[0],words[1],words[2],year,hours.get(i)));
							
						}
					}
					break;
					
				case "SECURITY":
					for(int i=0; i<hours.size();i++) {
						if(hours.get(i).getRegister().equals(words[1])) {
							information.add(new Security(words[0],words[1],words[2],year,hours.get(i)));
							
						}
					}
					break;
				case "OFFICER":
					for(int i=0; i<hours.size();i++) {
						if(hours.get(i).getRegister().equals(words[1])) {
							information.add(new Officer(words[0],words[1],words[2],year,hours.get(i)));
							
						}
					}
					
					break;
				case "PARTTIME_EMPLOYEE": 
					for(int i=0; i<hours.size();i++) {
						if(hours.get(i).getRegister().equals(words[1])) {
							information.add(new PartTimeEmployee(words[0],words[1],words[2],year,hours.get(i)));
							
						}
					}
					break;
				case "WORKER":
					for(int i=0; i<hours.size();i++) {
						if(hours.get(i).getRegister().equals(words[1])) {
							information.add(new Worker(words[0],words[1],words[2],year,hours.get(i)));
							
						}
					}
					break;
				case "CHIEF":
					for(int i=0; i<hours.size();i++) {
						if(hours.get(i).getRegister().equals(words[1])) {
							information.add(new Chief(words[0],words[1],words[2],year,hours.get(i)));
							
						}
					}
					break;
			
			}
						
		}
			
	}
	
	//this method calls writeFile for every component of information arraylist 
	public void getInformation() {
		for(int i=0; i<information.size(); i++) {			 
			
			writeFile(information.get(i).getRegisterNumber(),information.get(i).toString());
		}
		
	}
	//method for create a txt file from given name and writes information
	public void writeFile(String fileName, String information) {
		try {
		      FileWriter myWriter = new FileWriter(fileName+".txt");
		      myWriter.write(information);
		      myWriter.close();
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}


}
