package FMASprint2.Android.Tests.UserManagement.FleetDispatcher;

import BaseClasses.TestBase;
import FMASprint1.Android.LoginToDashboard;
import FMASprint1.Android.Pages.DashboardPage;
import FMASprint1.Android.Pages.DriverMgt.AddDriverPage;
import FMASprint1.Android.Pages.DriverMgt.DriversListPage;
import FMASprint1.Android.Pages.LandingPage;
import FMASprint1.Android.Pages.MyTasksPage;
import FMASprint1.Android.Pages.VehicleMgt.AddVehiclePage;
import FMASprint1.Android.Pages.VehicleMgt.EditVehiclePage;
import FMASprint1.Android.Pages.VehicleMgt.VehicleAndBoatManagementPage;
import FMASprint1.Android.Pages.VehicleMgt.VehicleListPage;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class VehicleManagement  extends TestBase {
LoginToDashboard loginToDashboard;
DashboardPage dashboardPage;
LandingPage landingPage;
MyTasksPage myTasksPage;
VehicleListPage vehicleListPage;
VehicleAndBoatManagementPage vehicleAndBoatManagementPage;
AddVehiclePage addVehiclePage;
AddDriverPage addDriverPage;

EditVehiclePage editVehiclePage;
private  static String TEST_CATEGORY ="Fleet Dispatcher";
DriversListPage driversListPage;
    public void initializer(){
        loginToDashboard = new LoginToDashboard();
        dashboardPage = new DashboardPage(driver);
        landingPage = new LandingPage(driver);
        myTasksPage = new MyTasksPage(driver);
        addDriverPage = new AddDriverPage(driver);
        vehicleAndBoatManagementPage = new VehicleAndBoatManagementPage(driver);
        vehicleListPage = new VehicleListPage(driver);
        addVehiclePage = new AddVehiclePage(driver);
        driversListPage = new DriversListPage(driver);
        editVehiclePage = new EditVehiclePage(driver);
        loginToDashboard.login();
        landingPage.selectFleetManagement();
        dashboardPage.selectMoreTasks();
        myTasksPage.selectVehicleBoatManagement();
        vehicleAndBoatManagementPage.selectVehicleList();
        vehicleListPage.selectAddNewBtn();
    }
    public void addVehicleInfo(){
        addVehiclePage.enterVehicleMake(testDataProp.getProperty("vehicleMake"));
        addVehiclePage.enterVehicleModel(testDataProp.getProperty("vehicleModel"));
        addVehiclePage.enterVehicleColor(testDataProp.getProperty("vehicleColor"));
        addVehiclePage.enterVehicleRegistration(testDataProp.getProperty("vehicleRegistration"));
        addVehiclePage.enterVehicleEngineNumber(testDataProp.getProperty("engineNumber"));
        addVehiclePage.enterVehicleChassisNumber(testDataProp.getProperty("chassisNumber"));
        addVehiclePage.enterVehicleCapacity(testDataProp.getProperty("capacity"));
        scrollGesture(driversListPage.returnDriverListScrollElement(), "up", 40, 0.4);
        addVehiclePage.selectManufactureYear();
        flingGesture(addVehiclePage.year2023, "down");
        addVehiclePage.selectYear2014();
    }
    @Test(priority = 1, description = "Validate that fleet dispatcher responsibilities below shall be limited to their region and location\n" +
            "f. Add Vehicle")
    public  void TC_049_validateFleetDispatcherRoleIsLimitedToTheirRegion_AddVehicle(Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        initializer();
        addVehicleInfo();
        addVehiclePage.clickNextBtn();
        addVehiclePage.clickDropDownField();
        validateContentDesc(addDriverPage.returnRegion(testDataProp.getProperty("dispatcherRegion")),
                testDataProp.getProperty("dispatcherRegion"));
        addVehiclePage.clickCloseVehicleRegionDropDown();
        addVehiclePage.backToVehicleListPage();
    }
    @Test(priority = 2, description = "Validate that fleet dispatcher responsibilities below shall be limited to their region and location\n" +
            "h. view Vehicles")
    public  void TC_051_validateFleetDispatcherRoleIsLimitedToTheirRegion_ViewVehicle(Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        vehicleListPage.selectVehicle(1);
//        DynamicWait(driversListPage.returnDriverListScrollElement(), 10);
        sleep(10);
        scrollGesture(driversListPage.returnDriverListScrollElement(), "up", 40, 0.9);
        validateContentDesc(editVehiclePage.returnLagosRegionText(), testDataProp.getProperty("dispatcherRegion"));
    }
    @Test(priority = 3, description = "Validate that fleet dispatcher responsibilities below shall be limited to their region and location\n" +
            "g. Edit Vehicles")
    public  void TC_050_validateFleetDispatcherRoleIsLimitedToTheirRegion_EditVehicle(Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        editVehiclePage.clickEditVehicleButton();
        editVehiclePage.clickNextBtn();
        addVehiclePage.clickDropDownField();
        validateContentDesc(addDriverPage.returnRegion(testDataProp.getProperty("dispatcherRegion")),
                testDataProp.getProperty("dispatcherRegion"));
    }
    @Test(priority = 4, description = "Validate that fleet dispatcher responsibilities below shall be limited to their region and location\n" +
            "i. Disable Vehicles")
    public  void TC_052_validateFleetDispatcherRoleIsLimitedToTheirRegion_DisableVehicle(Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        addVehiclePage.clickCloseVehicleRegionDropDown();
        editVehiclePage.clickNextBtn();
        editVehiclePage.clickVehicleConditionStatus();
        validateContentDesc(editVehiclePage.disableVehicle(), "Inactive");
    }
    @Test(priority = 6, description = "Validate that fleet dispatcher responsibilities below shall be limited to their region and location\n" +
            "e. Assign driver to vehicle")
    public  void TC_48_validateFleetDispatcherRoleIsLimitedToTheirRegion_AllocateVehicle(Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        editVehiclePage.closeConditionStatusDropDown();
        editVehiclePage.clickPreviousButton();
        editVehiclePage.setEditVehicleRegion();
        editVehiclePage.setEditVehicleState();
        editVehiclePage.setEditVehicleLocation();
//        DynamicWait(driversListPage.returnDriverListScrollElement(), 10);
        sleep(10);
        scrollGesture(driversListPage.returnDriverListScrollElement(), "up", 40, 0.2);
        editVehiclePage.setEditDriversNAme();
        editVehiclePage.clickEditVehicleRegionDropDown();
        validateContentDesc(addDriverPage.returnRegion(testDataProp.getProperty("dispatcherRegion")),
                testDataProp.getProperty("dispatcherRegion"));

    }
}
