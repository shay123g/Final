package PageObjects_Wikipedia;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class resultPage
{
    @FindBy(how = How.CLASS_NAME, using ="mw-search-createlink")
    public WebElement resultField;
}
