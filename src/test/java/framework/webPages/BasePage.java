package framework.webPages;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import stepdefinition.SharedSD;

import java.time.Duration;
import java.util.List;

public class BasePage {
    public static WebElement webAction(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .withMessage(
                        "Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown"
                );

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {

                return driver.findElement(locator);
            }
        });

        return element;
    }

    public static List<WebElement> webActions(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .withMessage(
                        "Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

        List<WebElement> elements = wait.until(new Function<WebDriver, List<WebElement>>() {
            public List<WebElement> apply(WebDriver driver) {
                return driver.findElements(locator);
            }
        });
        return elements;
    }

    public void clickOn(By locator){
        SharedSD.getDriver().findElement(locator).click();
    }

    public void setValue(By locator, String value) {
        webAction(locator).sendKeys(value);
    }

    public String getTextFromElement(By locator) {
        return webAction(locator).getText();
    }

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    public boolean isElementDisplayed(By locator) {
        return webAction(locator).isDisplayed();
    }

    public boolean isElementSelected(By locator) {
        return webAction(locator).isSelected();
    }

    public String getPageUrl() {
        return SharedSD.getDriver().getCurrentUrl();
    }

    public String getPageTitle(){return SharedSD.getDriver().getTitle();}


}


