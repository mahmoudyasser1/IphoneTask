package VSSE.Iphone;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
/**
 * This Class represent the start page and deals with its locators
 * @author Mahmoud Yasser
 * @version 1.0
 */
public class Start {
	WebDriver driver;
	ReadExcel ex = new ReadExcel();
	By SearchBar = By.id(ex.getSearchBarLocator());
	/**
	 * Constructor to deal with the same driver from SearchTest class
	 * @param driver
	 */
		public Start (WebDriver driver) {
		this.driver=driver;
	}
	/**
	 * Search function which takes search query and search on it
	 * @param query
	 * @throws Exception
	 */
	public void search(String query) throws Exception {
		//object from ReadExcel class to read from excel sheet
		ReadExcel ex = new ReadExcel();
		// By object to store the search bar id which is imported from excel sheet
		By SearchBar = By.id(ex.getSearchBarLocator());
		//Type the query in the search bar
		driver.findElement(SearchBar).sendKeys(query);
		//Proceed with searching
		driver.findElement(SearchBar).sendKeys(Keys.ENTER);
	}
}
