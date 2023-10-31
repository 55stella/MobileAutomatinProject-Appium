package FMASprint1.Android.Pages.VehicleMgt;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddVehiclePage extends PageBase {
    public AddVehiclePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(className = "android.widget.EditText")
    public List<WebElement>inputFields;

    @AndroidFindBy(className = "android.widget.EditText")
    WebElement dateField;

    @AndroidFindBy(accessibility = "2023")
    public WebElement year2023;

    @AndroidFindBy(accessibility = "2014")
    public WebElement year2014;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Manufacture Year *\"]/*[2]")
    public WebElement manufactureYear;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Transmission Type *\"]/..)/android.view.View/android.view.View[@index='1']")
    public List<WebElement>dropDownField;

    @AndroidFindBy(accessibility = "Next")
    WebElement nextBtn;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Car Park *\"]/android.view.View[2]")
    public WebElement carPark;

    @AndroidFindBy(xpath = "//android.view.View[@index='2']/*/*")
    public List<WebElement>dropDownOption;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Vehicle Condition *\"]/..)/android.view.View/android.view.View[@index='1']")
    public List<WebElement>dropDownField_ThirdPage;

    @AndroidFindBy(xpath = "//android.widget.Button[1]")
    WebElement editDate;

    @AndroidFindBy(accessibility = "OK")
    WebElement okBtn;

    @AndroidFindBy(xpath = "//android.view.View[@hint='Purchase Date *\nSelect Date']")
    WebElement purchaseDate;

    @AndroidFindBy(xpath = "//android.view.View[@hint='Delivery Date *\nSelect Date']")
    public WebElement deliveryDate;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Barcode Number *\nBarcode Number']")
    WebElement barCodeNumber;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Barcode Number *']")
    public WebElement barCodeNumberFilled;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Tyre Size *\nTyre Size']")
    WebElement tyreSize;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Tyre Size *']")
    public WebElement tyreSizeFilled;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Battery Size *\nBattery Size']")
    WebElement batterySize;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Battery Size *']")
    public WebElement batterySizeFilled;

    @AndroidFindBy(accessibility = "Confirm")
    private WebElement confirmBtn;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Add Vehicle\"]//../*[1]")
    WebElement backToVehicleListPage;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Select Vehicle Region\"]//../*[1]")
    WebElement closeRegionDropDown;

    @AndroidFindBy(accessibility = "Vehicle or boat record was successfully added")
    public WebElement successMsg;

    /*---------------Reusable Method----------------*/
        /*--------Enters text in the test field on 1/4 page of add vehicle-----*/
    public void enterVehicleMake(String vehicleMake) {
        click(inputFields.get(0));
        enterText(inputFields.get(0), vehicleMake);
    }
    public void enterVehicleModel(String vehicleModel) {
        click(inputFields.get(1));
        enterText(inputFields.get(1), vehicleModel);
    }
    public void enterVehicleColor(String vehicleColor) {
        click(inputFields.get(2));
        enterText(inputFields.get(2), vehicleColor);
    }
    public void enterVehicleRegistration(String vehicleRegistration) {
        click(inputFields.get(3));
        enterText(inputFields.get(3), vehicleRegistration);
    }
    public void enterVehicleEngineNumber(String engineNumber) {
        click(inputFields.get(4));
        enterText(inputFields.get(4), engineNumber);
    }
    public void enterVehicleChassisNumber(String chassisNumber) {
        click(inputFields.get(5));
        //supposed to be 5
        //5-1
        enterText(inputFields.get(5), chassisNumber);
    }
    public void enterVehicleCapacity(String capacity) {
        click(inputFields.get(6));
        //5
        // supposed to be 6
        //4
        enterText(inputFields.get(6), capacity);
    }
    public void selectYear2014() {
        click(year2014);
    }
    public void selectManufactureYear() {
        click(manufactureYear);
    }
    public void clickNextBtn() {
        click(nextBtn);
    }

    /*---------Click on dropdowns and select an option after dropdown opens up on 2/4 page of add vehicle---------*/
    public void setTransmissionType(int position) {
        click(dropDownField.get(0));
        refreshedClick(dropDownOption.get(position));
    }
    public void setFuelType(int position) {
        click(dropDownField.get(1));
        refreshedClick(dropDownOption.get(position));
    }
    public void setVehicleCategory() {
        click(dropDownField.get(2));
        refreshedClick(dropDownOption.get(2));
    }
    public void setVehicleRegion() {
        click(dropDownField.get(3));
        refreshedClick(dropDownOption.get(4));
    }
    public void clickDropDownField(){
        click(dropDownField.get(3));
    }
    public void setVehicleState() {
        click(dropDownField.get(4));
        refreshedClick(dropDownOption.get(0));
    }
    public void setVehicleLocation() {
        click(dropDownField.get(5));
        refreshedClick(dropDownOption.get(1));
    }
    public void setDriverName() {
        click(dropDownField.get(6));
        refreshedClick((dropDownOption.get(4)));
    }


    public void setCarPark() {
        click(carPark);
        refreshedClick(dropDownOption.get(4));
    }

    /*---------Click on dropdowns  and select an option after dropdown opens up on 3/4 page of add vehicle---------*/
    public void setOwnership() {
        click(dropDownField_ThirdPage.get(0));
        refreshedClick(dropDownOption.get(3));
    }
    public void setAllocationStatus(int position) {
        click(dropDownField_ThirdPage.get(1));
        refreshedClick(dropDownOption.get(position));
    }
    public void setVehicleStatus() {
        click(dropDownField_ThirdPage.get(2));
        refreshedClick(dropDownOption.get(0));
    }
    public void setVehicleCondition(int position) {
        click(dropDownField_ThirdPage.get((3)));
        refreshedClick(dropDownOption.get(position));
    }
    public void setConditionStatus() {
        click(dropDownField_ThirdPage.get(4));
        refreshedClick(dropDownOption.get(0));
    }
    public void setConditionDetail(String details) {
        click(inputFields.get(0));
        enterText(inputFields.get(0), details);
    }

    /*---------Click on dropdowns  and select an option after dropdown opens up on 4/4 page of add vehicle---------*/
    public void enterFuelCardName(String cardName) {
        click(inputFields.get(0));
        enterText(inputFields.get(0), cardName);
    }
    public void enterFuelCardNumber(String cardNumber) {
        click(inputFields.get(1));
        enterText(inputFields.get(1), cardNumber);
    }
    public void enterFuelBudget(String budget) {
        click(inputFields.get(2));
        enterText(inputFields.get(2), budget);
    }
    public void enterMaintenanceBudget(String budget) {
        click(inputFields.get(3));
        enterText(inputFields.get(3), budget);
    }
    public void enterOrderNumber(String orderNumber) {
        click(inputFields.get(4));
        enterText(inputFields.get(4), orderNumber);
    }
    public void enterPurchaseFrom(String from) {
        click(inputFields.get(5));
        enterText(inputFields.get(5), from);
    }
    public void enterPurchaseAmount(String amount) {
        click(inputFields.get(6));
        enterText(inputFields.get(6), amount);
    }
    public void selectPurchaseDate(String date) {
        click(purchaseDate);
        click(editDate);
        click(dateField);
        clearTextField(dateField);
        enterText(dateField, date);
        clickOkBtn();
    }
    public void clickOkBtn() {
        click(okBtn);
    }
    public void selectDeliveryDate(String date) {
        click(deliveryDate);
        click(editDate);
        click(dateField);
        clearTextField(dateField);
        enterText(dateField, date);
        clickOkBtn();
    }
    public void enterBarcodeNumber(String barcodeNumber) {
        click(barCodeNumber);
        enterText(barCodeNumber, barcodeNumber);
    }
    public void enterTyreSize(String size) {
        click(tyreSize);
        enterText(tyreSize, size);
    }
    public void enterBatterySize(String size) {
        click(batterySize);
        enterText(batterySize, size);
    }

    public void backToVehicleListPage(){
        click(backToVehicleListPage);
    }
    public void clickConfirmBtn() {
        click(confirmBtn);
    }

    public void clickCloseVehicleRegionDropDown(){
        click(closeRegionDropDown);;
    }
}
