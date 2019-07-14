package Workflows;

import Extensions.click;
import Extensions.update;
import Utilities.CommonOps;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class mobile_mortgage extends CommonOps
{
 public static void calculate (String amount,String term,String rate) throws IOException, SAXException, ParserConfigurationException
 {
     update.text(mortgageMain.amount,amount);
     update.text(mortgageMain.term,term);
     update.text(mortgageMain.rate,rate);
     click.Go(mortgageMain.calculate);

 }
}
