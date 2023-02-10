package DemoQAProject.Tests;

import DemoQAProject.Base.BaseTest;
import DemoQAProject.Pages.HomePage;
import DemoQAProject.Pages.PracticeFormPage;
import DemoQAProject.Pages.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest {

    public PracticeFormTest() { PageFactory.initElements(driver, this); }

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(loginURL);
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        practiceFormPage = new PracticeFormPage();
    }

    public void goToPracticeFormPage(){
        homePage.clickOnCards("Forms");
        sidebarPage.clickOnButton("Practice Form");
        String expectedURL = "https://demoqa.com/automation-practice-form";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        WebElement header = driver.findElement(By.className("main-header"));
        Assert.assertEquals(header.getText(), "Practice Form");
    }

    @Test
    public void userCanSubmitPracticeFormWithValidData() throws InterruptedException {

        String validFirstName = excelReader.getStringData("Practice Form-Valid data", 1, 0);
        String validLastName = excelReader.getStringData("Practice Form-Valid data", 1, 1);
        String validEmailAddress = excelReader.getStringData("Practice Form-Valid data", 1, 2);
        String radioButtonText = excelReader.getStringData("Practice Form-Radio Buttons", 1, 0);
        int validMobileNumber = excelReader.getIntegerData("Practice Form-Valid data", 1,3);
        String validDateOfBirth = "01 Jan 1999";
        String validCurrentAddress = excelReader.getStringData("Practice Form-Valid data", 1,5);
        String subject1 = excelReader.getStringData("Practice Form-Subjects", 1,0);
        String subject3 = excelReader.getStringData("Practice Form-Subjects", 3,0);
        String subject5 = excelReader.getStringData("Practice Form-Subjects", 5,0);

        goToPracticeFormPage();

        practiceFormPage.insertFirstName(validFirstName);
        practiceFormPage.insertLastName(validLastName);
        practiceFormPage.insertEmail(validEmailAddress);
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes(radioButtonText);
        practiceFormPage.insertMobileNumber(validMobileNumber);
        practiceFormPage.insertSubjects(subject1);
        practiceFormPage.insertSubjects(subject3);
        practiceFormPage.insertSubjects(subject5);
        practiceFormPage.insertDateOfBirth(validDateOfBirth);
        Thread.sleep(500);
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Sports");
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Reading");
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Music");
        practiceFormPage.uploadPicture("C:\\Users\\furga\\Downloads\\sampleFile.jpeg");

        practiceFormPage.insertCurrentAddress(validCurrentAddress);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", practiceFormPage.submitButton);

        Assert.assertEquals(practiceFormPage.submissionConfirmation.getText(), "Thanks for submitting the form");
        Assert.assertTrue(practiceFormPage.closeButton.isDisplayed());

    }

    @Test
    public void userCanSubmitPracticeFormWithDifferentRadioButtonsSelected() throws InterruptedException {

        String validFirstName = excelReader.getStringData("Practice Form-Valid data", 1, 0);
        String validLastName = excelReader.getStringData("Practice Form-Valid data", 1, 1);
        String validEmailAddress = excelReader.getStringData("Practice Form-Valid data", 1, 2);
        int validMobileNumber = excelReader.getIntegerData("Practice Form-Valid data", 1,3);
        String validDateOfBirth = "01 Jan 1999";
        String validCurrentAddress = excelReader.getStringData("Practice Form-Valid data", 1,5);
        String subject1 = excelReader.getStringData("Practice Form-Subjects", 1,0);
        String subject3 = excelReader.getStringData("Practice Form-Subjects", 3,0);
        String subject5 = excelReader.getStringData("Practice Form-Subjects", 5,0);

        goToPracticeFormPage();

        for(int i=1; i <= excelReader.getLastRow("Practice Form-Radio Buttons"); i++){

            String radioButtonText = excelReader.getStringData("Practice Form-Radio Buttons", i, 0);

            practiceFormPage.insertFirstName(validFirstName);
            practiceFormPage.insertLastName(validLastName);
            practiceFormPage.insertEmail(validEmailAddress);
            practiceFormPage.clickOnRadioButtonsAndCheckBoxes(radioButtonText);
            practiceFormPage.insertMobileNumber(validMobileNumber);
            practiceFormPage.insertSubjects(subject1);
            practiceFormPage.insertSubjects(subject3);
            practiceFormPage.insertSubjects(subject5);
            practiceFormPage.insertDateOfBirth(validDateOfBirth);
            Thread.sleep(500);
            practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Sports");
            practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Reading");
            practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Music");
            practiceFormPage.uploadPicture("C:\\Users\\furga\\Downloads\\sampleFile.jpeg");
            practiceFormPage.insertCurrentAddress(validCurrentAddress);

            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", practiceFormPage.submitButton);

            Thread.sleep(500);

            Assert.assertEquals(practiceFormPage.submissionConfirmation.getText(), "Thanks for submitting the form");
            Assert.assertTrue(practiceFormPage.closeButton.isDisplayed());

            practiceFormPage.clickOnCloseButton();

            Thread.sleep(500);
        }

    }

    @Test
    public void userCannotSubmitPracticeFormWithInvalidEmail() throws InterruptedException {

        goToPracticeFormPage();

        String validFirstName = excelReader.getStringData("Practice Form-Valid data", 1, 0);
        String validLastName = excelReader.getStringData("Practice Form-Valid data", 1, 1);
        int validMobileNumber = excelReader.getIntegerData("Practice Form-Valid data", 1,3);
        String validDateOfBirth = "01 Jan 1999";
        String validCurrentAddress = excelReader.getStringData("Practice Form-Valid data", 1,5);
        String subject1 = excelReader.getStringData("Practice Form-Subjects", 1,0);
        String subject3 = excelReader.getStringData("Practice Form-Subjects", 3,0);
        String subject5 = excelReader.getStringData("Practice Form-Subjects", 5,0);

        practiceFormPage.insertFirstName(validFirstName);
        practiceFormPage.insertLastName(validLastName);
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Male");
        practiceFormPage.insertMobileNumber(validMobileNumber);
        practiceFormPage.insertSubjects(subject1);
        practiceFormPage.insertSubjects(subject3);
        practiceFormPage.insertSubjects(subject5);
        practiceFormPage.insertDateOfBirth(validDateOfBirth);
        Thread.sleep(500);
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Sports");
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Reading");
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Music");
        practiceFormPage.uploadPicture("C:\\Users\\furga\\Downloads\\sampleFile.jpeg");
        practiceFormPage.insertCurrentAddress(validCurrentAddress);

        for(int i=1; i < excelReader.getLastRow("Practice Form-Invalid Email"); i++){

            String invalidEmailAddress = excelReader.getStringData("Practice Form-Invalid Email", i, 0);
            practiceFormPage.insertEmail(invalidEmailAddress);

            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", practiceFormPage.submitButton);

            Assert.assertTrue(practiceFormPage.emailField.isDisplayed());
            Assert.assertTrue(practiceFormPage.submitButton.isDisplayed());

            practiceFormPage.clearEmailField();

        }
    }

    @Test
    public void userCannotSubmitPracticeFormWithInvalidMobileNumber() throws InterruptedException {

        goToPracticeFormPage();

        String validFirstName = excelReader.getStringData("Practice Form-Valid data", 1, 0);
        String validLastName = excelReader.getStringData("Practice Form-Valid data", 1, 1);
        String validEmailAddress = excelReader.getStringData("Practice Form-Valid data", 1, 2);
        String validDateOfBirth = "01 Jan 1999";
        String validCurrentAddress = excelReader.getStringData("Practice Form-Valid data", 1,5);
        String subject1 = excelReader.getStringData("Practice Form-Subjects", 1,0);
        String subject3 = excelReader.getStringData("Practice Form-Subjects", 3,0);
        String subject5 = excelReader.getStringData("Practice Form-Subjects", 5,0);

        practiceFormPage.insertFirstName(validFirstName);
        practiceFormPage.insertLastName(validLastName);
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Male");
        practiceFormPage.insertEmail(validEmailAddress);
        practiceFormPage.insertSubjects(subject1);
        practiceFormPage.insertSubjects(subject3);
        practiceFormPage.insertSubjects(subject5);
        practiceFormPage.insertDateOfBirth(validDateOfBirth);
        Thread.sleep(500);
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Sports");
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Reading");
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Music");
        practiceFormPage.uploadPicture("C:\\Users\\furga\\Downloads\\sampleFile.jpeg");
        practiceFormPage.insertCurrentAddress(validCurrentAddress);

        for(int i=1; i < excelReader.getLastRow("Practice Form-Invalid Mobile"); i++){

            int invalidMobileNumber = excelReader.getIntegerData("Practice Form-Invalid Mobile", i,0);

            practiceFormPage.insertNumericInvalidMobileNumber(invalidMobileNumber);

            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", practiceFormPage.submitButton);

            Assert.assertTrue(practiceFormPage.mobileNumberField.isDisplayed());
            Assert.assertTrue(practiceFormPage.submitButton.isDisplayed());

            practiceFormPage.clearMobileNumberField();

        }

        for(int i=1; i < excelReader.getLastRow("Practice Form-Invalid Mobile"); i++){

            String invalidMobileNumber = excelReader.getStringData("Practice Form-Invalid Mobile", i,1);

            practiceFormPage.insertStringInvalidMobileNumber(invalidMobileNumber);

            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", practiceFormPage.submitButton);

            Assert.assertTrue(practiceFormPage.emailField.isDisplayed());
            Assert.assertTrue(practiceFormPage.submitButton.isDisplayed());

            practiceFormPage.clearMobileNumberField();

        }
    }

    @Test
    public void userCannotSubmitPracticeFormWithoutFirstName() throws InterruptedException {

        String validLastName = excelReader.getStringData("Practice Form-Valid data", 1, 1);
        String validEmailAddress = excelReader.getStringData("Practice Form-Valid data", 1, 2);
        String radioButtonText = excelReader.getStringData("Practice Form-Radio Buttons", 1, 0);
        int validMobileNumber = excelReader.getIntegerData("Practice Form-Valid data", 1,3);
        String validDateOfBirth = "01 Jan 1999";
        String validCurrentAddress = excelReader.getStringData("Practice Form-Valid data", 1,5);
        String subject1 = excelReader.getStringData("Practice Form-Subjects", 1,0);
        String subject3 = excelReader.getStringData("Practice Form-Subjects", 3,0);
        String subject5 = excelReader.getStringData("Practice Form-Subjects", 5,0);

        goToPracticeFormPage();

        practiceFormPage.insertLastName(validLastName);
        practiceFormPage.insertEmail(validEmailAddress);
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes(radioButtonText);
        practiceFormPage.insertMobileNumber(validMobileNumber);
        practiceFormPage.insertSubjects(subject1);
        practiceFormPage.insertSubjects(subject3);
        practiceFormPage.insertSubjects(subject5);
        practiceFormPage.insertDateOfBirth(validDateOfBirth);
        Thread.sleep(500);
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Sports");
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Reading");
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Music");
        practiceFormPage.uploadPicture("C:\\Users\\furga\\Downloads\\sampleFile.jpeg");

        practiceFormPage.insertCurrentAddress(validCurrentAddress);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", practiceFormPage.submitButton);

        Assert.assertTrue(practiceFormPage.firstNameField.isDisplayed());
        Assert.assertTrue(practiceFormPage.submitButton.isDisplayed());

    }

    @Test
    public void userCannotSubmitPracticeFormWithoutLastName() throws InterruptedException {
        String validFirstName = excelReader.getStringData("Practice Form-Valid data", 1, 0);
        String validEmailAddress = excelReader.getStringData("Practice Form-Valid data", 1, 2);
        String radioButtonText = excelReader.getStringData("Practice Form-Radio Buttons", 1, 0);
        int validMobileNumber = excelReader.getIntegerData("Practice Form-Valid data", 1,3);
        String validDateOfBirth = "01 Jan 1999";
        String validCurrentAddress = excelReader.getStringData("Practice Form-Valid data", 1,5);
        String subject1 = excelReader.getStringData("Practice Form-Subjects", 1,0);
        String subject3 = excelReader.getStringData("Practice Form-Subjects", 3,0);
        String subject5 = excelReader.getStringData("Practice Form-Subjects", 5,0);

        goToPracticeFormPage();

        practiceFormPage.insertFirstName(validFirstName);
        practiceFormPage.insertEmail(validEmailAddress);
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes(radioButtonText);
        practiceFormPage.insertMobileNumber(validMobileNumber);
        practiceFormPage.insertSubjects(subject1);
        practiceFormPage.insertSubjects(subject3);
        practiceFormPage.insertSubjects(subject5);
        practiceFormPage.insertDateOfBirth(validDateOfBirth);
        Thread.sleep(500);
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Sports");
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Reading");
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Music");
        practiceFormPage.uploadPicture("C:\\Users\\furga\\Downloads\\sampleFile.jpeg");

        practiceFormPage.insertCurrentAddress(validCurrentAddress);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", practiceFormPage.submitButton);

        Assert.assertTrue(practiceFormPage.lastNameField.isDisplayed());
        Assert.assertTrue(practiceFormPage.submitButton.isDisplayed());

    }

    @Test
    public void userCannotSubmitPracticeFormWithoutRadioButtonsSelected() throws InterruptedException {
        String validFirstName = excelReader.getStringData("Practice Form-Valid data", 1, 0);
        String validLastName = excelReader.getStringData("Practice Form-Valid data", 1, 1);
        String validEmailAddress = excelReader.getStringData("Practice Form-Valid data", 1, 2);
        int validMobileNumber = excelReader.getIntegerData("Practice Form-Valid data", 1,3);
        String validDateOfBirth = "01 Jan 1999";
        String validCurrentAddress = excelReader.getStringData("Practice Form-Valid data", 1,5);
        String subject1 = excelReader.getStringData("Practice Form-Subjects", 1,0);
        String subject3 = excelReader.getStringData("Practice Form-Subjects", 3,0);
        String subject5 = excelReader.getStringData("Practice Form-Subjects", 5,0);

        goToPracticeFormPage();

        practiceFormPage.insertFirstName(validFirstName);
        practiceFormPage.insertLastName(validLastName);
        practiceFormPage.insertEmail(validEmailAddress);
        practiceFormPage.insertMobileNumber(validMobileNumber);
        practiceFormPage.insertSubjects(subject1);
        practiceFormPage.insertSubjects(subject3);
        practiceFormPage.insertSubjects(subject5);
        practiceFormPage.insertDateOfBirth(validDateOfBirth);
        Thread.sleep(500);
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Sports");
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Reading");
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Music");
        practiceFormPage.uploadPicture("C:\\Users\\furga\\Downloads\\sampleFile.jpeg");

        practiceFormPage.insertCurrentAddress(validCurrentAddress);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", practiceFormPage.submitButton);

        Assert.assertTrue(practiceFormPage.emailField.isDisplayed());
        Assert.assertTrue(practiceFormPage.submitButton.isDisplayed());

    }

    @Test
    public void userCannotSubmitPracticeFormWithoutMobileNumber() throws InterruptedException {
        String validFirstName = excelReader.getStringData("Practice Form-Valid data", 1, 0);
        String validLastName = excelReader.getStringData("Practice Form-Valid data", 1, 1);
        String validEmailAddress = excelReader.getStringData("Practice Form-Valid data", 1, 2);
        String radioButtonText = excelReader.getStringData("Practice Form-Radio Buttons", 1, 0);
        String validDateOfBirth = "01 Jan 1999";
        String validCurrentAddress = excelReader.getStringData("Practice Form-Valid data", 1,5);
        String subject1 = excelReader.getStringData("Practice Form-Subjects", 1,0);
        String subject3 = excelReader.getStringData("Practice Form-Subjects", 3,0);
        String subject5 = excelReader.getStringData("Practice Form-Subjects", 5,0);

        goToPracticeFormPage();

        practiceFormPage.insertFirstName(validFirstName);
        practiceFormPage.insertLastName(validLastName);
        practiceFormPage.insertEmail(validEmailAddress);
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes(radioButtonText);
        practiceFormPage.insertSubjects(subject1);
        practiceFormPage.insertSubjects(subject3);
        practiceFormPage.insertSubjects(subject5);
        practiceFormPage.insertDateOfBirth(validDateOfBirth);
        Thread.sleep(500);
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Sports");
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Reading");
        practiceFormPage.clickOnRadioButtonsAndCheckBoxes("Music");
        practiceFormPage.uploadPicture("C:\\Users\\furga\\Downloads\\sampleFile.jpeg");

        practiceFormPage.insertCurrentAddress(validCurrentAddress);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", practiceFormPage.submitButton);

        Assert.assertTrue(practiceFormPage.mobileNumberField.isDisplayed());
        Assert.assertTrue(practiceFormPage.submitButton.isDisplayed());

    }

    @Test
    public void userCannotSubmitPracticeFormWithEmptyFields() throws InterruptedException {

        goToPracticeFormPage();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", practiceFormPage.submitButton);

        Assert.assertTrue(practiceFormPage.emailField.isDisplayed());
        Assert.assertTrue(practiceFormPage.firstNameField.isDisplayed());
        Assert.assertTrue(practiceFormPage.lastNameField.isDisplayed());
        Assert.assertTrue(practiceFormPage.mobileNumberField.isDisplayed());
        Assert.assertTrue(practiceFormPage.submitButton.isDisplayed());
    }
}
