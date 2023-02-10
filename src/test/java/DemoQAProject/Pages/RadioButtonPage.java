package DemoQAProject.Pages;

import DemoQAProject.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButtonPage extends BaseTest {

    public RadioButtonPage() {
        PageFactory.initElements( driver, this);
    }

    @FindBy(className = "custom-control-label")
    public List<WebElement> radioButton;

    @FindBy(className = "text-success")
    public WebElement notification;

    //-------------------------------------------

    public void clickOnRadioButton(String name){
        for(int i=0; i< radioButton.size(); i++){
            if(radioButton.get(i).getText().equals(name)){
                radioButton.get(i).click();
                break;
            }
        }
    }
}
