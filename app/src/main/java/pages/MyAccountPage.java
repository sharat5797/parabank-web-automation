package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MyAccountPage {
    private WebDriver driver;
    public WebDriver getMyAccountPage(){
        HomePage homePage = new HomePage();
        driver = homePage.getHomePage();
        WebElement elementToHover = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/i[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).build().perform();
        WebElement subElement = driver.findElement(By.xpath("//*[@id=\"user-account-menu\"]/li/a"));
        subElement.click();
        return driver;
    }

    public void changePassword(){
        driver.findElement(By.xpath("//*[@id=\"tasks\"]/a[1]")).click();
    }

    public void fillPasswords(){
        Faker faker = new Faker();
        String password = "Tempuser" + faker.number().numberBetween(10, 99);
        driver.findElement(By.id("oldPassword-field")).sendKeys("Admin123");
        driver.findElement(By.id("newPassword-field")).sendKeys(password);
        driver.findElement(By.id("confirmPassword-field")).sendKeys(password);
    }

    public void savePassword(){
        driver.findElement(By.id("save-button")).click();
    }
}
