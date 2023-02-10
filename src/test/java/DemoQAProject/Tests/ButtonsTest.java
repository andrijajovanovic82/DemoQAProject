package DemoQAProject.Tests;

import DemoQAProject.Base.BaseTest;
import DemoQAProject.Pages.ButtonsPage;
import DemoQAProject.Pages.HomePage;
import DemoQAProject.Pages.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(loginURL);
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        buttonsPage = new ButtonsPage();
    }

    public void goToButtonsPage(){
        homePage.clickOnCards("Elements");
        sidebarPage.clickOnButton("Buttons");
        String expectedURL = "https://demoqa.com/buttons";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        WebElement header = driver.findElement(By.className("main-header"));
        Assert.assertEquals(header.getText(), "Buttons");
    }

    @Test(priority = 10)
    public void doubleClickOnButton() throws InterruptedException {
        goToButtonsPage();

        doubleClick(buttonsPage.buttons.get(0));
        Assert.assertEquals(buttonsPage.doubleClickNotification.getText(), "You have done a double click");
    }

    @Test(priority = 20)
    public void rightClickOnButton() {
        goToButtonsPage();

        rightClick(buttonsPage.buttons.get(1));
        Assert.assertEquals(buttonsPage.rightClickNotification.getText(), "You have done a right click");
    }

    @Test (priority = 30)
    public void clickOnButton() {
        goToButtonsPage();

        buttonsPage.clickOnButton();
        Assert.assertEquals(buttonsPage.leftClickNotification.getText(), "You have done a dynamic click");
    }

}
