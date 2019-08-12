import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CucumberJava {

  private WebDriver driver = null;


  public CucumberJava() {
    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/../../deploy/geckodriver");
  }


  @Before
  public void before(Scenario scenario) {
    System.out.println("------------------------------");
    System.out.println("Starting - " + scenario.getName());
    System.out.println("------------------------------");
  }

  @After
  public void after(Scenario scenario) {
    System.out.println("------------------------------");
    System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
    System.out.println("------------------------------");
    driver.quit();
  }

  @Given("^I open the browser$")
  public void openBrowser() {
    driver = new FirefoxDriver();
  }

  @When("^I open DigitalArts website$")
  public void goToFacebook() {
    driver.navigate().to("file://" + System.getProperty("user.dir") + "/src/main/resources/templates/index.html");
  }

  @Then("^A field called password should exist$")
  public void loginButton() {
    Assert.assertTrue(driver.findElement(By.name("password")).isEnabled());
  }

}
