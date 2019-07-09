package Extensions;

import Utilities.CommonOps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.fail;

public class update extends CommonOps
{
    public static void text(WebElement elem,String value)
    {

        try {
            elem.sendKeys(value);
            System.out.println( "textfield updated ");
        }
        catch (Exception e)
        {
            System.out.println("failed to update textfield, see details"+e.getMessage());
            fail("failed to update textfield");
        }
    }

    public static void dropDownText(WebElement elem,String value)
    {

        try {
            Select myValue=new Select(elem);
            myValue.selectByVisibleText(value);
            System.out.println( "text dropdown  updated ");
        }
        catch (Exception e)
        {
            System.out.println("failed to update drop down, see details"+e.getMessage());
            fail("failed to update drop down");
        }
    }
}
