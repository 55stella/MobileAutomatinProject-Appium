package FMASprint1.Android;

import BaseClasses.TestBase;
import FMASprint1.Android.Pages.PolicyNoticePage;
import FMASprint1.Android.Pages.SignInPage;

public class LoginToDashboard extends TestBase {

    public void login() {
        PolicyNoticePage policyNoticePage = new PolicyNoticePage(driver);
        SignInPage signInPage = new SignInPage(driver);

        policyNoticePage.clickCheckBox();
        policyNoticePage.clickOkay();
        turnOffImplicitWait();
        if(policyNoticePage.permissionOkay.size() > 0) {
            policyNoticePage.clickPermissionOkay();
        }
        turnOnImplicitWait();
        signInPage.clickEmailField();
        signInPage.enterEmail(testDataProp.getProperty("Admin"));
        signInPage.clickSignInBtn();
    }
}
