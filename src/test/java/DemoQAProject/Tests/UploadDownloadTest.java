package DemoQAProject.Tests;

import DemoQAProject.Base.BaseTest;
import DemoQAProject.Pages.HomePage;
import DemoQAProject.Pages.SidebarPage;
import DemoQAProject.Pages.UploadDownloadPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class UploadDownloadTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(loginURL);
        homePage = new HomePage();
        sidebarPage = new SidebarPage();
        uploadDownloadPage = new UploadDownloadPage();
    }

    public void goToUploadDownloadPage(){
        homePage.clickOnCards("Elements");
        scrollDown();
        sidebarPage.clickOnButton("Upload and Download");
        String expectedURL = "https://demoqa.com/upload-download";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        WebElement header = driver.findElement(By.className("main-header"));
        Assert.assertEquals(header.getText(), "Upload and Download");
    }

    @Test
    public void downloadFile(){
        goToUploadDownloadPage();
        waitForClickability(uploadDownloadPage.downloadButton);
        uploadDownloadPage.downloadFile();

        boolean check = false;
        String fileName = "sampleFile";
        String dirPath = "C:\\Users\\furga\\Downloads";
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        for (File listFile : files) {
            if (listFile.getName().contains(fileName)) {
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }

    @Test
    public void uploadFile(){
        goToUploadDownloadPage();
        waitForClickability(uploadDownloadPage.uploadButton);
        uploadDownloadPage.uploadButton.sendKeys("C:\\Users\\furga\\Downloads\\sampleFile.jpeg");
        Assert.assertTrue(uploadDownloadPage.uploadedFilePath.isDisplayed());
    }
}
