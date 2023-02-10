package DemoQAProject.Pages;

import DemoQAProject.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="userName")
    public WebElement usernameField;

    @FindBy(id="password")
    public WebElement passwordField;

    @FindBy(id="login")
    public WebElement loginButton;

    @FindBy(id="userName-value")
    public WebElement userNameValue;

    @FindBy(css = ".btn.btn-primary")
    public WebElement logoutButton;

    @FindBy(className = "mb-1")
    public WebElement notification;


    //-----------------------------------------

    public void logIn(){
        usernameField.sendKeys("Andrija82");
        passwordField.sendKeys("Andrija23!");
        loginButton.click();
    }

    public void insertUsername(String username){
        usernameField.sendKeys(username);
    }

    public void insertPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void logOut(){
        logoutButton.click();
    }

    public void clearUserNameField(){
        usernameField.clear();
    }

    public void clearUserPasswordField(){
        passwordField.clear();
    }

}
