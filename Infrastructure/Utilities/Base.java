/* This package contains general variables and functions that will be used across all the projects
   e.x takeScreenShot(), readFromXMLConfig(), Webdriver variable and more...
 */
package Utilities;

import PageObjects_Wikipedia.mainPage;
import PageObjects_Wikipedia.resultPage;
import org.openqa.selenium.WebDriver;

/*
This class contain general variables that will be used across all the project
 */
public class Base
{
    protected static WebDriver driver;
    protected static mainPage WipediaMain;
    protected static resultPage WipediaResults;
}
