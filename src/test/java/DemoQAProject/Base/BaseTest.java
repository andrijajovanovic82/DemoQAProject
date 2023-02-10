package DemoQAProject.Base;

import DemoQAProject.Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public Actions action;


    public String loginURL;

    public HomePage homePage;
    public SidebarPage sidebarPage;
    public TextBoxPage textBoxPage;
    public CheckBoxPage checkBoxPage;
    public RadioButtonPage radioButtonPage;
    public WebTablesPage webTablesPage;
    public ButtonsPage buttonsPage;
    public LinksPage linksPage;
    public BrokenLinksImagesPage brokenLinksImagesPage;
    public UploadDownloadPage uploadDownloadPage;
    public DynamicPropertiesPage dynamicPropertiesPage;
    public PracticeFormPage practiceFormPage;
    public LoginPage loginPage;
    public BookstorePage bookstorePage;
    public ProfilePage profilePage;



    @BeforeClass
    public void SetUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
        excelReader = new ExcelReader("src/test/java/DemoQA/TestData.xlsx");
        loginURL = excelReader.getStringData("URL", 1, 0);
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void scrollDown(){
        ((JavascriptExecutor) driver).executeScript("scroll(0, 350)");
    }
    public void doubleClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].dispatchEvent(new MouseEvent('dblclick', { bubbles: true }));", element);
    }
    public void rightClick(WebElement element){
        action.contextClick(element).perform();
    }

    public void waitForClickability(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void zoom100() {
        WebElement html  = driver.findElement(By.tagName("html"));
        html.sendKeys(Keys.chord(Keys.CONTROL, "0"));
    }

    @AfterClass
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
