package DemoQAProject.Pages;

import DemoQAProject.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BrokenLinksImagesPage extends BaseTest {

    public BrokenLinksImagesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="img[src='/images/Toolsqa.jpg']")
    public List<WebElement> validImage;

    @FindBy(css="img[src='/images/Toolsqa_1.jpg']")
    public WebElement invalidImage;

    @FindBy(tagName = "img")
    public List<WebElement> images;

    @FindBy(linkText = "Click Here for Valid Link")
    public WebElement validLink;

    @FindBy(linkText = "Click Here for Broken Link")
    public WebElement brokenLink;

    //------------------------------------------------

    public void clickOnValidLink(){

        validLink.click();
    }

    public void clickOnBrokenLink(){
        brokenLink.click();
    }

}
