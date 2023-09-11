package openmrs_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CaptureVitalsPage;
import pages.FindPatientRecordPage;
import pages.HomePage;
import pages.PatientDetailsPage;

import javax.annotation.concurrent.ThreadSafe;
import java.time.Duration;

public class VitalsTest {
    private WebDriver driver;
    private CaptureVitalsPage captureVitalsPage;

    //    private FindPatientRecordPage findPatientRecordPage;
//    private PatientDetailsPage patientDetailsPage;
    @BeforeTest(groups = {"full"})
    public void setDriver() {
        captureVitalsPage = new CaptureVitalsPage();
        driver = captureVitalsPage.getCaptureVitalsPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        patientDetailsPage = new PatientDetailsPage();
//        findPatientRecordPage =new FindPatientRecordPage();
    }

    @Test(groups = {"full"})
    public void testCaptureVitals() throws InterruptedException {
        captureVitalsPage.selectMyRecord();
        captureVitalsPage.confirmPatient();
        captureVitalsPage.fillVitals();
        captureVitalsPage.confirmVitalDetails();

        // Use explicit wait to wait for success message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.toast-container.toast-position-top-right")));

        Assert.assertTrue(successMessage.getText().contains("Entered Vitals for"));
    }

//    @Test
//    public void testShowContactInfo() throws InterruptedException {
//        captureVitalsPage.selectMyRecord();
//        captureVitalsPage.showContactInfo();
//
//        // Use explicit wait to wait for contact info element
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement contactInfoElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact-info")));
//
//        Assert.assertNotEquals(contactInfoElement.getText(), "");
//    }


    @Test(groups = {"full"})
    public void testNoFindOtherPatient() throws InterruptedException {
//        CaptureVitalsPage captureVitalsPage = new CaptureVitalsPage();
//        WebDriver driver = captureVitalsPage.getCaptureVitalsPage();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        captureVitalsPage.selectMyRecord();
        captureVitalsPage.noFindOtherPatient();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).getText(), "Capture Vitals for Patient");
    }

    @Test(groups = {"full"})
    public void testSaveForm() throws InterruptedException {
//        CaptureVitalsPage captureVitalsPage = new CaptureVitalsPage();
//        WebDriver driver = captureVitalsPage.getCaptureVitalsPage();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        captureVitalsPage.selectMyRecord();
        captureVitalsPage.confirmPatient();
        captureVitalsPage.saveForm();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"confirmationQuestion\"]/h3")).getText(), "Confirm submission?");
    }

    @Test(groups = {"full"})
    public void testExitForm() throws InterruptedException {
//        CaptureVitalsPage captureVitalsPage = new CaptureVitalsPage();
//        WebDriver driver = captureVitalsPage.getCaptureVitalsPage();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        captureVitalsPage.selectMyRecord();
        captureVitalsPage.confirmPatient();
        captureVitalsPage.exitForm();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).getText(), "Capture Vitals for Patient");
    }

//    @Test
//    public void testConfirmSubmissionNo() throws InterruptedException {
////        CaptureVitalsPage captureVitalsPage = new CaptureVitalsPage();
////        WebDriver driver = captureVitalsPage.getCaptureVitalsPage();
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        captureVitalsPage.selectMyRecord();
//        captureVitalsPage.confirmPatient();
////        driver.findElement(By.id("w8")).sendKeys("123");
//        captureVitalsPage.fillVitals();
//        captureVitalsPage.confirmSubmissionNo();
//        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"formBreadcrumb\"]/li[1]/ul/li[1]/span")).getText(),"Height (cm)");
//    }

    @Test(groups = {"full"})
    public void testConfirmSubmissionSave() throws InterruptedException {
//        CaptureVitalsPage captureVitalsPage = new CaptureVitalsPage();
//        WebDriver driver = captureVitalsPage.getCaptureVitalsPage();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        captureVitalsPage.selectMyRecord();
        captureVitalsPage.confirmPatient();
        captureVitalsPage.fillVitals();
        captureVitalsPage.saveForm();
        captureVitalsPage.confirmSubmissionSave();
        Assert.assertTrue(driver.findElement(By.cssSelector("body > div.toast-container.toast-position-top-right")).getText().contains("Entered Vitals for"));
    }

    @AfterTest(groups = {"full"})
    public void quitDriver() {
        driver.quit();
    }
}
