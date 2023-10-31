package FMASprint1.Android.Tests.DriversManagement;

import BaseClasses.TestBase;
import FMASprint1.Android.LoginToDashboard;
import java.lang.reflect.Method;

import FMASprint1.Android.Pages.*;
import FMASprint1.Android.Pages.DriverMgt.AddDriverPage;
import FMASprint1.Android.Pages.DriverMgt.DriverManagementPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utils.extentReports.ExtentTestManager.startTest;

public class DriverCreationTest extends TestBase {

    PolicyNoticePage policyNoticePage;
    SignInPage signInPage;
    LandingPage landingPage;
    DashboardPage dashboardPage;
    MyTasksPage myTasksPage;
    DriverManagementPage driverManagementPage;
    AddDriverPage addDriverPage;
    LoginToDashboard user;

    String testCategory = "Drivers-Management";

    public void initializer() {
        policyNoticePage = new PolicyNoticePage(driver);
        signInPage = new SignInPage(driver);
        landingPage = new LandingPage(driver);
        dashboardPage = new DashboardPage(driver);
        myTasksPage = new MyTasksPage(driver);
        driverManagementPage = new DriverManagementPage(driver);
        addDriverPage = new AddDriverPage(driver);
        user = new LoginToDashboard();

        user.login();
    }

    @Test(priority = 1, description = "Validate that Admin shall be able to click on Drivers Management Module")
    public void validateAdminCanClickOnDriversManagementModule(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        initializer();
        landingPage.selectFleetManagement();
        dashboardPage.selectMoreTasks();
        validateAttribute(myTasksPage.driverManagement, "displayed", true);
        validateAttribute(myTasksPage.driverManagement, "clickable", true);
    }


    @Test(priority = 2, description = "Validate that the Add Driver button is clickable by the Admin")
    public void validateAdminCanClickOnAddDriverButton(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        myTasksPage.clickDriverManagement();
        validateAttribute(driverManagementPage.addDriver, "displayed", true);
        validateAttribute(driverManagementPage.addDriver, "clickable", true);
    }

    @Test(priority = 3, description = "Validate that After Admin click on Add Driver button, a form to create a driver is displayed")
    public void validateAdminCanClickOnAddDriverButtonAndFormIsDisplayed(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Drivers-Management");

        driverManagementPage.clickAddDriver();
        validateAttribute(addDriverPage.addDriverFormTitle, "displayed", true);
    }

    @Test(priority = 4, description = "Validate that Admin is able to add the first name field details about a driver")
    public void validateAdminCanAddFirstNameFieldDetails(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String firstName = testDataProp.getProperty("driverFirstName");
        addDriverPage.clickFirstNameField();
        addDriverPage.clearFirstNameField();
        addDriverPage.enterFirstName(firstName);

        validateText(addDriverPage.firstName, firstName);
    }

    @Test(priority = 5, description = "Validate that Admin is able to add the middle name field details about a driver")
    public void validateAdminCanAddMiddleNameFieldDetails(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String middleName = testDataProp.getProperty("driverMiddleName");
        addDriverPage.clickMiddleNameField();
        addDriverPage.clearMiddleNameField();
        addDriverPage.enterMiddleName(middleName);

        validateText(addDriverPage.middleName, middleName);
    }

    @Test(priority = 6, description = "Validate that Admin is able to add the surname name field details about a driver")
    public void validateAdminCanAddSurnameFieldDetails(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String surname = testDataProp.getProperty("driverSurname");
        addDriverPage.clickSurnameField();
        addDriverPage.clearSurnameField();
        addDriverPage.enterSurname(surname);

        validateText(addDriverPage.surname, surname);
    }

