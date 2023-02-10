package DemoQAProject.Tests;

import DemoQAProject.Base.BaseTest;
import DemoQAProject.Pages.BrokenLinksImagesPage;
import DemoQAProject.Pages.HomePage;
import DemoQAProject.Pages.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksImagesTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(loginURL);
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        brokenLinksImagesPage = new BrokenLinksImagesPage();
    }

    public void goToBrokenLinksImagesPage(){
        homePage.clickOnCards("Elements");
        scrollDown();
        sidebarPage.clickOnButton("Broken Links - Images");
        String expectedURL = "https://demoqa.com/broken";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        WebElement header = driver.findElement(By.className("main-header"));
        Assert.assertEquals(header.getText(), "Broken Links - Images");
    }

    @Test
    public void clickOnValidLink(){
        goToBrokenLinksImagesPage();
        brokenLinksImagesPage.clickOnValidLink();
        String expectedURL = "https://demoqa.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

    }

    @Test
    public void clickOnBrokenLink() throws InterruptedException {
        goToBrokenLinksImagesPage();
        brokenLinksImagesPage.clickOnBrokenLink();
        String expectedURL = "http://the-internet.herokuapp.com/status_codes/500";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

}
