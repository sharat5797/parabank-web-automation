package openmrs_tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    @Test
    public void testLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        WebDriver driver = loginPage.getLoginPage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.enterCredentials("admin", "Admin123");
        loginPage.selectLocation("Registration Desk");
        loginPage.doLogin();
        Assert.assertEquals(driver.getTitle(),"Home");
        driver.quit();
    }
}
