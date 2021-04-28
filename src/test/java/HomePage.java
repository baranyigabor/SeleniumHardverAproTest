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


class HomePage extends PageBase {
	private By titleTextBy = By.xpath("//*[@id='header-sticky']/div/a");
	private By signInButtonBy = By.xpath("//*[@id='header-sticky']/div/ul/li[1]/button");
	
	private By searchInputBy = By.xpath("//*[@id='top']/div[1]/div[1]/div/form/div[1]/div/input");
	private By searchButtonBy = By.cssSelector("button[class='btn btn-primary']");
    
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver.get("https://hardverapro.hu/index.html");
    }    
    
	public String getPageTitleText(){
        return this.driver.getTitle();
	}
    public String getTitleText() {
        return this.waitAndReturnElement(titleTextBy).getAttribute("title");
    }
	
	public LoginPage clickOnSignIn() {
		this.waitAndReturnElement(signInButtonBy).click();
		return new LoginPage(this.driver);
	}
	
	public SearchPage searchForItem(String item){
		this.waitAndReturnElement(searchInputBy).sendKeys(item);
		this.waitAndReturnElement(searchButtonBy).click();
		
		return new SearchPage(this.driver);
	}
}
