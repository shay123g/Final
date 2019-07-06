package Utilities;

import PageObjects_Wikipedia.mainPage;
import PageObjects_Wikipedia.resultPage;
import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base
{
    public static void Init()
    {
        WipediaMain= PageFactory.initElements(driver, mainPage.class);
        WipediaResults= PageFactory.initElements(driver, resultPage.class);
    }

}
