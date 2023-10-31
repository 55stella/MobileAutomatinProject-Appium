package FMASprint1.Android.Tests.CarPark_Jetty;

import BaseClasses.TestBase;
import FMASprint1.Android.LoginToDashboard;
import FMASprint1.Android.Pages.*;
import FMASprint1.Android.Pages.DriverMgt.AddDriverPage;
import FMASprint1.Android.Pages.DriverMgt.DriverManagementPage;
import FMASprint1.Android.Pages.VehicleMgt.CarPark_JettyPage;
import io.appium.java_client.*;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class CarPark_Jetty extends TestBase {

   PolicyNoticePage policyNoticePage;
   SignInPage signInPage;
   LandingPage landingPage;
   DashboardPage dashboardPage;
   MyTasksPage myTasksPage;
   DriverManagementPage driverManagementPage;
   AddDriverPage addDriverPage;
   LoginToDashboard user;
   CarPark_JettyPage carParkJettyPage;

   AppiumDriver drivers;
private static  final String  TEST_CATEGORY="CarPark/jetty";



    public void initializer() {
        policyNoticePage = new PolicyNoticePage(driver);
        signInPage = new SignInPage(driver);
        landingPage = new LandingPage(driver);
        dashboardPage = new DashboardPage(driver);
        myTasksPage = new MyTasksPage(driver);
        user = new LoginToDashboard();
        carParkJettyPage = new CarPark_JettyPage(driver);
        user.login();
        landingPage.selectFleetManagement();
        dashboardPage.selectMoreTasks();
    }

    @Test(priority = 1, description = "Validate that Admin shall be able to to click on carPark/jetty module")
    public void validateAdminCanClickOnCarParkOrjettyModule(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY );
       initializer();
        validateAttribute(myTasksPage.carparkjetty, "clickable", true);

    }
    @Test(priority = 2, description = "Validate that Admin shall be able select Car Park or Jetty")
    public void validateThattheAdminCanSelectCarParkOrJetty(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        myTasksPage.clickCarparkOrJetty();
        validateAttribute(carParkJettyPage.carParkOrJettyText, "displayed", true);
    }
    @Test(priority = 3, description = "Validate that Admin shall be able to Add new cark park/jetty")
    public void validateThattheAdminCanAddNewCarParkOrJetty(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        myTasksPage.clickCarparkOrJetty();
        carParkJettyPage.clickaddbutton();
        validateAttribute(carParkJettyPage.addcarParkorjetty, "displayed", true);
    }
    @Test(priority = 4, description = "Validate that  the Admin can Add  Name of Car park/jetty")
    public void validateThattheAdminCanAddNameofCarparkJetty(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        if(carParkJettyPage.addnameCarparkjetty.isDisplayed()){
            System.out.println("it is displayed");
        }
        carParkJettyPage.sendCarParkname();
        sleep(2);
        validateText(carParkJettyPage.carparkName, "TestLocation2");;
    }
    @Test(priority = 5, description = "Validate that  the Admin can Add Region")
    public void validateThattheAdminCanAddRegion(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        carParkJettyPage.clickRegionDropdown();
        carParkJettyPage.clickphregionoption();
        validateAttribute(carParkJettyPage.regionName, "displayed", true );
    }
    @Test(priority = 6, description = "Validate that  the Admin can  add State")
    public void validateThattheAdminCanAddState(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);;
        carParkJettyPage.clickstatedropdown();
        carParkJettyPage.clickriversoption();
        validateAttribute(carParkJettyPage.stateName, "displayed", true);
    }

    @Test(priority = 7, description = "Validate that  the Admin can  add  Location Name")
    public void validateThattheAdminCanAddLocationName(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        carParkJettyPage.clickloactionNamedropdown();
        carParkJettyPage.clickonetwooption();
        validateAttribute(carParkJettyPage.locationName, "displayed", true);
    }
    @Test(priority = 8, description = "Validate that  the Admin can  add  Address")
    public void validateThattheAdminCanAddAdress(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(1)"));
        carParkJettyPage.sendAddress();
        validateText(carParkJettyPage.address,"39a adebayo Doherty ");
    }
    @Test(priority = 9, description = "Validate that  the Admin can  add   Security Assignee Phone Number")
    public void validateThattheAdminCanAddSecurityAsigneePhoneNumber(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        carParkJettyPage.sendAsigneePhonenumber();
        sleep(2);
        validateText(carParkJettyPage.enteredPhonenumber, "08132374056");
    }
    @Test(priority = 10, description = "Validate that  the Admin can  add   Security Assignee Email Address ")
    public void validateThattheAdminCanAddSecurityAsigneeEmailAddress(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(1)"));
        carParkJettyPage.sendAsigneeEmailAddress();
        validateText(carParkJettyPage.emailAddress, "stellarichards7@gmail.com");
    }
    @Test(priority = 11, description = "Validate that Admin shall get a successful notication upon completion of Adding car park/Jetty")
    public  void validateThatAdminCanGetSuccessfulNotificationUponCompletionOfAddingCAtParkJetty(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        carParkJettyPage.clicksubmitbtn();
        validateAttribute(carParkJettyPage.carparkregistrationsucess, "displayed", true);

    }

    @Test(priority = 12, description = "Validate that the Admin can Update CArPark/Jetty")
    public  void validateThatAdminCanEditCarParkOrJetty(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);

        myTasksPage.clickCarparkOrJetty();
        carParkJettyPage.setOpencarpark();
        carParkJettyPage.clickeditcarparkbutton();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(1)"));
        carParkJettyPage.clickUpdatebtn();
        validateAttribute(carParkJettyPage.updatesucessmessage, "displayed", true);
    }
    @Test(priority = 13, description = "Validate that the Admin can View/Retrieve CArPark/Jetty")
    public  void validateThatAdminCanViewCArparkOrJetty(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), TEST_CATEGORY);
        myTasksPage.clickCarparkOrJetty();
        carParkJettyPage.setOpencarpark();
        carParkJettyPage.clickeditcarparkbutton();
        validateAttribute(carParkJettyPage.editcarParkpage , "displayed", true);

    }











}
