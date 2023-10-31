package com.anvsystems.utils;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *<p> This class consists of Re-usable helper  / utility method</p>
 * @author- Satyabrata Nayak
 * @version-1.0
 * @See External References
 */

public class CommonUtilities{
    public Properties configData;       //Property itself is a class and it comes from java.util package
    public WebDriver driver;

    /**
     *<p>This method raeds the config and parses the same into key value pairs</p>
     * */
    public void readConfig(){

        try {
            FileInputStream fis=new FileInputStream(new File("src/main/resources/config.properties"));
            configData=new Properties();
            configData.load(fis);
            System.out.println(configData.getProperty("browser.name"));

        } catch (IOException e) {
            System.out.println("Unable to read config "+e.getMessage());
        }
    }

    /**
     * <p> Launches a fresh instance of  Browser depending on configuration</p>
     * */

    public void launchBrowser()
    {
        if (configData.getProperty("browser.name").equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",configData.getProperty("browser.executable"));
            driver=new ChromeDriver();
            driver.manage().window().maximize();
        }
        else{
            //IMPLEMENT FOR OTHER BROWSERS
        }
    }

    /**
     * <p> Closes Current browser instance</p>*/
    public void closeBrowser()
    {
        driver.quit();
    }

    public static void main(String[] args) {
        //new CommonUtilities().readConfig();
        //or
        CommonUtilities comm=new CommonUtilities();
        comm.readConfig();
        comm.launchBrowser();
        comm.closeBrowser();
    }
}
