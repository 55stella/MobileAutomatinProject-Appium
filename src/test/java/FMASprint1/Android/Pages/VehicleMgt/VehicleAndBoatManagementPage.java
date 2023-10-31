package FMASprint1.Android.Pages.VehicleMgt;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class VehicleAndBoatManagementPage extends PageBase {
    public VehicleAndBoatManagementPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[2]")
    WebElement addBoatIcon;

    @AndroidFindBy(accessibility = "Add Boat")
    WebElement addBoatTab;

    @AndroidFindBy(accessibility = "Boat List")
    WebElement boatList;
    @AndroidFindBy(accessibility = "Add Vehicle")
    WebElement addVehicle;
    @AndroidFindBy(accessibility = "Vehicle List")
    WebElement vehicleList;

    /*-----------------Reusable Method---------------*/
    public void selectVehicleList() {
        click(vehicleList);
    }

    public void clickAddBoatTab() {
        click(addBoatTab);
    }

    public void selectAddBoat() {
        click(addBoatIcon);
    }

    public void selectBoatList() {
        click(boatList);
    }
}
