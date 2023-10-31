package FMASprint1.Android.Pages.incidentMgt;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class IncidentManagementPage extends PageBase {
    public IncidentManagementPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button")
    public WebElement addIncidentBtn;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Incident Management\"]")
    public WebElement incidentPageTitle;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Search \"]")
    public WebElement incidentPageSearchElement;

    @AndroidFindBy(accessibility = "Select incident date")
    public WebElement incidentDate;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, \"SELECT DATE\")]/android.widget.Button[1]")
    public WebElement incidentDateEditIcon;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, \"SELECT DATE\")]/android.widget.EditText")
    public WebElement incidentDateEditField;

    @AndroidFindBy(accessibility = "OK")
    public WebElement okayBtn;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, \"Fill in the following Information below:\")]//android.widget.EditText[1]")
    public WebElement locationOfIncident;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, \"Fill in the following Information below:\")]//android.widget.EditText[2]")
    public WebElement vehicleRegistrationNo;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, \"Fill in the following Information below:\")]//android.widget.EditText[3]")
    public WebElement driversPhoneNumber;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, \"Fill in the following Information below:\")]/android.widget.EditText")
    public List<WebElement> textInputs;

    @AndroidFindBy(accessibility = "Submit")
    public WebElement submitBtn;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Success Success\"]")
    public WebElement incidentSuccessMsg;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"AGL162XW\n" +
            "MTN Plaza\"]")
    public WebElement incidentRecord;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"View Incident\"]")
    public WebElement incidentRecordDetailPage;

    public String convertDateFormat(String inputDate) {
        // Define the input and output date formats
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            // Parse the input date
            LocalDate date = LocalDate.parse(inputDate, inputFormatter);

            // Format the date to the desired output format
            return date.format(outputFormatter);
        } catch (Exception e) {
            // Handle parsing or formatting errors
            e.printStackTrace();
            return null; // Or handle the error in another way as needed
        }
    }

    public WebElement getIncidentDetail(String contentDesc){
        return driver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc,\"" + contentDesc + "\")]"));
    }

    public static WebElement findByAccessibility(String accessibility) {
        return driver.findElement(AppiumBy.accessibilityId(accessibility));
    }

    public static WebElement findDropdownByText(String text) {
        String dynamicXPath = String.format("//android.widget.Button[contains(@content-desc, '%s')]", text);
        return driver.findElement(AppiumBy.xpath(dynamicXPath));
    }

    public void clickAddIncidentBtn() {
        click(addIncidentBtn);
    }

    public void clickIncidentCategoryDropDown(String type){
        WebElement categoryDropDown = findByAccessibility(type);
        click(categoryDropDown);
    }

    public void selectFromDropDown(String category){
        WebElement categoryEl = findByAccessibility(category);
        click(categoryEl);
    }



    public void clickIncidentDate(){
        click(incidentDate);
    }

    public void clickIncidentDateEditIcon(){
        click(incidentDateEditIcon);
    }

    public void enterIncidentDate(String date){
        click(incidentDateEditField);
        incidentDateEditField.clear();
        incidentDateEditField.sendKeys(date);
    }

    public void clickOkayBtn(){
        click(okayBtn);
    }

    public void enterLocationOfIncident(String location){
        locationOfIncident.click();
        locationOfIncident.clear();
        locationOfIncident.sendKeys(location);
    }

    public void enterVehicleRegistrationNo(String vehicleNo){
        vehicleRegistrationNo.click();
        vehicleRegistrationNo.clear();
        vehicleRegistrationNo.sendKeys(vehicleNo);
    }

    public void enterDriversPhoneNo(String phoneNo){
        driversPhoneNumber.click();
        driversPhoneNumber.clear();
        driversPhoneNumber.sendKeys(phoneNo);
    }

    public WebElement getStateDropDown() {
        return driver.findElement(AppiumBy.xpath("(//android.widget.Button[@content-desc=\"Abuja\"])[2]"));
    }

    public WebElement findTextEditFields(int index) { //This function assumes that the incident Description is -2 (second to last) and third party is -1 (last item)

        // get the last two elements in the list but check if the list is empty and if index is not greater than the size of the list
        if (textInputs.size() > 0 && index < textInputs.size()) {
            return textInputs.get(textInputs.size() + index);
        }
        return null; // Before using this method, always check if the return value is null before using it
    }

    public void clickSubmitBtn(){
        click(submitBtn);
    }

    public void clickIncidentRecord(){
        click(incidentRecord);
    }

}



