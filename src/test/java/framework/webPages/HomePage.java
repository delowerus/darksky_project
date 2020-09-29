package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage{

    private By darkSkyApiLink = By.xpath("//a[contains(text(),'Dark Sky API')]");
    private By currentTemp = By.xpath("//span[@class='summary swap']");
    private By timelineTemps = By.xpath("//div[@id='timeline']//div[@class='temps']/span/span");

    public void clickOnDarkSkyApiLink(){
        clickOn(darkSkyApiLink);
    }
    public int getCurrentTemperature(){
        String text = getTextFromElement(currentTemp);
        String temp = text.substring(0,2); //"68"

        return Integer.parseInt(temp);
    }
    public int[] getTimelineTemps(){
        List<WebElement> webElementList = getWebElements(timelineTemps);
        int[] temps = new int[webElementList.size()];

        int i = 0;
        for(WebElement element:webElementList){
            int temp = Integer.parseInt(getTextFromElement(element).substring(0, 2));
            temps[i] = temp;
            i++;
        }

        return temps;
    }

    public int getMaxTimelineTemp(int[] timelineTemps){
        int max = timelineTemps[0];

        for (int i = 1; i < timelineTemps.length; i++){
            if (timelineTemps[i] > max){
                max = timelineTemps[i];
            }
        }
        return max;
    }

    public int getMinTimelineTemp(int[] timelineTemps){
        int min = timelineTemps[0];

        for (int i = 1; i < timelineTemps.length; i++){
            if (timelineTemps[i] < min){
                min = timelineTemps[i];
            }
        }
        return min;
    }

}
