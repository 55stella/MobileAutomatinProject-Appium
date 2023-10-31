package FMASprint1.Android.Tests.VehicleManagement;

import BaseClasses.TestBase;
import FMASprint1.Android.LoginToDashboard;
import FMASprint1.Android.Pages.DashboardPage;
import FMASprint1.Android.Pages.VehicleMgt.AddVehiclePage;
import FMASprint1.Android.Pages.VehicleMgt.VehicleAndBoatManagementPage;
import FMASprint1.Android.Pages.VehicleMgt.VehicleListPage;
import FMASprint1.Android.Pages.LandingPage;
import FMASprint1.Android.Pages.MyTasksPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class AddVehicle extends TestBase {

    LandingPage landingPage;
    DashboardPage dashboardPage;
    MyTasksPage myTasksPage;
    VehicleAndBoatManagementPage vehicleAndBoatManagementPage;
    VehicleListPage vehicleListPage;
    AddVehiclePage addVehiclePage;
    LoginToDashboard user;

    public void initializer() {
        landingPage = new LandingPage(driver);
        dashboardPage = new DashboardPage(driver);
        myTasksPage = new MyTasksPage(driver);
        vehicleListPage = new VehicleListPage(driver);
        addVehiclePage = new AddVehiclePage(driver);
        user = new LoginToDashboard();
        vehicleAndBoatManagementPage = new VehicleAndBoatManagementPage(driver);

        user.login();
        landingPage.selectFleetManagement();
        dashboardPage.selectMoreTasks();
        myTasksPage.selectVehicleBoatManagement();
        vehicleAndBoatManagementPage.selectVehicleList();
    }


    @Test(priority = 1, description = "Validate that admin shall be able to add vehicle with Vehicle Make")
    public void validateAdminCanAddVehicleWithVehicleMaker(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");
        initializer();
        vehicleListPage.selectAddNewBtn();
        addVehiclePage.enterVehicleMake(testDataProp.getProperty("vehicleMake"));
        validateText(addVehiclePage.inputFields.get(0), testDataProp.getProperty("vehicleMake"));
    }
    @Test(priority = 2, description = "Validate that admin shall be able to add vehicle with Vehicle Model")
    public void validateAdminCanAddVehicleWithVehicleModel(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.enterVehicleModel(testDataProp.getProperty("vehicleModel"));
        validateText(addVehiclePage.inputFields.get(1), testDataProp.getProperty("vehicleModel"));
    }
    @Test(priority = 3, description = "Validate that admin shall be able to add vehicle with Vehicle Color")
    public void validateAdminCanAddVehicleWithVehicleColor(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");
        addVehiclePage.enterVehicleColor(testDataProp.getProperty("vehicleColor"));
        validateText(addVehiclePage.inputFields.get(2), testDataProp.getProperty("vehicleColor"));
    }
    @Test(priority = 4, description = "Validate that admin shall be able to add vehicle with Vehicle Registration Number")
    public void validateAdminCanAddVehicleWithVehicleRegistrationNumber(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.enterVehicleRegistration(testDataProp.getProperty("vehicleRegistration"));
        validateText(addVehiclePage.inputFields.get(3), testDataProp.getProperty("vehicleRegistration"));
    }
    @Test(priority = 5, description = "Validate that admin shall be able to add vehicle with Vehicle Engine Number")
    public void validateAdminCanAddVehicleWithVehicleEngineNumber(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");
        addVehiclePage.enterVehicleEngineNumber(testDataProp.getProperty("engineNumber"));
        validateText(addVehiclePage.inputFields.get(4), testDataProp.getProperty("engineNumber"));
    }
    @Test(priority = 6, description = "Validate that admin shall be able to add vehicle with Vehicle Chassis Number")
    public void validateAdminCanAddVehicleWithVehicleChassisNumber(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        System.out.println(addVehiclePage.inputFields.size());
        addVehiclePage.enterVehicleChassisNumber(testDataProp.getProperty("chassisNumber"));
        validateText(addVehiclePage.inputFields.get(5), testDataProp.getProperty("chassisNumber"));
    }
    @Test(priority = 7, description = "Validate that admin shall be able to add vehicle with Vehicle Capacity")
    public void validateAdminCanAddVehicleWithVehicleCapacity(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");
        addVehiclePage.enterVehicleCapacity(testDataProp.getProperty("capacity"));
//
        validateText(addVehiclePage.inputFields.get(6), testDataProp.getProperty("capacity"));
    }
    @Test(priority = 8, description = "Validate that admin shall be able to add vehicle with Vehicle Manufacture year")
    public void validateAdminCanAddVehicleWithVehicleManufactureYear(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        flingGesture(addVehiclePage.inputFields.get(4), "down");
        addVehiclePage.selectManufactureYear();
        flingGesture(addVehiclePage.year2023, "down");
        addVehiclePage.selectYear2014();
        validateText(addVehiclePage.manufactureYear, testDataProp.getProperty("manufactureYear"));
    }
    @Test(priority = 9, description = "Validate that admin shall be able to add vehicle with Vehicle Transmission type to be Manual")
    public void validateAdminCanAddVehicleWithVehicleTransmissionTypeManual(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.clickNextBtn();
        addVehiclePage.setTransmissionType(1);
        validateText(addVehiclePage.dropDownField.get(0), testDataProp.getProperty("manualTransmissionType"));
    }
    @Test(priority = 10, description = "Validate that admin shall be able to add vehicle with Vehicle Transmission type to be Automatic")
    public void validateAdminCanAddVehicleWithVehicleTransmissionTypeAutomatic(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.setTransmissionType(0);
        validateText(addVehiclePage.dropDownField.get(0), testDataProp.getProperty("automaticTransmissionType"));
    }
    @Test(priority = 11, description = "Validate that admin shall be able to add vehicle with Vehicle Fuel type of Petrol")
    public void validateAdminCanAddVehicleWithVehicleFuelTypeOfDiesel(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.setFuelType(1);
        validateText(addVehiclePage.dropDownField.get(1), testDataProp.getProperty("fuelTypeDiesel"));
    }
    @Test(priority = 12, description = "Validate that admin shall be able to add vehicle with Vehicle Fuel type of Petrol")
    public void validateAdminCanAddVehicleWithVehicleFuelTypeOfPetrol(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.setFuelType(0);
        validateText(addVehiclePage.dropDownField.get(1), testDataProp.getProperty("fuelTypePetrol"));
    }
    @Test(priority = 13, description = "Validate that admin shall be able to add vehicle with Vehicle category")
    public void validateAdminCanAddVehicleWithVehicleCategory(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.setVehicleCategory();
        validateText(addVehiclePage.dropDownField.get(2), testDataProp.getProperty("vehicleCategory"));
    }
    @Test(priority = 14, description = "Validate that admin shall be able to add vehicle with Vehicle region")
    public void validateAdminCanAddVehicleWithVehicleRegion(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.setVehicleRegion();
        validateText(addVehiclePage.dropDownField.get(3), testDataProp.getProperty("vehicleRegion"));
    }
    @Test(priority = 15, description = "Validate that admin shall be able to add vehicle with Vehicle State")
    public void validateAdminCanAddVehicleWithVehicleState(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.setVehicleState();
        validateText(addVehiclePage.dropDownField.get(4), testDataProp.getProperty("VehicleState"));
    }
    @Test(priority = 16, description = "Validate that admin shall be able to add vehicle with Vehicle location")
    public void validateAdminCanAddVehicleWithVehicleLocation(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.setVehicleLocation();
        validateText(addVehiclePage.dropDownField.get(5), testDataProp.getProperty("vehicleLocation"));
    }
    @Test(priority = 17, description = "Validate that admin shall be able to add vehicle with Drivers name")
    public void validateAdminCanAddVehicleWithDriverName(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.setDriverName();
        validateText(addVehiclePage.dropDownField.get(6), testDataProp.getProperty("driverName"));
    }
    @Test(priority = 18, description = "Validate that admin shall be able to add vehicle with vehicle car park")
    public void validateAdminCanAddVehicleWithCarPark(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        flingGesture(addVehiclePage.dropDownField.get(6), "down");
        addVehiclePage.setCarPark();
        validateText(addVehiclePage.carPark, testDataProp.getProperty("carPark"));
    }
    @Test(priority = 19, description = "Validate that admin shall be able to add vehicle with Vehicle ownership")
    public void validateAdminCanAddVehicleWithVehicleOwnership(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.clickNextBtn();
        addVehiclePage.setOwnership();
        validateText(addVehiclePage.dropDownField_ThirdPage.get(0), testDataProp.getProperty("ownership"));
    }
    @Test(priority = 20, description = "Validate that admin shall be able to add vehicle with allocation status as Allocated")
    public void validateAdminCanAddVehicleWithAllocationStatusAllocated(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.setAllocationStatus(0);
        validateText(addVehiclePage.dropDownField_ThirdPage.get(1), testDataProp.getProperty("allocationStatus-allocated"));
    }
    @Test(priority = 21, description = "Validate that admin shall be able to add vehicle with allocation status as free")
    public void validateAdminCanAddVehicleWithAllocationStatus(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.setAllocationStatus(1);
        validateText(addVehiclePage.dropDownField_ThirdPage.get(1), testDataProp.getProperty("allocationStatus-free"));
    }
    @Test(priority = 22, description = "Validate that admin shall be able to add vehicle with vehicle status")
    public void validateAdminCanAddVehicleWithVehicleStatus(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.setVehicleStatus();
        validateText(addVehiclePage.dropDownField_ThirdPage.get(2), testDataProp.getProperty("vehicleStatus"));
    }
    @Test(priority = 23, description = "Validate that admin shall be able to add vehicle with vehicle status")
    public void validateAdminCanAddVehicleWithVehicleCondition(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.setVehicleCondition(0);
        validateText(addVehiclePage.dropDownField_ThirdPage.get(3), testDataProp.getProperty("vehicleConditionBad"));
        addVehiclePage.setVehicleCondition(2);
        validateText(addVehiclePage.dropDownField_ThirdPage.get(3), testDataProp.getProperty("vehicleConditionUnderRepair"));
        addVehiclePage.setVehicleCondition(3);
        validateText(addVehiclePage.dropDownField_ThirdPage.get(3), testDataProp.getProperty("vehicleConditionStolen"));
        addVehiclePage.setVehicleCondition(4);
        validateText(addVehiclePage.dropDownField_ThirdPage.get(3), testDataProp.getProperty("vehicleConditionWrittenOff"));
        addVehiclePage.setVehicleCondition(1);
        validateText(addVehiclePage.dropDownField_ThirdPage.get(3), testDataProp.getProperty("vehicleConditionGood"));
    }
    @Test(priority = 24, description = "Validate that admin shall be able to add vehicle with vehicle status")
    public void validateAdminCanAddVehicleWithConditionStatus(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.setConditionStatus();
        validateText(addVehiclePage.dropDownField_ThirdPage.get(4), testDataProp.getProperty("conditionStatus"));
    }
    @Test(priority = 25, description = "Validate that admin shall be able to add vehicle with vehicle status")
    public void validateAdminCanAddConditionDetails(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.setConditionDetail(testDataProp.getProperty("conditionDetail"));
        validateText(addVehiclePage.inputFields.get(0), testDataProp.getProperty("conditionDetail"));
    }


    @Test(priority = 26, description = "Validate that admin shall be able to add Fuel card name")
    public void  validateAdminCanAddFuelCardName(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.clickNextBtn();
        addVehiclePage.enterFuelCardName(testDataProp.getProperty("fuelCardName"));
        validateText(addVehiclePage.inputFields.get(0), testDataProp.getProperty("fuelCardName"));
    }
    @Test(priority = 27, description = "Validate that admin shall be able to add Fuel card number")
    public void  validateAdminCanAddFuelCardNumber(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.enterFuelCardNumber(testDataProp.getProperty("fuelCardNumber"));
        validateText(addVehiclePage.inputFields.get(1), testDataProp.getProperty("fuelCardNumber"));
    }
    @Test(priority = 28, description = "Validate that admin shall be able to add Fuel budget")
    public void validateAdminCanAddFuelBudget(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.enterFuelBudget(testDataProp.getProperty("fuelBudget"));
        validateText(addVehiclePage.inputFields.get(2), testDataProp.getProperty("fuelBudget"));
    }
    @Test(priority = 29, description = "Validate that admin shall be able to add Maintenance budget")
    public void validateAdminCanAddMaintenanceBudget(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.enterMaintenanceBudget(testDataProp.getProperty("maintenanceBudget"));
        validateText(addVehiclePage.inputFields.get(3), testDataProp.getProperty("maintenanceBudget"));
    }
    @Test(priority = 30, description = "Validate that admin shall be able to add purchase order number")
    public void validateAdminCanAddPurchaseOrderNumber(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.enterOrderNumber(testDataProp.getProperty("orderNumber"));
        validateText(addVehiclePage.inputFields.get(4), testDataProp.getProperty("orderNumber"));
    }
    @Test(priority = 31, description = "Validate that admin shall be able to add purchase from")
    public void validateAdminCanAddPurchaseFrom(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.enterPurchaseFrom(testDataProp.getProperty("purchasedFrom"));
        validateText(addVehiclePage.inputFields.get(5), testDataProp.getProperty("purchasedFrom"));
    }
    @Test(priority = 32, description = "Validate that admin shall be able to add purchase amount")
    public void validateAdminCanAddPurchaseAmount(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.enterPurchaseAmount(testDataProp.getProperty("purchaseAmount"));
        validateText(addVehiclePage.inputFields.get(6), testDataProp.getProperty("purchaseAmount"));
    }
    @Test(priority = 33, description = "Validate that admin shall be able to add purchase date")
    public void validateAdminCanEnterPurchasedDate(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        flingGesture(addVehiclePage.inputFields.get(6), "down");
        addVehiclePage.selectPurchaseDate(testDataProp.getProperty("purchaseDate"));
//        validateText(addVehiclePage.inputFields.get(6), testDataProp.getProperty("purchaseAmount"));
    }
    @Test(priority = 34, description = "Validate that admin shall be able to add delivery date")
    public void validateAdminCanEnterDeliveryDate(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.selectDeliveryDate(testDataProp.getProperty("deliveryDate"));
//        validateText(addVehiclePage.inputFields.get(6), testDataProp.getProperty("purchaseAmount"));
    }
    @Test(priority = 35, description = "Validate that admin shall be able to add barcode number")
    public void validateAdminCanEnterBarcodeNumber(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        flingGesture(addVehiclePage.inputFields.get(2), "down");
        addVehiclePage.enterBarcodeNumber(testDataProp.getProperty("barcodeNumber"));
        validateText(addVehiclePage.barCodeNumberFilled, testDataProp.getProperty("barcodeNumber"));
    }
    @Test(priority = 36, description = "Validate that admin shall be able to add tyre size")
    public void validateAdminCanEnterTyreSize(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        addVehiclePage.enterTyreSize(testDataProp.getProperty("tyreSize"));
        validateText(addVehiclePage.tyreSizeFilled, testDataProp.getProperty("tyreSize"));
    }
    @Test(priority = 37, description = "Validate that admin shall be able to add barcode number")
    public void validateAdminCanEnterBatterySize(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        flingGesture(addVehiclePage.tyreSizeFilled, "down");
        addVehiclePage.enterBatterySize(testDataProp.getProperty("batterySize"));
        validateText(addVehiclePage.batterySizeFilled, testDataProp.getProperty("batterySize"));
    }

    @Test(priority = 38, description = "Validate that Admin shall see a Successful message upon submitting the required details")
    public void validateAdminCanSeeSuccessfulMessage(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Add-Vehicle");

        String successMsg = testDataProp.getProperty("addVehicleSuccessMsg");

        addVehiclePage.clickNextBtn();
        addVehiclePage.clickConfirmBtn();
        validateContentDesc(addVehiclePage.successMsg, successMsg);
    }
}
