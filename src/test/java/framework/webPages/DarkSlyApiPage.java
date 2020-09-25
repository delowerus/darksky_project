package framework.webPages;

import org.openqa.selenium.By;

public class DarkSlyApiPage extends BasePage{

    private By loginLink = By.xpath("//a[@class='button']");

    public void clickOnLoginLink(){
        clickOn(loginLink);
    }
}
