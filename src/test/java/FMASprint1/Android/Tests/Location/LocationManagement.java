package FMASprint1.Android.Tests.Location;

import BaseClasses.TestBase;
import FMASprint1.Android.LoginToDashboard;
import FMASprint1.Android.Pages.*;
import io.appium.java_client.MobileBy;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class LocationManagement extends TestBase {

    PolicyNoticePage policyNoticePage;
    SignInPage signInPage;
    LandingPage landingPage;
    DashboardPage dashboardPage;
    MyTasksPage myTasksPage;
    LoginToDashboard user;
    LocationManagementPage locationManagementPage;

    private  static final String TEST_CATEGORY = "Location Management";





    public void initializer() {
        policyNoticePage = new PolicyNoticePage(driver);
        signInPage = new SignInPage(driver);
        landingPage = new LandingPage(driver);
        dashboardPage = new DashboardPage(driver);
        myTasksPage = new MyTasksPage(driver);
        user = new LoginToDashboard();
        locationManagementPage = new LocationManagementPage(driver);
        user.login();
        landingPage.selectFleetManagement();
        dashboardPage.selectMoreTasks();
        myTasksPage.clickLocationManagement();

    }

     @Test(priority = 1, description = "Validate that admin shall be able to click on Location Module")
     public void ValidateThatAdminCanClickOnLocationModule(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        initializer();
        validateAttribute(locationManagementPage.locationtext, "displayed", true);
}
    @Test(priority = 2, description = "Validate that Admin shall be able to add new location ")
    public void ValidateThatAdminCanAddNewLocation(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        locationManagementPage.clickPlusbutton();
        validateAttribute(locationManagementPage.addLocation, "displayed", true);
    }
    @Test(priority = 3, description = "Validate that Admin shall be able to add new Location Name ")
    public void ValidateThatAdminCanAddLocationName(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        locationManagementPage.clickLocationNameInputField();
        locationManagementPage.sendLocationName();
        validateText(locationManagementPage.enteredLocationName, "TestLocation2");
    }
    @Test(priority = 4, description = "Validate that Admin shall be able to add new Location Region ")
    public void ValidateThatAdminCanAddRegion(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        locationManagementPage.clickLocationRegionDropdown();
        locationManagementPage.selectPhOption();
        validateAttribute(locationManagementPage.porthaCourtOption, "displayed", true);
    }
    @Test(priority = 5, description = "Validate that Admin shall be able to add new State ID ")
    public void ValidateThatAdminCanAddStateId(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        locationManagementPage.openstatedropdownandclickstateoption();
        validateAttribute(locationManagementPage.openStateDropdown, "displayed", true);
    }

    @Test(priority = 6, description = "Validate that Admin shall be abl  Create/Add")
    public void ValidateThatAdminCanCreateLocation(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        locationManagementPage.clickSubmitLocationButton();
        sleep(5);
        validateAttribute(locationManagementPage.locationCreationSuccess, "displayed", true);
    }
    @Test(priority = 7, description = "Validate that Admin shall be able to Update Location")
    public void ValidateThatAdminCanUpdateLocation(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        locationManagementPage.clickOpenLocation();
        locationManagementPage.clickEditbutton();
        locationManagementPage.clickUpdate();
        validateAttribute(locationManagementPage.updateSuccess, "displayed", true);
    }

    @Test(priority = 8, description = "Validate that Admin shall be able to View/Retrieve")
    public void ValidateThatAdminCanViewOrRetreiveLocation(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(6)"));
    }
}
