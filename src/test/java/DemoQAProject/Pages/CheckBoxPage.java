package DemoQAProject.Pages;

import DemoQAProject.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckBoxPage extends BaseTest {

    public CheckBoxPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(className="rct-title")
    public List<WebElement> checkBox;

    @FindBy(css=".rct-icon.rct-icon-expand-close")
    public List<WebElement> expand;

//    @FindBy(className = "text-success")
//    public List<WebElement> notification;

    //----------------------------------------------------

    public void selectCheckBox(String name){
        for(int i=0; i< checkBox.size(); i++){
            if(checkBox.get(i).getText().equals(name)){
                checkBox.get(i).click();
                break;
            }
        }
    }

    public void expandCheckBoxes(int i){
        expand.get(i).click();
    }

}
