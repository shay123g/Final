package Tests;

import Extensions.verify;
import Utilities.CommonOps;
import Utilities.ManagePages;
import Workflows.Web_Search;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class wikipedia extends CommonOps
{
    @BeforeClass
    public void StartSession() throws IOException, SAXException, ParserConfigurationException {
        InitBrowser(getData("BrowserType"));
        ManagePages.Init();
    }

    @AfterClass
    public void CloseSession()
    {
    driver.quit();
    }

    @Test
    public void Test01_SearchValue()
    {
        Web_Search.Go("Shay Gazit","Español");
        verify.textInElement(WipediaResults.resultField,"Si consideras que este artículo debería existir y dispones de fuentes fiables, puedes crearlo teniendo en cuenta nuestros pilares y, si quieres, usando nuestro asistente.");
    }
}
