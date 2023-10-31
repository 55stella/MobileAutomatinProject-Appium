package FMASprint1.Android.Pages;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PolicyNoticePage extends PageBase {
    public PolicyNoticePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(className = "android.widget.CheckBox")
    WebElement checkBox;

    @AndroidFindBy(accessibility = "OKAY")
    public
    WebElement okay;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    public List<WebElement> permissionOkay;


    public void clickCheckBox() {
        click(checkBox);
    }
    public void clickOkay() {
        click(okay);
    }
    public void clickPermissionOkay() {
        click(permissionOkay.get(0));
    }

}
