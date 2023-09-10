package openmrs_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CaptureVitalsPage;
import pages.HomePage;

import java.time.Duration;

public class VitalsTest {
    private WebDriver driver;
    private CaptureVitalsPage captureVitalsPage;
    @BeforeClass
    public void setDriver(){
        captureVitalsPage = new CaptureVitalsPage();
        driver = captureVitalsPage.getCaptureVitalsPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void testCaptureVitals() throws InterruptedException {
        captureVitalsPage.selectFirstPatient();
        captureVitalsPage.confirmPatient();
        captureVitalsPage.fillVitals();
        captureVitalsPage.confirmVitalDetails();
        Assert.assertTrue(driver.findElement(By.cssSelector("body > div.toast-container.toast-position-top-right")).getText().contains("Entered Vitals for"));
        driver.quit();
    }

    @Test
    public void testShowContactInfo() {
        captureVitalsPage.selectFirstPatient();
        captureVitalsPage.showContactInfo();
        Assert.assertNotEquals(captureVitalsPage.getContactInfo(),"");
    }

    @Test
    public void testNoFindOtherPatient() {
        captureVitalsPage.selectFirstPatient();
        captureVitalsPage.noFindOtherPatient();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).getText(),"Capture Vitals for Patient");
    }

    @Test
    public void testSaveForm() {
        captureVitalsPage.selectFirstPatient();
        captureVitalsPage.confirmPatient();
        captureVitalsPage.saveForm();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"confirmationQuestion\"]/h3")).getText(),"Confirm submission?");
    }

    @Test
    public void testExitForm() {
        captureVitalsPage.selectFirstPatient();
        captureVitalsPage.confirmPatient();
        captureVitalsPage.exitForm();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).getText(),"Capture Vitals for Patient");
    }

    @Test
    public void testConfirmSubmissionNo() {
        captureVitalsPage.selectFirstPatient();
        captureVitalsPage.confirmPatient();
        driver.findElement(By.id("w8")).sendKeys("123");
        captureVitalsPage.saveForm();
        captureVitalsPage.confirmSubmissionNo();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"formBreadcrumb\"]/li[1]/ul/li[1]/span")).getText(),"Height (cm)");
    }

    @Test
    public void testConfirmSubmissionSave() {
        captureVitalsPage.selectFirstPatient();
        captureVitalsPage.confirmPatient();
        captureVitalsPage.fillVitals();
        captureVitalsPage.saveForm();
        captureVitalsPage.confirmSubmissionSave();
        Assert.assertTrue(driver.findElement(By.cssSelector("body > div.toast-container.toast-position-top-right")).getText().contains("Entered Vitals for"));
    }
}
