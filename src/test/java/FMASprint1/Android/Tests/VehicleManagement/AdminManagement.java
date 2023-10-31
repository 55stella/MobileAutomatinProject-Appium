package FMASprint1.Android.Tests.VehicleManagement;

import BaseClasses.TestBase;
import FMASprint1.Android.LoginToDashboard;
import FMASprint1.Android.Pages.DashboardPage;
import FMASprint1.Android.Pages.LandingPage;
import FMASprint1.Android.Pages.MyTasksPage;
import FMASprint1.Android.Pages.VehicleMgt.VehicleAndBoatManagementPage;
import FMASprint1.Android.Pages.VehicleMgt.VehicleListPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

import static utils.extentReports.ExtentTestManager.startTest;

public class AdminManagement extends TestBase {

    LandingPage landingPage;
    DashboardPage dashboardPage;
    MyTasksPage myTasksPage;
    VehicleAndBoatManagementPage vehicleAndBoatManagementPage;
    VehicleListPage vehicleListPage;
    LoginToDashboard user;
    ArrayList<WebElement> adminTasks;

    public void initializer() {
        landingPage = new LandingPage(driver);
        dashboardPage = new DashboardPage(driver);
        myTasksPage = new MyTasksPage(driver);
        vehicleListPage = new VehicleListPage(driver);
        user = new LoginToDashboard();
        vehicleAndBoatManagementPage = new VehicleAndBoatManagementPage(driver);

        user.login();
    }

    @Test(priority = 1, description = "Validate the services on the landing page")
    public void validateServicesOnLandingPage(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Admin-Management");

        initializer();
        for(int i = 0; i < landingPage.services.size(); i += 1) {
            validateAttribute(landingPage.services.get(i), "displayed", true);
            validateAttribute(landingPage.services.get(i), "clickable", true);
        }
    }
    @Test(priority = 2, description = "Validate the menu at the footer of the landing page")
    public void validateFooterMenu(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Admin-Management");

        Assert.assertTrue(landingPage.footer.size() == 4);
        for(int i = 0; i < landingPage.footer.size(); i += 1) {
            validateAttribute(landingPage.footer.get(i), "displayed", true);
            validateAttribute(landingPage.footer.get(i), "clickable", true);
        }
    }
    @Test(priority = 3, description = "Validate More tasks tile is visible and clickable")
    public void validateMoreTabIsDisplayedAndClickable(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Admin-Management");

        landingPage.selectFleetManagement();
        validateAttribute(dashboardPage.moreTasks, "displayed", true);
        validateAttribute(dashboardPage.moreTasks, "clickable", true);
    }
    @Test(priority = 4, description = "Validate that there are 13 admin options/privileges after user selects more tasks")
    public void validateThirteenAdminPrivilegesAreDisplayed(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Admin-Management");

        dashboardPage.selectMoreTasks();
        adminTasks = new ArrayList<>(myTasksPage.adminTasks);          // Gets the list of admin privileges displayed on the screen and saves it in an ArrayList
        flingGesture(myTasksPage.fuelingManagement, "down");   //The content of myTasksPage.adminTasks has changed after scrolling to the end
        for(int i = 0; i < myTasksPage.adminTasks.size(); i++) {       // this loop checks if the privileges currently showing on the page in contained in the list gotten before scrolling, if not, it adds it to the previous list
            if(!adminTasks.contains(myTasksPage.adminTasks.get(i))){
                adminTasks.add(myTasksPage.adminTasks.get(i));
            }
        }
        System.out.println("The number of the admin tasks is: " + adminTasks.size());
        Assert.assertTrue(adminTasks.size() == 13);
    }
    @Test(priority = 5, description = "Validate Admin shall be able to have access to all admin privileges")
    public void validateAdminHasAllAdminPrivileges(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Admin-Management");

        String[]adminTasksContentDesc = testDataProp.getProperty("adminTasks").split(",");
        for(int i = 0; i < adminTasks.size(); i += 1) {
            Assert.assertTrue(adminTasks.get(i).getAttribute("content-desc").equals(adminTasksContentDesc[i]));
        }
    }
    @Test(priority = 6, description = "Validate that initial list and details of all vehicles shall be preloaded into the app")
    public void validateVehiclesDetailsArePreloaded(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Admin-Management");

        flingGesture(myTasksPage.fuelingManagement, "up");
        myTasksPage.selectVehicleBoatManagement();
        vehicleAndBoatManagementPage.selectVehicleList();
        Assert.assertTrue(vehicleListPage.vehicleList.size() > 0);
    }
    @Test(priority = 7, description = "Validate that Admin shall be able to click on the Add vehicle button")
    public void validateAdminCanClickAddVehicleButton(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Admin-Management");

        validateAttribute(vehicleListPage.addNewBtn, "clickable", true);
    }

}
