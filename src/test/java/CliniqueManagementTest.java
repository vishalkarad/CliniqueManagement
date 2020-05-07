import com.bridgelabz.exception.CliniqueException;
import com.bridgelabz.interfaces.CliniqueInterface;
import com.bridgelabz.pojo.Doctor;
import com.bridgelabz.services.DoctorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CliniqueManagementTest {

    DoctorService doctor;
    @Before
    public void setUp() {
        doctor = new DoctorService("F:\\bridgelabze\\CliniqueManagement\\src\\test\\resources\\doctors\\doctorList.json");
    }

    @Test
    public void givenDoctorInformation_WhenAddDoctor_ThenReturnSuccessMessage() throws CliniqueException {
        String result = doctor.addRecord(new Doctor("D102","shubham","8956561313","parli","PM","skin"));
        Assert.assertEquals("Add Records Successfully",result);
    }
}
