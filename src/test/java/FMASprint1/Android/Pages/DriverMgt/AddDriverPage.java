package FMASprint1.Android.Pages.DriverMgt;

import BaseClasses.PageBase;
import BaseClasses.TestBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static BaseClasses.TestBase.testDataProp;

public class AddDriverPage extends PageBase {
    public AddDriverPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(accessibility = "Add Driver details below")
    public WebElement addDriverFormTitle;


    @AndroidFindBy(className = "android.widget.EditText")
    List<WebElement> addDriverInputFields;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.widget.EditText[1]")
    public WebElement firstName;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.widget.EditText[2]")
    public WebElement middleName;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.widget.EditText[3]")
    public WebElement surname;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.widget.EditText[4]")
    public WebElement email;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.widget.EditText[5]")
    public WebElement phoneNumber;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.widget.EditText[6]")
    public WebElement homeAddress;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.view.View")
    public WebElement dateOfBirth;

    @AndroidFindBy(className = "android.widget.EditText")
    public List<WebElement> dateInputField;

    @AndroidFindBy(accessibility = "OK")
    public WebElement okBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.view.View[2]")
    public WebElement licenseRenewalDate;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.view.View[1]")
    public WebElement licenseRenewalDate1;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Driver's Designation *\"]/android.view.View[2]")
    public WebElement driverDesignation;

