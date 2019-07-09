package Extensions;

import Utilities.CommonOps;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class verify extends CommonOps
{
    public static void textInElement(WebElement elem,String expectedValue) throws ParserConfigurationException, SAXException, IOException
    {

            try {
                assertEquals(elem.getText(),expectedValue);
                test.log(LogStatus.PASS,"text found in element");
            }
            catch (Exception e)
            {
                test.log(LogStatus.FAIL,"error with finding text. see details "+e.getMessage()+ " See screenshot: " +test.addScreenCapture(TakeSS()));
                fail("Error with finding text");
            }
            catch (AssertionError e)
            {
                test.log(LogStatus.FAIL,"text not found in element. see details "+e.getMessage()+ " See screenshot: " +test.addScreenCapture(TakeSS()));
                fail("text not found in  element");
            }
    }
}
