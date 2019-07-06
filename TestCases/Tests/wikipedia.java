package Tests;

import Extensions.verify;
import Utilities.CommonOps;
import Utilities.ManagePages;
import Workflows.Web_Search;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class wikipedia extends CommonOps
{
    @BeforeClass
    public void StartSession()
    {
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        driver=new ChromeDriver();
        ManagePages.Init();
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
