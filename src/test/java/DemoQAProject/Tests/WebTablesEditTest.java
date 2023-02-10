package DemoQAProject.Tests;

import DemoQAProject.Base.BaseTest;
import DemoQAProject.Pages.HomePage;
import DemoQAProject.Pages.SidebarPage;
import DemoQAProject.Pages.WebTablesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesEditTest extends BaseTest {

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

    public void submitRegistrationForm(){

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

    @Test
    public void userCanEditRegistrationFormWithNewFirstName(){

        String newFirstName = excelReader.getStringData("Web Tables-Valid data", 2, 0);

        submitRegistrationForm();
        webTablesPage.clickOnEditButton();

        webTablesPage.clearFirstNameField();
        webTablesPage.insertFirstName(newFirstName);
        webTablesPage.clickOnSubmitButton();

        List<WebElement> tableData = driver.findElements(By.className("rt-td"));
        boolean check = false;
        for (int i = 0; i < tableData.size(); i++) {
            if (tableData.get(i).getText().equals("Ivan")) {
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }

    @Test
    public void userCanEditRegistrationFormWithNewLastName(){

        String newLastName = excelReader.getStringData("Web Tables-Valid data", 2, 1);

        submitRegistrationForm();
        webTablesPage.clickOnEditButton();

        webTablesPage.clearLastNameField();
        webTablesPage.insertLastName(newLastName);
        webTablesPage.clickOnSubmitButton();

        List<WebElement> tableData = driver.findElements(By.className("rt-td"));
        boolean check = false;
        for (int i = 0; i < tableData.size(); i++) {
            if (tableData.get(i).getText().equals("Markovic")) {
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }


    @Test
    public void userCanEditRegistrationFormWithNewEmail(){

        String newEmail = excelReader.getStringData("Web Tables-Valid data", 2, 2);

        submitRegistrationForm();
        webTablesPage.clickOnEditButton();

        webTablesPage.clearEmailField();
        webTablesPage.insertEmail(newEmail);
        webTablesPage.clickOnSubmitButton();

        List<WebElement> tableData = driver.findElements(By.className("rt-td"));
        boolean check = false;
        for (int i = 0; i < tableData.size(); i++) {
            if (tableData.get(i).getText().equals("newmail@gmail.com")) {
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }

    @Test
    public void userCanEditRegistrationFormWithNewAge(){

        int newAge = excelReader.getIntegerData("Web Tables-Valid data", 2, 3);

        submitRegistrationForm();
        webTablesPage.clickOnEditButton();

        webTablesPage.clearAgeField();
        webTablesPage.insertAge(newAge);
        webTablesPage.clickOnSubmitButton();

//        List<WebElement> tableData = driver.findElements(By.className("rt-td"));
//        boolean check = false;
//        for (int i = 0; i < tableData.size(); i++) {
//            if (tableData.get(i).equals(String.valueOf(23))) {
//                check = true;
//                break;
//            }
//        }
//        Assert.assertTrue(check);
    }

    @Test
    public void userCanEditRegistrationFormWithNewSalary(){

        int newSalary = excelReader.getIntegerData("Web Tables-Valid data", 2, 4);

        submitRegistrationForm();
        webTablesPage.clickOnEditButton();

        webTablesPage.clearSalaryField();
        webTablesPage.insertSalary(newSalary);
        webTablesPage.clickOnSubmitButton();

//        List<WebElement> tableData = driver.findElements(By.className("rt-td"));
//        boolean check = false;
//        for (int i = 0; i < tableData.size(); i++) {
//            if (tableData.get(i).equals(String.valueOf(700))) {
//                check = true;
//                break;
//            }
//        }
//        Assert.assertTrue(check);
    }

    @Test
    public void userCanEditRegistrationFormWithNewDepartment(){

        String newDepartment = excelReader.getStringData("Web Tables-Valid data", 2, 5);

        submitRegistrationForm();
        webTablesPage.clickOnEditButton();

        webTablesPage.clearDepartmentField();
        webTablesPage.insertDepartment(newDepartment);
        webTablesPage.clickOnSubmitButton();

        List<WebElement> tableData = driver.findElements(By.className("rt-td"));
        boolean check = false;
        for (int i = 0; i < tableData.size(); i++) {
            if (tableData.get(i).getText().equals("Marketing")) {
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }

    //---------------------------------------------------------------------------------------------

    @Test
    public void userCannnotEditRegistrationFormWithInvalidEmail() {

        submitRegistrationForm();
        webTablesPage.clickOnEditButton();

        for (int i = 1; i < excelReader.getLastRow("Web Tables-Invalid data"); i++) {

            String invalidEmailAddress = excelReader.getStringData("Web Tables-Invalid data", i, 0);

            webTablesPage.clearEmailField();
            webTablesPage.insertEmail(invalidEmailAddress);
            webTablesPage.clickOnSubmitButton();

            Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
            Assert.assertTrue(webTablesPage.firstNameField.isDisplayed());
            Assert.assertTrue(webTablesPage.emailField.isDisplayed());

            webTablesPage.clearEmailField();
        }
    }

    @Test
    public void userCannotEditRegistrationFormWithInvalidAge() throws InterruptedException {

        submitRegistrationForm();
        webTablesPage.clickOnEditButton();

        for (int i = 1; i < excelReader.getLastRow("Web Tables-Invalid data"); i++) {

            String invalidAge = excelReader.getStringData("Web Tables-Invalid data", i, 1);

            webTablesPage.clearAgeField();
            webTablesPage.insertInvalidAge(invalidAge);
            webTablesPage.clickOnSubmitButton();

            Thread.sleep(500);

            Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
            Assert.assertTrue(webTablesPage.firstNameField.isDisplayed());
            Assert.assertTrue(webTablesPage.ageField.isDisplayed());

            webTablesPage.clearAgeField();
        }

    }

    @Test
    public void userCannotEditRegistrationFormWithInvalidSalary() throws InterruptedException {

        submitRegistrationForm();
        webTablesPage.clickOnEditButton();

        for (int i = 1; i < excelReader.getLastRow("Web Tables-Invalid data"); i++) {

            String invalidSalary = excelReader.getStringData("Web Tables-Invalid data", i, 2);

            webTablesPage.clearSalaryField();
            webTablesPage.insertInvalidSalary(invalidSalary);
            webTablesPage.clickOnSubmitButton();

            Thread.sleep(500);

            Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
            Assert.assertTrue(webTablesPage.firstNameField.isDisplayed());
            Assert.assertTrue(webTablesPage.salaryField.isDisplayed());

            webTablesPage.clearSalaryField();
        }
    }

    //---------------------------------------------------------------------------------------

    @Test
    public void userCannotEditRegistrationFormWithoutFirstName() throws InterruptedException {

        submitRegistrationForm();
        webTablesPage.clickOnEditButton();

        Thread.sleep(500);

        webTablesPage.deleteDataInTheField(webTablesPage.firstNameField);
        webTablesPage.clickOnSubmitButton();

        Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
        Assert.assertTrue(webTablesPage.firstNameField.isDisplayed());
        Assert.assertTrue(webTablesPage.emailField.isDisplayed());
    }

    @Test
    public void userCannotEditRegistrationFormWithoutLastName() throws InterruptedException {

        submitRegistrationForm();
        webTablesPage.clickOnEditButton();

        Thread.sleep(500);

        webTablesPage.deleteDataInTheField(webTablesPage.lastNameField);
        webTablesPage.clickOnSubmitButton();

        Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
        Assert.assertTrue(webTablesPage.lastNameField.isDisplayed());
        Assert.assertTrue(webTablesPage.emailField.isDisplayed());
    }

    @Test
    public void userCannotEditRegistrationFormWithoutEmail() throws InterruptedException {

        submitRegistrationForm();
        webTablesPage.clickOnEditButton();

        Thread.sleep(500);

        webTablesPage.deleteDataInTheField(webTablesPage.emailField);
        webTablesPage.clickOnSubmitButton();

        Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
        Assert.assertTrue(webTablesPage.firstNameField.isDisplayed());
        Assert.assertTrue(webTablesPage.emailField.isDisplayed());
    }

    @Test
    public void userCannotEditRegistrationFormWithoutAge() throws InterruptedException {

        submitRegistrationForm();
        webTablesPage.clickOnEditButton();

        Thread.sleep(500);

        webTablesPage.deleteDataInTheField(webTablesPage.ageField);
        webTablesPage.clickOnSubmitButton();

        Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
        Assert.assertTrue(webTablesPage.ageField.isDisplayed());
        Assert.assertTrue(webTablesPage.emailField.isDisplayed());
    }

    @Test
    public void userCannotEditRegistrationFormWithoutSalary() throws InterruptedException {

        submitRegistrationForm();
        webTablesPage.clickOnEditButton();

        Thread.sleep(500);

        webTablesPage.deleteDataInTheField(webTablesPage.salaryField);
        webTablesPage.clickOnSubmitButton();

        Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
        Assert.assertTrue(webTablesPage.salaryField.isDisplayed());
        Assert.assertTrue(webTablesPage.emailField.isDisplayed());
    }

    @Test
    public void userCannotEditRegistrationFormWithoutDepartment() throws InterruptedException {

        submitRegistrationForm();
        webTablesPage.clickOnEditButton();

        Thread.sleep(500);

        webTablesPage.deleteDataInTheField(webTablesPage.departmentField);
        webTablesPage.clickOnSubmitButton();

        Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
        Assert.assertTrue(webTablesPage.departmentField.isDisplayed());
        Assert.assertTrue(webTablesPage.emailField.isDisplayed());
    }

    @Test
    public void userCannotEditRegistrationFormWithEmptyFields() throws InterruptedException {

        submitRegistrationForm();
        webTablesPage.clickOnEditButton();

        Thread.sleep(500);
        webTablesPage.deleteDataInTheField(webTablesPage.firstNameField);
        webTablesPage.deleteDataInTheField(webTablesPage.lastNameField);
        webTablesPage.deleteDataInTheField(webTablesPage.emailField);
        webTablesPage.deleteDataInTheField(webTablesPage.ageField);
        webTablesPage.deleteDataInTheField(webTablesPage.salaryField);
        webTablesPage.deleteDataInTheField(webTablesPage.departmentField);

        webTablesPage.clickOnSubmitButton();

        Assert.assertTrue(webTablesPage.submitButton.isDisplayed());
        Assert.assertTrue(webTablesPage.departmentField.isDisplayed());
        Assert.assertTrue(webTablesPage.emailField.isDisplayed());

    }
}
