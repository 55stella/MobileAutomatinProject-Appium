package FMASprint1.Android.Pages.DriverMgt;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DriverManagementPage extends PageBase {
    public DriverManagementPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Add Driver\"]")
    public WebElement addDriver;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Driver List\"]")
    WebElement driverList;

    public void clickAddDriver() {
        click(addDriver);
    }

    public void clickDriversList(){
        click(driverList);
    }


}
