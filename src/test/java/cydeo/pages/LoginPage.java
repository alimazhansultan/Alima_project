package cydeo.pages;

import cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "login")
    public WebElement emailTextbox;

    @FindBy(id = "password")
    public WebElement passwordTextbox;

    @FindBy(css = "div[class='clearfix oe_login_buttons'] button")
    public WebElement loginButton;

    @FindBy(css = "p[class='alert alert-danger']")
    public WebElement wrongCredentialsMessage;

    @FindBy(xpath = "//button[@data-toggle='collapse']")
    public WebElement userAccountDropdownBtn;

    @FindBy(xpath = "//a[text()='Log out']")
    public WebElement logOutBtn;

    public void clickUsernameDropdownBtn(String username) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//span[text()='" + username + "']"));
        element.click();
    }

}
