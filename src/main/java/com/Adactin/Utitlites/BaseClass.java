package com.Adactin.Utitlites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Helper_File.FileReadManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static void loadConfig() {
		try {
			prop = new Properties();
			File path = new File(System.getProperty("user.dir") + "\\Configuration\\data.properties");
			FileInputStream ip = new FileInputStream(path);
			// C:\Users\Lenovo\eclipse-workspace\Practice\Mavenproject\Confiuration
			prop.load(ip);
			System.out.println("Driver = " + driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static  ExtentReports getExtendReport() {
		
			String path = System.getProperty("user.dir")+"\\Reports\\report1.html";
			ExtentSparkReporter report = new ExtentSparkReporter(path);
			report.config().setReportName("Adactin Automation Results");
			report.config().setDocumentTitle("Test Results");
			extent = new ExtentReports();
			extent.attachReporter(report);
			extent.setSystemInfo("Tester", "Akila Baskar");
			return extent;	
		}
	
	
	
public void ExcelDataParticularData(String path,int row_index,int cell_index) throws IOException {

	File f = new File(path);
	FileInputStream fis = new FileInputStream(f);
	XSSFWorkbook wb= new XSSFWorkbook(fis);
	XSSFSheet sheetAt = wb.getSheetAt(0);
	XSSFRow row = sheetAt.getRow(row_index);
	XSSFCell cell = row.getCell(cell_index);
	CellType cellType = cell.getCellType();
	if (cellType.equals(cellType.STRING)) {
		String StringcellValue = cell.getStringCellValue();
		System.out.println(StringcellValue);
	}else if (cellType.equals(cellType.NUMERIC)) {
		double numericCellValue = cell.getNumericCellValue();
		int value = (int)numericCellValue;
		System.out.println(value);
	}	
}
	public static WebDriver browserLaunch(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					// G:\Automation workspace\E2EAutomationPractice\Drivers\chromedriver.exe
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//driver.manage().timeouts().pageLoadTimeout(prop.getProperty("pageLoadTimeout")),TimeUnit.SECONDS);
		return driver;
	}

	public static void waiting() {
		// long time = Long.parseLong(prop.getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public static void getUrl(String url) {
		driver.get(url);
	}

	public static void toclick(WebElement element) {
		element.click();
		
	}

	public static void dropDown(WebElement element, String type, String value) {
		Select s = new Select(element);
		if (type.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (type.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(value);
			s.selectByIndex(index);
		} else if (type.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		}
	}

	public static void toGetText(WebElement element) {
		element.getText();
	}

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();
	}

	public static void toSendKeys(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void takeScreenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir") + "\\Screenshot.img.png");
		FileUtils.copyFile(src, des);
	}

	public static void toGetAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		System.out.println(attribute);

	}

	public static void moveToElement(WebElement element, String type) {
		Actions ac = new Actions(driver);
		if (type.equalsIgnoreCase("movetoelement")) {
			ac.moveToElement(element).build().perform();
		} else if (type.equalsIgnoreCase("rightclick")) {
			ac.contextClick(element);
		} else if (type.equalsIgnoreCase("doubleclick")) {
			ac.doubleClick(element);
		}
	}

	public static void dragAndDrop(WebElement drag, WebElement drop) {
		Actions ac = new Actions(driver);
		ac.dragAndDrop(drag, drop);
	}

	public static void scrolling(String type) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (type.equalsIgnoreCase("scrollDown")) {
			js.executeScript("window.ScrollBy(0,500);");
		} else if (type.equalsIgnoreCase("scrollup")) {
			js.executeScript("window.ScrollBy(0,-500);");
		}
	}

	public static void windowHandling(String type) {
		if (type.equalsIgnoreCase("currentwindowhandle")) {
			driver.getWindowHandle();
		} else if (type.equalsIgnoreCase("allwindowhandles")) {
			driver.getWindowHandles();
		}
	}

	public static void getTitle() {
		System.out.println(driver.getTitle());
	}

}
