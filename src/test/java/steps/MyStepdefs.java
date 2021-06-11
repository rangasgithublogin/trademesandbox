package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import pages.Car;
import pages.homePage;
import pages.usedCars;

public class MyStepdefs {
    String url = "https://www.tmsandbox.co.nz/";
    MutablePicoContainer pico = new DefaultPicoContainer();
    @Before
    public void loadDriver(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        pico.addComponent(driver);
    }
    @Given("I navigate to trademe sandbox")
    public void i_navigate_to_trademe() {
        WebDriver driver = pico.getComponent(WebDriver.class);
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("I search for used cars")
    public void i_search_for_used_cars() {
        WebDriver driver = pico.getComponent(WebDriver.class);
        homePage home = new homePage(driver);
        home.searchUsedCars();
    }
    @After
    public void unloadDriver(){
        WebDriver driver = pico.getComponent(WebDriver.class);
        driver.close();
        driver.quit();
    }

    @Then("the Used Cars listing is displayed")
    public void theUsedCarsListingIsDisplayed() {
        WebDriver driver = pico.getComponent(WebDriver.class);
        usedCars usedcars = new usedCars(driver);
        Assert.assertTrue(usedcars.listOfUsedCars().size() > 0);
        pico.addComponent(usedcars);
    }

    @And("I verify the queried car's info")
    public void iVerifyTheQueriedCarsInfo() {
        usedCars usedcars = pico.getComponent(usedCars.class);
        usedcars.listOfUsedCars().get(0).click();
        Car car = new Car(pico.getComponent(WebDriver.class));
        car.verifyCarInfo();
    }
}
