package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PatientDetailsPage {
    private WebDriver driver;

    public WebDriver getPatientDetailsPage() {
        FindPatientRecordPage findPatientRecordPage = new FindPatientRecordPage();
        driver = findPatientRecordPage.getFindPatientRecordPage();
        findPatientRecordPage.selectFirstPatient();
        return driver;
    }

    public void editRegistrationDetails() {
        driver.findElement(By.xpath("//*[@id=\"application.registrationapp.summary.editPatientLink\"]/div/div[2]")).click();
    }

    public void startVisit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if (driver.findElement(By.xpath("//*[@id=\"org.openmrs.module.coreapps.createVisit\"]")).getText().contains("Start Visit")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement startVisitIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#org\\.openmrs\\.module\\.coreapps\\.createVisit > div > div.col-1.col-lg-2 > i")));
            startVisitIcon.click();
            driver.findElement(By.xpath("//*[@id=\"start-visit-with-visittype-confirm\"]")).click();
        }
    }

    public void endVisit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if (driver.findElement(By.xpath("//*[@id=\"org.openmrs.module.coreapps.createVisit\"]")).getText().contains("End Visit")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement startVisitIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#referenceapplication\\.realTime\\.endVisit > div > div.col-1.col-lg-2 > i")));
            startVisitIcon.click();
            driver.findElement(By.xpath("//*[@id=\"end-visit-dialog\"]/div[2]/button[1]")).click();
        }
    }

}
