package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UnitedAirlinesConformationPage extends UnitedAirlinesBasePage{

    public UnitedAirlinesConformationPage(){
        super();
    }

    @FindBy(css = "div[class*='Left--3']>div")
    public WebElement conformationDate;

}
