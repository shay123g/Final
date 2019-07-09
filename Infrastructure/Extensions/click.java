/*
 This package contains classes that extend the original actions user can do with the regular seleinum library
 */
package Extensions;

import Utilities.CommonOps;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.testng.Assert.fail;

public class click extends CommonOps
{
    public static void Go(WebElement elem) throws ParserConfigurationException, SAXException, IOException
    {
        try {
            elem.click();
            test.log(LogStatus.PASS,"element clicked");
        }
        catch (Exception e)
        {
            test.log(LogStatus.FAIL,"failed to click on element, see details"+e.getMessage()+ " See screenshot: " +test.addScreenCapture(TakeSS()));
            fail("failed to click on element");
        }
    }
}
