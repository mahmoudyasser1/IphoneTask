package VSSE.Iphone;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This Class to Read data from external excel sheet
 * @author Mahmoud Yasser
 * @version 1.0
 */
//Class to manipulate external excel sheet
public class ReadExcel {
	//Delcare new instance from XSSFSheet to deal with sheets in excel
static XSSFSheet sh;
	//Delcare new instance from XSSFWorkbook to deal with wxcel workbook
static XSSFWorkbook wb;
	//Declare Array of strings to store data from excel sheet 
static String [] data;
/**
 * Function to read data
 * @throws Exception
 */
	public void readData() throws Exception {
		//Create new instance from File class to store file path
		File src = new File (".\\TestData.xlsx");
		//Create new instance from FileInputStream to read from file
		FileInputStream fis = new FileInputStream(src);
		
		//initialize workbook instance wb with the file stream instance
		wb = new XSSFWorkbook(fis);
		//Initialize sheet object with the 1st sheet from the workbook object 
		 sh = wb.getSheetAt(0);
		 // Set array size = 13
		data = new String [13];
		
		//Crate new instance from DataFormatted to deal with different types of excel cells
		DataFormatter formatter = new DataFormatter();

		//Loop on data array
		for(int i = 0; i<data.length;i++)
		{
			//Fill objects in array with data from excel sheet
			data[i] = formatter.formatCellValue(sh.getRow(1).getCell(i));
			
		}
		
	}
	// Functions to pass the data from excel sheet when called.
		public String getSearchBarLocator() {
		return data[1];
		}
		
		public String getStartUrl()
		{
			return data[0];
		}
		public String getFireFoxProperty()
		{return data[2];
		}
		public String getGeckoDriver()
		{return data[3];
		}
		public String getChromeProperty()
		{return data[4];		}
		public String getChromeDriver()
		{return data[5];		}
		public String getExplorerProperty()
		{return data[6];
		}
		public String getExplorerDriver()
		{return data[7];
		}
		public String getError()
		{return data[8];
		}
		public String getSearchQuery()
		{return data[9];
		}
		public String getResultUrl()
		{return data[10];
		}
		public String getResultNumber()
		{return data[11];
		}
		public String getResultLocator()
		{
			return data[12];
		}
}
