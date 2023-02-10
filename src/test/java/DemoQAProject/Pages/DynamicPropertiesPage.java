package DemoQAProject.Pages;

import DemoQAProject.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicPropertiesPage extends BaseTest{

    public DynamicPropertiesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "enableAfter")
    public WebElement enabledAfter5SecondsButton;

    @FindBy(id="visibleAfter")
    public WebElement visibleAfter5SecondsButton;

    @FindBy(id = "colorChange")
    public WebElement originalColorButton;

    @FindBy(css = ".mt-4.text-danger.btn.btn-primary")
    public WebElement changedColorButton;
}
