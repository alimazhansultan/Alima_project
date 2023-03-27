package cydeo.step_definitions;

import cydeo.pages.HomePage;
import cydeo.pages.LoginPage;
import cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LogoutProject_stepDefinitions {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    WebDriver driver = Driver.getDriver();

    @Given("User already logged in")
    public void user_already_logged_in() throws InterruptedException {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa.upgenix.net/web/login/");

        loginPage.emailTextbox.sendKeys("salesmanager15@info.com");
        loginPage.passwordTextbox.sendKeys("salesmanager");
        loginPage.loginButton.click();
        Thread.sleep(4000);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "#Inbox - Odoo";

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("user click to his own username")
    public void user_click_to_his_own_username() {
        homePage.usernameButton.click();
    }

    @When("user click to Log Out button")
    public void user_click_to_log_out_button() {
        homePage.logOutButton.click();

    }

    @Then("User in on log in page")
    public void user_in_on_log_in_page() {
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Then("User clicks the step back button after successfully logged out.")
    public void user_clicks_the_step_back_button_after_successfully_logged_out() {
        Driver.getDriver().navigate().back();
    }

    @Then("can not go to the home page again.")
    public void can_not_go_to_the_home_page_again() {
        Assert.assertFalse(homePage.usernameButton.isDisplayed());
    }

    @When("User closes tab")
    public void user_closes_tab() {
        driver.close();
    }

    @When("User navigates back to homepage")
    public void user_navigates_to_home_page() {
        driver.get("https://qa.upgenix.net/web?#menu_id=115&action=120&active_id=channel_inbox");
    }

    @Then("User must be logged out")
    public void user_must_be_logged_out() {
        Assert.assertFalse(homePage.usernameButton.isDisplayed());
    }

}