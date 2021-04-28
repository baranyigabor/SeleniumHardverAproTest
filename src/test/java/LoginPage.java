import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


class LoginPage extends PageBase {

	private By singInTextBy = By.className("modal-title");
	private By emailInputBoxBy = By.name("email");
	private By passwordInputBoxBy = By.name("pass");
	private By signInButtonBy = By.xpath("/html/body/div[3]/div/div/div[2]/form/div[5]/button");
	
	private By userInfoBy = By.xpath("//*[@id='header-sticky']/div/ul/li[5]/a");
	private By userNameBy = By.xpath("//*[@id='header-sticky']/div/ul/li[5]/div/h6/a");
	
	private By logoutButtonby = By.cssSelector("div[class='dropdown-menu dropdown-menu-right show'] .dropdown-item:nth-of-type(13)");
    
    public LoginPage(WebDriver driver) {
        super(driver);
    }    
    
    public String getSignInText() {
        return this.waitAndReturnElement(singInTextBy).getText();
    }

	public void Login(String email, String password){
		this.waitAndReturnElement(emailInputBoxBy).sendKeys(email);
		this.waitAndReturnElement(passwordInputBoxBy).sendKeys(password);
		this.waitAndReturnElement(signInButtonBy).click();
	}
	
	public String getUserName(){
		this.waitAndReturnElement(userInfoBy).click();
		String userName = this.waitAndReturnElement(userNameBy).getText();
		this.waitAndReturnElement(userInfoBy).click(); // hide dropdown
		return userName;
	}
	public void Logout(){		
		this.waitAndReturnElement(userInfoBy).click();
		this.waitAndReturnElement(logoutButtonby).click();
	}
	
	public boolean isUserLoggedIn(){		
		try{
			this.waitAndReturnElement(userInfoBy).click();
			String userName = this.waitAndReturnElement(userNameBy).getText();
			return true;
		}
		catch(Exception e){
			return false;
		}		
	}
}
