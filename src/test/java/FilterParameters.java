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


class FilterParameters{

	public String SearchText;
	public String Region;
	public String City;
	public String MinPrice;
	public String MaxPrice;
	public String IgnoreWord;
	public String Brand;
	public String Seller;
	public boolean FilterByShipping;
	public boolean FilterBySellerFlag;
	public boolean FilterByBuyerFlag;
	public boolean FilterByExactMatchFlag;
	public boolean FilterByTitleOnlyFlag;
	public boolean FilterByOnHoldExlusionFlag;
    
    public FilterParameters(
		String searchText,
		String region,
		String city,
		String minPrice,
		String maxPrice,
		String ignoreWord,
		String brand,
		String seller,
		boolean filterByShippingFlag,
		boolean filterBySellerFlag,
		boolean filterByBuyerFlag,
		boolean filterByExactMatchFlag,
		boolean filterByTitleOnlyFlag,
		boolean filterByOnHoldExlusionFlag
		) {
		this.SearchText = searchText;
		this.Region = region;
		this.City = city;
		this.MinPrice = minPrice;
		this.MaxPrice = maxPrice;
		this.IgnoreWord = ignoreWord;
		this.Brand = brand;
		this.Seller = seller;
		this.FilterByShipping = filterByShippingFlag;
		this.FilterBySellerFlag = filterBySellerFlag;
		this.FilterByBuyerFlag = filterByBuyerFlag;
		this.FilterByExactMatchFlag = filterByExactMatchFlag;
		this.FilterByTitleOnlyFlag = filterByTitleOnlyFlag;
		this.FilterByOnHoldExlusionFlag = filterByOnHoldExlusionFlag;
    }    
}