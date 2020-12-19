import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public interface PatientDao {
	
	public Patient getByID(int ID); // read a single entry from the ﬁle
	public void deleteByID(int ID); // delete a single entry from ﬁle
	public void addPatient (Patient patient); // add or update an entry
	public List<Patient> getListSortedbyName(); // get all entries
	public List<Patient> getListSortedbyID();
		
}
