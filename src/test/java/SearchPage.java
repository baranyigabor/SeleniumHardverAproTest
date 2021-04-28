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


class SearchPage extends PageBase {

	private By searchTextBy = By.name("stext");
	private By filterByRegionBy = By.name("county");
	private By filterByCityBy = By.name("settlement");
	private By minPriceBy = By.name("minprice");
	private By maxPriceBy = By.name("maxprice");
	private By ignoreWordBy = By.name("stext_none");
	private By filterByBrandBy = By.name("company");
	private By filterBySellerBy = By.name("user");
	private String filterByShippingBy = "shipping";
	private String filterBySellerCheckBoxBy = "selling";
	private String filterByBuyerCheckBoxBy = "buying";
	private String filterByExactMatchCheckBoxBy = "search_exac";
	private String filterByTitleOnlyBy = "search_title";
	private String filterByOnHoldExlusionBy = "noiced";
	
	private By advertismentInfoBy = By.xpath("//*[@id='center']/div[3]/ul/li[1]/h3");
	private By searchButtonBy = By.cssSelector("button[class='btn btn-primary']");
	
	public int getTotalHits(){
		return Integer.parseInt(this.waitAndReturnElement(advertismentInfoBy).getText().split(" ")[2]);
	}
	
    public SearchPage(WebDriver driver) {
        super(driver);
    }    
    
    public void setFilters(FilterParameters params) {
        setSearchText(params.SearchText);
		setRegion(params.Region);
		setCity(params.City);
		setMinPrice(params.MinPrice);
		setMaxPrice(params.MaxPrice);
		setIgnoreWord(params.IgnoreWord);
		setBrand(params.Brand);
		setSeller(params.Seller);
		setShipping(params.FilterByShipping);
		setSellerCheckBox(params.FilterBySellerFlag);
		setBuyerCheckBox(params.FilterByBuyerFlag);
		setExactMatchCheckBox(params.FilterByExactMatchFlag);
		setFilterByTitleOnlyCheckBox(params.FilterByTitleOnlyFlag);
		setFilterByOnHoldExclusionCheckBox(params.FilterByOnHoldExlusionFlag);
		
		applyFilters();
    }
	
	public ItemPage SelectElement(int elementId){
		By advertistmentLocatorBy = By.cssSelector(String.format(".list-unstyled li[class='media']:nth-of-type(%d) a", elementId));
		this.waitAndReturnElement(advertistmentLocatorBy).click();
		//this.driver.navigate().back();
		
		return new ItemPage(this.driver);
	}
		
	private void applyFilters(){
		this.waitAndReturnElement(searchButtonBy).click();
	}
	
	private void setSearchText(String text){
		this.waitAndReturnElement(searchTextBy).clear();
		this.waitAndReturnElement(searchTextBy).sendKeys(text);
	}
	private void setRegion(String text){
		this.waitAndReturnElement(filterByRegionBy).clear();
		this.waitAndReturnElement(filterByRegionBy).sendKeys(text);
	}
	private void setCity(String text){
		this.waitAndReturnElement(filterByCityBy).clear();
		this.waitAndReturnElement(filterByCityBy).sendKeys(text);
	}
	private void setMinPrice(String text){
		this.waitAndReturnElement(minPriceBy).clear();
		this.waitAndReturnElement(minPriceBy).sendKeys(text);
	}
	private void setMaxPrice(String text){
		this.waitAndReturnElement(maxPriceBy).clear();
		this.waitAndReturnElement(maxPriceBy).sendKeys(text);
	}
	private void setIgnoreWord(String text){
		this.waitAndReturnElement(ignoreWordBy).clear();
		this.waitAndReturnElement(ignoreWordBy).sendKeys(text);
	}
	private void setBrand(String text){
		this.waitAndReturnElement(filterByBrandBy).clear();
		this.waitAndReturnElement(filterByBrandBy).sendKeys(text);
	}
	private void setSeller(String text){
		this.waitAndReturnElement(filterBySellerBy).clear();
		this.waitAndReturnElement(filterBySellerBy).sendKeys(text);
	}
	private void setShipping(boolean flag)
	{
		this.SetCheckBoxByName(filterByShippingBy, flag);
	}
	private void setSellerCheckBox(boolean flag)
	{
		this.SetCheckBoxByName(filterBySellerCheckBoxBy, flag);
	}
	private void setBuyerCheckBox(boolean flag)
	{		
		this.SetCheckBoxByName(filterByBuyerCheckBoxBy, flag);
	}
	private void setExactMatchCheckBox(boolean flag)
	{
		this.SetCheckBoxByName(filterByExactMatchCheckBoxBy, flag);
	}
	private void setFilterByTitleOnlyCheckBox(boolean flag)
	{
		this.SetCheckBoxByName(filterByTitleOnlyBy, flag);
	}
	private void setFilterByOnHoldExclusionCheckBox(boolean flag)
	{
		this.SetCheckBoxByName(filterByOnHoldExlusionBy, flag);
	}
}
