package DemoQAProject.Tests;

import DemoQAProject.Base.BaseTest;
import DemoQAProject.Pages.HomePage;
import DemoQAProject.Pages.SidebarPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SidebarPageTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get(loginURL);
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
    }

    @Test(priority = 10)
    public void elementsButtonsTest(){
        homePage.clickOnCards("Elements");

        sidebarPage.clickOnButton("Text Box");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/text-box");

        sidebarPage.clickOnButton("Check Box");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/checkbox");

        sidebarPage.clickOnButton("Radio Button");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/radio-button");

        sidebarPage.clickOnButton("Web Tables");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/webtables");

        sidebarPage.clickOnButton("Buttons");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/buttons");

        sidebarPage.clickOnButton("Links");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/links");

        sidebarPage.clickOnButton("Broken Links - Images");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/broken");

        scrollDown();
        sidebarPage.clickOnButton("Upload and Download");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/upload-download");

        scrollDown();
        sidebarPage.clickOnButton("Dynamic Properties");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/dynamic-properties");
    }

    @Test(priority = 20)
    public void formsButtonsTest(){
        homePage.clickOnCards("Forms");
        sidebarPage.clickOnButton("Practice Form");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/automation-practice-form");
    }

    @Test(priority = 30)
    public void alertsButtonsTest() {
        homePage.clickOnCards("Alerts, Frame & Windows");

        sidebarPage.clickOnButton("Browser Windows");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/browser-windows");

        sidebarPage.clickOnButton("Alerts");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/alerts");

        sidebarPage.clickOnButton("Frames");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/frames");

        sidebarPage.clickOnButton("Nested Frames");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/nestedframes");

        sidebarPage.clickOnButton("Modal Dialogs");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/modal-dialogs");
    }

    @Test(priority = 40)
    public void widgetsButtonsTest() {
        homePage.clickOnCards("Widgets");

        sidebarPage.clickOnButton("Accordian");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/accordian");

        sidebarPage.clickOnButton("Auto Complete");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/auto-complete");

        sidebarPage.clickOnButton("Date Picker");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/date-picker");

        scrollDown();
        sidebarPage.clickOnButton("Slider");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/slider");

        scrollDown();
        sidebarPage.clickOnButton("Progress Bar");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/progress-bar");

        scrollDown();
        sidebarPage.clickOnButton("Tabs");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/tabs");

        scrollDown();
        sidebarPage.clickOnButton("Tool Tips");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/tool-tips");

        scrollDown();
        sidebarPage.clickOnButton("Menu");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/menu");

        scrollDown();
        sidebarPage.clickOnButton("Select Menu");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/select-menu");
    }

    @Test(priority = 50)
    public void interactionsButtonsTest() {
        homePage.clickOnCards("Interactions");

        sidebarPage.clickOnButton("Sortable");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/sortable");

        sidebarPage.clickOnButton("Selectable");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/selectable");

        scrollDown();
        sidebarPage.clickOnButton("Resizable");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/resizable");

        scrollDown();
        sidebarPage.clickOnButton("Droppable");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/droppable");

        scrollDown();
        sidebarPage.clickOnButton("Dragabble");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/dragabble");
    }

    @Test(priority = 60)
    public void bookstoreButtonsTest() {
        scrollIntoView(homePage.cards.get(5));
        homePage.clickOnCards("Book Store Application");

        scrollDown();
        sidebarPage.clickOnButton("Login");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");

        scrollDown();
        sidebarPage.clickOnButton("Book Store");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/books");

        scrollDown();
        sidebarPage.clickOnButton("Profile");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", sidebarPage.buttons.get(sidebarPage.buttons.size()-1));
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/swagger/");
    }
}
