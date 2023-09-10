package openmrs_tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.FindPatientRecordPage;
import pages.PatientDetailsPage;

public class VisitWorkflowTest {
    private FindPatientRecordPage findPatientRecordPage;
    private WebDriver driver;
    private PatientDetailsPage patientDetailsPage;

    @BeforeTest (groups = {"full"})
    public void setup() {
        findPatientRecordPage = new FindPatientRecordPage();
        driver = findPatientRecordPage.getFindPatientRecordPage();
        patientDetailsPage = new PatientDetailsPage();
    }

    @Test (groups = {"full"})
    public void testVisitWorkFlow() {
        findPatientRecordPage.selectFirstPatient();
        Assert.assertEquals(driver.getTitle(), "OpenMRS Electronic Medical Record");
    }

    @Test (groups = {"full"})
    public void testEditRegistrationDetails() {
        driver = patientDetailsPage.getPatientDetailsPage();
        patientDetailsPage.editRegistrationDetails();
        Assert.assertEquals(driver.getTitle(), "OpenMRS Electronic Medical Record");
    }

    @Test (groups = {"full"})
    public void testStartVisit() {
        driver = patientDetailsPage.getPatientDetailsPage();
        patientDetailsPage.startVisit();
    }

    @Test (groups = {"full"})
    public void testEndVisit() {
        driver = patientDetailsPage.getPatientDetailsPage();
        patientDetailsPage.endVisit();
    }

    @AfterTest (groups = {"full"})
    public void quitDriver() {
        driver.quit();
    }

}
