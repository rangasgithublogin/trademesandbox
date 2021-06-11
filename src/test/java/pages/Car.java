package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Car extends basePage {
    public Car(WebDriver driver){
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '/motors/used-cars/')]")));
    }

    public void verifyCarInfo(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='AttributesDisplay_attributesSection']//li"));
        Assert.assertTrue("Number plate is empty",
                getKeyDetailsAttributeValue("Number plate", list).getText().trim().length() > 0);
        Assert.assertTrue("Kilometres is empty",
                getKeyDetailsAttributeValue("Kilometres", list).getText().trim().length() > 0);
        Assert.assertTrue("Body is empty",
                getKeyDetailsAttributeValue("Body", list).getText().trim().length() > 0);
        Assert.assertTrue("Seats is empty",
                getKeyDetailsAttributeValue("Seats", list).getText().trim().length() > 0);
    }

}
