package openmrs_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.EditRegistrationInfoPage;
import pages.FindPatientRecordPage;
import pages.PatientDetailsPage;

public class EditRegistrationDetailsTest {
    private EditRegistrationInfoPage editRegistrationInfoPage;
    private WebDriver driver;
    @BeforeTest (groups = { "full" })
    public void setup() throws InterruptedException {
        editRegistrationInfoPage = new EditRegistrationInfoPage();
        driver = editRegistrationInfoPage.getEditRegistrationInfoPage();
    }

    @Test (groups = { "full" })
    public void testNavigateToEditRegistrationPage() {
//        driver.findElement(By.partialLinkText("Edit Registration Information")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div[9]/div[1]/div/div[1]/div[1]/div[1]")).getText(),"DEMOGRAPHICS");
    }

    @Test (groups = { "full" })
    public void testEditDemoGraphicsName() {
        editRegistrationInfoPage.editDemoGraphicsName();
        Assert.assertEquals(driver.findElement(By.cssSelector("body > div.toast-container.toast-position-top-right")).getText(),"Saved changes in Demographics for: XYZ ZZZ");
    }

    @Test (groups = { "full" })
    public void testEditContactInfo() {
        editRegistrationInfoPage.editContactInfo();
        Assert.assertEquals(driver.findElement(By.cssSelector("body > div.toast-container.toast-position-top-right")).getText(),"Saved changes in contact info for: XYZ ZZZ");
    }

    @AfterTest (groups = { "full" })
    public void quitDriver(){
        driver.quit();
    }

}
