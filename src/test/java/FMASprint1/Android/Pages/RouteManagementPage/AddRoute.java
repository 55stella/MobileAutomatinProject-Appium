package FMASprint1.Android.Pages.RouteManagementPage;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddRoute  extends PageBase {
    public AddRoute(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @FindBy(xpath = "//android.view.View[@content-desc=\"Route List\"]//../*[5]")
    WebElement addRouteButton;
    @FindBy(xpath = "//android.view.View[@content-desc=\"Type *\"]/android.view.View[2]")
    WebElement routeTypeDropDown;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Region *\"]/android.view.View[2]")
    WebElement regionDropDown;
    @AndroidFindBy(accessibility = "Boat Route")
    WebElement boatRoute;
    @AndroidFindBy(accessibility = "Vehicle Route")
    WebElement vehicleRoute;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Select Region\"]//../*[1]")
    WebElement closeRegionDropDownButton;
    @AndroidFindBy(className = "android.widget.ScrollView")
    WebElement addRouteScrollEl;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Add Route\"]//../*[1]")
    WebElement backToAllRouteButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Route List\"]//../*[4]/*/*/*")
    List<WebElement> routeList;
    @AndroidFindBy(accessibility = "Region\n" +
            "Lagos")
    WebElement viewRouteRegion;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Bus Route Detail\"]//../*[3]")
    WebElement editRouteButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Status *\"]/android.view.View[2]")
    WebElement routeStatus;
    @AndroidFindBy(accessibility = "Active")
    WebElement activeStatus;
    @AndroidFindBy(accessibility = "Inactive")
    WebElement inactiveStatus;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Select Status\"]//../*[1]")
    WebElement closeStatusDropDown;






    //-----Methods-----
    public void clickaddRouteButton(){click(addRouteButton);}
    public  void clickRouteTypeDropDown(){click(routeTypeDropDown);}
    public void selectBoatRoute(){click(boatRoute);}
    public void selectVehicleRoute(){click(vehicleRoute);}
    public WebElement returnAddRouteScroll(){return  addRouteScrollEl;};
    public void clickRegionDropDown(){click(regionDropDown);}
    public void clickCloseRegionDropDownButton(){click(closeRegionDropDownButton);}
    public  void clickBackButton(){click(backToAllRouteButton);}
    public void clickEditRouteButton(){click(editRouteButton);}
    public void selectActiveStatus(){click(activeStatus);}
    public void selectInactiveStatus(){click(inactiveStatus);}
    public void clickRouteStatus(){click(routeStatus);}
    public void closeStatusDropDown(){click(closeStatusDropDown);}

    public static WebElement findByAccessibility(String accessibility) {
        return driver.findElement(AppiumBy.accessibilityId(accessibility));
    }

    public void selectFromRouteList(){click(routeList.get(0));}



}
