package DemoQAProject.Tests;

import DemoQAProject.Base.BaseTest;
import DemoQAProject.Pages.DynamicPropertiesPage;
import DemoQAProject.Pages.HomePage;
import DemoQAProject.Pages.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicPropertiesTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(loginURL);
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        dynamicPropertiesPage = new DynamicPropertiesPage();
    }

    public void goToDynamicPropertiesPage(){
        homePage.clickOnCards("Elements");
        scrollDown();
        sidebarPage.clickOnButton("Dynamic Properties");
        String expectedURL = "https://demoqa.com/dynamic-properties";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        WebElement header = driver.findElement(By.className("main-header"));
        Assert.assertEquals(header.getText(), "Dynamic Properties");
    }

    @Test(priority =10)
    public void enabledAfter5SecondsButtonCheck() throws InterruptedException {
        goToDynamicPropertiesPage();
        Assert.assertFalse(dynamicPropertiesPage.enabledAfter5SecondsButton.isEnabled());
        Thread.sleep(5000);
        Assert.assertTrue(dynamicPropertiesPage.enabledAfter5SecondsButton.isEnabled());
    }

    @Test(priority =20)
    public void changeColorAfter5SecondsButtonCheck() throws InterruptedException {
        goToDynamicPropertiesPage();

        boolean check = false;
        try {
            check = dynamicPropertiesPage.changedColorButton.isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(check);
        Assert.assertTrue(dynamicPropertiesPage.originalColorButton.isDisplayed());

        Thread.sleep(5000);
        Assert.assertTrue(dynamicPropertiesPage.changedColorButton.isDisplayed());
    }

    @Test(priority =30)
    public void visibleAfter5SecondsButtonCheck() throws InterruptedException {
        goToDynamicPropertiesPage();

        boolean check = false;
        try {
            check = dynamicPropertiesPage.visibleAfter5SecondsButton.isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(check);

        Thread.sleep(5000);
        Assert.assertTrue(dynamicPropertiesPage.visibleAfter5SecondsButton.isDisplayed());
    }

}
