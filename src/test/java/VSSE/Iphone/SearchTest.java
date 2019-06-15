package VSSE.Iphone;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * This Class to Drive testing
 * @author Mahmoud Yasser
 * @version 1.0
 */
public class SearchTest {
	//object from ReadExcel class to read from excel sheet
	 ReadExcel ex = new ReadExcel();
	 
	 //Delcare new global Web driver
	 		WebDriver driver;
	/**
	 * Thisfunction to setup the environment
	 * @param browser
	 * @throws Exception
	*/
	@BeforeTest
	@Parameters("browser")

	public void setup(String browser) throws Exception{
		// Call readData function from ReadExcel to import data from Excel sheet
		ex.readData();
		//Check if parameter passed is'firefox'
		if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
			driver = new FirefoxDriver();
			//Set firefox property
			System.setProperty(ex.getFireFoxProperty(), ex.getFireFoxProperty());

		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty(ex.getChromeDriver(),ex.getChromeProperty());
			//create chrome instance
			driver = new ChromeDriver();
			
		}
		//Check if parameter passed as 'IE'
				else if(browser.equalsIgnoreCase("IE")){
					//set path to IE Driver Server.exe
					System.setProperty(ex.getExplorerDriver(),ex.getExplorerProperty());
					//create Internet Explorer instance
					driver = new InternetExplorerDriver();
				}
		else{
			//If no browser passed throw exception
			throw new Exception(ex.getError());
		}
		
	}

	
  @Test
  /**
   * This is Test Case to assert Url 
   * @throws Exception
   */
  public void f1AssertUrl() throws Exception {
	  //Maximize browser window
	  driver.manage().window().maximize();
	  //Navigate to Start page url which is imported from external excel sheet
	  driver.get(ex.getStartUrl());	  

	  //Create new instance from startpage class to access its functions
	  Start startpage = new Start(driver);
	  //import search query from excel sheet then pass it to search function in startpage class
	  startpage.search(ex.getSearchQuery());
	  
	//Create new instance from SearchResult class to access its functions
	  SearchResult result = new SearchResult(driver);

//Create new instance from WebDriverWait to use explicit wait
	  WebDriverWait wait = new WebDriverWait(driver,120);
	  //Force driver to wait until an element from the 2nd page becomes visible
	 wait.until(ExpectedConditions.visibilityOfElementLocated(result.locateNumber()));
 
	   
	//Assert that current url contains the expected result which is imported from Excel sheet
	 assertTrue((driver.getCurrentUrl().contains(ex.getResultUrl())), "Url Test Failed");
  }
  
  @Test
  /**
   * This is Test Case to assert number of results
   * @throws Exception
   */
  public void f2AssertNumber() throws Exception {
	  SearchResult result = new SearchResult(driver);
	  //Assert that Actual number of results equals the expected one imported from excel sheet
	 assertEquals(driver.findElement(result.locateNumber()).getText(), ex.getResultNumber(),"Result number test failed");
	 driver.quit();
  }
 
}
