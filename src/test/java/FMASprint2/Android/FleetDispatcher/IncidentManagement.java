package FMASprint2.Android.FleetDispatcher;

import BaseClasses.TestBase;
import FMASprint1.Android.LoginToDashboard;
import FMASprint1.Android.Pages.*;
import FMASprint1.Android.Pages.DriverMgt.AddDriverPage;
import FMASprint1.Android.Pages.DriverMgt.DriverManagementPage;
import FMASprint1.Android.Pages.incidentMgt.IncidentManagementPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class IncidentManagement  extends TestBase {

LandingPage landingPage;
DashboardPage dashboardPage;
MyTasksPage myTasksPage;
DriverManagementPage driverManagementPage;
AddDriverPage addDriverPage;
IncidentManagementPage incidentManagement;
LoginToDashboard user;
IncidentManagementPage incidentManagementPage;
private String TEST_CATEGORY="Fleet Dispatcher";


    public void initializer() {
        landingPage = new LandingPage(driver);
        dashboardPage = new DashboardPage(driver);
        myTasksPage = new MyTasksPage(driver);
        driverManagementPage = new DriverManagementPage(driver);
        addDriverPage = new AddDriverPage(driver);
        incidentManagement = new IncidentManagementPage(driver);
        user = new LoginToDashboard();
        user.login();
        landingPage.selectFleetManagement();
        dashboardPage.selectMoreTasks();
        myTasksPage.clickIncidentManagement();
        incidentManagement.clickAddIncidentBtn();
    }

    @Test(priority = 1, description = "Validate that fleet dispatcher responsibilities below shall be limited to their region and location\n" +
            "f. Add Vehicle")
    public  void TC_061_validateFleetDispatcherRoleIsLimitedToTheirRegion_AddVehicle(Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        initializer();
        String  region= testDataProp.getProperty("dispatcherRegion");
        WebElement regionDropDown = IncidentManagementPage.findDropdownByText(region);
        regionDropDown.click();
        validateContentDesc(incidentManagementPage.findByAccessibility(region),region );
    }





}
