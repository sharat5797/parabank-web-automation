package openmrs_tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FindPatientRecordPage;
import pages.PatientDetailsPage;

public class VisitWorkflowTest {
    @Test
    public void testVisitWorkFlow() {
        FindPatientRecordPage findPatientRecordPage = new FindPatientRecordPage();
        WebDriver driver = findPatientRecordPage.getFindPatientRecordPage();
        findPatientRecordPage.selectFirstPatient();
        Assert.assertEquals(driver.getTitle(), "OpenMRS Electronic Medical Record");
        driver.quit();
    }

    @Test
    public void testEditRegistrationDetails() {
        PatientDetailsPage patientDetailsPage = new PatientDetailsPage();
        WebDriver driver = patientDetailsPage.getPatientDetailsPage();
        patientDetailsPage.editRegistrationDetails();
        Assert.assertEquals(driver.getTitle(),"OpenMRS Electronic Medical Record");
        driver.quit();
    }

}
