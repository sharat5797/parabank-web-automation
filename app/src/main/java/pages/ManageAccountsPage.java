package pages;

import com.github.javafaker.Faker;
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

    public void addNewAccount(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/a")).click();
    }

    public void fillUserAccountDetails(){
        driver.findElement(By.id("adminui-familyName-field")).sendKeys("Temp");
        driver.findElement(By.id("adminui-givenName-field")).sendKeys("User");
        driver.findElement(By.id("adminui-gender-0-field")).click();
        driver.findElement(By.id("adminui-addUserAccount")).click();

        Faker faker = new Faker();
        String randomUserName = "tempuser" + faker.number().numberBetween(10, 99);

        driver.findElement(By.id("adminui-username-field")).sendKeys(randomUserName);
        driver.findElement(By.id("adminui-privilegeLevel-field")).click();
        driver.findElement(By.xpath("//*[@id=\"adminui-privilegeLevel-field\"]/option[2]")).click();
        driver.findElement(By.id("adminui-password-field")).sendKeys("Test1234");
        driver.findElement(By.id("adminui-confirmPassword-field")).sendKeys("Test1234");
        driver.findElement(By.id("adminui-forceChangePassword")).click();
        driver.findElement(By.id("adminui-capabilities-Application: Administers System")).click();
    }

    public void saveAccount(){
        driver.findElement(By.id("save-button")).click();
    }

    public void searchUser(){
        driver.findElement(By.xpath("//*[@id=\"list-accounts_filter\"]/label/input")).sendKeys("Super User");
    }
}
