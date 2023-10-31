package FMASprint1.Android.Pages;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SignInPage extends PageBase {
    public SignInPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Sign In\"]/android.view.View[2]/android.view.View/android.widget.EditText")
    WebElement emailField;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Sign in\"]")
    WebElement signInBtn;
    @AndroidFindBy(accessibility = "External")
    public WebElement external;
    @AndroidFindBy(accessibility = "Internal")
    public WebElement internal;
    @AndroidFindBy(accessibility = "Enter a valid email")
    public WebElement blankEmailErrorMsg;
    @AndroidFindBy(accessibility = "Okay")
    WebElement okayBtn;
    @AndroidFindBy(accessibility = "No user record found")
    public WebElement userNotFound;

    public void clickSignInBtn() {
        click(signInBtn);
    }
    public void clickEmailField() {
        click(emailField);
    }
    public void enterEmail(String email) {
        enterText(emailField, email);
    }
    public void clickOkBtn() {
        click(okayBtn);
    }
    public void clearEmailField() {
        clearTextField(emailField);
    }
}
