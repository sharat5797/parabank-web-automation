package pages;

import drivers.DriverCreator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CaptureVitalsPage {
    private WebDriver driver = null;

    //    public CaptureVitalsPage() {
//        DriverCreator driverCreator = new DriverCreator();
//        driver = driverCreator.create("chrome");
//    }
    public WebDriver getCaptureVitalsPage() {
        if (driver == null) {
            HomePage homePage = new HomePage();
            driver = homePage.getHomePage();
            homePage.gotoCaptureVitalsPage();
        }
        return driver;
    }

    public void selectFirstPatient() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr[1]")).click();
    }

    public void confirmPatient() {
        driver.findElement(By.xpath("//*[@id=\"coreapps-vitals-confirm\"]")).click();
    }

    public void fillVitals() {
        driver.findElement(By.id("w8")).sendKeys("272");
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("w10")).sendKeys("80");
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("w12")).sendKeys("32");
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("w14")).sendKeys("220");
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("w16")).sendKeys("88");
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("w18")).sendKeys("60");
        driver.findElement(By.id("w20")).sendKeys("120");
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("w22")).sendKeys("98");
        driver.findElement(By.id("next-button")).click();
    }

    public void confirmVitalDetails() throws InterruptedException {
        driver.findElement(By.cssSelector("#confirmationQuestion > p:nth-child(6) > button")).click();
    }

    public void showContactInfo() {
        driver.findElement(By.xpath("//*[@id=\"patient-header-contactInfo\"]/i[1]")).click();
    }

    public String getContactInfo() {
        String contactInfo = driver.findElement(By.xpath("//*[@id=\"contactInfoContent\"]/div/span[1]")).getText();
        return contactInfo;
    }

    public void noFindOtherPatient() {
        driver.findElement(By.xpath("//*[@id=\"actions\"]/button[2]")).click();
    }

    public void saveForm() {
        driver.findElement(By.xpath("//*[@id=\"save-form\"]")).click();
    }

    public void exitForm() {
        driver.findElement(By.xpath("//*[@id=\"form-actions-container\"]/a[2]")).click();
    }

    public void confirmSubmissionNo() {
        driver.findElement(By.xpath("//*[@id=\"confirmationQuestion\"]/p[2]/input")).click();
    }

    public void confirmSubmissionSave() {
        driver.findElement(By.xpath("//*[@id=\"confirmationQuestion\"]/p[1]/button")).click();
    }

    public void selectTempUser() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.findElement(By.id("patient-search")).sendKeys("100N15");
        driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr")).click();
    }

    public void startVisit()  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement webElement = null;

        try {
            webElement = driver.findElement(By.xpath("//*[@id=\"coreapps-vitals-confirm\"]"));
        } catch (NoSuchElementException e) {
            webElement = null;
        }
        if (webElement == null) {
            driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/div/div[1]")).click();
            if(!driver.findElement(By.xpath("//*[@id=\"org.openmrs.module.coreapps.createVisit\"]")).getText().contains("Start Visit")){
                driver.findElement(By.xpath("//div[contains(text(),'Start Visit')]")).click();
                driver.findElement(By.xpath("//button[@id='start-visit-with-visittype-confirm']")).click();
            }
        }

    }

}
