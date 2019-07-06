package PageObjects_Wikipedia;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class mainPage
{
     @FindBy (how = How.ID, using ="searchInput")
            public WebElement searchBox;
    @FindBy (how = How.ID, using ="searchLanguage")
    public WebElement selectLanguage;
    @FindBy (how = How.XPATH, using ="//button[@type='submit']")
    public WebElement searchButton;
}
