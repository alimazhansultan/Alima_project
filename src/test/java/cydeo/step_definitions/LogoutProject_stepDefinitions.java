package cydeo.step_definitions;

import cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LogoutProject_stepDefinitions {
    @Given("User already logged in")
    public void user_already_logged_in() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa.upgenix.net/web/login/");

        WebElement email = Driver.getDriver().findElement(By.id("login"));
        email.sendKeys("salesmanager15@info.com");

        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("salesmanager");

        WebElement loginButton = Driver.getDriver().findElement(By.cssSelector("div[class='clearfix oe_login_buttons'] button"));
        loginButton.click();
        Thread.sleep(4000);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "#Inbox - Odoo";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Successfull Login ");
        } else {
            System.out.println("Error");
        }
    }

    @When("user click to his own username")
    public void user_click_to_his_own_username() {
        WebElement userName = Driver.getDriver().findElement(By.className("oe_topbar_name"));
        userName.click();
    }
    @When("user click to Log Out button")
    public void user_click_to_log_out_button() {
        WebElement userName = Driver.getDriver().findElement(By.className("oe_topbar_name"));
        userName.click();
    }
    @Then("User in on log in page")
    public void user_in_on_log_in_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
