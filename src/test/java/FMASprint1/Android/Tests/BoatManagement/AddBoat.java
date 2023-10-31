package FMASprint1.Android.Tests.BoatManagement;

import BaseClasses.TestBase;
import FMASprint1.Android.LoginToDashboard;
import FMASprint1.Android.Pages.*;
import FMASprint1.Android.Pages.BoatMgt.BoatManagementPage;
import FMASprint1.Android.Pages.VehicleMgt.VehicleAndBoatManagementPage;
import FMASprint1.Android.Pages.DashboardPage;
import FMASprint1.Android.Pages.LandingPage;
import FMASprint1.Android.Pages.MyTasksPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class AddBoat extends TestBase {

    LandingPage landingPage;
    DashboardPage dashboardPage;
    MyTasksPage myTasksPage;
    VehicleAndBoatManagementPage vehicleAndBoatManagementPage;
    LoginToDashboard user;
    BoatManagementPage boatManagementPage;

    String testCategory = "Boat-Management";

    public void initializer() {
        landingPage = new LandingPage(driver);
        dashboardPage = new DashboardPage(driver);
        myTasksPage = new MyTasksPage(driver);
        user = new LoginToDashboard();
        vehicleAndBoatManagementPage = new VehicleAndBoatManagementPage(driver);
        boatManagementPage = new BoatManagementPage(driver);

        user.login();
        landingPage.selectFleetManagement();
        dashboardPage.selectMoreTasks();
        myTasksPage.selectVehicleBoatManagement();

    }
    @Test(priority = 1, description = "Validate that list and details of all boats shall be pre-loaded into the App")
    public void TC_102_validateListAndDetailsOfAllBoatsIsPreLoadedIntoTheApp(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);
        initializer();
        vehicleAndBoatManagementPage.selectBoatList();
        sleep(5);
        Assert.assertTrue(boatManagementPage.boatListItems.size() > 4);
        vehicleAndBoatManagementPage.selectAddBoat();
    }

    @Test(priority = 2, description = "Validate that Admin shall be able to enter boat name in the add boat form")
    public void TC_104_validateAdminAbleToEnterBoatNameInTheAddBoatForm(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String boatName = testDataProp.getProperty("boatName");

        WebElement boatNameField = boatManagementPage.enterBoatName(boatName);
        validateText(boatNameField, boatName);
    }

    @Test(priority = 3, description = "Validate that Admin shall be able to enter boat make in the add boat form")
    public void TC_105_validateAdminAbleToEnterBoatMakeInTheAddBoatForm(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String boatMake = testDataProp.getProperty("boatMake");

        WebElement makeField = boatManagementPage.enterBoatMake(boatMake);
        validateText(makeField, boatMake);
    }

    @Test(priority = 4, description = "Validate that Admin shall be able to enter boat model in the add boat form")
    public void TC_106_validateAdminAbleToEnterBoatModelInTheAddBoatForm(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String boatModel = testDataProp.getProperty("boatModel");

        boatManagementPage.enterBoatModel(boatModel);
        validateText(boatManagementPage.getAddBoatTextFields().get(2), boatModel);
    }

    @Test(priority = 5, description = "Validate that Admin shall be able to select boat fuel type on the add boat form")
    public void TC_109_validateAdminAbleToSelectBoatFuelTypeOnTheAddBoatForm(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String boatFuelType = testDataProp.getProperty("fuelType");

        boatManagementPage.clickOnFuelType();
        boatManagementPage.selectFuelType(boatFuelType);
        validateText(boatManagementPage.fuelType, boatFuelType);
    }

    @Test(priority = 6, description = "Validate that Admin shall be able to select boat status in the add boat form")
    public void TC_115_validateAdminAbleToSelectBoatStatusInTheAddBoatForm(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String boatStatus = testDataProp.getProperty("boatStatus");

        boatManagementPage.clickOnBoatStatus();
        boatManagementPage.selectBoatStatus(boatStatus);
        validateText(boatManagementPage.boatStatus, boatStatus);
    }

    @Test(priority = 7, description = "Validate that Admin shall be able to enter boat color in the add boat form")
    public void TC_107_validateAdminAbleToEnterBoatColorInTheAddBoatForm(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String boatColor = testDataProp.getProperty("boatColor");

        WebElement colorField = boatManagementPage.enterBoatColor(boatColor);
        validateText(colorField, boatColor);
        ScrollGesture(colorField, "up", 1.0);
        ScrollGesture(colorField, "up", 1.0);
        ScrollGesture(colorField, "up", 1.0);
    }

    @Test(priority = 8, description = "Validate that Admin shall be able to enter BOAT CAPACITY in the add boat form")
    public void TC_110_validateAdminAbleToEnterBoatCapacityInTheAddBoatForm(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String boatCapacity = testDataProp.getProperty("boatCapacity");

        WebElement capacityField = boatManagementPage.enterBoatCapacity(boatCapacity);
        validateText(capacityField, boatCapacity);
    }

    @Test(priority = 9, description = "Validate that Admin shall be able to enter BOAT OWNER in the add boat form")
    public void TC_116_validateAdminAbleToEnterBoatOwnerInTheAddBoatForm(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String boatOwner = testDataProp.getProperty("boatOwner");

        WebElement ownerField = boatManagementPage.enterBoatOwner(boatOwner);
        validateText(ownerField, boatOwner);
        boatManagementPage.clickOnNextButton();
    }

    @Test(priority = 10, description = "Validate that Admin shall be able to enter BOAT PURCHASE DATE in the add boat form")
    public void TC_112_validateAdminAbleToEnterBoatPurchaseDateInTheAddBoatForm(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String boatPurchaseDate = testDataProp.getProperty("boatPurchaseDate");

        boatManagementPage.enterPurchaseDate(boatPurchaseDate);
        String convertedBoatPurchaseDate = convertDateFormat(boatPurchaseDate);
        validateText(boatManagementPage.boatPurchaseDate, convertedBoatPurchaseDate);
    }

    @Test(priority = 11, description = "Validate that Admin shall be able to enter BOAT PURCHASE AMOUNT in the add boat form")
    public void TC_113_validateAdminAbleToEnterBoatPurchaseAmountInTheAddBoatForm(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String boatPurchaseAmount = testDataProp.getProperty("boatPurchaseAmount");

        WebElement purchaseAmountField = boatManagementPage.enterPurchaseAmount(boatPurchaseAmount);
        validateText(purchaseAmountField, boatPurchaseAmount);
    }

    @Test(priority = 12, description = "Validate that Admin shall be able to enter NAME OF BOAT SELLER (Purchased From) in the add boat form")
    public void TC_117_validateAdminAbleToEnterNameOfBoatSellerInTheAddBoatForm(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String purchasedFrom = testDataProp.getProperty("boatPurchasedFrom");

        WebElement purchasedFromField = boatManagementPage.enterPurchasedFromField(purchasedFrom);
        validateText(purchasedFromField, purchasedFrom);
    }

    @Test(priority = 13, description = "Validate that Admin shall be able to Select REGION in the add boat form")
    public void validateAdminAbleToSelectBoatRegionInTheAddBoatForm(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String boatRegion = testDataProp.getProperty("boatRegion");

        boatManagementPage.clickOnBoatRegion();
        boatManagementPage.selectBoatRegion(boatRegion);
        validateText(boatManagementPage.boatRegion, boatRegion);
    }

    @Test(priority = 14, description = "Validate that Admin shall be able to select BOAT STATE in the add boat form")
    public void TC_114_validateAdminAbleToSelectBoatStateInTheAddBoatForm(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String boatState = testDataProp.getProperty("boatState");

        boatManagementPage.clickOnBoatState();
        boatManagementPage.selectBoatState(boatState);
        validateText(boatManagementPage.boatState, boatState);
    }

    @Test(priority = 15, description = "Validate that Admin shall be able to select BOAT USE LOCATION in the add boat form")
    public void TC_111_validateAdminAbleToSelectBoatUseLocationInTheAddBoatForm(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String boatUseLocation = testDataProp.getProperty("boatLocation");

        boatManagementPage.clickOnBoatLocation();
        boatManagementPage.selectBoatLocation(boatUseLocation);
        validateText(boatManagementPage.boatLocation, boatUseLocation);
        ScrollGesture(boatManagementPage.boatLocation, "up", 1.0);
        ScrollGesture(boatManagementPage.boatLocation, "up", 1.0);
        ScrollGesture(boatManagementPage.boatLocation, "up", 1.0);
    }

    @Test(priority = 16, description = "Validate that Admin shall be able to select BOAT CAPTAIN in the add boat form")
    public void TC_114_validateAdminAbleToSelectBoatCaptainInTheAddBoatForm(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String boatCaptain = testDataProp.getProperty("boatCaptain");

        boatManagementPage.clickOnBoatCaptain();
        boatManagementPage.selectBoatCaptain(boatCaptain);
        validateText(boatManagementPage.boatCaptain, boatCaptain);
    }

    @Test(priority = 17, description = "Validate that Admin shall be able to select BOAT Jetty in the add boat form")
    public void TC_118_validateAdminAbleToSelectBoatJettyInTheAddBoatForm(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String boatJetty = testDataProp.getProperty("boatJetty");

        boatManagementPage.clickOnBoatJetty();
        boatManagementPage.selectBoatJetty(boatJetty);
        validateText(boatManagementPage.boatJetty, boatJetty);
        boatManagementPage.clickOnNextButton();
        sleep(20);
        boatManagementPage.clickConfirmBtn();
    }

    @Test(priority = 18, description = "validate that Admin can see success message after clicking confirm button")
    public void TC_119_validateAdminCanSeeSuccessMessageAfterClickingConfirmButton(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String successMessage = testDataProp.getProperty("boatAddedSuccessMsg");

        validateText(boatManagementPage.boatAddedSuccessMsg, successMessage);
        boatManagementPage.clickOnOkBtn();
    }

    @Test(priority = 19, description = "Validate that Admin shall be able notified that boat details already exist")
    public void TC_120_validateAdminNotifiedThatBoatDetailsAlreadyExist(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), testCategory);

        String boatAlreadyExistMsg = testDataProp.getProperty("boatAlreadyExistMsg");

        String boatName = testDataProp.getProperty("boatName");
        String boatMake = testDataProp.getProperty("boatMake");
        String boatModel = testDataProp.getProperty("boatModel");
        String boatFuelType = testDataProp.getProperty("fuelType");
        String boatStatus = testDataProp.getProperty("boatStatus");
        String boatPurchaseDate = testDataProp.getProperty("boatPurchaseDate");
        String boatPurchaseAmount = testDataProp.getProperty("boatPurchaseAmount");
        String boatColor = testDataProp.getProperty("boatColor");
        String boatCapacity = testDataProp.getProperty("boatCapacity");
        String boatOwner = testDataProp.getProperty("boatOwner");
        String purchasedFrom = testDataProp.getProperty("boatPurchasedFrom");
        String boatRegion = testDataProp.getProperty("boatRegion");
        String boatState = testDataProp.getProperty("boatState");
        String boatUseLocation = testDataProp.getProperty("boatLocation");
        String boatCaptain = testDataProp.getProperty("boatCaptain");
        String boatJetty = testDataProp.getProperty("boatJetty");

        vehicleAndBoatManagementPage.clickAddBoatTab();
        boatManagementPage.enterBoatName(boatName);
        boatManagementPage.enterBoatMake(boatMake);
        boatManagementPage.enterBoatModel(boatModel);
        boatManagementPage.clickOnFuelType();
        boatManagementPage.selectFuelType(boatFuelType);
        boatManagementPage.clickOnBoatStatus();
        boatManagementPage.selectBoatStatus(boatStatus);
        WebElement colorField = boatManagementPage.enterBoatColor(boatColor);
        // Scroll up to make the capacity & boat owner fields visible
        ScrollGesture(colorField, "up", 1.0);
        ScrollGesture(colorField, "up", 1.0);
        ScrollGesture(colorField, "up", 1.0);
        boatManagementPage.enterBoatCapacity(boatCapacity);
        boatManagementPage.enterBoatOwner(boatOwner);
        boatManagementPage.clickOnNextButton();
        boatManagementPage.enterPurchaseDate(boatPurchaseDate);
        boatManagementPage.enterPurchaseAmount(boatPurchaseAmount);
        boatManagementPage.enterPurchasedFromField(purchasedFrom);
        boatManagementPage.clickOnBoatRegion();
        boatManagementPage.selectBoatRegion(boatRegion);
        boatManagementPage.clickOnBoatState();
        boatManagementPage.selectBoatState(boatState);
        boatManagementPage.clickOnBoatLocation();
        boatManagementPage.selectBoatLocation(boatUseLocation);
        boatManagementPage.clickOnBoatCaptain();
        boatManagementPage.selectBoatCaptain(boatCaptain);
        boatManagementPage.clickOnBoatJetty();
        boatManagementPage.selectBoatJetty(boatJetty);
        boatManagementPage.clickOnNextButton();
        boatManagementPage.clickConfirmBtn();
        validateText(boatManagementPage.boatAlreadyExistMsg, boatAlreadyExistMsg);


        WebElement purchasedFromField = boatManagementPage.enterPurchasedFromField(purchasedFrom);






    }
}
