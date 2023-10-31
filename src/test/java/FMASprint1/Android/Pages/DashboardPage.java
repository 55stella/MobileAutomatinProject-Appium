package FMASprint1.Android.Pages;

import BaseClasses.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPage extends PageBase {
    public DashboardPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(accessibility = "More Tasks")
    public WebElement moreTasks;


    @AndroidFindBy(accessibility = "Open navigation menu")
    WebElement dashboardProfileMenu;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='View Requests']/..")
    List<WebElement>quickAccessTiles;
    public void selectMoreTasks() {
        click(moreTasks);
    }
    public void clickdashboardProfileMenu(){
        click(dashboardProfileMenu);
    }



}
