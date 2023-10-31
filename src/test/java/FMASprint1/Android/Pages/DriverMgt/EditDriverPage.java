package FMASprint1.Android.Pages.DriverMgt;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class EditDriverPage extends PageBase {
    public EditDriverPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    @AndroidFindBy(className = "android.widget.ScrollView")
    WebElement addRouteScrollEl;


    public WebElement returnScrollElement(){return addRouteScrollEl;};

}
