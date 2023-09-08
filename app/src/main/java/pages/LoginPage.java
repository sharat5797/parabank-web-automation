package pages;

import drivers.DriverCreator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public WebDriver getLoginPage() {
        DriverCreator driverCreator = new DriverCreator();
        driver = driverCreator.create("chrome");
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        return driver;
    }

    public void enterCredentials(String id, String password) {
        driver.findElement(By.id("username")).sendKeys(id);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void selectLocation(String location) {
        switch (location) {
            case "Inpatient Ward":
                driver.findElement(By.id("Inpatient Ward")).click();
                break;
            case "Isolation Ward":
                driver.findElement(By.id("Isolation Ward")).click();
                break;
            case "Laboratory":
                driver.findElement(By.id("Laboratory")).click();
                break;
            case "Outpatient Clinic":
                driver.findElement(By.id("Outpatient Clinic")).click();
                break;
            case "Pharmacy":
                driver.findElement(By.id("Pharmacy")).click();
                break;
            case "Registration Desk":
                driver.findElement(By.id("Registration Desk")).click();
                break;
        }
    }

    public void doLogin() {
        driver.findElement(By.id("loginButton")).click();
    }

}
