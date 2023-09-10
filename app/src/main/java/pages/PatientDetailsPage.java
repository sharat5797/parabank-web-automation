package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientDetailsPage {
    private WebDriver driver;
    public WebDriver getPatientDetailsPage(){
        FindPatientRecordPage findPatientRecordPage = new FindPatientRecordPage();
        driver = findPatientRecordPage.getFindPatientRecordPage();
        findPatientRecordPage.selectFirstPatient();
        return driver;
    }

    public void editRegistrationDetails(){
        driver.findElement(By.xpath("//*[@id=\"application.registrationapp.summary.editPatientLink\"]/div/div[2]")).click();
    }

}
