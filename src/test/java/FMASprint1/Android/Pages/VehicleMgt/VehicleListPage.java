package FMASprint1.Android.Pages.VehicleMgt;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VehicleListPage extends PageBase {
    public VehicleListPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Assign\"]/../../*")
    public List <WebElement> vehicleList;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Vehicle List\"]/../*)[5]")
    public WebElement addNewBtn;

    /*-----------------Reusable Methods-------*/
    public void selectAddNewBtn() {
        click(addNewBtn);
    }
    public void selectVehicle(int position) {
        click(vehicleList.get(position));
    }
}
