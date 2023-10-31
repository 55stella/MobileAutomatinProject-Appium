package FMASprint1.Android.Tests.VehicleManagement;

import BaseClasses.TestBase;
import FMASprint1.Android.LoginToDashboard;
import FMASprint1.Android.Pages.DashboardPage;
import FMASprint1.Android.Pages.LandingPage;
import FMASprint1.Android.Pages.MyTasksPage;
import FMASprint1.Android.Pages.VehicleMgt.EditVehiclePage;
import FMASprint1.Android.Pages.VehicleMgt.VehicleAndBoatManagementPage;
import FMASprint1.Android.Pages.VehicleMgt.VehicleListPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class EditVehicle extends TestBase {
    LandingPage landingPage;
    DashboardPage dashboardPage;
    MyTasksPage myTasksPage;
    VehicleAndBoatManagementPage vehicleAndBoatManagementPage;
    VehicleListPage vehicleListPage;
    LoginToDashboard user;
    EditVehiclePage editVehiclePage;

    String testCategory = "Edit Vehicle";

    public void initializer() {
        landingPage = new LandingPage(driver);
        dashboardPage = new DashboardPage(driver);
        myTasksPage = new MyTasksPage(driver);
        vehicleListPage = new VehicleListPage(driver);
        user = new LoginToDashboard();
        vehicleAndBoatManagementPage = new VehicleAndBoatManagementPage(driver);
        editVehiclePage = new EditVehiclePage(driver);

        user.login();
    }
    @Test(priority = 1, description = "Validate that an admin should be able to view vehicle Registration Number details about a vehicle")
    public void ValidateAdminCanSeeVehicleRegistrationNumberDetails(Method method) {

        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        initializer();
        landingPage.selectFleetManagement();
        dashboardPage.selectMoreTasks();
        myTasksPage.selectVehicleBoatManagement();
        vehicleAndBoatManagementPage.selectVehicleList();
        vehicleListPage.selectVehicle(2);
        sleep(5);

        WebElement registrationNumber = editVehiclePage.getVehicleDetail("Registration Number");
        validateContentDesc(registrationNumber, "Registration Number");
    }

    @DataProvider(name = "vehicleDetails1")
    public Object[][] vehicleDetails1() {
        return new Object[][] {
                {"Make"},
                {"Model"},
                {"Colour"},
                {"Assigned Car Park"},
                {"Type"},
                {"Engine Number"},
                {"Chassis Number"},
                {"Manufacture Year"},
                {"Transmission"},
                {"Capacity"},
                {"Fuel Type"},
                {"Fuel Card Name"},
                {"Fuel Card No"},
                {"Fuel Budget"},
                {"Purchase Date"},
        };
    }

    @Test(priority = 2, dataProvider = "vehicleDetails1")
    public void validateAdminCanViewVariousVehicleDetails(String vehicleDetail) {
        // Assuming you have appropriate methods for starting the test and performing validations
        startTest(vehicleDetail, "Validate admin can view " + vehicleDetail + "detail", testCategory);

        WebElement detailElement = editVehiclePage.getVehicleDetail(vehicleDetail);
        validateContentDesc(detailElement, vehicleDetail);

        if(vehicleDetail.equals("Purchase Date")) {
            // scroll down to view other details
            ScrollGesture(detailElement, "up", 1);
            ScrollGesture(detailElement, "up", 1);
            ScrollGesture(detailElement, "up", 1);
            ScrollGesture(detailElement, "up", 1);
            ScrollGesture(detailElement, "up", 1);
            ScrollGesture(detailElement, "up", 1);
            ScrollGesture(detailElement, "up", 1);
            ScrollGesture(detailElement, "up", 1);
        }
    }

    @DataProvider(name = "vehicleDetails2")
    public Object[][] vehicleDetails2() {
        return new Object[][] {
                {"Purchase Order No."},
                {"Maintenance Budget"},
                {"Barcode No."},
                {"Purchase Price"},
                {"Purchased From"},
                {"Delivery Date"},
                {"Allocation Status"},
                {"Assigned Driver"},
                {"Assigned Driver's Phone"},
                {"Assigned Driver Date"},
                {"Region Name"},
                {"State Name"},
                {"Location Name"},
                {"Car Park Name"},
                {"Status"},
                {"Condition"},
        };
    }

    @Test(priority = 3, dataProvider = "vehicleDetails2")
    public void validateAdminCanViewVariousVehicleDetails2(String vehicleDetail) {
        // Assuming you have appropriate methods for starting the test and performing validations
        startTest(vehicleDetail, "Validate admin can view " + vehicleDetail + "detail", testCategory);

        WebElement detailElement = editVehiclePage.getVehicleDetail(vehicleDetail);
        validateContentDesc(detailElement, vehicleDetail);

        if(vehicleDetail.equals("Condition")) {
            // Fling up to view other details
            flingGesture(detailElement, "down");
            flingGesture(detailElement, "down");
        }
    }

    @DataProvider(name = "vehicleDetails3")
    public Object[][] vehicleDetails3() {
        return new Object[][] {
                {"Condition Status"},
                {"Condition Detail"},
                {"Ownership"},
                {"Category"},
                {"Last Updated"},
                {"Added Date"},
                {"Tyre Size"},
                {"Battery Size"},
        };
    }

    @Test(priority = 4, dataProvider = "vehicleDetails3")
    public void validateAdminCanViewVariousVehicleDetails3(String vehicleDetail) {
        // Assuming you have appropriate methods for starting the test and performing validations
        startTest(vehicleDetail, "Validate admin can view " + vehicleDetail + "detail", testCategory);

        WebElement detailElement = editVehiclePage.getVehicleDetail(vehicleDetail);
        validateContentDesc(detailElement, vehicleDetail);
    }

    @Test(priority = 5, description = "Validate that system shall be able to verify when last a vehicle was last updated")
    public void ValidateAdminCanSeeLastUpdated(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        String vehicleDetail = "Last Updated";

        WebElement detailElement = editVehiclePage.getVehicleDetail(vehicleDetail);
        validateContentDesc(detailElement, vehicleDetail);
    }

    @Test(priority = 6, description = "Validate that Admin shall be able to edit vehicles details")
    public void ValidateAdminCanEditVehicleDetails(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        editVehiclePage.clickEditVehicleButton();
        validateContentDesc(editVehiclePage.editVehicleSubTitle, "Edit Vehicle details below");
        sleep(2);
        editVehiclePage.editVehicleTextFields(0, "Toyota");
        validateText(editVehiclePage.getVehicleTextField(0), "Toyota");
    }

    @Test(priority = 7, description = "Validate that edited fields shall be updated successfully")
    public void ValidateAdminCanUpdateEditedVehicleDetails(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

       editVehiclePage.clickNextBtn();
       editVehiclePage.clickNextBtn();
       flingGesture(editVehiclePage.conditionStatus, "down");
       editVehiclePage.selectTempDriverStatus("Assigned");
       editVehiclePage.clickNextBtn();
       editVehiclePage.clickNextBtn();
       editVehiclePage.clickConfirmBtn();
       validateContentDesc(editVehiclePage.successMsg, "Vehicle or boat record was successfully updated");
    }

}
