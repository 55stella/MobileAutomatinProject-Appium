package FMASprint1.Android.Pages.VehicleMgt;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class EditVehiclePage extends PageBase {

    public EditVehiclePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Vehicle Detail\"]//../*[3]")
    public WebElement editVehicleButton;

    @AndroidFindBy( accessibility = "Edit Vehicle details below")
    public WebElement editVehicleSubTitle;

    @AndroidFindBy(accessibility = "Next")
    public WebElement nextBtn;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Condition Status *\"]")
    public WebElement conditionStatus;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Select Condition Status\"]//../*[1]")
    WebElement closeConditionStatusDropDown;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Temporal Driver Status *\"]/android.view.View[2]")
    public WebElement temporalDriverStatus;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Vehicle State *\"]/android.view.View[2]"
            )
    WebElement editVehiclesState;
    @AndroidFindBy(xpath ="//android.view.View[@content-desc=\"Vehicle Region *\"]/android.view.View[2]" )
    WebElement editVehicleRegion;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Vehicle Location *\"]/android.view.View[2]")
    WebElement editVehicleLocation;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Driver Name *\"]/android.view.View[2]")
    WebElement editDriversNAme;

    @AndroidFindBy(accessibility = "Lagos")
    WebElement vehicleRegion;
    @AndroidFindBy(accessibility = "MTN Plaza")
    WebElement vehicleLocation;
    @AndroidFindBy(accessibility = "John Oh O0h\n" +
            "08012345600 - Vehicle Driver")
    WebElement driversDetails;
   @AndroidFindBy(accessibility = "Previous")
   WebElement previousButton;

    @AndroidFindBy(accessibility = "Confirm")
    public WebElement confirmBtn;

    @AndroidFindBy(accessibility = "Vehicle or boat record was successfully updated")
    public WebElement successMsg;

    @AndroidFindBy(accessibility = "Region Name\n" +
            "Lagos")
    WebElement lagosRegion;
    @AndroidFindBy(accessibility = "Inactive")
    WebElement disableVehicle;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Condition Status *\"]/android.view.View[2]")
    WebElement editVehicleConditionStatusButton;


    public WebElement getVehicleDetail(String contentDesc){
        return driver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc,\"" + contentDesc + "\")]"));
    }

    public void clickEditVehicleButton(){
        click(editVehicleButton);
    }

    public void editVehicleTextFields(int index, String value){
        WebElement element = driver.findElements(AppiumBy.className("android.widget.EditText")).get(index);
        click(element);
        clearTextField(element);
        enterText(element, value);
    }

    public WebElement getVehicleTextField(int index){
        return driver.findElements(AppiumBy.className("android.widget.EditText")).get(index);
    }

    public static WebElement findByAccessibility(String accessibility) {
        return driver.findElement(AppiumBy.accessibilityId(accessibility));
    }

    public void clickNextBtn(){
        click(nextBtn);
    }

    public  void editVehicleConditionButton(){
        click(editVehicleButton);
    }

    public void selectTempDriverStatus(String status){
        click(temporalDriverStatus);
        click(findByAccessibility(status));
    }

    public void clickConfirmBtn(){
        click(confirmBtn);
    }

    public WebElement returnLagosRegionText(){
        return lagosRegion;
    }

    public  WebElement disableVehicle(){return  disableVehicle;
    }

    public  void clickVehicleConditionStatus(){
        click(editVehicleConditionStatusButton);
    }
    public void clickPreviousButton(){
        click(previousButton);
    }
    public void closeConditionStatusDropDown(){
        click(closeConditionStatusDropDown);
    }

    public void setEditVehicleRegion(){
        click(editVehicleRegion);
        click(vehicleRegion);
    }

    public void clickEditVehicleRegionDropDown(){
        click(editVehicleRegion);
    }
    public void setEditVehicleState(){
        click(editVehiclesState);
        click(vehicleRegion);
    }
    public void setEditVehicleLocation(){
        click(editVehicleLocation);
        click(vehicleLocation);
    }

    public void  setEditDriversNAme(){
        click(editDriversNAme);
        click(driversDetails);
    }

}
