package openmrs_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MyAccountPage;

import java.time.Duration;

public class MyAccountPageTest {
    private MyAccountPage myAccountPage;
    private WebDriver driver;
    @BeforeTest (groups = { "full" })
    public void setup(){
        myAccountPage = new MyAccountPage();
        driver = myAccountPage.getMyAccountPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test (groups = { "full" })
    public void testMyAccount() throws InterruptedException {
//        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.findElement(By.cssSelector("#breadcrumbs > li:nth-child(2)")).getText(),"My Account");
    }

    @Test (groups = { "full" })
    public void testChangePassword() {
        myAccountPage.changePassword();
        myAccountPage.fillPasswords();
        myAccountPage.savePassword();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"error-message\"]/div/div[1]/p")).getText(),"Failed to change your new password");
    }

    @AfterTest (groups = { "full" })
    public void quitDriver(){
        driver.quit();
    }
}
