package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver=null;
    public WebDriver getHomePage(){
        LoginPage loginPage = new LoginPage();
        driver = loginPage.getLoginPage();
        loginPage.enterCredentials("admin","Admin123");
        loginPage.selectLocation("Registration Desk");
        loginPage.doLogin();
        return driver;
    }

    public void gotoCaptureVitalsPage(){
        driver.findElement(By.id("referenceapplication-vitals-referenceapplication-vitals-extension")).click();
    }

}
