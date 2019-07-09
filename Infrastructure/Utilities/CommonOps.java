package Utilities;

import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/*
This class contain general functions that will be used across all the project
 */
public class CommonOps extends Base
{
    public static String getData (String nodeName) throws ParserConfigurationException, SAXException, IOException
    {
        File fXmlFile = new File("./ConfigFiles/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public static void InitBrowser(String BrowserType) throws ParserConfigurationException, SAXException, IOException
    {
        switch (BrowserType.toLowerCase())
        {
            case ("chrome"):
            {
                driver= InitChromeDriver();
                break;
            }
            case ("firefox"):
            {
                driver= InitFFDriver();
                break;
            }
        }
        driver.manage().window().maximize();
        driver.get(getData("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver InitChromeDriver() throws IOException, SAXException, ParserConfigurationException
    {
        System.setProperty("webdriver.chrome.driver",getData("chromedriverpath"));
        WebDriver local_driver=new ChromeDriver();
        return local_driver;
    }

    public static WebDriver InitFFDriver() throws IOException, SAXException, ParserConfigurationException
    {
        System.setProperty("webdriver.gecko.driver",getData("firefoxdriverpath"));
        WebDriver local_driver=new FirefoxDriver();
        return local_driver;
    }
    public static void InstanceReport() throws IOException, SAXException, ParserConfigurationException
    {
        extent=new ExtentReports(getData("reportfiltepath")+getData("reportfilename")+".html");
    }
    public static void InitReportTest(String TestName,String TestDescription)
    {
        test=extent.startTest(TestName, TestDescription);
    }
    public static void FinalizeReportTest()
    {
        extent.endTest(test);
    }
    public static void FinalizeExtentReport()
    {
        extent.flush();
        extent.close();
    }
}
