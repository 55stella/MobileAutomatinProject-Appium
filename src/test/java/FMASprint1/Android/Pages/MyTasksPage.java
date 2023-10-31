package FMASprint1.Android.Pages;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyTasksPage extends PageBase {
    public MyTasksPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(accessibility = "Vehicle & Boat Management")
    WebElement vehicleAndBoatManagement;

    @AndroidFindBy(accessibility = "Fueling Management")
    public WebElement fuelingManagement;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Fueling Management']/../*")
    public List<WebElement> adminTasks;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Driver Management\"]")
    public WebElement driverManagement;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Incident Management\"]")
    public WebElement incidentManagement;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Car Park-Jetty\"]")
     public WebElement carparkjetty;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Route Management\"]")
    WebElement routeManagement;
    @AndroidFindBy(accessibility = "Location Management")
    WebElement locationManagement;


    public void clickDriverManagement() {
        click(driverManagement);
    }

    public void clickIncidentManagement() {
        click(incidentManagement);
    }

    /*-----------------Reusable Methods-----------------*/
    public void selectVehicleBoatManagement() {
        click(vehicleAndBoatManagement);
    }

    public void clickCarparkOrJetty(){
        click(carparkjetty);
    }

    public void clickLocationManagement(){
        click(locationManagement);
    }

    public  void clickRouteManagement(){click(routeManagement);}
}
