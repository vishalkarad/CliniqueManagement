import com.bridgelabz.exception.CliniqueException;
import com.bridgelabz.pojo.Doctor;
import com.bridgelabz.pojo.Patients;
import com.bridgelabz.services.AppointmentService;
import com.bridgelabz.services.DoctorService;
import com.bridgelabz.services.PatientServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.text.ParseException;

public class CliniqueManagementTest {

    DoctorService doctor;
    PatientServices patient;
    public String appointmentFilePath = "F:\\bridgelabze\\cliniqueManagementApplication\\src\\test\\resources\\appointment\\appointmentList.json";
    @Before
    public void setUp() {
        doctor = new DoctorService("F:\\bridgelabze\\cliniqueManagementApplication\\src\\test\\resources\\doctors\\doctorList.json");
        patient = new PatientServices("F:\\bridgelabze\\cliniqueManagementApplication\\src\\test\\resources\\patients\\patientList.json");
    }

    @Test
    public void givenDoctorInformation_WhenAddDoctor_ThenReturnSuccessMessage() throws CliniqueException {
        String result = doctor.addDoctorEntry(new Doctor("D103","vaibhav","8956561313","parli","PM","skin"));
        Assert.assertEquals("Add Records Successfully",result);
    }

    @Test
    public void givenPatientsInformation_WhenAddPatients_ThenReturnSuccessMessage() {
        String result = patient.addPatientEntry(new Patients("P3", "rohan", "9874563216", 40));
        Assert.assertEquals("Add Records Successfully",result);
    }

    @Test
    public void givenPatientId_WhenSearch_ThenReturnSuccessMessage()  {
        int result = patient.searchPatientRecord("P3");
        Assert.assertEquals(1,result);
    }

    @Test
    public void givenDoctorId_WhenSearch_ThenReturnSuccessMessage()  {
        int result = doctor.searchDoctorEntry("D102");
        Assert.assertEquals(2,result);
    }

    @Test
    public void givenRecord_WhenSearchAllDoctorRecords_ThenReturnSuccessMessage()  {
        String result = doctor.listOfAllDoctorRecords();
        Assert.assertEquals("Search record",result);
    }

    @Test
    public void givenRecord_WhenSearchAllPatientsRecords_ThenReturnSuccessMessage()  {
        String result = patient.listOfAllPatientRecords();
        Assert.assertEquals("Search record",result);
    }

    @Test
    public void givenDoctorIdAndDate_WhenFixAppointment_ThenReturnSuccessMessage() throws IOException, CliniqueException, ParseException {
        AppointmentService appoint = new AppointmentService();
        String result = appoint.appointment("D103","P3","10/12/2020");
        Assert.assertEquals("Appointment fix",result);
    }

    @Test
    public void givenDoctorId_WhenSearchDoctorPatient_ThenReturnSuccessMessage() throws IOException, CliniqueException, ParseException {
        DoctorService doctorService = new DoctorService(appointmentFilePath);
        int result = doctorService.doctorPatientReport("D103");
        Assert.assertEquals(1,result);
    }
}
