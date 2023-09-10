package openmrs_tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.SystemAdministrationPage;

public class SystemAdministrationPageTest {
    @Test (groups = {"full"})
    public void testSystemAdministration() throws InterruptedException {
        SystemAdministrationPage systemAdministrationPage = new SystemAdministrationPage();
        WebDriver driver =  systemAdministrationPage.getSystemAdministrationPage();
        driver.quit();
    }
}
