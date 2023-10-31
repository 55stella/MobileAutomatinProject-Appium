package BaseClasses;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofMillis;

public class PageBase {

    public static AppiumDriver driver;
    public static final Duration WAIT = ofMillis(60000);
    public WebDriverWait wait;
    public PageBase(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        driver = appiumDriver;
        wait = new WebDriverWait(driver, WAIT);
    }

    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void refreshedClick(WebElement element) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
        element.click();
    }

    public void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void clickElementWithJavaScript(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void enterText(WebElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }

    public void clearTextField(WebElement element) {
        element.clear();
    }

    // Find element on the UI by text using uiautomator
    public static WebElement findElementByText(String text) {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"" + text + "\")"));
    }
}
