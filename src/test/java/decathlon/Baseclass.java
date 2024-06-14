package decathlon;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	
	public static WebDriver driver ;
	public static WebElement findelement;
	public static WebElement findelements;
    public static Actions actions;
    public static JavascriptExecutor jsExecutor;
    public static WebDriverWait wait;
    public static Robot robot;
    
    
  
	//for browser launching
	public static void driverLaunch(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            // Add cases for other browsers if needed
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
		
    }
	
	
	
	//FOR URL LAUNCHING
	 public static void url(String link) {
	        if (driver == null) {
	            throw new IllegalStateException("WebDriver is not initialized. Please initialize the WebDriver before using.");
	        }
	        driver.get(link);
	    }
	
	
	//FINDELEMENT
	public static WebElement findelement(String type, String value ) {
	
		
		switch (type) {
		case "name":findelement = driver.findElement(By.name(value));
	    break;
		case "id": findelement = driver.findElement(By.id(value));
	    break;
		case "xpath": findelement =driver.findElement(By.xpath(value));
	    break;
		case "tagname": findelement = driver.findElement(By.tagName(value));
	    break;
		
		}
		return findelement;}
	
	
	//FINDELEMENTS
	 public static List<WebElement> findElements(String type, String value) {
	        switch (type) {
	            case "name":
	                return driver.findElements(By.name(value));
	            case "id":
	                return driver.findElements(By.id(value));
	            case "xpath":
	                return driver.findElements(By.xpath(value));
	            case "tagname":
	                return driver.findElements(By.tagName(value));
	            default:
	                throw new IllegalArgumentException("Unsupported locator type: " + type);}
	        }
	
	 
	 
	//TO GET CURRENT URL
	public static String currenturl() {
		
		return driver.getCurrentUrl();
	}
	
	
	
	//TO GET TITLE
	
	public static String title() {
		
		return driver.getTitle();
	}
	
	
	
	// TO GET PAGE SOURCE
	public static String pagesource() {
		
		return driver.getPageSource();
	}
	
	
	
	//TO CLICK
	 public static void clickElement(WebElement element) {
	        element.click();
	    }
	
	 
	 
	//TO SENDKEYS
	 public static void sendkeys(WebElement element, String keys) {
		   element.sendKeys(keys);
	 }
	 
	// MOUSEACTIONS
	  public static void doubleClickElement(WebElement element) {
		  actions = new Actions(driver);
	        actions.doubleClick(element).perform();
	    }
	    
	    public static void rightClickElement(WebElement element) {
	    	actions = new Actions(driver);
	        actions.contextClick(element).perform();
	    }
	    
	    public static void dragAndDrop(WebElement source, WebElement target) {
	    	actions = new Actions(driver);
	        actions.dragAndDrop(source, target).perform();
	    }
	    
	    public static void moveToElement(WebElement element) {
	        actions = new Actions(driver);
	        actions.moveToElement(element).perform();
	    }
	    
	    
	 //WAIT 
	    public static void Wait(long timeoutInSeconds) {
	        driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
	    }

	    
	  
	  //MAXIMIZE WINDOW
	    public static void maximizeWindow() {
	        driver.manage().window().maximize();
	    }
	    
	    
	    //MINIMIZE WINDOW
	    public static void minimizeWindow() {
	        driver.manage().window().minimize();
	    }
	    
	    
	    //REFRESH PAGE
	    public static void refresh() {
	        driver.navigate().refresh();
	    }
	    
	    
	    //NAVIGATE TO URL
	    public static void navigateToUrl(String url) {
	        driver.navigate().to(url);
	    }
	    
	    
	    //WINDOW BACK
	    public static void goBack() {
	        driver.navigate().back();
	    }
	    
	    
	    //WINDOWFORWARD
	    public static void goForward() {
	        driver.navigate().forward();
	    }
	    
	    
	    
	    //TAKESCREENSHOT
	     public static void takeScreenshot(String screenshotPath) throws IOException {
	       
	        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
	        File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(screenshotFile, new File(screenshotPath));
	        
	    }
	    
	     
	    //SCROLL TO TOP
	    public static Object scrollToTop() {
	    	jsExecutor = (JavascriptExecutor) driver;
	    	return jsExecutor.executeScript("window.scrollTo(0, 0)");
	    }
	    
	    
	    //SCROLL TO SPECIFIC
	    public  static Object scrollToElement(WebElement string) {
	    	jsExecutor = (JavascriptExecutor) driver;
	        return jsExecutor.executeScript("arguments[0].scrollIntoView(true);", string);
	    }
	    
	    
	    //SWITCHING FRAME USING FRAMEELEMENT
	    public  static void switchToFrameByElement(WebElement frameElement) {
	        driver.switchTo().frame(frameElement);
	    }

	    
	    // BACK TO DEFAULT FRAME
	    public  static void switchToDefaultContent() {
	        driver.switchTo().defaultContent();
	    }
	    
	    
	    //DROPDOWN
	    
	    public  static void selectbyVisibleText(WebElement dropdownElement, String visibleText) {
	    
	        Select dropdown = new Select(dropdownElement);
	        dropdown.selectByVisibleText(visibleText);}
	    
	    
	 
	    public  static void deselectAllOptions(String locator) {
	        WebElement dropdownElement = driver.findElement(By.xpath(locator));
	        Select dropdown = new Select(dropdownElement);
	        if (dropdown.isMultiple()) {
	            dropdown.deselectAll();
	        }
	    }
	    
	    
	    //VK ENTERKEY
	    public static void pressEnterKey() throws AWTException {
	    	robot = new Robot();
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	    }

	    
	    //ALERT
	    //ACCEPT ALERT
	    public static void acceptAlert() {
	        Alert alert = driver.switchTo().alert();
	        alert.accept();
	    }

	    
	    // METHOD TO DISMISS THE ALERT
	    public   static void dismissAlert() {
	        Alert alert = driver.switchTo().alert();
	        alert.dismiss();
	    }
	    
	    
	    //SENDKEYS TO ALERT   
	    public  static void sendKeysToAlert(String keys) {
	        Alert alert = driver.switchTo().alert();
	        alert.sendKeys(keys);
	    }
	    
	    
	   //CURRENT WINDOW
	    
        public static String getCurrentWindowHandle() {
	        return driver.getWindowHandle();
	    }
        
        
        // ALLWINDOWS
        
	    public static Set<String> getAllWindowHandles() {
	        return driver.getWindowHandles();
	    }
	   
	    public void switchToFirstWindow() {
	        Set<String> windowHandles = getAllWindowHandles();
	        if (!windowHandles.isEmpty()) {
	            String firstWindowHandle = windowHandles.iterator().next();
	            switchToWindow(firstWindowHandle);
	        } else {
	            System.out.println("No windows are available.");
	        }
	    }

	    
	    public void switchToSecondWindow() {
	        Set<String> windowHandles = getAllWindowHandles();
	        Iterator<String> iterator = windowHandles.iterator();
	        // Skip the first window handle
	        iterator.next();
	        if (iterator.hasNext()) {
	            String secondWindowHandle = iterator.next();
	            switchToWindow(secondWindowHandle);
	        } else {
	            System.out.println("There is no second window available.");
	        }
	    }

	    
	 
	  
	   
	    
	    public static void switchTosecondewindowclosefirstwindow() {
	        String mainWindowHandle = getCurrentWindowHandle();
	        for (String handle : getAllWindowHandles()) {
	            if (!handle.equals(mainWindowHandle)) {
	                switchToWindow(handle);
	                closeCurrentWindow();
	            }
	        }
	        switchToWindow(mainWindowHandle);
	    }
	    
	  
	    public static void switchTofirstewindowclosefirstwindow () {
	        String mainWindowHandle = getCurrentWindowHandle();
	        for (String handle : getAllWindowHandles()) {
	            if (handle.equals(mainWindowHandle)) {
	                switchToWindow(handle);
	                closeCurrentWindow();
	            }
	        }
	        switchToWindow(mainWindowHandle);
	    }
	   

	    
	    
	    //CLOSECURRENTWINDOW
	    public static void closeCurrentWindow() {
	        driver.close();}
	    
	    //SWITCHTOWINDOW
	    public static void switchToWindow(String windowHandle) {
	        driver.switchTo().window(windowHandle);
	    }
	 
	    
	    //WEBTABLE
	    public static String getTableHeaderText(String xpath) {
	        WebElement tableHeader = driver.findElement(By.xpath(xpath+"/tbody/tr"));
	        return tableHeader.getText();
	    }
	    public static void gettableValue(String xpath) {
	        List<WebElement> rows = driver.findElements(By.xpath(xpath + "/tbody/tr"));
	        int rowCount = rows.size();

	        List<WebElement> columns = driver.findElements(By.xpath(xpath + "/tbody/tr[1]/td"));
	        int columnCount = columns.size();

	        for (int i = 1; i < rowCount; i++) {
	            for (int j = 1; j <columnCount; j++) {
	                WebElement cell = driver.findElement(By.xpath(xpath + "/tbody/tr[" + i + "]/td[" + j + "]"));
	                String cellValue = cell.getText();
	                System.out.println("Cell value at row " + i + ", column " + j + ": " + cellValue);
	            }
	        }
	    }

	//EXCELREAD
	    public static String excelRead(String path, String sheetname, int rowNum, int cellNum) throws IOException {
	        try (FileInputStream fis = new FileInputStream(path);
	             Workbook wb = new XSSFWorkbook(fis)) {
	            Sheet sheet = wb.getSheet(sheetname);

	            if (sheet == null) {
	                throw new IllegalArgumentException("Sheet '" + sheetname + "' not found!");
	            }

	            Row row = sheet.getRow(rowNum);
	            if (row == null) {
	                throw new IllegalArgumentException("Row " + rowNum + " not found in sheet '" + sheetname + "'!");
	            }

	            Cell cell = row.getCell(cellNum);
	            if (cell == null) {
	                return ""; // CELL IS EMPTY
	            }

	            switch (cell.getCellType()) {
	                case STRING:
	                    return cell.getStringCellValue();

	                case NUMERIC:
	                    if (DateUtil.isCellDateFormatted(cell)) {
	                        return new SimpleDateFormat("dd/MM/yyyy").format(cell.getDateCellValue());
	                    } else {
	                        double numericValue = cell.getNumericCellValue();
	                        long longValue = (long) numericValue;
	                        return (numericValue == longValue) ? String.valueOf(longValue) : String.valueOf(numericValue);
	                    }

	                case BOOLEAN:
	                    return String.valueOf(cell.getBooleanCellValue());

	                default:
	                    return ""; // DEFAULT RETURN STATEMENT
	            }
	        }
	    }



	            
	       
			
			
	    
	
	  
	
	    
	   
	 
	//CLOSEDRIVER
	        public static void closeDriver() {
	           
	                driver.quit();
	
	
}}
	



