package VSSE.Iphone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * This Class represent the search result page and deals with its locators
 * @author Mahmoud Yasser
 * @version 1.0
 */public class SearchResult {
	WebDriver driver;
	
	/**
	 * This is Function to locate and return number of results
	 * @return
	 * @throws Exception
	 */
	public By locateNumber() throws Exception {
		//object from ReadExcel class to read from excel sheet
		ReadExcel ex = new ReadExcel();
		// By object to store the result-number's id which is imported from excel sheet
		By resultnumber = By.cssSelector(ex.getResultLocator());
		return resultnumber;
		}
	
	/**
	 * Constructor to deal with the same driver from SearchTest class
	 * @param driver
	 */
	public SearchResult (WebDriver driver) {
	this.driver=driver;
}
}
