package DemoQAProject.Pages;

import DemoQAProject.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ButtonsPage extends BaseTest {

    public ButtonsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".btn.btn-primary")
    public List<WebElement> buttons;

    @FindBy(id="doubleClickMessage")
    public WebElement doubleClickNotification;

    @FindBy(id="rightClickMessage")
    public WebElement rightClickNotification;

    @FindBy(id="dynamicClickMessage")
    public WebElement leftClickNotification;

    //--------------------------------------

    public void clickOnButton(){
        for(int i=0; i< buttons.size(); i++)
            if(buttons.get(i).getText().equals("Click Me")){
                buttons.get(i).click();
                break;}
    }
}
