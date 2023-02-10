package DemoQAProject.Tests;

import DemoQAProject.Base.BaseTest;
import DemoQAProject.Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookstoreTest extends BaseTest {

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


    public void logInAndGoToBookstorePage() {
        scrollIntoView(homePage.cards.get(5));
        homePage.clickOnCards("Book Store Application");
        scrollDown();
        sidebarPage.clickOnButton("Login");
        loginPage.logIn();
        waitForClickability(profilePage.goToBookstoreButton);
        profilePage.goToTheBookstore();
        WebElement header = driver.findElement(By.className("main-header"));
        Assert.assertEquals(header.getText(), "Book Store");
    }

    @Test(priority =10)
    public void addOneBook() throws InterruptedException {

        logInAndGoToBookstorePage();
        waitForClickability(bookstorePage.book1);

        bookstorePage.addBook("Git Pocket Guide");
        driver.navigate().back();

        scrollIntoView(sidebarPage.buttons.get(sidebarPage.buttons.size() - 1));
        sidebarPage.clickOnButton("Profile");
        Thread.sleep(1000);


        Assert.assertTrue(bookstorePage.book1OnTheAccount.isDisplayed());
        Assert.assertEquals(bookstorePage.book1OnTheAccount.getText(), "Git Pocket Guide");

        profilePage.deleteAllBooks();
        driver.navigate().refresh();
    }

    @Test(priority =20)
    public void addTwoBooks() throws InterruptedException {

        logInAndGoToBookstorePage();
        waitForClickability(bookstorePage.book1);

        bookstorePage.addBook("Git Pocket Guide");
        driver.navigate().back();

        bookstorePage.addBook("Learning JavaScript Design Patterns");
        driver.navigate().back();

        scrollIntoView(sidebarPage.buttons.get(sidebarPage.buttons.size() - 1));
        sidebarPage.clickOnButton("Profile");
        Thread.sleep(1000);

        Assert.assertTrue(bookstorePage.book1OnTheAccount.isDisplayed());
        Assert.assertEquals(bookstorePage.book1OnTheAccount.getText(), "Git Pocket Guide");

        Assert.assertTrue(bookstorePage.book2OnTheAccount.isDisplayed());
        Assert.assertEquals(bookstorePage.book2OnTheAccount.getText(), "Learning JavaScript Design Patterns");

        scrollIntoView(profilePage.deleteAllBooksButton);
        profilePage.deleteAllBooks();
        driver.navigate().refresh();
    }

    @Test(priority =30)
    public void addThreeBooks() throws InterruptedException {

        logInAndGoToBookstorePage();
        waitForClickability(bookstorePage.book1);

        bookstorePage.addBook("Git Pocket Guide");
        driver.navigate().back();

        bookstorePage.addBook("Learning JavaScript Design Patterns");
        driver.navigate().back();

        bookstorePage.addBook("Designing Evolvable Web APIs with ASP.NET");
        driver.navigate().back();

        scrollIntoView(sidebarPage.buttons.get(sidebarPage.buttons.size() - 1));
        sidebarPage.clickOnButton("Profile");
        Thread.sleep(1000);

        Assert.assertTrue(bookstorePage.book1OnTheAccount.isDisplayed());
        Assert.assertEquals(bookstorePage.book1OnTheAccount.getText(), "Git Pocket Guide");

        Assert.assertTrue(bookstorePage.book2OnTheAccount.isDisplayed());
        Assert.assertEquals(bookstorePage.book2OnTheAccount.getText(), "Learning JavaScript Design Patterns");

        Assert.assertTrue(bookstorePage.book3OnTheAccount.isDisplayed());
        Assert.assertEquals(bookstorePage.book3OnTheAccount.getText(), "Designing Evolvable Web APIs with ASP.NET");

        scrollIntoView(profilePage.deleteAllBooksButton);
        profilePage.deleteAllBooks();
        driver.navigate().refresh();
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.manage().deleteAllCookies();
//        driver.quit();
//
//    }
}
