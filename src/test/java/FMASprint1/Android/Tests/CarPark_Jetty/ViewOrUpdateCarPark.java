package FMASprint1.Android.Tests.CarPark_Jetty;

import BaseClasses.TestBase;
import FMASprint1.Android.LoginToDashboard;
import FMASprint1.Android.Pages.DashboardPage;
import FMASprint1.Android.Pages.LandingPage;
import FMASprint1.Android.Pages.MyTasksPage;
import FMASprint1.Android.Pages.PolicyNoticePage;
import FMASprint1.Android.Pages.VehicleMgt.CarPark_JettyPage;
import io.appium.java_client.MobileBy;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class ViewOrUpdateCarPark  extends TestBase {
    PolicyNoticePage policyNoticePage;
    DashboardPage dashboardPage;
    MyTasksPage myTasksPage;
    LoginToDashboard user;
    CarPark_JettyPage carParkJettyPage;
    LandingPage landingPage;

    public void initializer() {

        landingPage = new LandingPage(driver);
        dashboardPage = new DashboardPage(driver);
        myTasksPage = new MyTasksPage(driver);
        user = new LoginToDashboard();
        carParkJettyPage = new CarPark_JettyPage(driver);
        user.login();
        landingPage.selectFleetManagement();
        dashboardPage.selectMoreTasks();
        myTasksPage.clickCarparkOrJetty();
    }
    @Test(priority = 12, description = "Validate that the Admin can View/Retrieve CArPark/Jetty")
    public  void validateThatAdminCanViewCArparkOrJetty(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "CarPark/jetty");
        initializer();
        carParkJettyPage.setOpencarpark();
        carParkJettyPage.clickeditcarparkbutton();
        validateAttribute(carParkJettyPage.editcarParkpage , "displayed", true);

    }
    @Test(priority = 13, description = "Validate that the Admin can Update CArPark/Jetty")
    public  void validateThatAdminCanEditCarParkOrJetty(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "CarPark/jetty");
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(1)"));
        carParkJettyPage.clickUpdatebtn();
        validateAttribute(carParkJettyPage.updatesucessmessage, "displayed", true);
    }

}
