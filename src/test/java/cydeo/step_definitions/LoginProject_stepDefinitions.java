package cydeo.step_definitions;

import cydeo.pages.LoginPage;
import cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginProject_stepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("User navigate to login page")
    public void user_navigate_to_login_page() {
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa.upgenix.net/web/login/");
    }


    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        loginPage.emailTextbox.sendKeys("salesmanager15@info.com");

        loginPage.passwordTextbox.sendKeys("salesmanager");
    }

    @When("User clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();
    }

    @Then("User can see dashboard")
    public void user_can_see_dashboard() throws InterruptedException {
        Thread.sleep(4000);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "#Inbox - Odoo";

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("User enters invalid {string} and {string}")
    public void user_enters_invalid_and(String email, String password) {
        loginPage.emailTextbox.sendKeys(email);
        loginPage.passwordTextbox.sendKeys(password);
    }

    @Then("User sees the Wrong login and password message displayed")
    public void user_sees_the_wrong_login_password_message_displayed() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(loginPage.wrongCredentialsMessage.isDisplayed());
    }

    @When("User enters valid {string} and leaves password field empty")
    public void user_enters_valid(String email) {
        loginPage.emailTextbox.sendKeys(email);
    }

    @Then("User should see message")
    public void user_should_see_message() {
        Assert.assertTrue(loginPage.passwordTextbox.getText().isEmpty());

        boolean required = Boolean.parseBoolean(loginPage.passwordTextbox.getAttribute("required"));
        Assert.assertTrue(required);

        String validationMsg = loginPage.passwordTextbox.getAttribute("validationMessage");
        System.out.println(validationMsg);
        Assert.assertEquals("Please fill out this field.", validationMsg);
    }


    @Then("User can see bullet signs by default")
    public void user_can_see_bullet_signs_by_default() {
        Assert.assertEquals("password", loginPage.passwordTextbox.getAttribute("type"));

    }

    @Then("User clicks enter button")
    public void user_clicks_enter_button() {
        loginPage.loginButton.sendKeys(Keys.RETURN);
    }

}
