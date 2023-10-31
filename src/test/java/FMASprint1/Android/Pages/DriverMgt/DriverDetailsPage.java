package FMASprint1.Android.Pages.DriverMgt;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DriverDetailsPage extends PageBase {
    public DriverDetailsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(accessibility = "Region\n" +
            "Lagos")
    WebElement driversRegion;
    @AndroidFindBy(accessibility = "Edit Driver")
    WebElement editDriverButton;
    @AndroidFindBy(accessibility = "Next")
    WebElement nextButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Driver Status *\"]/android.view.View[2]")
    WebElement driversStatus;
    @AndroidFindBy(accessibility = "Suspended")
    WebElement suspendDriver;
    @AndroidFindBy(className = "android.widget.ScrollView")
    WebElement addRouteScrollEl;

    public WebElement returnDriversRegion(){
        return  driversRegion;
    }
    public void clickEditDriverButton(){
        click(editDriverButton);
    }
    public void clickNextButton(){
        click(nextButton);
    }

    public void clickDriversStatus(){
        click(driversStatus);
    }
    public WebElement returnSuspendDriver(){
        return  suspendDriver;
    }
    public void clickSuspendDriver(){
        click(suspendDriver);
    }

    public WebElement returnScrollableElement(){return  addRouteScrollEl;}


}
