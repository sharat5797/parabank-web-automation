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
//        findPatientRecordPage.selectMyRecord();
        return driver;
    }

    public void editRegistrationDetails() {
        driver.findElement(By.xpath("//*[@id=\"application.registrationapp.summary.editPatientLink\"]/div/div[2]")).click();
    }

    public void startVisit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if (driver.findElement(By.xpath("//*[@id=\"org.openmrs.module.coreapps.createVisit\"]")).getText().contains("Start Visit")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement startVisitIcon = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Start Visit")));
            startVisitIcon.click();
            driver.findElement(By.xpath("//*[@id=\"start-visit-with-visittype-confirm\"]")).click();
        }
    }

    public void endVisit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if (driver.findElement(By.xpath("//*[@id=\"org.openmrs.module.coreapps.createVisit\"]")).getText().contains("End Visit")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement startVisitIcon = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("End Visit")));
            startVisitIcon.click();
            driver.findElement(By.xpath("//*[@id=\"end-visit-dialog\"]/div[2]/button[1]")).click();
        }
    }

    public void navigateToEditRegistrationPage(){
        driver.findElement(By.partialLinkText("Edit Registration Information")).click();
    }

}
