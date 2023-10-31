package FMASprint1.Android.Tests.IncidentManagement;

import BaseClasses.TestBase;
import FMASprint1.Android.LoginToDashboard;
import java.lang.reflect.Method;

import FMASprint1.Android.Pages.*;
import FMASprint1.Android.Pages.DriverMgt.AddDriverPage;
import FMASprint1.Android.Pages.DriverMgt.DriverManagementPage;
import FMASprint1.Android.Pages.incidentMgt.IncidentManagementPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static utils.extentReports.ExtentTestManager.startTest;

public class IncidentCreationTests extends TestBase {

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
    }

    @Test(priority = 1, description = "Validate that Admin can click on the incident management module")
    public void validateAdminCanClickOnIncidentManagementModule(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        initializer();
        landingPage.selectFleetManagement();
        dashboardPage.selectMoreTasks();
        validateAttribute(myTasksPage.incidentManagement, "displayed", true);
        validateAttribute(myTasksPage.incidentManagement, "clickable", true);
    }

    @Test(priority = 2, description = "Validate that admin can see a list of incidents with ability to search")
    public void validateThatAdminCanSeeListOfIncidents(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        myTasksPage.clickIncidentManagement();
        sleep(3);
        validateAttribute(incidentMgtPage.incidentPageTitle, "displayed", true);
        validateAttribute(incidentMgtPage.incidentPageSearchElement, "displayed", true );
        incidentMgtPage.clickAddIncidentBtn();
    }

    @Test(priority = 3, description = "Validate that Admin is able to select fire from the incident category dropdown")
    public void validateThatAdminCanSelectFireAsIncidentCategory(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String categoryType = "Fire";

        incidentMgtPage.clickIncidentCategoryDropDown(categoryType);
        incidentMgtPage.selectFromDropDown(categoryType);
        validateContentDesc(IncidentManagementPage.findDropdownByText(categoryType), categoryType);
    }

    @Test(priority = 4, description = "Validate that Admin is able to select Accident from the incident category dropdown")
    public void validateThatAdminCanSelectAccidentAsIncidentCategory(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String categoryType = "Accident";

        incidentMgtPage.clickIncidentCategoryDropDown("Fire");
        incidentMgtPage.selectFromDropDown(categoryType);
        validateContentDesc(IncidentManagementPage.findDropdownByText(categoryType), categoryType);
    }

    @Test(priority = 5, description = "Validate that Admin is able to select Theft from the incident category dropdown")
    public void validateThatAdminCanSelectTheftAsIncidentCategory(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String categoryType = "Theft";

        incidentMgtPage.clickIncidentCategoryDropDown("Accident");
        incidentMgtPage.selectFromDropDown(categoryType);
        validateContentDesc(IncidentManagementPage.findDropdownByText(categoryType), categoryType);
    }

    @Test(priority = 6, description = "Validate that Admin is able to input incident date on the form")
    public void validateThatAdminCanInputIncidentDate(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String incidentDate = testDataProp.getProperty("incidentDate");

        incidentMgtPage.clickIncidentDate();
        incidentMgtPage.clickIncidentDateEditIcon();
        incidentMgtPage.enterIncidentDate(incidentDate);
        incidentMgtPage.clickOkayBtn();

        String convertedDate = incidentMgtPage.convertDateFormat(incidentDate); // from mm/dd/yyyy to yyyy-mm-dd
        WebElement newIncidentDate = IncidentManagementPage.findByAccessibility(convertedDate);
        validateContentDesc(newIncidentDate, convertedDate);
    }

    @Test(priority = 7, description = "Validate that Admin is able to input location of incident on the form")
    public void validateThatAdminCanInputLocationOfIncident(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String locationOfIncident = testDataProp.getProperty("locationOfIncident");

        incidentMgtPage.enterLocationOfIncident(locationOfIncident);
//
        validateText(incidentMgtPage.locationOfIncident, locationOfIncident);
    }

    @Test(priority = 8, description = "Validate that Admin is able to input vehicle registration number on the form")
    public void validateThatAdminCanInputVehicleRegistrationNumber(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String vehicleRegistrationNo = testDataProp.getProperty("VehicleRegistrationNo");

        incidentMgtPage.enterVehicleRegistrationNo(vehicleRegistrationNo);
//
        validateText(incidentMgtPage.vehicleRegistrationNo, vehicleRegistrationNo);
    }

    @Test(priority = 9, description = "Validate that Admin is able to input drivers phone number on the form")
    public void validateThatAdminCanInputDriversPhoneNumber(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String driversPhoneNumber = testDataProp.getProperty("driversPhoneNumber");

        incidentMgtPage.enterDriversPhoneNo(driversPhoneNumber);
//
        validateText(incidentMgtPage.driversPhoneNumber, driversPhoneNumber);
    }
    @Test(priority = 10, description = "Validate that Admin is can select region on the form")
    public void validateThatAdminCanSelectRegionThatIncidentOccurred(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String region = testDataProp.getProperty("incidentRegion");

        WebElement regionDropDown = IncidentManagementPage.findDropdownByText("Kano");
        regionDropDown.click();

        incidentMgtPage.selectFromDropDown(region);

        WebElement selectedRegion = IncidentManagementPage.findDropdownByText(region);
        validateContentDesc(selectedRegion, region);
    }

    @Test(priority = 11, description = "Validate that Admin is can select state on the form")
    public void validateThatAdminCanSelectStateThatIncidentOccurred(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String state = testDataProp.getProperty("incidentState");

        WebElement stateDropDown = incidentMgtPage.getStateDropDown();
        stateDropDown.click();
        incidentMgtPage.selectFromDropDown(state);

        WebElement selectedState = IncidentManagementPage.findDropdownByText(state);
        validateContentDesc(selectedState, state);
        flingGesture(selectedState, "down");
    }

    @Test(priority = 12, description = "Validate that Admin can select location Name on the form")
    public void validateThatAdminCanSelectLocationThatIncidentOccurred(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String location = testDataProp.getProperty("incidentLocation");

        WebElement locationDropDown = IncidentManagementPage.findDropdownByText(location);
        locationDropDown.click();
        incidentMgtPage.selectFromDropDown(location);

        WebElement selectedLocation = IncidentManagementPage.findDropdownByText(location);
        validateContentDesc(selectedLocation, location);
    }
    @Test(priority = 13, description = "Validate that Admin is able to type incident description on the form")
    public void validateThatAdminCanTypeIncidentDescription(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String incidentDesc = testDataProp.getProperty("incidentDesc");

        WebElement incidentDescEl = incidentMgtPage.findTextEditFields(-2);
        incidentDescEl.click();
        incidentDescEl.clear();
        incidentDescEl.sendKeys(incidentDesc);
//

        validateText(incidentDescEl, incidentDesc);
    }

    @Test(priority = 14, description = "Validate that Admin is able to type third party details on the form")
    public void validateThatAdminCanTypeThirdPartyDetails(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String thirdPartyDetails = testDataProp.getProperty("thirdParty");

        WebElement thirdPartyEl = incidentMgtPage.findTextEditFields(-1);
        flingGesture(thirdPartyEl, "down");
        thirdPartyEl.click();
        thirdPartyEl.clear();
        thirdPartyEl.sendKeys(thirdPartyDetails);
//

        validateText(thirdPartyEl, thirdPartyDetails);
    }
    @Test(priority = 15, description = "Validate that Admin is able to see a success message after creating incident")
    public void validateThatAdminCanSuccessMessage(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        incidentMgtPage.clickSubmitBtn();
        validateAttribute(incidentMgtPage.incidentSuccessMsg, "displayed", true);
    }
}
