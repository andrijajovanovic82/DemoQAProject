package DemoQAProject.Pages;

import DemoQAProject.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadDownloadPage extends BaseTest {

    public UploadDownloadPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="downloadButton")
    public WebElement downloadButton;

    @FindBy(className = "form-control-file")
    public WebElement uploadButton;

    @FindBy(id="uploadedFilePath")
    public WebElement uploadedFilePath;

    //-------------------------------------

    public void downloadFile(){
        downloadButton.click();
    }
}
