/* This package contains general variables and functions that will be used across all the projects
   e.x takeScreenShot(), readFromXMLConfig(), Webdriver variable and more...
 */
package Utilities;

import PageObjects_Wikipedia.mainPage;
import PageObjects_Wikipedia.resultPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
This class contain general variables that will be used across all the project
 */
public class Base
{
    protected static WebDriver driver;
    public static Screen screen;

    protected static mainPage WipediaMain;
    protected static resultPage WipediaResults;

    public static ExtentReports extent;
    public static ExtentTest test;

    public static String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());


}
