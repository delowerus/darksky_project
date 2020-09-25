package framework.webPages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By emailTextField = By.xpath("//input[@id='email']");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[contains(text(),'Log in')]");

    public void enterEmail(String email){
        setValue(emailTextField,email);
    }

    public void enterPassword(String password){
        setValue(passwordField,password);
    }

    public void clickOnLoginButton(){
        clickOn(loginButton);
    }
}
