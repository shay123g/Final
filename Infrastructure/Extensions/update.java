package Extensions;

import Utilities.CommonOps;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.testng.Assert.fail;

public class update extends CommonOps
{
    public static void text(WebElement elem,String value) throws ParserConfigurationException, SAXException, IOException
    {

        try {
            elem.sendKeys(value);
            test.log(LogStatus.PASS,"textfield updated");
        }
        catch (Exception e)
        {
            test.log(LogStatus.PASS,"failed to update textfield"+e.getMessage()+ " See screenshot: " +test.addScreenCapture(TakeSS()));
            fail("failed to update textfield");
        }
    }

    public static void dropDownText(WebElement elem,String value) throws ParserConfigurationException, SAXException, IOException
    {

        try {
            Select myValue=new Select(elem);
            myValue.selectByVisibleText(value);
            test.log(LogStatus.PASS,"text drop down updated");
        }
        catch (Exception e)
        {
            test.log(LogStatus.FAIL,"failed to update dropdown"+e.getMessage()+ " See screenshot: " +test.addScreenCapture(TakeSS()));
            fail("failed to update drop down");
        }
    }
}
