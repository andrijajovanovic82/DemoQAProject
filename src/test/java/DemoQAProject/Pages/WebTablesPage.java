package DemoQAProject.Pages;

import DemoQAProject.Base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage extends BaseTest {

    public WebTablesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addButton;

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(id = "age")
    public WebElement ageField;

    @FindBy(id = "salary")
    public WebElement salaryField;

    @FindBy(id = "department")
    public WebElement departmentField;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(className = "close")
    public WebElement closeButton;

    @FindBy(className = "mr-2")
    public List<WebElement> editButtons;

    @FindBy(id = "delete-record-4")
    public WebElement deleteButton;

    @FindBy(className="form-control")
    public WebElement searchBox;

    @FindBy(id="basic-addon2")
    public WebElement searchButton;


    //--------------------------------------------------

    public void clickOnAddButton() {
        addButton.click();
    }

    public void insertFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void insertLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void insertEmail(String email) {
        if (email != null) {
            emailField.sendKeys(email);
        }
    }

    public void insertAge(int age) {
        ageField.sendKeys(String.valueOf(age));
    }

    public void insertInvalidAge(String age) {
        ageField.sendKeys(age);
    }

    public void insertSalary(int salary) {
        salaryField.sendKeys(String.valueOf(salary));
    }

    public void insertInvalidSalary(String salary) {
        salaryField.sendKeys(salary);
    }

    public void insertDepartment(String department) {
        departmentField.sendKeys(department);
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    //------------------------------------------

    public void clearFirstNameField() {
        firstNameField.clear();
    }

    public void clearLastNameField() {
        lastNameField.clear();
    }

    public void clearEmailField() {
        emailField.clear();
    }

    public void clearAgeField() {
        ageField.clear();
    }

    public void clearSalaryField() {
        salaryField.clear();
    }

    public void clearDepartmentField() {
        departmentField.clear();
    }

    public void deleteDataInTheField(WebElement element){
        String s = Keys.chord(Keys.CONTROL, "a");
        element.sendKeys(s);
        element.sendKeys(Keys.DELETE);
    }

    public void clickOnCloseButton() {
        closeButton.click();
    }

    //-----------------------------------------

    public void clickOnEditButton(){
        editButtons.get(editButtons.size()-1).click();
    }

    public void clickOnDeleteButton(){
        deleteButton.click();
    }

    public void insertIntegerSearchData(int data){
        searchBox.sendKeys(String.valueOf(data));
    }

    public void insertStringSearchData(String data){
        searchBox.sendKeys(data);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public void clearSearchField(){
        searchBox.clear();
    }

}
