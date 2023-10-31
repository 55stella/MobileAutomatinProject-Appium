package FMASprint2.Android.Tests.UserManagement.FleetDispatcher;

import BaseClasses.TestBase;
import FMASprint1.Android.LoginToDashboard;
import FMASprint1.Android.Pages.DashboardPage;
import FMASprint1.Android.Pages.LandingPage;
import FMASprint1.Android.Pages.MyTasksPage;
import FMASprint1.Android.Pages.RouteManagementPage.AddRoute;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class RouteManagement  extends TestBase {
    LandingPage landingPage;
    DashboardPage dashboardPage;
    MyTasksPage myTasksPage;
    LoginToDashboard user;
    AddRoute addRoute;

    private String TEST_CATEGORY = "Fleet Dispatcher";
    private String region = testDataProp.getProperty("dispatcherRegion");

    public void initializer() {
        landingPage = new LandingPage(driver);
        dashboardPage = new DashboardPage(driver);
        myTasksPage = new MyTasksPage(driver);
        addRoute = new AddRoute(driver);
        user = new LoginToDashboard();
        user.login();
        landingPage.selectFleetManagement();
        dashboardPage.selectMoreTasks();
        myTasksPage.clickRouteManagement();
    }
    @Test(priority = 1, description = "Validate that fleet dispatcher responsibilities below shall be limited to their region and location\n" +
            "u. Create Bus routes")
    public void TC_064_validateFleetDispatcherRoleIsLimitedToTheirRegion_CreateBusRoute(Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        initializer();
        addRoute.clickaddRouteButton();
        addRoute.clickRouteTypeDropDown();
        addRoute.selectVehicleRoute();
        scrollGesture(addRoute.returnAddRouteScroll(), "up", 100, 0.9);
        addRoute.clickRegionDropDown();
        validateContentDesc(addRoute.findByAccessibility(region), region);
        addRoute.clickCloseRegionDropDownButton();
    }
    @Test(priority = 2, description = "Validate that fleet dispatcher responsibilities below shall be limited to their region and location\n" +
            "v. Create Boat routes")
    public void TC_065_validateFleetDispatcherRoleIsLimitedToTheirRegion_CreateBoatRoute(Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        scrollGesture(addRoute.returnAddRouteScroll(), "down", 100, 0.9);
        addRoute.clickRouteTypeDropDown();
        addRoute.selectBoatRoute();
        scrollGesture(addRoute.returnAddRouteScroll(), "up", 100, 0.9);
        addRoute.clickRegionDropDown();
        validateContentDesc(addRoute.findByAccessibility(region), region);
    }
    @Test(priority = 3, description = "Validate that fleet dispatcher responsibilities below shall be limited to their region and location\n" +
            "w. Edit Bus routes")
    public void TC_066_validateFleetDispatcherRoleIsLimitedToTheirRegion_EditBusRoute(Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        addRoute.clickCloseRegionDropDownButton();
        addRoute.clickBackButton();
        addRoute.selectFromRouteList();
        addRoute.clickEditRouteButton();
        addRoute.clickRouteTypeDropDown();
        addRoute.selectVehicleRoute();
        scrollGesture(addRoute.returnAddRouteScroll(), "up", 100, 0.9);
        addRoute.clickRegionDropDown();
        validateContentDesc(addRoute.findByAccessibility(region), region);
        addRoute.clickCloseRegionDropDownButton();
    }
    @Test(priority = 4, description = "Validate that fleet dispatcher responsibilities below shall be limited to their region and location\n" +
            "x. Edit Boat routes")
    public void TC_067_validateFleetDispatcherRoleIsLimitedToTheirRegion_EditBoatRoute(Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        scrollGesture(addRoute.returnAddRouteScroll(), "down", 100, 0.9);
        addRoute.clickRouteTypeDropDown();
        addRoute.selectBoatRoute();
        scrollGesture(addRoute.returnAddRouteScroll(), "up", 100, 0.9);
        addRoute.clickRegionDropDown();
        validateContentDesc(addRoute.findByAccessibility(region), region);
        addRoute.clickCloseRegionDropDownButton();
    }
    @Test(priority = 5, description = "Validate that fleet dispatcher responsibilities below shall be limited to their region and location\n" +
            "y. Disable Bus routes")
    public void TC_068_validateFleetDispatcherRoleIsLimitedToTheirRegion_DisableBusRoute(Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        scrollGesture(addRoute.returnAddRouteScroll(), "down", 100, 0.9);
        addRoute.clickRouteTypeDropDown();
        addRoute.selectVehicleRoute();
        scrollGesture(addRoute.returnAddRouteScroll(), "up", 100, 0.9);
        addRoute.clickRouteStatus();
        addRoute.selectInactiveStatus();
        addRoute.clickRegionDropDown();
        validateContentDesc(addRoute.findByAccessibility(region), region);
        addRoute.clickCloseRegionDropDownButton();
    }
    @Test(priority = 6, description = "Validate that fleet dispatcher responsibilities below shall be limited to their region and location\n" +
            "z. Disable Boat routes")
    public void TC_069_validateFleetDispatcherRoleIsLimitedToTheirRegion_DisableBoatRoute(Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        scrollGesture(addRoute.returnAddRouteScroll(), "down", 100, 0.9);
        addRoute.clickRouteTypeDropDown();
        addRoute.selectBoatRoute();
        scrollGesture(addRoute.returnAddRouteScroll(), "up", 100, 0.9);
        addRoute.clickRouteStatus();
        addRoute.selectInactiveStatus();
        addRoute.clickRegionDropDown();
        validateContentDesc(addRoute.findByAccessibility(region), region);
        addRoute.clickCloseRegionDropDownButton();
    }
}