    @AndroidFindBy(accessibility = "Next")
    public WebElement nextBtn;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Driver Status *\"]/android.view.View[2]")
    public WebElement driverStatus;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Vendor *\"]/android.view.View[2]")
    public WebElement vendorDropDown;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.view.View[3]")
    public WebElement deploymentDate;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Region *\"]/android.view.View[2]")
    public WebElement regionDropDown;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"State Name *\"]/android.view.View[2]")
    public WebElement stateDropDown;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Location Name *\"]/android.view.View[2]")
    public WebElement locationDropDown;
  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.widget.EditText[7]")
  public WebElement annualGross;
    @AndroidFindBy(accessibility = "Submit")
    public WebElement submitBtn;

    @AndroidFindBy(accessibility = "Driver record was successfully added")
    public WebElement driverAddedSuccessMsg;

    @AndroidFindBy(accessibility = "Okay")
    public WebElement okayBtn;

    @AndroidFindBy(accessibility = "Driver List")
    public WebElement driverListBtn;

    @AndroidFindBy(accessibility = "Driver Detail")
    public WebElement driverDetailPageTitle;

    @AndroidFindBy(accessibility = "Edit Driver")
    public WebElement editDriverBtn;

    @AndroidFindBy(accessibility = "Edit Driver info below")
    public WebElement editDriverFormTitle;
    @AndroidFindBy(className = "android.widget.ScrollView")
    WebElement scrollElement;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Add Driver']/../*[1]")
    WebElement backArrow;
    @FindBy(xpath = "//android.view.View[@content-desc=\"Select Region\"]//../*[1]")
    WebElement closeRegionDropDown;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Kano\"]//../*")
   List  <WebElement> allRegions;



    public void enterFirstName(String firstName) {
        enterText(this.firstName, firstName);
    }

    public void clickFirstNameField() {
        click(firstName);
    }

    public void clearFirstNameField() {
        clearTextField(this.firstName);
    }

    public void enterMiddleName(String middleName) {
        enterText(this.middleName, middleName);
    }

    public void clickMiddleNameField() {
        click(middleName);
    }

    public void clearMiddleNameField() {
        clearTextField(middleName);
    }

    public void enterSurname(String surname) {
        enterText(this.surname, surname);
    }

    public void clickSurnameField() {
        click(surname);
    }

    public void clearSurnameField() {
        clearTextField(surname);
    }

    public void enterEmail(String email) {
        enterText(this.email, email);
    }

    public void clickEmailField() {
        click(email);
    }

    public void clearEmailField() {
        clearTextField(email);
    }

    public void enterPhoneNumber(String phoneNumber) {
        enterText(this.phoneNumber, phoneNumber);
    }

    public void clickPhoneNumberField() {
        click(phoneNumber);
    }

    public void clearPhoneNumberField() {
        clearTextField(phoneNumber);
    }

    public void clickDateOfBirthField() {
        click(dateOfBirth);
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

    public WebElement getDateInputField() {
        return dateInputField.get(0);
    }

    public void clickDateOfBirthInputField() {
        click(getDateInputField());
    }

    public void clearDateOfBirthInputField() {
        clearTextField(getDateInputField());
    }

    public void enterDateOfBirth(String dateOfBirth) {
        enterText(getDateInputField(), dateOfBirth);
    }

    public void clickOkBtn() {
        click(okBtn);
    }

    public WebElement findFields(int index) { //This funtion assumes that the home address is -2 (second to last) and license is -1 (last item)
        List<WebElement> fields = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView//android.widget.EditText"));
        // get the last two elements in the list
        return fields.get(fields.size() + index);
    }

    public WebElement findDriversLicenseNameField(int index) {
        return findFields(index);
    }
    public WebElement findHomeAddressField(int index) {
        return findFields(index);
    }

    public void clickLicenseRenewalDateField() {
        click(licenseRenewalDate);
    }

    public void clickLicenseRenewalDateInputField() {
        click(getDateInputField());
    }

    public void clearLicenseRenewalDateInputField() {
        clearTextField(getDateInputField());
    }

    public void enterLicenseRenewalDate(String licenseRenewalDate) {
        enterText(getDateInputField(), licenseRenewalDate);
    }

    public void clickDesignationField() {
        click(driverDesignation);
    }

    public void selectDesignation(String designation) {
        WebElement designationElement = driver.findElement(AppiumBy.accessibilityId(designation));
        click(designationElement);
    }

    public void clickNextBtn() {
        click(nextBtn);
    }

    public void clickStatusField() {
        click(driverStatus);
    }

    public void selectStatus(String driverStatus) {
        WebElement driverStatusElement = driver.findElement(AppiumBy.accessibilityId(driverStatus));
        click(driverStatusElement);
    }

    public WebElement findTextEditFields(int index) { //This funtion assumes that the home address is -2 (second to last) and license is -1 (last item)
        List<WebElement> fields = driver.findElements(By.xpath("//android.widget.EditText"));
        // get the last two elements in the list but check if the list is empty and if index is not greater than the size of the list
        if (fields.size() > 0 && index < fields.size()) {
            return fields.get(fields.size() + index);
        }
        return null; // Before using this method, always check if the return value is null before using it
    }

    public WebElement findStatusDescriptionField() {
        return findTextEditFields(-2);
    }

    public void clickVendorDropDown() {
        click(vendorDropDown);
    }

    public void selectVendor(String vendor) {
        WebElement vendorElement = driver.findElement(AppiumBy.accessibilityId(vendor));
        click(vendorElement);
    }

    public WebElement findEmergencyPhoneNumberField() {
        return findTextEditFields(-1);
    }

    public void clickDeploymentDateField() {
        click(deploymentDate);
    }

    public void clickDeploymentDateInputField() {
        click(getDateInputField());
    }

    public void clearDeploymentDateInputField() {
        clearTextField(getDateInputField());
    }

    public void enterDeploymentDate(String deploymentDate) {
        enterText(getDateInputField(), deploymentDate);
    }

    public void clickRegionDropDown() {
        click(regionDropDown);
    }

    public void selectRegion(String region) {
        WebElement regionElement = driver.findElement(AppiumBy.accessibilityId(region));
        click(regionElement);
    }


    public WebElement returnRegion(String region){
        return driver.findElement(AppiumBy.accessibilityId(region));

    }

    public void clickStateDropDown() {
        click(stateDropDown);
    }

    public void selectState(String state) {
        WebElement stateElement = driver.findElement(AppiumBy.accessibilityId(state));
        click(stateElement);
    }

    public void clickLocationDropDown() {
        click(locationDropDown);
    }

    public void selectLocation(String location) {
        WebElement locationElement = driver.findElement(AppiumBy.accessibilityId(location));
        click(locationElement);
    }

    public void clickSubmitBtn() {
        click(submitBtn);
    }

    public WebElement findAnnualGrossField() {
        return findTextEditFields(-1);
    }

    public void clickOkayBtn() {
        click(okayBtn);
    }

    public void clickDriverListBtn() {
        click(driverListBtn);
    }

    public WebElement getDriverFromList(String accessibility) {
        return driver.findElement(AppiumBy.accessibilityId(accessibility));
    }

    public static String combineWithSpace(String... strings) {
        StringBuilder combined = new StringBuilder();

        for (String str : strings) {
            if (str != null && !str.isEmpty()) {
                if (combined.length() > 0) {
                    combined.append(" ");
                }
                combined.append(str);
            }
        }

        return combined.toString();
    }


    public void clickLicenseRenewalDate(){
        click(licenseRenewalDate1);
    }

    public void clickAnnualGross(){
        click(annualGross);
    }

    public void findRightAddDriverIndexDuringScreenChange(int index, WebElement ele, String text ){
        click(ele);
        if(addDriverInputFields.size() <= index){
            System.out.println(index);
            enterText(addDriverInputFields.get(index-1), text);
        }else{
            enterText(addDriverInputFields.get(index), text);
        }
        driver.navigate().back();
    }
    public void enterFirstName(){
        String firstName = testDataProp.getProperty("driverFirstName");
        click(addDriverInputFields.get(0));
        enterText(addDriverInputFields.get(0), firstName );
    }
     public void enterMiddleName(){
         String middleName = testDataProp.getProperty("driverMiddleName");
        click(addDriverInputFields.get(1));
        enterText(addDriverInputFields.get(1), middleName );
     }

     public void enterSurname(){
         String surname = testDataProp.getProperty("driverSurname");
         click(addDriverInputFields.get(2));
         enterText(addDriverInputFields.get(2), surname);
     }
    public void enterEmail(){
        String email = testDataProp.getProperty("driverEmail");
        click(addDriverInputFields.get(3));
        enterText(addDriverInputFields.get(3), email);
    }
    public void enterPhone(){
        String phoneNumber = testDataProp.getProperty("driverPhoneNumber");
        click(addDriverInputFields.get(4));
        enterText(addDriverInputFields.get(4), phoneNumber);
    }
    public void enterHomeAddress(){
        String address = testDataProp.getProperty("driverAddress");
        click(addDriverInputFields.get(5));
        enterText(addDriverInputFields.get(5), address);
//        findRightAddDriverIndexDuringScreenChange(5,addDriverInputFields.get(5), address);
    }
    public void enterDateOfBirth(){
        String dateOfBirth = testDataProp.getProperty("dateOfBirth");
        clickDateOfBirthField();
        clickEditDateIcon();
        clickDateOfBirthInputField();
        clearDateOfBirthInputField();
        enterDateOfBirth(dateOfBirth);
        clickOkBtn();
    }
    public void enterLicenseNumber() {
        String licenseNumber = testDataProp.getProperty("driverLicenseNumber");
        WebElement licenseNumField = findDriversLicenseNameField(-1);
        licenseNumField.click();
        licenseNumField.clear();
        licenseNumField.sendKeys(licenseNumber);
    }
    public void enterDriverRenewalDate(){
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(1)"));
        String licenseRenewalDate = testDataProp.getProperty("licenseRenewalDate");
        clickLicenseRenewalDate();
        clickEditDateIcon();
        clickLicenseRenewalDateInputField();
        clearLicenseRenewalDateInputField();
        enterLicenseRenewalDate(licenseRenewalDate);
        clickOkBtn();
    }

    public void enterDriverDisgnation(){
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(1)"));
        String designation = testDataProp.getProperty("driverDesignation");
        clickDesignationField();
        selectDesignation(designation);

    }
    public void enterAnnualGross(){
        String annualGross = testDataProp.getProperty("driverAnnualGross");
        WebElement annualGrossField = findAnnualGrossField();
        if(annualGrossField != null) {
            annualGrossField.click();
            annualGrossField.clear();
            annualGrossField.sendKeys(annualGross);
        }
        clickNextBtn();
    }

    public WebElement getscrollElement(){
        return  scrollElement;

    }
    public  List <WebElement>returnAllRegions(){
        return allRegions;
    }

    public void clickBackArrow(){
        click(backArrow);
    }

    public void clickCloseRegionDropDown(){
        click(closeRegionDropDown);
    }

    public WebElement returnBackArrow(){
        return  backArrow;

    }



}
