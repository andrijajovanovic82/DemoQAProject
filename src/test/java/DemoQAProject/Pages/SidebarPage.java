package DemoQAProject.Pages;

import DemoQAProject.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SidebarPage extends BaseTest {

    public SidebarPage() {
        PageFactory.initElements(driver, this);
    }



    @FindBy(className = "text")
    public List<WebElement> buttons;


    //-------------------------------

    public void clickOnButton(String name) {
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals(name)) {
                buttons.get(i).click();
                break;
            }
        }
    }
}
