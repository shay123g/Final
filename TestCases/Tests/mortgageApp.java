package Tests;

import Extensions.verify;
import Utilities.CommonOps;
import Workflows.mobile_mortgage;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class mortgageApp extends CommonOps
{
    @Test
    public void Test01_verifyRepayment() throws IOException, SAXException, ParserConfigurationException
        {
            mobile_mortgage.calculate("1000","3","4");
            verify.textInElement(mortgageMain.repayment,"£30.03");
         }
}
