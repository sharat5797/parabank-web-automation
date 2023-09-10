package openmrs_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ManageAccountsPage;

public class ManageAccountsPageTest {
    private WebDriver driver;
    private ManageAccountsPage manageAccountsPage;

    @BeforeTest (groups = { "full" })
    public void setup() {
        manageAccountsPage = new ManageAccountsPage();
        driver = manageAccountsPage.getManageAccountsPage();
    }

    @Test(groups = { "full" })
    public void testManageAccounts() {
        Assert.assertEquals(driver.getTitle(), "OpenMRS Electronic Medical Record");
    }

    @Test (groups = { "full" })
    public void testAddNewAccount() throws InterruptedException {
        manageAccountsPage.addNewAccount();
        manageAccountsPage.fillUserAccountDetails();
        manageAccountsPage.saveAccount();
        Assert.assertEquals(driver.findElement(By.cssSelector("body > div.toast-container.toast-position-top-right")).getText(),"Account Saved Successfully");
    }

    @Test (groups = { "full" })
    public void testSearchUser() {
        manageAccountsPage.searchUser();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"list-accounts\"]/tbody/tr/td[1]")).getText(),"Super User");
    }

    @AfterTest (groups = { "full" })
    public void quitDriver() {
        driver.quit();
    }

}
