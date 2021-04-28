import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirstSeleniumTest {
    public WebDriver driver;
    public WebDriverWait wait;
    
    @Before
    public void setup() {
		
		ChromeOptions o= new ChromeOptions();
		o.addArguments("incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, o);
        WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(capabilities);
		
        //driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10);
    }
    
    @Test
    public void testSite() {
        HomePage homePage = new HomePage(this.driver);
        Assert.assertTrue("HomePage did not load properly", homePage.getPageTitleText().contains("HardverApr"));   
		
		LoginPage loginPage = homePage.clickOnSignIn();
		Assert.assertTrue("Login page did not load", loginPage.getSignInText().contains("Bel"));
		
		loginPage.Login("titaw57240@sejkt.com","NkLvipub");
		
		Assert.assertTrue("Login was not successful", loginPage.getUserName().contains("testing"));
		
		SearchPage searchPage = homePage.searchForItem("RTX 3080");
		
		int itemsNumberBeforeFiltering = searchPage.getTotalHits();
		
		FilterParameters params = new FilterParameters("RTX 3090","","","100","800000","","","",true,true,false,false,false,true);
		
		searchPage.setFilters(params);
		
		int itemsNumberAfterFiltering = searchPage.getTotalHits();
		
		Assert.assertFalse("number of items are the same", itemsNumberBeforeFiltering == itemsNumberAfterFiltering);
		
		ItemPage item = searchPage.SelectElement(getRandomNumber(itemsNumberAfterFiltering));
		System.out.println(String.format("The selected item has been raised at: %s", item.getPublishTime()));
		item.navigateBackToPreviousPage();
		
		loginPage.Logout();
		
		Assert.assertFalse("Logout was not successful", loginPage.isUserLoggedIn());
    }

    private int getRandomNumber(int totalItems) {
		int min = 1;
		int max = Math.min(50, totalItems);
		return (int) ((Math.random() * (max - min)) + min);
	}

    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
