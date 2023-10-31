package FMASprint1.Android.Pages;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingPage extends PageBase {
    public LandingPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(accessibility = "Fleet Management")
    WebElement fleetManagement;
    @AndroidFindBy(accessibility = "Pay Per Kilometer")
    WebElement payPerKilometer;
    @AndroidFindBy(accessibility = "Business Journey")
    WebElement businessJourney;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Fleet Management']/../*)[4]")
    WebElement uber;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Fleet Management']/../*")
    public List <WebElement> services;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='FAQ']/../*")
    public
    List<WebElement> footer;
    @AndroidFindBy(accessibility = "Select any of the applications to navigate")
    WebElement pageTitle;

    public void selectFleetManagement() {
        click(fleetManagement);
    }
}
