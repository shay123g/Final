package Utilities;


import com.relevantcodes.extentreports.ExtentReports;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        screen=new Screen();
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
        extent=new ExtentReports(getData("reportfiltepath")+ "Execution_"+ timestamp +"/"+ getData("reportfilename")+".html");
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

    public static String TakeSS() throws IOException, ParserConfigurationException, SAXException
    {
        String filename="Screenshot-"+new SimpleDateFormat(("yyyyMMddHHmmss'.jpg'")).format(new Date());
        String path= getData("reportfiltepath")+ "Execution_"+ timestamp +"/"+filename;
        File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile, new File(path));
        return path;
    }

    @BeforeClass
    public void StartSession() throws IOException, SAXException, ParserConfigurationException {
        InitBrowser(getData("BrowserType"));
        ManagePages.Init();
        InstanceReport();

    }
    @BeforeMethod
    public void doBeforeMethod(Method method)
    {
        InitReportTest(method.getName().split("_")[0],method.getName().split("_")[1]);
    }
    @AfterClass
    public void CloseSession()
    {
        driver.quit();
        FinalizeExtentReport();

    }
    @AfterMethod
    public void doAfterTest()
    {
        FinalizeReportTest();
    }

}
