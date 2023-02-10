package DemoQAProject.Pages;

import DemoQAProject.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "card-body")
    public List<WebElement> cards;

    @FindBy(css = "img[src='/images/Toolsqa.jpg'")
    public WebElement bannerToolsQA;

    //----------------------------------------------

    public void clickOnCards(String cardName) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().equals(cardName)) {
                cards.get(i).click();
                break;
            }
        }
    }

    public void clickOnBanner(){
        bannerToolsQA.click();
    }
}
