package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class usedCars extends basePage {
    List<WebElement> list;
    public usedCars(WebDriver driver){
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(@class, 'motors-heading-used-cars')]")));
    }

    public List<WebElement> listOfUsedCars(){
        list = driver.findElements(By.xpath("//li[@class='tmm-search-card-list-view']"));
         return list;
    }

    public void verifyEachListedCarsInfo(){
        for (WebElement car : list){
            Assert.assertTrue(car.findElement(By.xpath(".//div[@data-odometer]")).isDisplayed());
        }
    }
}
