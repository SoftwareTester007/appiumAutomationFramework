package androidappautomate.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataProperties {
    
    public Properties prop;
    public FileInputStream fis;
    public ReadDataProperties() {

        try{
        fis = new FileInputStream("//Users//indrajitchakraborty//MyAppiumProject//androidappautomateproject//resource//inputData.properties");
        prop = new Properties();
        prop.load(fis);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public  String getAppiumServerRunningOS(){
        String operating_System = prop.getProperty("AppiumScriptRunningOS");
        if(operating_System!=null){
            return operating_System;
        }
        else{
            throw new RuntimeException("Operating System not set in proeprties file, please set first");
        }
    }

    public String getCountryName(){

        String country = prop.getProperty("country_name");
        if(country!= null){
            return country;
        }
        else{
            throw new RuntimeException("Country name not set in properties file, please set first..");
        }
    }

    public  String getName(){
        String name = prop.getProperty("name");
        if(name!= null){
            return name;
        }
        else{
            throw new RuntimeException("Name not set in proeprties file, please set first");
        }
    }

    public  String getGender(){

        String gender = prop.getProperty("gender");
        if(gender!=null){
            return gender;
        }
        else{
            throw new RuntimeException("Gender name not set in properties file, please set first");
        }
    }

    public  String getMac_MainJSPath(){
        String macAppiumJSPath = prop.getProperty("MacOS_mainJsPath");
        if(macAppiumJSPath!=null){
            return macAppiumJSPath;
        }
        else{
            throw new RuntimeException("Main.js path not set for mac in properties file, please set first");
        }
    }
    
    public  String getWindows_MainJSPath(){

        String windowsJSPath = prop.getProperty("Windows_mainJsPath");
        if(windowsJSPath!=null){
            return windowsJSPath;
        }
        else{
            throw new RuntimeException("Main.js path not set for windows in properties file, please set first");
        }
    }

    public String getAppPath(){
        String app_Path = prop.getProperty("appPath");
        if(app_Path!=null){
            return app_Path;
        }
        else{
            throw new RuntimeException("App path not set in properties file, please set first");
        }
    }
}
