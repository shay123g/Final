package Extensions;

import Utilities.CommonOps;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class verify extends CommonOps
{
    public static void textInElement(WebElement elem,String expectedValue)
    {

            try {
                assertEquals(elem.getText(),expectedValue);
                test.log(LogStatus.PASS,"text found in element");
            }
            catch (Exception e)
            {
                test.log(LogStatus.PASS,"error with finding text. see details "+e.getMessage());
                fail("Error with finding text");
            }
            catch (AssertionError e)
            {
                test.log(LogStatus.PASS,"text not found in element. see details "+e.getMessage());
                fail("text not found in  element");
            }
    }
}
