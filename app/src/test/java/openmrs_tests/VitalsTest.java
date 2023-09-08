package openmrs_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CaptureVitalsPage;
import pages.HomePage;

import java.time.Duration;

public class VitalsTest {
    @Test
    public void testCaptureVitals() throws InterruptedException {
        CaptureVitalsPage captureVitalsPage = new CaptureVitalsPage();
        WebDriver driver = captureVitalsPage.getCaptureVitalsPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        captureVitalsPage.selectFirstPatient();
        captureVitalsPage.confirmPatient();
        captureVitalsPage.fillVitals();
        captureVitalsPage.confirmVitalDetails();
        Assert.assertTrue(driver.findElement(By.cssSelector("body > div.toast-container.toast-position-top-right")).getText().contains("Entered Vitals for"));
        driver.quit();
    }
}
