package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.AccountPage;
import framework.webPages.DarkSlyApiPage;
import framework.webPages.HomePage;
import framework.webPages.LoginPage;
import org.testng.Assert;
import util.Util;

public class LoginSD {
    HomePage homePage = new HomePage();
    DarkSlyApiPage darkSlyApiPage = new DarkSlyApiPage();
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();

    @Given("^I am on Dark Sky home page$")
    public void iAmOnDarkSkyHomePage(){
        String expectedUrl = "https://darksky.net/";
        String actualUrl = homePage.getPageUrl();
        Assert.assertTrue(actualUrl.startsWith(expectedUrl));
    }

    @When("^I click on Dark Sky Api link on home page$")
    public void iClickOnDarkSkyApiLinkOnHomePage() {
        homePage.clickOnDarkSkyApiLink();
    }

    @And("^I click on LOG IN link on Dark Sky Api page$")
    public void iClickOnLoginLink() {
        darkSlyApiPage.clickOnLoginLink();
    }

    @And("^I enter (.+) into email text field on login page$")
    public void iEnterEmailAddress(String email) throws InterruptedException {
        Util.syncWait(2000);
        loginPage.enterEmail(email);
    }

    @And("^I enter (.+) into password field on login page$")
    public void iEnterPassword(String password){
        loginPage.enterPassword(password);
    }

    @And("^I click on login button on login page$")
    public void iClickOnLoginButton(){
        loginPage.clickOnLoginButton();
    }

    @Then("^I verify header text$")
    public void iVerifyTextHeader(){
        String expectedHeaderText = "Your Account";
        String actualHeaderText = accountPage.getHeaderText();
        Assert.assertEquals(expectedHeaderText,actualHeaderText);
    }

}
