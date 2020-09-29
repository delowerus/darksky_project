package stepdefinition;

import cucumber.api.java.en.Then;
import framework.webPages.HomePage;
import org.testng.Assert;

import java.util.Arrays;

public class DarkSkySD {
    HomePage homePage = new HomePage();

    @Then("^I verify current temp is not greater or less then temps from daily timeline$")
    public void iVerifyCurrentTemperature(){
        int currentTemperature = homePage.getCurrentTemperature();
        System.out.println(currentTemperature);

        int[] temps = homePage.getTimelineTemps();
        System.out.println(Arrays.toString(temps));

        int minTimelineTemp = homePage.getMinTimelineTemp(temps);
        System.out.println(minTimelineTemp);

        int maxTimelineTemp = homePage.getMaxTimelineTemp(temps);
        System.out.println(maxTimelineTemp);

        Assert.assertTrue(currentTemperature >= minTimelineTemp);
        Assert.assertTrue(currentTemperature <= maxTimelineTemp);
    }
}
