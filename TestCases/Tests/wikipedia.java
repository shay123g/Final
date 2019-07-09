package Tests;

import Extensions.verify;
import Utilities.CommonOps;
import Utilities.ManagePages;
import Workflows.Web_Search;
import org.testng.annotations.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class wikipedia extends CommonOps
{
    @BeforeClass
    public void StartSession() throws IOException, SAXException, ParserConfigurationException {
        InitBrowser(getData("BrowserType"));
        ManagePages.Init();
        InstanceReport();

    }
    @BeforeMethod
    public void doBeforeMethod()
    {
        InitReportTest("TestName","TestDescription");
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
    @Test
    public void Test01_SearchValue() throws IOException, SAXException, ParserConfigurationException
    {
        Web_Search.Go("Shay Gazit","Español");
        verify.textInElement(WipediaResults.resultField,"Si consideras que este artículo debería existir y dispones de fuentes fiables, puedes crearlo teniendo en cuenta nuestros pilares y, si quieres, usando nuestro asistente.");
    }
}
