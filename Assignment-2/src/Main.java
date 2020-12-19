
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String personelFile=args[0];
		String monitorFile=args[1];
		PersonnelManager personnelManager= new PersonnelManager(personelFile,monitorFile);
		personnelManager.getInformation(); //call the method creates output files
		
	}

}
