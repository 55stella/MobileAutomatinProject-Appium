package FMASprint2.Android.FleetDispatcher;

import BaseClasses.TestBase;
import FMASprint1.Android.LoginToDashboard;
import FMASprint1.Android.Pages.*;
import FMASprint1.Android.Pages.DriverMgt.AddDriverPage;
import FMASprint1.Android.Pages.DriverMgt.DriverDetailsPage;
import FMASprint1.Android.Pages.DriverMgt.DriverManagementPage;
import FMASprint1.Android.Pages.DriverMgt.DriversListPage;
import FMASprint1.Android.Tests.DriversManagement.DriverCreationTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static utils.extentReports.ExtentTestManager.startTest;

public class DriverManagement extends TestBase {

    DashboardPage dashboardPage;
    ProfilePage profilePage;
    LoginToDashboard loginToDashboard;
    private  static String TEST_CATEGORY ="Fleet Dispatcher";
    LandingPage landingPage;
    MyTasksPage myTasksPage;
    DriverManagementPage driverManagementPage;
    DriverCreationTest driverCreationTest;
    AddDriverPage addDriverPage;
    DriversListPage driversListPage;
//    DriverDetailsPage driverDetailsPage;
    DriverDetailsPage driverDetailsPage;

    public void initializer(){
        loginToDashboard = new LoginToDashboard();
        dashboardPage = new DashboardPage(driver);
        landingPage = new LandingPage(driver);
        myTasksPage = new MyTasksPage(driver);
        driverCreationTest = new DriverCreationTest();
        driverManagementPage = new DriverManagementPage(driver);
        driversListPage = new DriversListPage(driver);
        addDriverPage = new AddDriverPage(driver);
        driverDetailsPage = new DriverDetailsPage(driver);
        loginToDashboard.login();
        landingPage.selectFleetManagement();
        dashboardPage.selectMoreTasks();
    }
    public void addDriverInfo(){
        myTasksPage.clickDriverManagement();
        driverManagementPage.clickAddDriver();
        addDriverPage.enterFirstName();
        addDriverPage.enterMiddleName();
        addDriverPage.enterSurname();
        addDriverPage.enterEmail();
        addDriverPage.enterPhone();
        addDriverPage.enterHomeAddress();
        scrollGesture(addDriverPage.getscrollElement(), "up", 100, 0.4);
        addDriverPage.enterDateOfBirth();
        addDriverPage.enterLicenseNumber();
        addDriverPage.enterDriverRenewalDate();
        addDriverPage.enterDriverDisgnation();
        addDriverPage.enterAnnualGross();
    }
    @Test(priority = 1, description = "Validate that fleet dispatcher responsibilities below shall be limited to their region and location\n" +
            "a. Add driver")
    public  void TC_044_validateFleetDispatcherRoleIsLimitedToTheirRegion_AddDriver(Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        initializer();
        addDriverInfo();
        scrollGesture(addDriverPage.getscrollElement(), "up", 30, 0.4);
        addDriverPage.clickRegionDropDown();
        validateContentDesc(addDriverPage.returnRegion(testDataProp.getProperty("dispatcherRegion")),
                testDataProp.getProperty("dispatcherRegion"));
    }
    @Test(priority = 2, description = "Validate that fleet dispatcher responsibilities below shall be limited to their region and location\n" +
            "b. Edit Driver")
    public  void TC_045_validateFleetDispatcherRoleIsLimitedToTheirRegion_EditDriver(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        addDriverPage.clickCloseRegionDropDown();
        addDriverPage.clickBackArrow();
        driverManagementPage.clickDriversList();
        boolean condition = true;
        while(condition){
            List  <WebElement> driversList = driversListPage.returnDriversList();
            for(int i =0; i< driversList.size(); i++){
                validateContentDesc(driversList.get(i), testDataProp.getProperty("dispatcherRegion"));
            }
            if(driversList.size() > 0){
                condition = false;
            }
            scrollGesture(driversListPage.returnDriverListScrollElement(), "up", 40, 0.4);
        }
    }
    // Change testcase45


    @Test(priority = 3, description = "Validate that fleet dispatcher responsibilities below shall be limited to their region and location\n" +
            "c. View Driver")
    public  void TC_046_validateFleetDispatcherRoleIsLimitedToTheirRegion_ViewDriver(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        DynamicWait(driversListPage.returnBackArrow(), 5);
        driversListPage.clickBackArrow();
        driverManagementPage.clickDriversList();
        driversListPage.clickOnDriverDetails();
        scrollGesture(driversListPage.returnDriverListScrollElement(), "up", 70, 0.9);
        validateContentDesc(driverDetailsPage.returnDriversRegion(), testDataProp.getProperty("dispatcherRegion"));
    }
    @Test(priority = 4, description = "Validate that fleet dispatcher responsibilities below shall be limited to their region and location\n" +
            "d. Suspend Driver")
    public  void TC_047_validateFleetDispatcherRoleIsLimitedToTheirRegion_SuspendDriver(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        driverDetailsPage.clickEditDriverButton();
        driverDetailsPage.clickNextButton();
        driverDetailsPage.clickDriversStatus();
        validateContentDesc(driverDetailsPage.returnSuspendDriver(), "Suspended");
        driverDetailsPage.clickSuspendDriver();
        scrollGesture(driversListPage.returnDriverListScrollElement(), "up", 50, 0.5);
        addDriverPage.clickRegionDropDown();
        validateContentDesc(addDriverPage.returnRegion(testDataProp.getProperty("dispatcherRegion")),
                testDataProp.getProperty("dispatcherRegion"));
    }


}
