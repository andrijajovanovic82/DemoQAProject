package DemoQAProject.Pages;

import DemoQAProject.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BaseTest {

    public TextBoxPage() {
        PageFactory.initElements( driver, this);
    }

    @FindBy(id="userName")
    public WebElement fullNameField;

    @FindBy(id="userEmail")
    public WebElement emailField;

    @FindBy(id="currentAddress")
    public WebElement currentAddressField;

    @FindBy(id="permanentAddress")
    public WebElement permanentAddressField;

    @FindBy(id="submit")
    public WebElement submitButton;


    //-----------------------------------------

    public void insertFullName(String fullName){
        fullNameField.sendKeys(fullName);
    }
    public void insertEmailAddress(String emailAddress) {
        emailField.sendKeys(emailAddress);
    }
    public void insertCurrentAddress(String currentAddress ) {
        currentAddressField.sendKeys(currentAddress);
    }
    public void insertPermanentAddress(String permanentAddress){
        permanentAddressField.sendKeys(permanentAddress);
    }
    public void clickOnSubmitButton(){
        submitButton.click();
    }

    public void clearFullName(){
        fullNameField.clear();
    }

    public void clearEmailAddress(){
        emailField.clear();
    }

    public void clearCurrentAddress(){
        currentAddressField.clear();
    }

    public void clearPermanentAddress(){
        permanentAddressField.clear();
    }


    //-----------------------------------------

    @FindBy(id="name")
    public WebElement insertedName;

    @FindBy(id="email")
    public WebElement insertedEmail;
}
