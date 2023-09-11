package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class EditRegistrationInfoPage {
    private WebDriver driver;
    public WebDriver getEditRegistrationInfoPage() throws InterruptedException {
        FindPatientRecordPage findPatientRecordPage = new FindPatientRecordPage();
        driver = findPatientRecordPage.getFindPatientRecordPage();
        findPatientRecordPage.selectMyRecord();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.partialLinkText("Edit Registration Information")).click();
        return driver;
    }

    public void editDemoGraphicsName(){
        driver.findElement(By.xpath("//*[@id=\"demographics-edit-link\"]")).click();
        driver.findElement(By.name("givenName")).clear();
        driver.findElement(By.name("givenName")).sendKeys("XYZ");
        driver.findElement(By.name("familyName")).clear();
        driver.findElement(By.name("familyName")).sendKeys("ZZZ");
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("registration-submit")).click();
    }

    public void editContactInfo(){
        driver.findElement(By.xpath("//*[@id=\"contactInfo-edit-link\"]")).click();
        driver.findElement(By.id("address1")).clear();
        driver.findElement(By.id("address1")).sendKeys("abcd");
        driver.findElement(By.id("address2")).clear();
        driver.findElement(By.id("address2")).sendKeys("abcd");
        driver.findElement(By.id("cityVillage")).clear();
        driver.findElement(By.id("cityVillage")).sendKeys("xyz");
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("registration-submit")).click();

    }

}
