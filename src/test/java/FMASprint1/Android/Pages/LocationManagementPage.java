package FMASprint1.Android.Pages;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LocationManagementPage extends PageBase {
    public LocationManagementPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }



    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button")
    WebElement addlocationbutton;
    @AndroidFindBy(accessibility = "Location")
     public WebElement locationtext;

    @AndroidFindBy(accessibility = "Add Location")
    public  WebElement addLocation;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='e.g Enter location name']")
     WebElement locationNameInputField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='TestLocation2']")
    public WebElement enteredLocationName;

    @AndroidFindBy(accessibility = "Kano")
    WebElement locationRegionDropdown;

    @AndroidFindBy(accessibility = "Port Harcourt")
    public  WebElement porthaCourtOption;

    @AndroidFindBy(accessibility = "Rivers")
     public WebElement openStateDropdown;


//     Submit LocationElement
    @AndroidFindBy(accessibility = "Submit")
    WebElement submitLocationButton;

//    success message Element After Location Creation Success

    @AndroidFindBy(accessibility ="Success\n" +
            "Success" )
     public WebElement locationCreationSuccess;

//    Update button
    @AndroidFindBy(accessibility = "Edit")
    WebElement editLocation;
    @AndroidFindBy(accessibility = "Update")
    WebElement update;
    @AndroidFindBy(accessibility = "Success!\n" +
            "Success")
    public WebElement updateSuccess;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Lekki\n" +
            "Rivers\"]")
    WebElement openeLocationButton;








//    Methods

    public void clickPlusbutton(){
        click(addlocationbutton);

    }

    public void clickLocationNameInputField(){
        click(locationNameInputField);
    }



    public void sendLocationName(){
        enterText(locationNameInputField, "TestLocation2");
    }

    public void clickLocationRegionDropdown(){
        click(locationRegionDropdown);
    }

    public void selectPhOption(){
        click(porthaCourtOption);
    }

    public void openstatedropdownandclickstateoption(){
        click(openStateDropdown);
//        select option after dropdown is opened
        click(openStateDropdown);
    }

    public void clickSubmitLocationButton(){
        click(submitLocationButton);
    }

    public void clickEditbutton(){
        click(editLocation);
    }

    public void clickUpdate(){
        click(update);
    }


    public void clickOpenLocation(){
        click(openeLocationButton);

    }




}
