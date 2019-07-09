/*\
This package contain aggregated actions to single operations
e.x. in Wikipedia we want to
    1. enter text in textfield
    2.change the search language
    3. click search button
we can aggregate the three actions to one Operation(=Workflow) called "Search"
 */
package Workflows;

import Extensions.click;
import Extensions.update;
import Utilities.CommonOps;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Web_Search extends CommonOps
{
    public static void Go (String searchValue, String Language) throws IOException, SAXException, ParserConfigurationException
    {
        update.text(WipediaMain.searchBox,searchValue);
        update.dropDownText(WipediaMain.selectLanguage,Language);
        click.Go(WipediaMain.searchButton);
    }
}
