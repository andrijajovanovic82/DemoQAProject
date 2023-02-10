package DemoQAProject.Tests;

import DemoQAProject.Base.BaseTest;
import DemoQAProject.Pages.HomePage;
import DemoQAProject.Pages.SidebarPage;
import DemoQAProject.Pages.WebTablesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesSubmitTest extends BaseTest{

    public WebTablesSubmitTest() {
        PageFactory.initElements(driver, this);
    }

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(loginURL);
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        webTablesPage = new WebTablesPage();
    }

    public void goToWebTablesPage() {
        homePage.clickOnCards("Elements");
        sidebarPage.clickOnButton("Web Tables");
        String expectedURL = "https://demoqa.com/webtables";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        WebElement header = driver.findElement(By.className("main-header"));
        Assert.assertEquals(header.getText(), "Web Tables");
    }

    @Test(priority = 10)
    public void userCanSubmitFormWithValidData() {
        String validFirstName = excelReader.getStringData("Web Tables-Valid data", 1, 0);
        String validLastName = excelReader.getStringData("Web Tables-Valid data", 1, 1);
        String validEmailAddress = excelReader.getStringData("Web Tables-Valid data", 1, 2);
        int validAge = excelReader.getIntegerData("Web Tables-Valid data", 1, 3);
        int validSalary = excelReader.getIntegerData("Web Tables-Valid data", 1, 4);
        String validDepartment = excelReader.getStringData("Web Tables-Valid data", 1, 5);

        goToWebTablesPage();

        webTablesPage.clickOnAddButton();

        webTablesPage.insertFirstName(validFirstName);
        webTablesPage.insertLastName(validLastName);
        webTablesPage.insertEmail(validEmailAddress);
        webTablesPage.insertAge(validAge);
        webTablesPage.insertSalary(validSalary);
        webTablesPage.insertDepartment(validDepartment);
        webTablesPage.clickOnSubmitButton();

        List<WebElement> tableData = driver.findElements(By.className("rt-td"));
        boolean check = false;
        for (int i = 0; i < tableData.size(); i++) {
            if (tableData.get(i).getText().equals("ppetrovic@gmail.com")) {
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }

    @Test(priority = 20)
    public void userCannotSubmitFormWithInvalidEmail() throws InterruptedException {

        goToWebTablesPage();
        webTablesPage.clickOnAddButton();

        String firstName = excelReader.getStringData("Web Tables-Valid data", 1, 0);
        String lastName = excelReader.getStringData("Web Tables-Valid data", 1, 1);
        int validAge = excelReader.getIntegerData("Web Tables-Valid data", 1, 3);
        int validSalary = excelReader.getIntegerData("Web Tables-Valid data", 1, 4);
        String department = excelReader.getStringData("Web Tables-Valid data", 1, 5);

        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertAge(validAge);
        webTablesPage.insertSalary(validSalary);
        webTablesPage.insertDepartment(department);

        for (int i = 1; i < excelReader.getLastRow("Web Tables-Invalid data"); i++) {

            String invalidEmailAddress = excelReader.getStringData("Web Tables-Invalid data", i, 0);

            webTablesPage.insertEmail(invalidEmailAddress);
            webTablesPage.clickOnSubmitButton();

            Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
            Assert.assertTrue(webTablesPage.firstNameField.isDisplayed());
            Assert.assertTrue(webTablesPage.emailField.isDisplayed());

            webTablesPage.clearEmailField();

        }
        webTablesPage.clickOnCloseButton();
        Assert.assertTrue(webTablesPage.addButton.isDisplayed());
    }

    @Test(priority = 30)
    public void userCannotSubmitFormWithInvalidAge() {

        goToWebTablesPage();
        webTablesPage.clickOnAddButton();

        String firstName = excelReader.getStringData("Web Tables-Valid data", 1, 0);
        String lastName = excelReader.getStringData("Web Tables-Valid data", 1, 1);
        String validEmailAddress = excelReader.getStringData("Web Tables-Valid data", 1, 2);
        int validSalary = excelReader.getIntegerData("Web Tables-Valid data", 1, 4);
        String department = excelReader.getStringData("Web Tables-Valid data", 1, 5);

        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(validEmailAddress);
        webTablesPage.insertSalary(validSalary);
        webTablesPage.insertDepartment(department);


        for (int i = 1; i < excelReader.getLastRow("Web Tables-Invalid data"); i++) {
            String invalidAge = excelReader.getStringData("Web Tables-Invalid data", i, 1);
            webTablesPage.insertInvalidAge(invalidAge);
            webTablesPage.clickOnSubmitButton();

            Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
            Assert.assertTrue(webTablesPage.firstNameField.isDisplayed());
            Assert.assertTrue(webTablesPage.emailField.isDisplayed());

            webTablesPage.clearAgeField();
        }
        webTablesPage.clickOnCloseButton();
        Assert.assertTrue(webTablesPage.addButton.isDisplayed());
    }

    @Test
    public void userCannotSubmitFormWithInvalidSalary() {

        goToWebTablesPage();
        webTablesPage.clickOnAddButton();

        String firstName = excelReader.getStringData("Web Tables-Valid data", 1, 0);
        String lastName = excelReader.getStringData("Web Tables-Valid data", 1, 1);
        String emailAddress = excelReader.getStringData("Web Tables-Valid data", 1, 2);
        int age = excelReader.getIntegerData("Web Tables-Valid data", 1, 3);
        String department = excelReader.getStringData("Web Tables-Valid data", 1, 5);

        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertEmail(emailAddress);
        webTablesPage.insertAge(age);
        webTablesPage.insertDepartment(department);

        for (int i = 1; i < excelReader.getLastRow("Web Tables-Invalid data"); i++) {

            String invalidSalary = excelReader.getStringData("Web Tables-Invalid data", i, 2);
            webTablesPage.insertInvalidSalary(invalidSalary);
            webTablesPage.clickOnSubmitButton();

            Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
            Assert.assertTrue(webTablesPage.firstNameField.isDisplayed());
            Assert.assertTrue(webTablesPage.emailField.isDisplayed());

            webTablesPage.clearSalaryField();
        }
        webTablesPage.clickOnCloseButton();
        Assert.assertTrue(webTablesPage.addButton.isDisplayed());
    }

    @Test
    public void userCannotSubmitFormWithInvalidEmailAgeAndSalary()  {

        goToWebTablesPage();
        webTablesPage.clickOnAddButton();

        String firstName = excelReader.getStringData("Web Tables-Valid data", 1, 0);
        String lastName = excelReader.getStringData("Web Tables-Valid data", 1, 1);
        String department = excelReader.getStringData("Web Tables-Valid data", 1, 5);

        webTablesPage.insertFirstName(firstName);
        webTablesPage.insertLastName(lastName);
        webTablesPage.insertDepartment(department);

        for (int i = 1; i < excelReader.getLastRow("Web Tables-Invalid data"); i++) {
            String invalidEmailAddress = excelReader.getStringData("Web Tables-Invalid data", i, 0);
            String invalidAge = excelReader.getStringData("Web Tables-Invalid data", i, 1);
            String invalidSalary = excelReader.getStringData("Web Tables-Invalid data", i, 2);
            webTablesPage.insertEmail(invalidEmailAddress);
            webTablesPage.insertInvalidAge(invalidAge);
            webTablesPage.insertInvalidSalary(invalidSalary);
            webTablesPage.clickOnSubmitButton();

            Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
            Assert.assertTrue(webTablesPage.firstNameField.isDisplayed());
            Assert.assertTrue(webTablesPage.emailField.isDisplayed());


            webTablesPage.clearEmailField();
            webTablesPage.clearAgeField();
            webTablesPage.clearSalaryField();
        }

        webTablesPage.clickOnCloseButton();
        Assert.assertTrue(webTablesPage.addButton.isDisplayed());
    }

    @Test
    public void userCannotSubmitFormWithoutFirstName() {
        String validLastName = excelReader.getStringData("Web Tables-Valid data", 1, 1);
        String validEmailAddress = excelReader.getStringData("Web Tables-Valid data", 1, 2);
        int validAge = excelReader.getIntegerData("Web Tables-Valid data", 1, 3);
        int validSalary = excelReader.getIntegerData("Web Tables-Valid data", 1, 4);
        String validDepartment = excelReader.getStringData("Web Tables-Valid data", 1, 5);

        goToWebTablesPage();

        webTablesPage.clickOnAddButton();

        webTablesPage.insertLastName(validLastName);
        webTablesPage.insertEmail(validEmailAddress);
        webTablesPage.insertAge(validAge);
        webTablesPage.insertSalary(validSalary);
        webTablesPage.insertDepartment(validDepartment);
        webTablesPage.clickOnSubmitButton();

        Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
        Assert.assertTrue(webTablesPage.firstNameField.isDisplayed());
    }

    @Test
    public void userCannotSubmitFormWithoutLastName() {
        String validFirstName = excelReader.getStringData("Web Tables-Valid data", 1, 0);
        String validEmailAddress = excelReader.getStringData("Web Tables-Valid data", 1, 2);
        int validAge = excelReader.getIntegerData("Web Tables-Valid data", 1, 3);
        int validSalary = excelReader.getIntegerData("Web Tables-Valid data", 1, 4);
        String validDepartment = excelReader.getStringData("Web Tables-Valid data", 1, 5);

        goToWebTablesPage();

        webTablesPage.clickOnAddButton();

        webTablesPage.insertFirstName(validFirstName);
        webTablesPage.insertEmail(validEmailAddress);
        webTablesPage.insertAge(validAge);
        webTablesPage.insertSalary(validSalary);
        webTablesPage.insertDepartment(validDepartment);
        webTablesPage.clickOnSubmitButton();

        Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
        Assert.assertTrue(webTablesPage.lastNameField.isDisplayed());
    }

    @Test
    public void userCannotSubmitFormWithoutEmail() {
        String validFirstName = excelReader.getStringData("Web Tables-Valid data", 1, 0);
        String validLastName = excelReader.getStringData("Web Tables-Valid data", 1, 1);
        int validAge = excelReader.getIntegerData("Web Tables-Valid data", 1, 3);
        int validSalary = excelReader.getIntegerData("Web Tables-Valid data", 1, 4);
        String validDepartment = excelReader.getStringData("Web Tables-Valid data", 1, 5);

        goToWebTablesPage();

        webTablesPage.clickOnAddButton();

        webTablesPage.insertFirstName(validFirstName);
        webTablesPage.insertLastName(validLastName);
        webTablesPage.insertAge(validAge);
        webTablesPage.insertSalary(validSalary);
        webTablesPage.insertDepartment(validDepartment);
        webTablesPage.clickOnSubmitButton();

        Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
        Assert.assertTrue(webTablesPage.emailField.isDisplayed());
    }

    @Test
    public void userCannotSubmitFormWithoutAge() {
        String validFirstName = excelReader.getStringData("Web Tables-Valid data", 1, 0);
        String validLastName = excelReader.getStringData("Web Tables-Valid data", 1, 1);
        String validEmailAddress = excelReader.getStringData("Web Tables-Valid data", 1, 2);
        int validSalary = excelReader.getIntegerData("Web Tables-Valid data", 1, 4);
        String validDepartment = excelReader.getStringData("Web Tables-Valid data", 1, 5);

        goToWebTablesPage();

        webTablesPage.clickOnAddButton();

        webTablesPage.insertFirstName(validFirstName);
        webTablesPage.insertLastName(validLastName);
        webTablesPage.insertEmail(validEmailAddress);
        webTablesPage.insertSalary(validSalary);
        webTablesPage.insertDepartment(validDepartment);
        webTablesPage.clickOnSubmitButton();

        Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
        Assert.assertTrue(webTablesPage.ageField.isDisplayed());
    }

    @Test
    public void userCannotSubmitFormWithoutSalary() {
        String validFirstName = excelReader.getStringData("Web Tables-Valid data", 1, 0);
        String validLastName = excelReader.getStringData("Web Tables-Valid data", 1, 1);
        String validEmailAddress = excelReader.getStringData("Web Tables-Valid data", 1, 2);
        int validAge = excelReader.getIntegerData("Web Tables-Valid data", 1, 3);
        String validDepartment = excelReader.getStringData("Web Tables-Valid data", 1, 5);

        goToWebTablesPage();

        webTablesPage.clickOnAddButton();

        webTablesPage.insertFirstName(validFirstName);
        webTablesPage.insertEmail(validLastName);
        webTablesPage.insertEmail(validEmailAddress);
        webTablesPage.insertAge(validAge);
        webTablesPage.insertDepartment(validDepartment);
        webTablesPage.clickOnSubmitButton();

        Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
        Assert.assertTrue(webTablesPage.salaryField.isDisplayed());
    }

    @Test
    public void userCannotSubmitFormWithoutDepartment() {
        String validFirstName = excelReader.getStringData("Web Tables-Valid data", 1, 0);
        String validLastName = excelReader.getStringData("Web Tables-Valid data", 1, 1);
        String validEmailAddress = excelReader.getStringData("Web Tables-Valid data", 1, 2);
        int validAge = excelReader.getIntegerData("Web Tables-Valid data", 1, 3);
        int validSalary = excelReader.getIntegerData("Web Tables-Valid data", 1, 4);

        goToWebTablesPage();

        webTablesPage.clickOnAddButton();

        webTablesPage.insertFirstName(validFirstName);
        webTablesPage.insertLastName(validLastName);
        webTablesPage.insertEmail(validEmailAddress);
        webTablesPage.insertAge(validAge);
        webTablesPage.insertSalary(validSalary);
        webTablesPage.clickOnSubmitButton();

        Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
        Assert.assertTrue(webTablesPage.departmentField.isDisplayed());
    }

    @Test
    public void userCannotSubmitFormWithEmptyFields() {

        goToWebTablesPage();

        webTablesPage.clickOnAddButton();

        webTablesPage.clickOnSubmitButton();

        Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
        Assert.assertTrue(webTablesPage.firstNameField.isDisplayed());
        Assert.assertTrue(webTablesPage.lastNameField.isDisplayed());
        Assert.assertTrue(webTablesPage.emailField.isDisplayed());
    }
}
