package openmrs_tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ManageAccountsPage;

public class ManageAccountsPageTest {
    @Test
    public void testManageAccounts() {
        ManageAccountsPage manageAccountsPage = new ManageAccountsPage();
        WebDriver driver = manageAccountsPage.getManageAccountsPage();
        Assert.assertEquals(driver.getTitle(), "OpenMRS Electronic Medical Record");
        driver.quit();
    }
}
