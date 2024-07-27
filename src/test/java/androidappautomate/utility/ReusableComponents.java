package androidappautomate.utility;
import java.io.File;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ReusableComponents {
    
    AndroidDriver driver;
    public static AppiumDriverLocalService service;
    public ReusableComponents(AndroidDriver driver){

        this.driver = driver;
    }
    public void scrollAction(String text){

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));

    }

    public static void startAppiumServer(String main_jsPath){

        service = new AppiumServiceBuilder().withAppiumJS(new File(main_jsPath)).withIPAddress("127.0.0.1")
        .usingPort(4723)
        .build();
        service.start();

        
    }
}
 