package FMASprint1.Android.Pages.DriverMgt;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DriversListPage  extends PageBase {
    public DriversListPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @CacheLookup
    @FindBy(className = "android.widget.ScrollView")
    WebElement scrollInDriversPage;

    @FindBy(xpath = "//android.view.View[@content-desc='John O0h\n" +
            "08012345600\n" +
            "Active\n" +
            "Lagos']/../*")
    List< WebElement> driversList;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Driver List\"]//../*[1]")
    WebElement driversListPageBackArrow;


    public  List <WebElement> returnDriversList(){
        return  driversList;
    }

    public  WebElement returnDriverListScrollElement(){
        return  scrollInDriversPage;
    }

    public void clickOnDriverDetails(){
        click(driversList.get(0));
    }
    public WebElement returnBackArrow(){
        return  driversListPageBackArrow;
    }
    public void clickBackArrow(){
        click(driversListPageBackArrow);
    }

}
