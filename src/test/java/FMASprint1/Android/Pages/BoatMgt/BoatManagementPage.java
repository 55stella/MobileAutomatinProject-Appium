package FMASprint1.Android.Pages.BoatMgt;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BoatManagementPage extends PageBase {


    public BoatManagementPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Add Boat\"]")
    public WebElement addBoatTab;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Boat List\"]")
    public WebElement boatListTab;

    @AndroidFindBy(className = "android.view.View")
    public List<WebElement> boatListItems;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Fuel Type *\"]/android.view.View[2]")
    public WebElement fuelType;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Status *\"]/android.view.View[2]")
    public WebElement boatStatus;

    @AndroidFindBy(accessibility = "Next")
    public WebElement nextButton;

    @AndroidFindBy(accessibility = "OK")
    public WebElement okBtn;

    public List<WebElement> getPreloadedBoatList() {
        return driver.findElements(AppiumBy.className("android.view.View"));
    }

    public List<WebElement> getAddBoatTextFields() {
        return driver.findElements(AppiumBy.className("android.widget.EditText"));
    }

    public WebElement enterBoatName(String boatName) {
        WebElement boatNameField = getAddBoatTextFields().get(0);
        click(boatNameField);
        enterText(boatNameField, boatName);
        return boatNameField;
    }

    public WebElement enterBoatMake(String make) {
        WebElement makeField = getAddBoatTextFields().get(1);
        click(makeField);
        enterText(makeField, make);
        return makeField;
    }

    public void enterBoatModel(String model) {
        WebElement modelField = getAddBoatTextFields().get(2);
        click(modelField);
        enterText(modelField, model);
    }

    public WebElement enterBoatColor(String color) {
        WebElement colorField = getAddBoatTextFields().get(3);
        click(colorField);
        enterText(colorField, color);
        return colorField;
    }

    public void clickOnFuelType() {
        click(fuelType);
    }

    public void clickOnBoatStatus() {
        click(boatStatus);
    }

    public WebElement findByAccessibilityId(String accessibilityId) {
        return driver.findElement(AppiumBy.accessibilityId(accessibilityId));
    }

    public void selectFuelType(String fuelType) {
        click(findByAccessibilityId(fuelType));
    }

    public void selectBoatStatus(String boatStatus) {
        click(findByAccessibilityId(boatStatus));
    }

    public WebElement enterBoatCapacity(String capacity) {
        WebElement capacityField = getAddBoatTextFields().get(2);
        click(capacityField);
        enterText(capacityField, capacity);
        return capacityField;
    }

    public WebElement enterBoatOwner(String owner) {
        WebElement ownerField = getAddBoatTextFields().get(3);
        click(ownerField);
        enterText(ownerField, owner);
        return ownerField;
    }

    public void clickOnNextButton() {
        click(nextButton);
    }

    public void clickOkBtn() {
        click(okBtn);
    }
    public List<WebElement> findByAccessibilityIdPartials(String partialAccessibilityId) {
        String xpathExpression = "//android.view.View[contains(@content-desc, '" + partialAccessibilityId + "')]";
        return driver.findElements(AppiumBy.xpath(xpathExpression));
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.view.View[1]")
    public WebElement boatPurchaseDate;

    public void clickOnBoatPurchaseDate() {
        click(boatPurchaseDate);
    }

    private WebElement findEditIcon() {
        List<WebElement> icons = driver.findElements(AppiumBy.className("android.widget.Button"));
        //get the first element in the list
        return icons.get(0);
    }

    public void clickEditDateIcon() {
        WebElement editIcon = findEditIcon();
        click(editIcon);
    }

    @AndroidFindBy(className = "android.widget.EditText")
    public List<WebElement> dateInputField;

    public WebElement getDateInputField() {
        return dateInputField.get(0);
    }

    public void enterPurchaseDate(String date) {
        click(boatPurchaseDate);
        clickEditDateIcon();

        WebElement dateField = getDateInputField();
        click(dateField);
        clearTextField(dateField);
        enterText(dateField, date);
        clickOkBtn();
    }

    public WebElement enterPurchaseAmount(String amount) {
        WebElement amountField = getAddBoatTextFields().get(0);
        click(amountField);
        clearTextField(amountField);
        enterText(amountField, amount);
        return amountField;
    }

    public WebElement enterPurchasedFromField(String purchasedFrom) {
        WebElement purchasedFromField = getAddBoatTextFields().get(1);
        click(purchasedFromField);
        clearTextField(purchasedFromField);
        enterText(purchasedFromField, purchasedFrom);
        return purchasedFromField;
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Region *\"]/android.view.View[2]")
    public WebElement boatRegion;

    public void clickOnBoatRegion() {
        click(boatRegion);
    }

    public void selectBoatRegion(String boatRegion) {
        click(findByAccessibilityId(boatRegion));
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"State *\"]/android.view.View[2]")
    public WebElement boatState;

    public void clickOnBoatState() {
        click(boatState);
    }

    public void selectBoatState(String state) {
        click(findByAccessibilityId(state));
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Location *\"]/android.view.View[2]")
    public WebElement boatLocation;

    public void clickOnBoatLocation() {
        click(boatLocation);
    }

    public void selectBoatLocation(String location) {
        click(findByAccessibilityId(location));
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Boat Captain *\"]/android.view.View[2]")
    public WebElement boatCaptain;

    public void clickOnBoatCaptain() {
        click(boatCaptain);
    }

    public void selectBoatCaptain(String captain) {
        click(findByAccessibilityIdPartials(captain).get(0));
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Jetty *\"]/android.view.View[2]")
    public WebElement boatJetty;

    public void clickOnBoatJetty() {
        click(boatJetty);
    }

    public void selectBoatJetty(String jetty) {
        click(findByAccessibilityIdPartials(jetty).get(0));
    }

    @AndroidFindBy(accessibility = "Confirm")
    public WebElement confirmBtn;

    public void clickConfirmBtn() {
        click(confirmBtn);
    }

    @AndroidFindBy(accessibility = "Vehicle or boat record was successfully added")
    public WebElement boatAddedSuccessMsg;

    @AndroidFindBy(accessibility = "Okay")
    public WebElement okayBtn;

    public void clickOnOkBtn() {
        click(okayBtn);
    }

    @AndroidFindBy(accessibility = "boatAlreadyExistMsg")
    public WebElement boatAlreadyExistMsg;
}
