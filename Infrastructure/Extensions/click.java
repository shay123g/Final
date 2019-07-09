/*
 This package contains classes that extend the original actions user can do with the regular seleinum library
 */
package Extensions;

import Utilities.CommonOps;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.fail;

public class click extends CommonOps
{
    public static void Go(WebElement elem)
    {
        try {
            elem.click();
            System.out.println( "element clicked");
        }
        catch (Exception e)
        {
            System.out.println("failed to click on element, see details"+e.getMessage());
            fail("failed to click on element");
        }
    }
}
