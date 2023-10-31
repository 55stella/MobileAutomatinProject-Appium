package FMASprint1.Android.Tests;

import BaseClasses.TestBase;
import FMASprint1.Android.Pages.DashboardPage;
import FMASprint1.Android.Pages.LandingPage;
import FMASprint1.Android.Pages.PolicyNoticePage;
import FMASprint1.Android.Pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class Login extends TestBase {

    PolicyNoticePage policyNoticePage;
    SignInPage signInPage;
    LandingPage landingPage;
    DashboardPage dashboardPage;

    public void initializer() {
        policyNoticePage = new PolicyNoticePage(driver);
        signInPage = new SignInPage(driver);
        landingPage = new LandingPage(driver);
        dashboardPage = new DashboardPage(driver);
 }
    @Test(priority = 1 , description ="Validate that the okay button is not clickable when checkbox is unchecked")
    public void validateOkButtonNotClickableWhenCheckBoxIsUnchecked(Method method){
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Login");

        initializer();
        validateAttribute(policyNoticePage.okay, "clickable", false);
    }
    @Test(priority = 2, description = "validate that after user clicks the check box, the okay button will be clickable")
    public void validateUserCanProceedAfterCheckingCheckBox(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Login");

        policyNoticePage.clickCheckBox();
        validateAttribute(policyNoticePage.okay, "clickable", true);
    }
    @Test(priority = 3, description = "Validate user can see the internal and external tabs")
    public void validateInternalAndExternalTabsAreVisible(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Login");

        policyNoticePage.clickOkay();
        turnOffImplicitWait();
        if(policyNoticePage.permissionOkay.size() > 0) {
            policyNoticePage.clickPermissionOkay();
        }
        turnOnImplicitWait();
        validateAttribute(signInPage.external, "displayed", true);
        validateAttribute(signInPage.internal, "displayed", true);
    }
    @Test(priority = 4, description = "Validate that user cannot sign in with empty email field")
    public void validateUserCannotLoginWithEmptyEmptyEmailField(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Login");

        signInPage.clickEmailField();
        signInPage.clickSignInBtn();
        validateAttribute(signInPage.blankEmailErrorMsg, "displayed", true);
    }
    @Test(priority = 5, description = "Validate that user cannot login with invalid email address")
    public void validateUserCannotLoginWithInvalidEmail(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Login");

        signInPage.clickOkBtn();
        signInPage.enterEmail(testDataProp.getProperty("invalidEmail"));
        signInPage.clickSignInBtn();
        validateAttribute(signInPage.userNotFound, "displayed", true);
    }
    @Test(priority = 6, description = "Validate that User can sign in with valid email address")
    public void validateUserCanLoginWithValidEmail(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Login");

        signInPage.clickOkBtn();
        signInPage.clickEmailField();
        signInPage.clearEmailField();
        signInPage.enterEmail(testDataProp.getProperty("Admin"));
        signInPage.clickSignInBtn();
        Assert.assertTrue(landingPage.services.size() == 4);
    }
    @Test(priority = 7, description = "Validate More tasks tile is visible and clickable")
    public void validateMoreTabIsDisplayedAndClickable(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Admin-Management");

        landingPage.selectFleetManagement();
        validateAttribute(dashboardPage.moreTasks, "displayed", true);
        validateAttribute(dashboardPage.moreTasks, "clickable", true);
        sleep(5);
    }
}
