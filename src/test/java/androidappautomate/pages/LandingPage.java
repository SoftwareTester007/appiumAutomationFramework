package androidappautomate.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import androidappautomate.utility.ReusableComponents;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LandingPage extends ReusableComponents{
    

    AndroidDriver driver;
    public LandingPage(AndroidDriver driver){

        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="android:id/text1")
    WebElement country;

    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    WebElement setName;

    @AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
    WebElement maleOption;

    @AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
    WebElement femaleOption;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    WebElement clickLetsShopButton;

    @AndroidFindBy(xpath="//android.widget.RadioButton")
    List<WebElement> genders;

   
    
    public void selectCountry(String countryName){

        country.click();
        scrollAction(countryName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
    }

    public void enterName(String name){
        setName.sendKeys(name);
    }

    public void chooseGender(String genderName){

        for(WebElement gender : genders){

            if(gender.getText().equalsIgnoreCase(genderName)){
                if(gender.isSelected()){
                    continue;
                }
                else{
                    gender.click();
                }
            }
        }
        
    }

    public void clickLetsShop(){

        clickLetsShopButton.click();
    }
}
