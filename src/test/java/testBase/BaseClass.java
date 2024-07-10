package testBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public WebDriver driver;
    public Logger logger;
    public ResourceBundle rb;

    @BeforeClass
   @Parameters({"browser"})
    public void setUp(String br) 
    {
    	
        logger = LogManager.getLogger(this.getClass());
        rb = ResourceBundle.getBundle("config");
        if(br.equalsIgnoreCase("chrome"))
        {
        driver=new ChromeDriver();
        }
        else if (br.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (br.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + br);
        }
        	
        	driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("url"));
		driver.manage().window().maximize();
    }

  

    @AfterClass
    public void tearDown() {
            driver.quit();
          
    }
}
