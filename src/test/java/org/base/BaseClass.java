package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
  public static WebDriver driver;// can call the driver anywhere in baseclass,Global variable
  public static void launchBrowser() { // public becos we can inherit
	   WebDriverManager.chromedriver().setup();
	   driver =new ChromeDriver();	
}
   public static void windowMaximize() {
	  driver.manage().window().maximize();
	}
 public static void launchUrl(String Url) {
	 driver.get(Url);
	 }
 public static void pageTitle() {
	 String title = driver.getTitle();
	 System.out.println(title);
	}
 public static void pageUrl() {
	String Url = driver.getCurrentUrl();
	System.out.println(Url);
	}
 public static void passText(String txt, WebElement ele) {
	 ele.sendKeys(txt);
	}
	  public static void closeEntireBrowser() {
		  driver.quit();
		
	}
	  public static void clickBtn(WebElement ele) {
		  ele.click();
		
	}
	  public static void screenShot(String imgName) throws IOException {
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File image = ts.getScreenshotAs(OutputType.FILE);
		  File f = new File("location+ imageName.png");
		  FileUtils.copyFile(image, f);
		  }
	public static Actions a ;
	
	public static void moveTheCursor(WebElement tragetElement) {
		a=new Actions (driver);
		a.moveToElement(tragetElement).perform();
		
	}
	public static void dragDrop(WebElement dragWebElement, WebElement dropElement) {
		a=new Actions(driver);
		a.dragAndDrop(dragWebElement, dropElement).perform();
		}
		public static JavascriptExecutor js;
		
		public static void scrollThePage(WebElement tarWebEle) {
			js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()true", tarWebEle);
			
		}
		public static void scroll(WebElement element) {
			js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(false)", element);
			
		}
		public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException {
			File f = new File("excellocation.xlsx");
			FileInputStream  fis =new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet mySheet = wb.getSheet("Data");
			Row r = mySheet.getRow(rowNum);
			Cell c = r.getCell(cellNum);
			int cellType = c.getCellType();
			
			String value = " ";
			if(cellType == 1) {
				String value2 = c.getStringCellValue();
				
			}
			else if (DateUtil.isCellDateFormatted(c)) {
				Date dd  =c.getDateCellValue();
				SimpleDateFormat s = new SimpleDateFormat(value);
				String Value1 = s.format(dd);
				
			}
			else {
				double d =c.getNumericCellValue();
				long l =(long)d;
				String valueOf =String.valueOf(l);
			}
			
		}
		public static void createNewExcelFile(int rowNum, int cellNum, String writeData) throws IOException {
			File f = new File("C:\\Users\\HP\\eclipse-workspace3\\BaseClass\\Excel\\Excellocation.xlsx");
			Workbook w = new XSSFWorkbook();
			Sheet newSheet = w.createSheet("Datas");
			Row newRow = newSheet.createRow(rowNum);
			Cell newCell = newRow.createCell(cellNum);
			newCell.setCellValue(writeData);
			FileOutputStream fos = new FileOutputStream(f);
			w.write(fos);
			
		}
		public static void createCell(int getRow, int creCell, String newData) throws IOException {
			File f = new File("Excel location.xlsx");
			FileInputStream  fis =new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet s = wb.getSheet("Datas");
			Row r = s.getRow(getRow);
			Cell c= r.createCell(creCell);
			c.setCellValue(newData);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
			
}
		public static void updateDateToParticularCell(int getTheRow, int getTheCell, String existingData,String writeNewData) throws IOException {
			File f = new File("Excel location.xlsx");
			FileInputStream  fis =new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet s = wb.getSheet("Datas");
			Row r = s.getRow(getTheRow);
			Cell c= r.createCell(getTheCell);
		String str = c.getStringCellValue();
			if (str.equals(existingData)) {
				c.setCellValue(writeNewData);
				
			}
			
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
}


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}

//static means dont want to create object for the class