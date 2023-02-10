package DemoQAProject.Tests;

import DemoQAProject.Base.BaseTest;
import DemoQAProject.Pages.CheckBoxPage;
import DemoQAProject.Pages.HomePage;
import DemoQAProject.Pages.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(loginURL);
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        checkBoxPage = new CheckBoxPage();
    }

    public void goToCheckBoxPage() {
        homePage.clickOnCards("Elements");
        sidebarPage.clickOnButton("Check Box");
        String expectedURL = "https://demoqa.com/checkbox";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        WebElement header = driver.findElement(By.className("main-header"));
        Assert.assertEquals(header.getText(), "Check Box");
    }

    @Test
    public void checkHomeCheckBox() {
        goToCheckBoxPage();
        checkBoxPage.selectCheckBox("Home");
        List<WebElement> notification = driver.findElements(By.className("text-success"));
        boolean check = false;
        for (int i = 0; i < notification.size(); i++) {
            if (notification.get(i).getText().equals("home")) {
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }

    @Test
    public void checkDesktopCheckBox() {
        goToCheckBoxPage();
        checkBoxPage.expandCheckBoxes(0);
        checkBoxPage.selectCheckBox("Desktop");
        List<WebElement> notification = driver.findElements(By.className("text-success"));
        boolean check = false;
        for (int i = 0; i < notification.size(); i++) {
            if (notification.get(i).getText().equals("desktop")) {
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }

    @Test
    public void checkReactCheckBox() {
        goToCheckBoxPage();
        checkBoxPage.expandCheckBoxes(0);
        checkBoxPage.expandCheckBoxes(1);
        checkBoxPage.expandCheckBoxes(0);
        checkBoxPage.expandCheckBoxes(0);
        checkBoxPage.selectCheckBox("React");
        List<WebElement> notification = driver.findElements(By.className("text-success"));
        boolean check = false;
        for (int i = 0; i < notification.size(); i++) {
            if (notification.get(i).getText().equals("react")) {
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }

    @Test
    public void uncheckHomeCheckBox() {
        goToCheckBoxPage();
        checkBoxPage.selectCheckBox("Home");
        List<WebElement> notification = driver.findElements(By.className("text-success"));
        boolean check = false;
        for (int i = 0; i < notification.size(); i++) {
            if (notification.get(i).getText().equals("home")) {
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);

        checkBoxPage.selectCheckBox("Home");
    }

}
