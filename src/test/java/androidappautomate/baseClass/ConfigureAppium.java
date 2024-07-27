package androidappautomate.baseClass;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import androidappautomate.utility.ReadDataProperties;
import androidappautomate.utility.ReusableComponents;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ConfigureAppium extends ReadDataProperties{
    
    public AndroidDriver driver;
    public UiAutomator2Options options;
    public ReadDataProperties readData = new ReadDataProperties();
    
   
    @BeforeTest
    public void start_AppiumServer() throws URISyntaxException, IOException{

        
        if(readData.getAppiumServerRunningOS().equalsIgnoreCase("mac")){

        
            ReusableComponents.startAppiumServer(readData.getMac_MainJSPath());
            options = new UiAutomator2Options();
            options.setDeviceName(prop.getProperty("deviceName"));
            options.setApp(readData.getAppPath());

            driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL() ,options);
    
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        }

        else if(readData.getAppiumServerRunningOS().equalsIgnoreCase("windows")){

            ReusableComponents.startAppiumServer(readData.getWindows_MainJSPath());
            options = new UiAutomator2Options();
            options.setDeviceName(prop.getProperty("deviceName"));
            options.setApp(readData.getAppPath());
           
            driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL() ,options);
            
           
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        }
        else{
            throw new RuntimeException("Data not configured proeprly..");
        } 
        
    }

    @AfterTest
    public void tearDown(){
        ReusableComponents.service.stop();
        driver.quit();

    }
}
