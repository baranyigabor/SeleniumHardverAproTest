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


class ItemPage extends PageBase {	
	private By publishDateTimeBy = By.xpath("//*[@id='center']/div[1]/div[2]/span[2]");
    public ItemPage(WebDriver driver) {
        super(driver);
    }   
	
	public String getPublishTime(){
		return this.waitAndReturnElement(publishDateTimeBy).getText();
	}
	
	public void navigateBackToPreviousPage()
	{		
		this.driver.navigate().back();
	}
}
