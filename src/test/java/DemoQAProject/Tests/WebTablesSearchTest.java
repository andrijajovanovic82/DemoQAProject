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

public class WebTablesSearchTest extends BaseTest {

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

    public void submitRegistrationForm() {

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
    public void searchByFirstName() {

        goToWebTablesPage();
        submitRegistrationForm();

        webTablesPage.insertStringSearchData("Petar");
        webTablesPage.clickOnSearchButton();

        List<WebElement> tableData = driver.findElements(By.className("rt-td"));
        boolean check = false;
        for (int i = 0; i < tableData.size(); i++) {
            if (tableData.get(i).getText().equals("Petar")) {
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }

    @Test
    public void searchByLastName () {

        goToWebTablesPage();
        submitRegistrationForm();
        webTablesPage.insertStringSearchData("Petrovic");
        webTablesPage.clickOnSearchButton();

        List<WebElement> tableData = driver.findElements(By.className("rt-td"));
        boolean check = false;
        for (int i = 0; i < tableData.size(); i++) {
            if (tableData.get(i).getText().equals("Petrovic")) {
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }


    @Test
    public void searchByEmail(){

        goToWebTablesPage();
        submitRegistrationForm();
        webTablesPage.insertStringSearchData("ppetrovic@gmail.com");
        webTablesPage.clickOnSearchButton();

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
    public void searchByAge(){

        goToWebTablesPage();
        submitRegistrationForm();
        webTablesPage.insertIntegerSearchData(30);
        webTablesPage.clickOnSearchButton();

//        List<WebElement> tableData = driver.findElements(By.className("rt-td"));
//        boolean check = false;
//        for (int i = 0; i < tableData.size(); i++) {
//            if (tableData.get(i).getText().equals(900)) {
//                check = true;
//                break;
//            }
//        }
//        Assert.assertTrue(check);
    }

    @Test
    public void searchBySalary(){

        goToWebTablesPage();
        submitRegistrationForm();
        webTablesPage.insertIntegerSearchData(900);
        webTablesPage.clickOnSearchButton();

//        List<WebElement> tableData = driver.findElements(By.className("rt-td"));
//        boolean check = false;
//        for (int i = 0; i < tableData.size(); i++) {
//            if (tableData.get(i).getText().equals(900)) {
//                check = true;
//                break;
//            }
//        }
//        Assert.assertTrue(check);
    }

    @Test
    public void searchByDepartment(){

        goToWebTablesPage();
        submitRegistrationForm();

        webTablesPage.insertStringSearchData("QA");
        webTablesPage.clickOnSearchButton();

        List<WebElement> tableData = driver.findElements(By.className("rt-td"));
        boolean check = false;
        for (int i = 0; i < tableData.size(); i++) {
            if (tableData.get(i).getText().equals("QA")) {
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }
}
