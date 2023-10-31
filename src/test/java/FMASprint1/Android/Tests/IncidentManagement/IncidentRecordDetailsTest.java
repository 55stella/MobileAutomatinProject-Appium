package FMASprint1.Android.Tests.IncidentManagement;

import BaseClasses.TestBase;
import FMASprint1.Android.LoginToDashboard;
import FMASprint1.Android.Pages.*;
import FMASprint1.Android.Pages.DriverMgt.AddDriverPage;
import FMASprint1.Android.Pages.DriverMgt.DriverManagementPage;
import FMASprint1.Android.Pages.incidentMgt.IncidentManagementPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class IncidentRecordDetailsTest extends TestBase {
    PolicyNoticePage policyNoticePage;
    SignInPage signInPage;
    LandingPage landingPage;
    DashboardPage dashboardPage;
    MyTasksPage myTasksPage;
    DriverManagementPage driverManagementPage;
    AddDriverPage addDriverPage;
    LoginToDashboard user;
    IncidentManagementPage incidentMgtPage;

    String testCategory = "Incident-Management";

    public void initializer() {
        policyNoticePage = new PolicyNoticePage(driver);
        signInPage = new SignInPage(driver);
        landingPage = new LandingPage(driver);
        dashboardPage = new DashboardPage(driver);
        myTasksPage = new MyTasksPage(driver);
        driverManagementPage = new DriverManagementPage(driver);
        addDriverPage = new AddDriverPage(driver);
        incidentMgtPage = new IncidentManagementPage(driver);
        user = new LoginToDashboard();
        user.login();

        landingPage.selectFleetManagement();
        dashboardPage.selectMoreTasks();
        myTasksPage.clickIncidentManagement();
        incidentMgtPage.clickIncidentRecord(); // For some reasons, this is not working
    }

    @Test(priority = 1, description = "Validate that Admin is able to view incident record details after selecting it")
    public void validateThatAdminCanSeeIncidentRecordDetails(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        initializer();

        validateAttribute(incidentMgtPage.incidentRecordDetailPage, "displayed", true);
    }
    @Test(priority = 2, description = "Validate that incident report shall contain Incident category")
    public void validateThatIncidentReportContainsIncidentCategory(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        WebElement incidentHeader = incidentMgtPage.getIncidentDetail("Incident Category");
        validateAttribute(incidentHeader, "displayed", true);
    }

    @Test(priority = 3, description = "Validate that incident report shall contain Date of Incident")
    public void validateThatIncidentReportContainsDateOfIncident(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        WebElement incidentDate = incidentMgtPage.getIncidentDetail("Date of Incident");
        validateAttribute(incidentDate, "displayed", true);
    }

    @Test(priority = 4, description = "Validate that incident report shall contain Location of Incident")
    public void validateThatIncidentReportContainsLocationOfIncident(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        WebElement incidentLocation = incidentMgtPage.getIncidentDetail("Location of Incident");
        validateAttribute(incidentLocation, "displayed", true);
    }

    @Test(priority = 5, description = "Validate that incident report shall contain Vehicle Registration No.")
    public void validateThatIncidentReportContainsVehicleRegistrationNo(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        WebElement vehicleRegNo = incidentMgtPage.getIncidentDetail("Vehicle Registration No.");
        validateAttribute(vehicleRegNo, "displayed", true);
    }

    @Test(priority = 6, description = "Validate that incident report shall contain Driver's Name")
    public void validateThatIncidentReportContainsDriversName(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        WebElement driversName = incidentMgtPage.getIncidentDetail("Driver's Name");
        validateAttribute(driversName, "displayed", true);
    }

    @Test(priority = 7, description = "Validate that incident report shall contain Driver's Phone No.")
    public void validateThatIncidentReportContainsDriversPhoneNo(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        WebElement driversPhoneNo = incidentMgtPage.getIncidentDetail("Driver's Phone No.");
        validateAttribute(driversPhoneNo, "displayed", true);
    }

    @Test(priority = 8, description = "Validate that incident report shall contain Incident Region")
    public void validateThatIncidentReportContainsIncidentRegion(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        WebElement incidentRegion = incidentMgtPage.getIncidentDetail("Incident Region");
        validateAttribute(incidentRegion, "displayed", true);
    }

    @Test(priority = 9, description = "Validate that incident report shall contain Incident State")
    public void validateThatIncidentReportContainsIncidentState(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        WebElement incidentState = incidentMgtPage.getIncidentDetail("Incident State");
        validateAttribute(incidentState, "displayed", true);
    }

    @Test(priority = 10, description = "Validate that incident report shall contain Incident Location")
    public void validateThatIncidentReportContainsIncidentLocation(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        WebElement incidentLocation = incidentMgtPage.getIncidentDetail("Incident Location");
        validateAttribute(incidentLocation, "displayed", true);
    }

    @Test(priority = 11, description = "Validate that incident report shall contain Incident Description")
    public void validateThatIncidentReportContainsIncidentDescription(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        WebElement incidentDescription = incidentMgtPage.getIncidentDetail("Incident Description");
        validateAttribute(incidentDescription, "displayed", true);
    }

    @Test(priority = 12, description = "Validate that incident report shall contain Third Party Details")
    public void validateThatIncidentReportContainsThirdPartyDetails(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        WebElement thirdPartyDetails = incidentMgtPage.getIncidentDetail("Third Party Details");
        validateAttribute(thirdPartyDetails, "displayed", true);
    }
}
