package DemoQAProject.Tests;

import DemoQAProject.Base.BaseTest;
import DemoQAProject.Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get(loginURL);
        homePage = new HomePage();
    }


    @Test(priority = 10)
    public void testCardElements() {
        homePage.clickOnCards("Elements");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/elements");
        WebElement header = driver.findElement(By.className("main-header"));
        Assert.assertEquals(header.getText(), "Elements");
        homePage.clickOnBanner();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
    }

    @Test(priority = 20)
    public void testCardForms() {
        homePage.clickOnCards("Forms");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/forms");
        WebElement header = driver.findElement(By.className("main-header"));
        Assert.assertEquals(header.getText(), "Forms");
        homePage.clickOnBanner();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
    }

    @Test (priority = 30)
    public void testCardAlerts() {
        homePage.clickOnCards("Alerts, Frame & Windows");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/alertsWindows");
        WebElement header = driver.findElement(By.className("main-header"));
        Assert.assertEquals(header.getText(), "Alerts, Frame & Windows");
        homePage.clickOnBanner();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
    }

    @Test (priority = 40)
    public void testCardWidgets() {
        homePage.clickOnCards("Widgets");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/widgets");
        WebElement header = driver.findElement(By.className("main-header"));
        Assert.assertEquals(header.getText(), "Widgets");
        homePage.clickOnBanner();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
    }

    @Test (priority = 50)
    public void testCardInteractions() {
        homePage.clickOnCards("Interactions");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/interaction");
        WebElement header = driver.findElement(By.className("main-header"));
        Assert.assertEquals(header.getText(), "Interactions");
        homePage.clickOnBanner();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
    }

    @Test (priority = 60)
    public void testCardBookStoreApplication() {
        scrollIntoView(homePage.cards.get(5));
        homePage.clickOnCards("Book Store Application");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/books");
        WebElement header = driver.findElement(By.className("main-header"));
        Assert.assertEquals(header.getText(), "Book Store");
        homePage.clickOnBanner();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
    }
}
