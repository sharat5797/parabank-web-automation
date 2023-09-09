package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SystemAdministrationPage {
    private WebDriver driver;

    public WebDriver getSystemAdministrationPage() {
        HomePage homePage = new HomePage();
        driver = homePage.getHomePage();
        driver.findElement(By.cssSelector("#coreapps-systemadministration-homepageLink-coreapps-systemadministration-homepageLink-extension")).click();
        return driver;
    }

}
