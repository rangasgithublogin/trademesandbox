package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class homePage extends basePage {
    public homePage(WebDriver driver){
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src, 'tm-logo')]")));
    }

    public void searchUsedCars(){
        String id = "SearchTabs1_MotorsLink";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        driver.findElement(By.id(id)).click();
        String xpath = "//a[@href='/motors/used-cars']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }
}
