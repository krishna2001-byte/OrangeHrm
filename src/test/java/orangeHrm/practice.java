package orangeHrm;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class practice {
     
	
	

    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
    	String Link1=practice.getProperties("Link1");
    	String Link2=practice.getProperties("Link2");
    	String webName=practice.getProperties("webName");
    	
    	
    	
    	
        WebDriver driver = DriverManager.createDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                
        try {
        	
            //google navigations
            google.getGoogleNavigationMethods(driver,webName,Link1);

            // Open OrangeHRM in a new tab
            driver.switchTo().newWindow(WindowType.TAB);
            
            driver.navigate().to(Link2);

            // Capture the URL of the OrangeHRM page before closing
            String initialUrlAfterHrm = driver.getCurrentUrl();
           
            
            // Fill out and submit contact form
            orange.getOrangeHRM(driver);
            
            driver.switchTo().window(driver.getWindowHandles().iterator().next());
  
            // Verify navigation back to the Google search results tab
            google.getGooglenav(driver,initialUrlAfterHrm);

            
          } catch (NoSuchElementException e) {
              System.out.println("Element not found: " + e.getMessage());
          } catch (Exception e) {
              System.out.println("An error occurred: " + e.getMessage());
          } finally {
                     if (driver != null) {
                       driver.quit();  
                       }
          }
    }
    
    public static String getProperties(String key) throws IOException {
    	Properties prop=new Properties();
    	FileInputStream fi=new FileInputStream("C:\\Users\\2332815\\eclipse-workspace\\OrangeHRM_MiniProject\\excel\\file.properties");
        prop.load(fi);
        
        String res=prop.getProperty(key);
        return  res;
    }
    
   
}