    @Test(priority = 7, description = "Validate that Admin is able to add the email field details about a driver")
    public void validateAdminCanAddEmailFieldDetails(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Drivers-Management");

        String email = testDataProp.getProperty("driverEmail");
        addDriverPage.clickEmailField();
        addDriverPage.clearEmailField();
        addDriverPage.enterEmail(email);

        validateText(addDriverPage.email, email);
        ScrollGesture(addDriverPage.homeAddress, "up", 1.0);
    }

    @Test(priority = 8, description = "Validate that Admin is able to add the phone number field details about a driver")
    public void validateAdminCanAddPhoneNumberFieldDetails(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Drivers-Management");

        String phoneNumber = testDataProp.getProperty("driverPhoneNumber");
        addDriverPage.clickPhoneNumberField();
        addDriverPage.clearPhoneNumberField();
        addDriverPage.enterPhoneNumber(phoneNumber);

        validateText(addDriverPage.phoneNumber, phoneNumber);
    }

    @Test(priority = 9, description = "Validate that Admin is able to add the address field details about a driver")
    public void validateAdminCanAddDriversHomeAddress(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Drivers-Management");

        String address = testDataProp.getProperty("driverAddress");
        ScrollGesture(addDriverPage.homeAddress, "up", 1.0);
        // Update home address element
        WebElement homeAddress = addDriverPage.findHomeAddressField(-2);
        homeAddress.click();
        homeAddress.clear();
        homeAddress.sendKeys(address);
        validateText(homeAddress, address);
    }

    @Test(priority = 10, description = "Validate that Admin is able to add the date of birth details about a driver")
    public void validateAdminCanAddDateOfBirthDetailsOfDriver(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Drivers-Management");

        String dateOfBirth = testDataProp.getProperty("driverDateOfBirth");

        addDriverPage.clickDateOfBirthField();
        addDriverPage.clickEditDateIcon();
        addDriverPage.clickDateOfBirthInputField();
        addDriverPage.clearDateOfBirthInputField();
        addDriverPage.enterDateOfBirth(dateOfBirth);
        addDriverPage.clickOkBtn();
        String convertedDateOfBirth = convertDateFormat(dateOfBirth); //mm/dd/yy is Converted to July 08, 1987, format as displayed on the app
        // validate that the date of birth is displayed
        validateText(addDriverPage.dateOfBirth, convertedDateOfBirth);
    }

    @Test(priority = 11, description = "Validate that Admin is able to add the Driver License Number details about a driver")
    public void validateAdminCanAddDriverLicenseNumberOfDriver() {

        String DriversLicenseNumber = testDataProp.getProperty("driverLicenseNumber");

        WebElement licenseNumField = addDriverPage.findDriversLicenseNameField(-1);
        licenseNumField.click();
        licenseNumField.clear();
        licenseNumField.sendKeys(DriversLicenseNumber);

        validateText(licenseNumField, DriversLicenseNumber);
        ScrollGesture(licenseNumField, "up", 1.0);
    }

    @Test(priority = 12, description = "Validate that Admin is able to add the Driver License Renewal Date about a driver")
    public void validateAdminCanAddDriverLicenseRenewalDateOfDriver(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String licenseRenewalDate = testDataProp.getProperty("driverLicenseRenewalDate");

        addDriverPage.clickLicenseRenewalDateField();
        addDriverPage.clickEditDateIcon();
        addDriverPage.clickLicenseRenewalDateInputField();
        addDriverPage.clearLicenseRenewalDateInputField();
        addDriverPage.enterLicenseRenewalDate(licenseRenewalDate);
        addDriverPage.clickOkBtn();
//        driver.navigate().back();

        String convertedLicenseRenewalDate = convertDateFormat(licenseRenewalDate); //mm/dd/yy is Converted to July 08, 1987, format as displayed on the app
        // validate that the date of birth is displayed
        validateText(addDriverPage.licenseRenewalDate, convertedLicenseRenewalDate);
    }

