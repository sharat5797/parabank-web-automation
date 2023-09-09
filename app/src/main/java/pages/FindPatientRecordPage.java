package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

}
