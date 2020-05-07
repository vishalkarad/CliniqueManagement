import com.bridgelabz.exception.CliniqueException;
import com.bridgelabz.interfaces.CliniqueInterface;
import com.bridgelabz.pojo.Doctor;
import com.bridgelabz.pojo.Patients;
import com.bridgelabz.services.DoctorService;
import com.bridgelabz.services.PatientServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CliniqueManagementTest {

    DoctorService doctor;
    PatientServices patient;
    @Before
    public void setUp() {
        doctor = new DoctorService("F:\\bridgelabze\\CliniqueManagement\\src\\test\\resources\\doctors\\doctorList.json");
        patient = new PatientServices("F:\\bridgelabze\\CliniqueManagement\\src\\test\\resources\\patients\\patientList.json");
    }

    @Test
    public void givenDoctorInformation_WhenAddDoctor_ThenReturnSuccessMessage() throws CliniqueException {
        String result = doctor.addRecord(new Doctor("D102","shubham","8956561313","parli","PM","skin"));
        Assert.assertEquals("Add Records Successfully",result);
    }

    @Test
    public void givenPatientsInformation_WhenAddPatients_ThenReturnSuccessMessage() {
        String result = doctor.addRecord(new Patients("P3", "rohan", "9874563216", 40));
        Assert.assertEquals("Add Records Successfully",result);
    }

    @Test
    public void givenPatientId_WhenSearch_ThenReturnSuccessMessage()  {
        String result = patient.searchRecord("P2");
        Assert.assertEquals("Search record",result);
    }

    @Test
    public void givenDoctorId_WhenSearch_ThenReturnSuccessMessage()  {
        String result = doctor.searchRecord("D102");
        Assert.assertEquals("Search record",result);
    }

    @Test
    public void givenRecord_WhenSearchAllRecords_ThenReturnSuccessMessage()  {
        String result = doctor.listOfAllRecords();
        Assert.assertEquals("Search record",result);
    }
}
