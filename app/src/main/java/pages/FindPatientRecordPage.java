package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindPatientRecordPage {
    private WebDriver driver;
    public WebDriver getFindPatientRecordPage(){
        HomePage homePage = new HomePage();
        driver = homePage.getHomePage();
        driver.findElement(By.cssSelector("#coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")).click();
        return driver;
    }

    public void selectFirstPatient(){
        driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr[1]")).click();
    }

    public void selectMyRecord() throws InterruptedException {
        driver.findElement(By.id("patient-search")).sendKeys("100MWE");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement myRecordId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr/td[1]")));
        Thread.sleep(4000);
            driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr")).click();
//        return driver;
    }

}
