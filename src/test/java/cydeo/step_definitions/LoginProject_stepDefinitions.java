package cydeo.step_definitions;

import cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginProject_stepDefinitions {
    @Given("User navigate to login page")
    public void user_navigate_to_login_page() {
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa.upgenix.net/web/login/");
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        WebElement email = Driver.getDriver().findElement(By.id("login"));
        email.sendKeys("salesmanager15@info.com");

        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("salesmanager");
    }

    @When("User clicks login button")
    public void user_clicks_login_button() {
        WebElement loginButton = Driver.getDriver().findElement(By.cssSelector("div[class='clearfix oe_login_buttons'] button"));
        loginButton.click();
    }

    @Then("User can see dashboard")
    public void user_can_see_dashboard() throws InterruptedException {
        Thread.sleep(4000);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "#Inbox - Odoo";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Successfull Login ");
        } else {
            System.out.println("Error");
        }
    }

    @When("User enters invalid {string} and {string}")
    public void user_enters_invalid_and(String email, String password) {

        WebElement emailTextbox = Driver.getDriver().findElement(By.id("login"));
        emailTextbox.sendKeys(email);

        WebElement passwordTextbox = Driver.getDriver().findElement(By.id("password"));
        passwordTextbox.sendKeys(password);
    }

    @Then("User sees the Wrong login and password message displayed")
    public void user_sees_the_wrong_login_password_message_displayed() throws InterruptedException {
        WebElement wrongCredentialsMessage = Driver.getDriver().findElement(By.cssSelector("p[class='alert alert-danger']"));
        if (wrongCredentialsMessage.isDisplayed()) {
            System.out.println("User see wrong credentials message");
        } else {
            System.out.println("User cant see the message");
        }


    }

    @When("User enters valid {string} and leaves password field empty")
    public void user_enters_valid(String email) {
        WebElement emailField = Driver.getDriver().findElement(By.id("login"));
        emailField.sendKeys(email);
    }

    @Then("User should see message")
    public void user_should_see_message() {
        Assert.assertTrue(Driver.getDriver().findElement(By.id("password")).getText().isEmpty());

        boolean required = Boolean.parseBoolean(Driver.getDriver().findElement(By.id("password")).getAttribute("required"));
        Assert.assertTrue(required);

        String validationMsg = Driver.getDriver().findElement(By.id("password")).getAttribute("validationMessage");
        System.out.println(validationMsg);
        Assert.assertEquals( "Please fill out this field.", validationMsg);
    }


    @Then("User can see bullet signs by default")
    public void user_can_see_bullet_signs_by_default() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User clicks enter button")
    public void user_clicks_enter_button() {
        WebElement loginButton = Driver.getDriver().findElement(By.cssSelector("div[class='clearfix oe_login_buttons'] button"));
        loginButton.sendKeys(Keys.RETURN);
    }

}
