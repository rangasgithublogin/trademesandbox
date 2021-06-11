package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class basePage {
    WebDriver driver;
    WebDriverWait wait;
    basePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 4);
    }

    public WebElement getKeyDetailsAttributeValue(String label, List<WebElement> list){
        for (WebElement attributes : list){
            if (attributes.findElement(By.xpath(".//div//label[@class='motors-attribute-label']"))
                    .getText().equalsIgnoreCase(label))
                return attributes.findElement(By.xpath(".//div//span[@class='motors-attribute-value']"));
        }
        return null;
    }
}
