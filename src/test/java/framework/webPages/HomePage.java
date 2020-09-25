package framework.webPages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    private By darkSkyApiLink = By.xpath("//a[contains(text(),'Dark Sky API')]");


    public void clickOnDarkSkyApiLink(){
        clickOn(darkSkyApiLink);
    }
}
