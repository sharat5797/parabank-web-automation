package openmrs_tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.MyAccountPage;

public class MyAccountPageTest {
    @Test
    public void testMyAccount() throws InterruptedException {
        MyAccountPage myAccountPage = new MyAccountPage();
        WebDriver driver = myAccountPage.getMyAccountPage();
        Thread.sleep(4000);
        System.out.println(driver.getTitle());

    }
}
