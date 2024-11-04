package orangeHrm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class orange {
    public static void getOrangeHRM(WebDriver driver) throws Exception {
    	String path=practice.getProperties("path");
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	
    	
    	driver.findElement(By.linkText("Contact Sales")).click();

        driver.findElement(By.id("Form_getForm_FullName")).sendKeys(apachiePOI.getExcelValue(path,1, 0));
        driver.findElement(By.id("Form_getForm_Contact")).sendKeys(apachiePOI.getExcelValue(path,1, 1));
        driver.findElement(By.id("Form_getForm_Email")).sendKeys(apachiePOI.getExcelValue(path,1, 2));
        driver.findElement(By.id("Form_getForm_JobTitle")).sendKeys(apachiePOI.getExcelValue(path,1, 3));

        WebElement countries = driver.findElement(By.id("Form_getForm_Country"));
        Select select = new Select(countries);
        select.selectByValue(apachiePOI.getExcelValue(path,1, 4));

        WebElement employees = driver.findElement(By.id("Form_getForm_NoOfEmployees"));
        Select drop = new Select(employees);
        drop.selectByVisibleText(apachiePOI.getExcelValue(path,1, 5));

        orange.getViewPort(driver,js);
     
        driver.findElement(By.id("Nocaptcha-Form_getForm_Captcha")).click();
		
		Thread.sleep(60000);
        driver.findElement(By.id("Form_getForm_action_submitForm")).click();
        
        Screenshot.getScreenshot(driver,js);
        
        driver.findElement(By.id("Form_getForm_Comment")).sendKeys(apachiePOI.getExcelValue(path,1, 6));
        
        driver.findElement(By.id("Nocaptcha-Form_getForm_Captcha")).click();
        driver.findElement(By.id("Form_getForm_action_submitForm")).click();
      

        // Close the current tab (OrangeHRM)
        driver.close();
    }
    
    
    
    public static void getViewPort(WebDriver driver,JavascriptExecutor js) throws InterruptedException {
    	
        WebElement textarea = driver.findElement(By.id("Form_getForm_Comment"));
        js.executeScript("arguments[0]. scrollIntoView();", textarea);
        Thread.sleep(1000); //for movement of scroller
    }
}
