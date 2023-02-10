package DemoQAProject.Pages;

import DemoQAProject.Base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PracticeFormPage extends BaseTest {

    public PracticeFormPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="firstName")
    public WebElement firstNameField;

    @FindBy(id="lastName")
    public WebElement lastNameField;

    @FindBy(id="userEmail")
    public WebElement emailField;

    @FindBy(className="custom-control-label")
    public List<WebElement> radioButtonsAndBoxes;

    @FindBy(id="userNumber")
    public WebElement mobileNumberField;

    @FindBy(id="dateOfBirthInput")
    public WebElement dateOfBirthField;

    @FindBy(id="subjectsInput")
    public WebElement subjectsField;

    @FindBy(css = ".css-12jo7m5.subjects-auto-complete__multi-value__label")
    public WebElement subject;

    @FindBy(className = "form-control-file")
    public WebElement uploadButton;

    @FindBy(id="currentAddress")
    public WebElement currentAddressField;

    @FindBy(css=".css-tlfecz-indicatorContainer")
    public WebElement stateDropdown;

    @FindBy(css=".btn.btn-primary")
    public WebElement submitButton;

    @FindBy(id="example-modal-sizes-title-lg")
    public WebElement submissionConfirmation;

    @FindBy(id="closeLargeModal")
    public WebElement closeButton;

    //---------------------------------------------

    public void insertFirstName(String firstName){
        firstNameField.sendKeys(firstName);
    }

    public void insertLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }

    public void insertEmail(String email){
        emailField.sendKeys(email);
    }

    public void clickOnRadioButtonsAndCheckBoxes(String name) {
        for (int i = 0; i < radioButtonsAndBoxes.size(); i++) {
            if (radioButtonsAndBoxes.get(i).getText().equals(name)) {
                radioButtonsAndBoxes.get(i).click();
            }
        }
    }
    public void insertMobileNumber(int mobileNumber){
        mobileNumberField.sendKeys(String.valueOf(mobileNumber));
    }

    public void insertNumericInvalidMobileNumber(int mobileNumber){
        mobileNumberField.sendKeys(String.valueOf(mobileNumber));
    }

    public void insertStringInvalidMobileNumber(String mobileNumber){
        mobileNumberField.sendKeys(mobileNumber);
    }

    public void insertDateOfBirth (String date){
        dateOfBirthField.sendKeys(Keys.CONTROL, "a");
        dateOfBirthField.sendKeys(date);
        dateOfBirthField.sendKeys(Keys.ESCAPE);
    }

    public void insertSubjects(String subject){
        subjectsField.sendKeys(subject);
        subjectsField.sendKeys(Keys.ENTER);
    }

    public void uploadPicture(String path){
        uploadButton.sendKeys(path);
    }
    public void insertCurrentAddress(String currentAddress){
        currentAddressField.sendKeys(currentAddress);
    }

    public void clickOnStateDropdown(){
        stateDropdown.click();
    }

    public void clearEmailField(){
        emailField.clear();
    }

    public void clearMobileNumberField(){
        mobileNumberField.clear();
    }

    public void clickOnCloseButton(){
        closeButton.click();
    }
}
