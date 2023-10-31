package FMASprint2.Android.Tests.UserManagement.Admin;

import BaseClasses.TestBase;
import FMASprint1.Android.LoginToDashboard;
import FMASprint1.Android.Pages.*;
import FMASprint1.Android.Pages.DriverMgt.*;
import FMASprint1.Android.Tests.DriversManagement.DriverCreationTest;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class DriverManagement  extends TestBase {
    private  static String TEST_CATEGORY ="Admin";
    private String[] regions = {"Kano", "Abuja", "Ibadan", "Port Harcourt","Lagos"};

    LoginToDashboard loginToDashboard;
    DashboardPage dashboardPage;
    LandingPage landingPage;
    MyTasksPage myTasksPage;
    DriverCreationTest driverCreationTest;
    DriverManagementPage  driverManagementPage;
    DriversListPage driversListPage;
    AddDriverPage addDriverPage;
//    DriverDetailsPage driverDetailsPage;
    DriverDetailsPage driverDetailsPage;
    EditDriverPage editDriverPage;

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
        editDriverPage = new EditDriverPage(driver);
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
    @Test(priority = 1, description = " Validate that Super Admin/Admin responsibilities below shall be to all regions and locations\n" +
            "a. Add driver"
            )
    public  void TC_013_validateFleetDispatcherRoleIsLimitedToTheirRegion_AddDriver(Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        initializer();
        addDriverInfo();
        DynamicWait(addDriverPage.getscrollElement(), 20);
        scrollGesture(addDriverPage.getscrollElement(), "up", 30, 0.4);
        addDriverPage.clickRegionDropDown();
        boolean condition =true;
        if(regions.length ==addDriverPage.returnAllRegions().size()){
            while(condition){
                for(int i =0; i<addDriverPage.returnAllRegions().size(); i++){
                    validateContentDesc(addDriverPage.returnAllRegions().get(i),regions[i]);
                    if(i ==addDriverPage.returnAllRegions().size() - 1){// end the While loop when you get to the Last index
                        condition = false;
                        break;
                    }
                }
            }
        }else{
            System.out.println("Index does not Match");
        }
    }

    @Test(priority = 2, description = " Validate that Super Admin/Admin responsibilities below shall be to all regions and locations\n" +
            "c. View Driver"
    )
    public  void TC_015_validateFleetDispatcherRoleIsLimitedToTheirRegion_AddDriver(Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        addDriverPage.clickCloseRegionDropDown();
        addDriverPage.clickBackArrow();
        driverManagementPage.clickDriversList();
        driversListPage.clickOnDriverDetails();
        scrollGesture(driverDetailsPage.returnScrollableElement(), "up", 100, 0.9);
        validateContentDesc(driverDetailsPage.returnDriversRegion(), testDataProp.getProperty("dispatcherRegion"));
    }
    @Test(priority = 3, description = " Validate that Super Admin/Admin responsibilities below shall be to all regions and locations\n" +
            "b. Edit Driver"
    )
    public  void TC_014_validateFleetDispatcherRoleIsLimitedToTheirRegion_AddDriver(Method method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);;
        sleep(10);
        driverDetailsPage.clickEditDriverButton();
        driverDetailsPage.clickNextButton();
        scrollGesture(editDriverPage.returnScrollElement(), "up", 50, 0.5);
        addDriverPage.clickRegionDropDown();
        boolean condition =true;
        if(regions.length ==addDriverPage.returnAllRegions().size()){
            while(condition){
                for(int i =0; i<addDriverPage.returnAllRegions().size(); i++){
                    validateContentDesc(addDriverPage.returnAllRegions().get(i),regions[i]);
                    if(i ==addDriverPage.returnAllRegions().size() - 1){
                        condition = false;
                        break;
                    }
                }
            }
        }else{
            System.out.println("Index does not Match");
        }
    }
    @Test(priority = 4, description = "Validate that fleet dispatcher responsibilities below shall be limited to their region and location\n" +
            "d. Suspend Driver")
    public  void TC_016_validateFleetDispatcherRoleIsLimitedToTheirRegion_SuspendDriver(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);;
        addDriverPage.clickCloseRegionDropDown();
        scrollGesture(driversListPage.returnDriverListScrollElement(), "down", 50, 0.9);
        driverDetailsPage.clickDriversStatus();
        validateContentDesc(driverDetailsPage.returnSuspendDriver(), "Suspended");
        driverDetailsPage.clickSuspendDriver();
        scrollGesture(driversListPage.returnDriverListScrollElement(), "up", 50, 0.5);
        addDriverPage.clickRegionDropDown();
        validateContentDesc(addDriverPage.returnRegion(testDataProp.getProperty("dispatcherRegion")),
                testDataProp.getProperty("dispatcherRegion"));
    }
}
