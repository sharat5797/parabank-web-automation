package openmrs_tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyAccountPage;

public class MyAccountPageTest {
    @Test
    public void testMyAccount() throws InterruptedException {
        MyAccountPage myAccountPage = new MyAccountPage();
        WebDriver driver = myAccountPage.getMyAccountPage();
        Assert.assertEquals(driver.getTitle(),"My Account");
        driver.quit();
    }
}
