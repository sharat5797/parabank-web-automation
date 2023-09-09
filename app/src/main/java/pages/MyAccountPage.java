package pages;

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
}
