package Extensions;

import Utilities.CommonOps;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class verify extends CommonOps
{
    public static void textInElement(WebElement elem,String expectedValue)
    {

            try {
                assertEquals(elem.getText(),expectedValue);
                System.out.println( "text found in  element ");
            }
            catch (Exception e)
            {
                System.out.println("Error with finding text, see details"+e.getMessage());
                fail("Error with finding text");
            }
            catch (AssertionError e)
            {
                System.out.println("text not found in  element, see details"+e.getMessage());
                fail("text not found in  element");
            }
    }
}
