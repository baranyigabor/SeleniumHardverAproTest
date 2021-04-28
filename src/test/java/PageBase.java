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


class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
	   
	private JavaScriptExtension jse;
    
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10,500);
		this.jse = new JavaScriptExtension(this.driver);
    }
	
    protected WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    } 
    
    protected String getBodyText() {
        WebElement bodyElement = this.waitAndReturnElement(By.tagName("body"));
        return bodyElement.getText();
    }
	
	protected void SetCheckBoxByName(String name, boolean checked)
	{	
		boolean status = (boolean)this.jse.getJavaScriptExecutionResult(String.format("return document.getElementsByName('%s')[0].checked", name));
		if(checked != status)
		{
			String code = String.format("document.getElementsByName('%s')[0].click()", name);
			this.jse.ExecuteJavaScriptCode(code);
		}
	}   
}
