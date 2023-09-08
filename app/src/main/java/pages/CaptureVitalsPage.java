package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CaptureVitalsPage {
    private WebDriver driver=null;
    public WebDriver getCaptureVitalsPage(){
        HomePage homePage = new HomePage();
        driver = homePage.getHomePage();
        homePage.gotoCaptureVitalsPage();
        return driver;
    }

    public void selectFirstPatient(){
        driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr[1]")).click();
    }

    public void confirmPatient(){
        driver.findElement(By.id("coreapps-vitals-confirm")).click();
    }

    public void fillVitals(){
        driver.findElement(By.id("w8")).sendKeys("272");
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("w10")).sendKeys("80");
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("w12")).sendKeys("32");
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("w14")).sendKeys("220");
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("w16")).sendKeys("88");
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("w18")).sendKeys("60");
        driver.findElement(By.id("w20")).sendKeys("120");
        driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("w22")).sendKeys("98");
        driver.findElement(By.id("next-button")).click();
    }

    public void confirmVitalDetails() throws InterruptedException {
        driver.findElement(By.cssSelector("#confirmationQuestion > p:nth-child(6) > button")).click();
    }

}
