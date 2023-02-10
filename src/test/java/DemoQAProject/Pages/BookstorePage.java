package DemoQAProject.Pages;

import DemoQAProject.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookstorePage extends BaseTest {

    public BookstorePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText="Git Pocket Guide")
    public WebElement book1;

    @FindBy(id="addNewRecordButton")
    public List<WebElement> bookstoreButton;

    @FindBy(className = "mr-2")
    public List<WebElement> books;

    @FindBy(linkText = "Git Pocket Guide")
    public WebElement book1OnTheAccount;

    @FindBy(linkText = "Learning JavaScript Design Patterns")
    public WebElement book2OnTheAccount;

    @FindBy(linkText = "Designing Evolvable Web APIs with ASP.NET")
    public WebElement book3OnTheAccount;


    //----------------------------------------------------------

    public void addToYourCollection(){
        for(int i=0; i<bookstoreButton.size(); i++){
            if(bookstoreButton.get(i).getText().equals("Add To Your Collection")){
                bookstoreButton.get(i).click();
                break;
            }
        }
    }

    public void backToBookStore(){
        for(int i=0; i<bookstoreButton.size(); i++){
            if(bookstoreButton.get(i).getText().equals("Back To Book Store")){
                bookstoreButton.get(i).click();
                break;
            }
        }
    }

//    public void addBook1(){
//        book1.click();
//        addToYourCollection();
////        driver.navigate().back();
//    }
//
//    public void addBook2(){
//        book2.click();
//        addToYourCollection();
//    }
//
//    public void addBook3(){
//        book3.click();
//        addToYourCollection();
//    }

    public void addBook(String book){
        for(int i=0; i< books.size(); i++){
            if(books.get(i).getText().equals(book)){
                books.get(i).click();
                break;
            }
        }
        addToYourCollection();
    }

}
