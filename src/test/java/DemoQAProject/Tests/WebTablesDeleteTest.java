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

public class WebTablesDeleteTest extends BaseTest {

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

    @Test
    public void userCanDeleteSubmittedForm() {

        goToWebTablesPage();

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

        webTablesPage.clickOnDeleteButton();

        Assert.assertTrue(webTablesPage.addButton.isDisplayed());
        List<WebElement> tableData1 = driver.findElements(By.className("rt-td"));
        boolean check1 = false;
        for (int i = 0; i < tableData1.size(); i++) {
            if (tableData1.get(i).getText().equals("ppetrovic@gmail.com")) {
                check1 = true;
                break;
            }
        }
        Assert.assertFalse(check1);

    }

}
