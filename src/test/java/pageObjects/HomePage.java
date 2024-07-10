package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
    public WebDriverWait wait;

	 @FindBy(xpath="//input[@name='username']")
	 WebElement Username_txt;
	 @FindBy(xpath="//input[@name='password']")
	 WebElement PWD_txt;
	 @FindBy(xpath="//input[@value='Log In']")
	 WebElement Login_btn;
	    // Page Actions
	    public void enterUsername(String username) {
	        
	        Username_txt.clear();
	        Username_txt.sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        
	        PWD_txt.clear();
	        PWD_txt.sendKeys(password);
	    }

	    public void clickLogin() {
	       
	        Login_btn.click();
	    }

	    public void login(String username, String password) {
	        enterUsername(username);
	        enterPassword(password);
	        clickLogin();
	    }
	}