    @Test(priority = 13, description = "Validate that Admin is able to add the Driver Designation")
    public void validateAdminCanAddDriverDesignation(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String designation = testDataProp.getProperty("driverDesignation");

        addDriverPage.clickDesignationField();
        addDriverPage.selectDesignation(designation);
//        driver.navigate().back();

        validateText(addDriverPage.driverDesignation, designation);
        flingGesture(addDriverPage.driverDesignation, "down");
    }

    @Test(priority = 14, description = "Validate that Admin is able to add the driver's Annual gross to form")
    public void validateAdminCanAddDriverAnnualGross(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String annualGross = testDataProp.getProperty("driverAnnualGross");

        WebElement annualGrossField = addDriverPage.findAnnualGrossField();
        if(annualGrossField != null) {
            annualGrossField.click();
            annualGrossField.clear();
            annualGrossField.sendKeys(annualGross);
//            driver.navigate().back();
            validateText(annualGrossField, annualGross);
        }
        // Assert false if annualGrossField is null
        Assert.assertNotNull(annualGrossField);
    }

    //Test to validate that Admin is able to click on the next button to navigate to the next page
    @Test(priority = 15, description = "Validate that Admin is able to click on the next button to navigate to the next page")
    public void validateAdminCanClickOnNextBtnToNavigateToNextPage(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        validateAttribute(addDriverPage.nextBtn, "displayed", true);
        validateAttribute(addDriverPage.nextBtn, "clickable", true);
        addDriverPage.clickNextBtn();
    }

    //Test to validate that Admin is able to add driver's status as suspended on the next page
    @Test(priority = 16, description = "Validate that Admin is able to add driver's status on the next page")
    public void validateAdminCanAddDriverStatusSuspended(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String status = testDataProp.getProperty("driverStatusSuspended");

        addDriverPage.clickStatusField();
        addDriverPage.selectStatus(status);

        validateText(addDriverPage.driverStatus, status);
    }

    @Test(priority = 17, description = "Validate that Admin is able to add driver's status on the next page")
    public void validateAdminCanAddDriverStatus(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String status = testDataProp.getProperty("driverStatusActive");

        addDriverPage.clickStatusField();
        addDriverPage.selectStatus(status);

        validateText(addDriverPage.driverStatus, status);
    }

    //Test to validate that Admin is able to add driver's status description on the next page
    @Test(priority = 18, description = "Validate that Admin is able to add driver's status description on the next page")
    public void validateAdminCanAddDriverStatusDescription(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String statusDescription = testDataProp.getProperty("driveStatusDesc");

        WebElement statusDescriptionField = addDriverPage.findStatusDescriptionField();
        if(statusDescriptionField != null) {
            statusDescriptionField.click();
            statusDescriptionField.clear();
            statusDescriptionField.sendKeys(statusDescription);
//            driver.navigate().back();
            validateText(statusDescriptionField, statusDescription);
        }
        // Assert false if statusDescriptionField is null
        Assert.assertNotNull(statusDescriptionField);
    }

    // Test to validate that Admin is able to add vendor on 2 page of the form
    @Test(priority = 19, description = "Validate that Admin is able to add vendor on 2 page of the form")
    public void validateAdminCanAddVendor(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String vendor = testDataProp.getProperty("driverVendor");

        addDriverPage.clickVendorDropDown();
        addDriverPage.selectVendor(vendor);
//        driver.navigate().back();

        validateText(addDriverPage.vendorDropDown, vendor);
    }


    // Test to validate the Admin can add the driver's emergency phone number on 2 page of the form
    @Test(priority = 20, description = "Validate that Admin is able to add the driver's emergency phone number form")
    public void validateAdminCanAddDriverEmergencyPhoneNumber(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String emergencyPhoneNumber = testDataProp.getProperty("driverEmergencyPhoneNumber");

        WebElement emergencyPhoneNumberField = addDriverPage.findEmergencyPhoneNumberField();
        if(emergencyPhoneNumberField != null) {
            emergencyPhoneNumberField.click();
            emergencyPhoneNumberField.clear();
            emergencyPhoneNumberField.sendKeys(emergencyPhoneNumber);
//            driver.navigate().back();
            validateText(emergencyPhoneNumberField, emergencyPhoneNumber);
        }
        // Assert false if emergencyPhoneNumberField is null
        Assert.assertNotNull(emergencyPhoneNumberField);
    }

