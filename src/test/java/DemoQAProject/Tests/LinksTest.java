package DemoQAProject.Tests;

import DemoQAProject.Base.BaseTest;
import DemoQAProject.Pages.HomePage;
import DemoQAProject.Pages.LinksPage;
import DemoQAProject.Pages.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class LinksTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(loginURL);
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        linksPage = new LinksPage();
    }

    public void goToLinksPage(){
        homePage.clickOnCards("Elements");
        sidebarPage.clickOnButton("Links");
        String expectedURL = "https://demoqa.com/links";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        WebElement header = driver.findElement(By.className("main-header"));
        Assert.assertEquals(header.getText(), "Links");
    }

    @Test(priority = 10)
    public void clickOnSimpleLink(){
        goToLinksPage();
        linksPage.clickOnSimpleLink();
        String expectedURL = "https://demoqa.com/";
        ArrayList<String> listOfTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listOfTabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        driver.switchTo().window(listOfTabs.get(0));
    }

    @Test(priority = 20)
    public void clickOnDynamicLink(){
        goToLinksPage();
        linksPage.clickOnDynamicLink();
        String expectedURL = "https://demoqa.com/";
        ArrayList<String>listOfTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listOfTabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        driver.switchTo().window(listOfTabs.get(0));
    }

    @Test(priority = 30)
    public void clickOnCreatedLink() throws InterruptedException {
        goToLinksPage();
        linksPage.clickOnCreatedLink();
        Thread.sleep(500);
        Assert.assertTrue(linksPage.linkResponse.isDisplayed());
        Assert.assertEquals(linksPage.linkResponse.getText(), ("Link has responded with staus 201 and status text Created"));
    }

    @Test(priority = 40)
    public void clickOnNoContentLink() throws InterruptedException {
        goToLinksPage();
        linksPage.clickOnNoContentLink();
        Thread.sleep(500);
        Assert.assertTrue(linksPage.linkResponse.isDisplayed());
        Assert.assertEquals(linksPage.linkResponse.getText(), ("Link has responded with staus 204 and status text No Content"));
    }

    @Test(priority = 50)
    public void clickOnMovedLink() throws InterruptedException {
        goToLinksPage();
        linksPage.clickOnMovedLink();
        Thread.sleep(500);
        Assert.assertTrue(linksPage.linkResponse.isDisplayed());
        Assert.assertEquals(linksPage.linkResponse.getText(), ("Link has responded with staus 301 and status text Moved Permanently"));
    }

    @Test(priority = 60)
    public void clickOnBadRequestLink() throws InterruptedException {
        goToLinksPage();
        linksPage.clickOnBadRequestLink();
        Thread.sleep(500);
        Assert.assertTrue(linksPage.linkResponse.isDisplayed());
        Assert.assertEquals(linksPage.linkResponse.getText(), ("Link has responded with staus 400 and status text Bad Request"));
    }

    @Test(priority = 70)
    public void clickOnUnauthorizedLink() throws InterruptedException {
        goToLinksPage();
        linksPage.clickOnUnauthorizedLink();
        Thread.sleep(500);
        Assert.assertTrue(linksPage.linkResponse.isDisplayed());
        Assert.assertEquals(linksPage.linkResponse.getText(), ("Link has responded with staus 401 and status text Unauthorized"));
    }

    @Test(priority = 80)
    public void clickOnForbiddenLink() throws InterruptedException {
        goToLinksPage();
        linksPage.clickOnForbiddenLink();
        Thread.sleep(500);
        Assert.assertTrue(linksPage.linkResponse.isDisplayed());
        Assert.assertEquals(linksPage.linkResponse.getText(), ("Link has responded with staus 403 and status text Forbidden"));
    }

    @Test(priority = 90)
    public void clickOnNotFoundLink() throws InterruptedException {
        goToLinksPage();
        linksPage.clickOnNotFoundLink();
        Thread.sleep(500);
        Assert.assertTrue(linksPage.linkResponse.isDisplayed());
        Assert.assertEquals(linksPage.linkResponse.getText(), ("Link has responded with staus 404 and status text Not Found"));
    }
}
