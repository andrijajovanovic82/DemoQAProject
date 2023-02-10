package DemoQAProject.Pages;

import DemoQAProject.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksPage extends BaseTest {

    public LinksPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="simpleLink")
    public WebElement simpleLink;

    @FindBy(id="dynamicLink")
    public WebElement dynamicLink;

    @FindBy(id="created")
    public WebElement createdLink;

    @FindBy(id="no-content")
    public WebElement noContentLink;

    @FindBy(id="moved")
    public WebElement movedLink;

    @FindBy(id="bad-request")
    public WebElement badRequestLink;

    @FindBy(id="unauthorized")
    public WebElement unauthorizedLink;

    @FindBy(id="forbidden")
    public WebElement forbiddenLink;

    @FindBy(id="invalid-url")
    public WebElement nofFoundLink;

    @FindBy(id="linkResponse")
    public WebElement linkResponse;


    //--------------------------------

    public void clickOnSimpleLink(){
        simpleLink.click();
    }

    public void clickOnDynamicLink(){
        dynamicLink.click();
    }

    public void clickOnCreatedLink(){
        createdLink.click();
    }

    public void clickOnNoContentLink(){
        noContentLink.click();
    }

    public void clickOnMovedLink(){
        movedLink.click();
    }

    public void clickOnBadRequestLink(){
        badRequestLink.click();
    }

    public void clickOnUnauthorizedLink(){
        unauthorizedLink.click();
    }

    public void clickOnForbiddenLink(){
        forbiddenLink.click();
    }
    public void clickOnNotFoundLink(){
        nofFoundLink.click();
    }

}
