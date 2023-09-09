package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageAccountsPage {
    private WebDriver driver;
    public WebDriver getManageAccountsPage(){
        SystemAdministrationPage systemAdministrationPage = new SystemAdministrationPage();
        driver = systemAdministrationPage.getSystemAdministrationPage();
        driver.findElement(By.cssSelector("#org-openmrs-module-adminui-accounts-app")).click();
        return driver;
    }
}
