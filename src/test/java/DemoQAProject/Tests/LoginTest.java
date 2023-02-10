package DemoQAProject.Tests;

import DemoQAProject.Base.BaseTest;
import DemoQAProject.Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(loginURL);
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        loginPage = new LoginPage();
        bookstorePage = new BookstorePage();
        profilePage = new ProfilePage();
    }

    public void goToLoginPage(){
        scrollIntoView(homePage.cards.get(5));
        homePage.clickOnCards("Book Store Application");
        scrollDown();
        sidebarPage.clickOnButton("Login");
        String expectedURL = "https://demoqa.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        WebElement header = driver.findElement(By.className("main-header"));
        Assert.assertEquals(header.getText(), "Login");
    }

    @Test
    public void userCanLogIn() throws InterruptedException {
        goToLoginPage();
        loginPage.clearUserNameField();
        loginPage.clearUserPasswordField();
        loginPage.insertUsername("Andrija82");
        loginPage.insertPassword("Andrija23!");
        loginPage.clickOnLoginButton();

        Thread.sleep(500);
        Assert.assertTrue(loginPage.userNameValue.isDisplayed());
        Assert.assertEquals(loginPage.userNameValue.getText(), "Andrija82");
        Assert.assertTrue(loginPage.logoutButton.isDisplayed());
        loginPage.logOut();
    }

    @Test
    public void userCannotLogInWithInvalidUsername() throws InterruptedException {
        goToLoginPage();
        loginPage.clearUserNameField();
        loginPage.clearUserPasswordField();
        loginPage.insertUsername("Andrija");
        loginPage.insertPassword("Andrija23!");
        loginPage.clickOnLoginButton();

        Thread.sleep(500);
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertEquals(loginPage.notification.getText(), "Invalid username or password!");
    }

    @Test
    public void userCannotLogInWithInvalidPassword() throws InterruptedException {
        goToLoginPage();
        loginPage.clearUserNameField();
        loginPage.clearUserPasswordField();
        loginPage.insertUsername("Andrija82");
        loginPage.insertPassword("Andrija");
        loginPage.clickOnLoginButton();

        Thread.sleep(500);
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertEquals(loginPage.notification.getText(), "Invalid username or password!");
    }

    @Test
    public void userCannotLogInWithInvalidUsernameAndPassword() throws InterruptedException {
        goToLoginPage();
        loginPage.clearUserNameField();
        loginPage.clearUserPasswordField();
        loginPage.insertUsername("Andrija");
        loginPage.insertPassword("Andrija");
        loginPage.clickOnLoginButton();

        Thread.sleep(500);
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertEquals(loginPage.notification.getText(), "Invalid username or password!");
    }

    @Test
    public void userCannotLogInWithoutUsername() throws InterruptedException {
        goToLoginPage();
        loginPage.clearUserNameField();
        loginPage.clearUserPasswordField();
        loginPage.insertPassword("Andrija23!");
        loginPage.clickOnLoginButton();

        Thread.sleep(500);
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test
    public void userCannotLogInWithoutPassword() throws InterruptedException {
        goToLoginPage();
        loginPage.clearUserNameField();
        loginPage.clearUserPasswordField();
        loginPage.insertUsername("Andrija82");
        loginPage.clickOnLoginButton();

        Thread.sleep(500);
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test
    public void userCannotLogInWithEmptyFields() throws InterruptedException {
        goToLoginPage();
        loginPage.clearUserNameField();
        loginPage.clearUserPasswordField();
        loginPage.clickOnLoginButton();

        Thread.sleep(500);
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test
    public void userCanLogOut() throws InterruptedException {
        goToLoginPage();
        loginPage.logIn();
        Thread.sleep(500);
        Assert.assertTrue(loginPage.userNameValue.isDisplayed());
        Assert.assertEquals(loginPage.userNameValue.getText(), "Andrija82");
        Assert.assertTrue(loginPage.logoutButton.isDisplayed());
        loginPage.logOut();

        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }
}
