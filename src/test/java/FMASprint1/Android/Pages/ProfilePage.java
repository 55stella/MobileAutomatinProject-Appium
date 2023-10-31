package FMASprint1.Android.Pages;

import BaseClasses.PageBase;
import BaseClasses.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProfilePage extends PageBase {


    public ProfilePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

  @AndroidFindBy(xpath = "//*[contains(@text, 'Edit Profile')]")
  WebElement editProfile;
    public void clickEditProfile(){
        click(editProfile);
        System.out.println(editProfile.getText());
    }



}
