package DemoQAProject.Pages;

import DemoQAProject.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePage extends BaseTest {

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".text-left.button")
    public WebElement goToBookstoreButton;

    @FindBy(css=".text-right.button.di")
    public WebElement deleteAllBooksButton;

    @FindBy(id="delete-record-undefined")
    public List<WebElement> deleteButton;

    @FindBy(id="closeSmallModal-ok")
    public WebElement okButton;

    //--------------------------------------------

    public void goToTheBookstore(){
        goToBookstoreButton.click();
    }

    public void deleteAllBooks(){
        deleteAllBooksButton.click();
        okButton.click();
    }

}
