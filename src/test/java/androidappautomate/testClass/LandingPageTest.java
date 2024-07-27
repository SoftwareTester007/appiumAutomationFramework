package androidappautomate.testClass;
import org.testng.annotations.Test;
import androidappautomate.baseClass.ConfigureAppium;
import androidappautomate.pages.LandingPage;

public class LandingPageTest extends ConfigureAppium{
    
    LandingPage lp ;

    @Test(priority =1)
    public void choose_Country() throws InterruptedException{
        lp = new LandingPage(driver);
        lp.selectCountry(readData.getCountryName());
    }

    @Test(priority =2)
    public void enter_Name(){

       lp = new LandingPage(driver);
        lp.enterName(readData.getName());
    }

    @Test(priority =3)
    public void choose_Gender(){

        lp = new LandingPage(driver);
        lp.chooseGender(readData.getGender());
    }

    @Test(priority = 4)
    public void clickOnShopButton(){
        lp = new LandingPage(driver);
        lp.clickLetsShop();
    }

}
