package Tests;

import Extensions.verify;
import Utilities.CommonOps;
import Workflows.Web_Search;
import org.sikuli.script.FindFailed;
import org.testng.annotations.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class wikipedia extends CommonOps
{
    @Test
    public void Test01_SearchValue() throws IOException, SAXException, ParserConfigurationException, FindFailed
    {
        Web_Search.Go("Shay Gazit","Español");
        verify.textInElement(WipediaResults.resultField,"Si consideras que este artículo debería existir y dispones de fuentes fiables, puedes crearlo teniendo en cuenta nuestros pilares y, si quieres, usando nuestro asistente.");
        verify.image("./ImageRepository/WikiLogo.PNG");
    }
}
