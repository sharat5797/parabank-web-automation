package openmrs_tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.FindPatientRecordPage;

public class VisitWorkflowTest {
    @Test
    public void testVisitWorkFlow() throws InterruptedException {
        FindPatientRecordPage findPatientRecordPage = new FindPatientRecordPage();
        WebDriver driver = findPatientRecordPage.getFindPatientRecordPage();
        findPatientRecordPage.selectFirstPatient();
        Thread.sleep(4000);
        System.out.println(driver.getTitle());
    }
}
