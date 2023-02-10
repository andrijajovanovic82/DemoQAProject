package DemoQAProject.Tests;

import DemoQAProject.Base.BaseTest;
import DemoQAProject.Pages.HomePage;
import DemoQAProject.Pages.RadioButtonPage;
import DemoQAProject.Pages.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(loginURL);
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        radioButtonPage = new RadioButtonPage();
    }

    public void goToRadioButtonPage(){
        homePage.clickOnCards("Elements");
        sidebarPage.clickOnButton("Radio Button");
        String expectedURL = "https://demoqa.com/radio-button";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        WebElement header = driver.findElement(By.className("main-header"));
        Assert.assertEquals(header.getText(), "Radio Button");
    }

    @Test(priority = 10)
    public void testYesRadioButton() {

        goToRadioButtonPage();

        radioButtonPage.clickOnRadioButton("Yes");

        Assert.assertTrue(radioButtonPage.notification.isDisplayed());
        Assert.assertEquals(radioButtonPage.notification.getText(), "Yes");
    }

    @Test(priority = 20)
    public void testImpressiveRadioButton() {

        goToRadioButtonPage();

        radioButtonPage.clickOnRadioButton("Impressive");

        Assert.assertTrue(radioButtonPage.notification.isDisplayed());
        Assert.assertEquals(radioButtonPage.notification.getText(), "Impressive");
    }

    @Test(priority = 30)
    public void testNoRadioButton() {

        goToRadioButtonPage();

        radioButtonPage.clickOnRadioButton("No");
        boolean check = false;
        try {
            check = radioButtonPage.notification.isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(check);
    }

}
