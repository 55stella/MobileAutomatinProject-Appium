package FMASprint1.Android.Pages.VehicleMgt;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


public class CarPark_JettyPage extends PageBase {
    public CarPark_JettyPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }



    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Car Park-Jetty\"]")
     public WebElement carParkOrJettyText;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button")
     WebElement addButton;



    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Fill in the following Information below:\n" +
            "Name *\n" +
            "Region * \n" +
            "State * \n" +
            "Location Name *\n" +
            "Address *\n" +
            "Assignee/Control Room Phone No. *\n" +
            "Assignee/Control Room Email *\"]/android.widget.EditText[2]")
    WebElement adminAddaddress;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='e.g Enter Email Address']")
    public WebElement controlRoomemail;


    @AndroidFindBy(xpath = "//android.widget.EditText[@text='stellarichards7@gmail.com']")
    public WebElement emailAddress;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Fill in the following Information below:\n" +
            "Name *\n" +
            "Region * \n" +
            "State * \n" +
            "Location Name *\n" +
            "Address *\n" +
            "Assignee/Control Room Phone No. *\n" +
            "Assignee/Control Room Email *\"]/android.widget.EditText[2]")
     public WebElement address;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='e.g Enter Phone Number']")
    public WebElement  assigneePhonenumber;


    @AndroidFindBy(xpath = "//android.widget.EditText[@text='08132374056']")
    public WebElement enteredPhonenumber;

    @AndroidFindBy(xpath= "//android.view.View[@content-desc=\"Add Car Park-Jetty\"]")
    public WebElement addcarParkorjetty;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='e.g Enter Name']")
     public WebElement addnameCarparkjetty;

    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc=\"Kano\"])[1]")
    WebElement regionDropdown;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Rivers\"]")
    WebElement stateDropdown;

    @AndroidFindBy(accessibility = "Onne Two")
    WebElement locationDropdown;


    @AndroidFindBy(accessibility = "Port Harcourt")
    WebElement phRegionOption;

    @AndroidFindBy(accessibility = "Rivers")
     public WebElement riversOption;

    @AndroidFindBy(accessibility = "Onne Two")
    WebElement onetwoOption;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='TestLocation2']")
    public WebElement carparkName;

    @AndroidFindBy(accessibility = "Port Harcourt")
    public WebElement regionName;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Rivers\"]")
     public WebElement stateName;

    @AndroidFindBy(accessibility = "Onne Two")
    public WebElement locationName;

    @AndroidFindBy(accessibility = "Car Park\n" +
            "Onne Two")
    WebElement openCarPark;

    @AndroidFindBy(accessibility = "Edit")
    WebElement editCarPark;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Edit Car Park-Jetty\"]")
     public WebElement editcarParkpage;

//  ----  #Submit button

    @AndroidFindBy(accessibility = "Submit")
    WebElement submitbtn;

//     #Update car PArk/jetty
    @AndroidFindBy(accessibility = "Update")
    WebElement updatebtn;

    @AndroidFindBy(accessibility = "Success\n" +
            "Success")
    public WebElement updatesucessmessage;

//    // #CarPark/Jetty Registration confirmation Element

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Success\n" +
            "Success\"]")
    public  WebElement  carparkregistrationsucess;













//    # Methods


    public void clickaddbutton(){
        click(addButton);
    }


    public  void setOpencarpark(){
        click(openCarPark);
    }

    public  void clickeditcarparkbutton(){
        click(editCarPark);
    }




    public void sendCarParkname(){
        click(addnameCarparkjetty );
        enterText(addnameCarparkjetty, "TestLocation2");
    }




    public void sendAddress(){
        click(adminAddaddress);
        enterText(adminAddaddress, "39a adebayo Doherty .");
    }

    public void clickRegionDropdown(){
        click(regionDropdown);
    }

    public void clickstatedropdown(){
        click(stateDropdown);
    }


    public void clickphregionoption(){
        click(phRegionOption);
    }


    public void clickriversoption(){
        click(riversOption);
    }

    public void clickloactionNamedropdown(){
        click(locationDropdown);
    }


     public void clickonetwooption(){
        click(onetwoOption );
     }

     public void sendAsigneePhonenumber(){
        click(assigneePhonenumber);
        enterText(assigneePhonenumber, "08132374056");
     }


     public void sendAsigneeEmailAddress(){
        click(controlRoomemail);
        enterText(controlRoomemail, "stellarichards7@gmail.com" );
     }

     public void clicksubmitbtn(){
        click(submitbtn);
     }

     public void clickUpdatebtn(){
        click(updatebtn);
     }








}

