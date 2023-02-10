package DemoQAProject.Tests;

import DemoQAProject.Base.BaseTest;
import DemoQAProject.Pages.HomePage;
import DemoQAProject.Pages.SidebarPage;
import DemoQAProject.Pages.TextBoxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(loginURL);
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        textBoxPage = new TextBoxPage();
    }

    public void goToTextBoxPage(){
        homePage.clickOnCards("Elements");
        sidebarPage.clickOnButton("Text Box");
        String expectedURL = "https://demoqa.com/text-box";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        WebElement header = driver.findElement(By.className("main-header"));
        Assert.assertEquals(header.getText(), "Text Box");
    }

    public void clearAllFields(){
        textBoxPage.clearFullName();
        textBoxPage.clearEmailAddress();
        textBoxPage.clearCurrentAddress();
        textBoxPage.clearPermanentAddress();
    }

    @Test(priority = 10)
    public void userCanSubmitTextBoxWithValidData() {
        String fullName = excelReader.getStringData("Text Box-Valid data", 1, 0);
        String emailAddress = excelReader.getStringData("Text Box-Valid data", 1, 1);
        String currentAddress = excelReader.getStringData("Text Box-Valid data", 1,2);
        String permanentAddress = excelReader.getStringData("Text Box-Valid data", 1,3);

        goToTextBoxPage();

        clearAllFields();

        textBoxPage.insertFullName(fullName);
        textBoxPage.insertEmailAddress(emailAddress);
        textBoxPage.insertCurrentAddress(currentAddress);
        textBoxPage.insertPermanentAddress(permanentAddress);
        textBoxPage.clickOnSubmitButton();

        Assert.assertTrue(textBoxPage.insertedName.isDisplayed());
        Assert.assertTrue(textBoxPage.insertedEmail.isDisplayed());

    }

    @Test(priority = 20)
    public void userCanSubmitTextBoxWithIncompleteData() {
        String emailAddress = excelReader.getStringData("Text Box-Valid data", 1, 1);

        goToTextBoxPage();

        clearAllFields();

        textBoxPage.insertEmailAddress(emailAddress);
        textBoxPage.clickOnSubmitButton();

        Assert.assertTrue(textBoxPage.insertedEmail.isDisplayed());
    }

    @Test(priority = 30)
    public void userCannotSubmitTextBoxWithInvalidEmail() {

        goToTextBoxPage();

        clearAllFields();

        for (int i = 1; i < excelReader.getLastRow("Text Box-Invalid data"); i++) {
            String fullName = excelReader.getStringData("Text Box-Valid data", 1, 0);
            String invalidEmailAddress = excelReader.getStringData("Text Box-Invalid data", i, 0);
            String currentAddress = excelReader.getStringData("Text Box-Valid data", 1,2);
            String permanentAddress = excelReader.getStringData("Text Box-Valid data", 1,3);

            textBoxPage.insertFullName(fullName);
            textBoxPage.insertEmailAddress(invalidEmailAddress);
            textBoxPage.insertCurrentAddress(currentAddress);
            textBoxPage.insertPermanentAddress(permanentAddress);
            textBoxPage.clickOnSubmitButton();

            Assert.assertTrue(textBoxPage.submitButton.isDisplayed());
            Assert.assertTrue((textBoxPage.fullNameField.isDisplayed()));
            Assert.assertTrue(textBoxPage.emailField.isDisplayed());

            clearAllFields();
        }

    }
    @Test(priority = 40)
    public void userCannotSubmitTextBoxWithoutEmail() {

        goToTextBoxPage();

        clearAllFields();

        textBoxPage.clickOnSubmitButton();

        Assert.assertTrue(textBoxPage.submitButton.isDisplayed());
        Assert.assertTrue((textBoxPage.fullNameField.isDisplayed()));
        Assert.assertTrue(textBoxPage.emailField.isDisplayed());

    }

}
