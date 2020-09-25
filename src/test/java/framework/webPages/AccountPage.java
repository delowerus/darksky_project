package framework.webPages;

import org.openqa.selenium.By;

public class AccountPage extends BasePage {

    private By headerText = By.xpath("//h2[contains(text(),'Your Account')]");

    public String getHeaderText(){
        return getTextFromElement(headerText);
    }
}