    @Test(priority = 21, description = "Validate that Admin is able to add the driver's deployment data to the form")
    public void validateAdminCanAddDriverDeploymentData(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String deploymentDate = testDataProp.getProperty("driverDeploymentDate");

        addDriverPage.clickDeploymentDateField();
        addDriverPage.clickEditDateIcon();
        addDriverPage.clickDeploymentDateInputField();
        addDriverPage.clearDeploymentDateInputField();
        addDriverPage.enterDeploymentDate(deploymentDate);
        addDriverPage.clickOkBtn();

        String convertedDeploymentDate = convertDateFormat(deploymentDate); //mm/dd/yy is Converted to July 08, 1987, format as displayed on the app
        // validate that the date of birth is displayed
        validateText(addDriverPage.deploymentDate, convertedDeploymentDate);
        flingGesture(addDriverPage.deploymentDate, "down");
    }

    @Test(priority = 22, description = "Validate that Admin is able to add the driver's region data to the form")
    public void validateAdminCanAddDriverRegionData(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String region = testDataProp.getProperty("driverRegion");
        addDriverPage.clickRegionDropDown();
        addDriverPage.selectRegion(region);
        validateText(addDriverPage.regionDropDown, region);
    }

    @Test(priority = 23, description = "Validate that Admin is able to add the driver's State data to the form")
    public void validateAdminCanAddDriverStateData(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String state = testDataProp.getProperty("driverState");

        addDriverPage.clickStateDropDown();
        addDriverPage.selectState(state);

        validateText(addDriverPage.stateDropDown, state);
    }

    @Test(priority = 24, description = "Validate that Admin is able to add the driver's location name data to the form")
    public void validateAdminCanAddDriverLocationNameData(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String locationName = testDataProp.getProperty("driverLocationName");

        addDriverPage.clickLocationDropDown();
        addDriverPage.selectLocation(locationName);

        validateText(addDriverPage.locationDropDown, locationName);
        addDriverPage.clickNextBtn();
    }

    @Test(priority = 25, description = "Validate that Admin is able to click on the next button to navigate to the next page")
    public void validateAdminCanClickOnSubmitBtnToCreateDriver(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        validateAttribute(addDriverPage.submitBtn, "displayed", true);
        validateAttribute(addDriverPage.submitBtn, "clickable", true);
        addDriverPage.clickSubmitBtn();
    }

    @Test(priority = 26, description = "Validate that Admin is able to success message after creating a driver")
    public void validateAdminCanSeeSuccessMessageAfterCreatingDriver(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String successMessage = testDataProp.getProperty("driverAddedSuccessMsg");
        validateText(addDriverPage.driverAddedSuccessMsg, successMessage);
        addDriverPage.clickOkayBtn();
    }

    @Test(priority = 28, description = "Validate that Admin is able to select a driver to view driver details")
    public void validateAdminCanSelectDriverToViewDetails(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String driverName = testDataProp.getProperty("driverName");
        String phoneNumber = testDataProp.getProperty("driverPhoneNumber");
        String status = testDataProp.getProperty("driverStatusActive");
        String region = testDataProp.getProperty("driverRegion");
        String DriverAccessibilityId = AddDriverPage.combineWithSpace(driverName, phoneNumber, status, region);

        addDriverPage.clickDriverListBtn();
        WebElement driver = addDriverPage.getDriverFromList(DriverAccessibilityId);
        driver.click();
        validateAttribute(addDriverPage.driverDetailPageTitle, "displayed", true);
    }
}
