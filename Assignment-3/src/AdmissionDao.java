import java.util.ArrayList;
import java.util.List;

public interface AdmissionDao {
	
	public void createAdmission (Admission admission);
	public Admission getAdmission(int ID);	
	public void removeAdmission(int ID); 
	public List<Admission> getAdmissionList();

}
