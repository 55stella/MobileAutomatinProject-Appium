package BaseClasses;

import DeviceCapabilities.DeviceCaps;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static AppiumDriver driver;
    public static DesiredCapabilities caps;
    public static String filePath_testDataProp = "src/test/java/TestData.properties";
    public static String filePath_deviceProp = "src/test/java/device.properties";
    public static FileInputStream fis;
    public static FileInputStream fis2;
    public static Properties testDataProp;
    public static Properties deviceProp;
    public static String device;

  
    public TestBase() {
        loadPropFile();
    }

    public static void loadPropFile() {
        testDataProp = new Properties();
        deviceProp = new Properties();
        try {
            fis = new FileInputStream(filePath_testDataProp);
            fis2 = new FileInputStream(filePath_deviceProp);
            testDataProp.load(fis);
            deviceProp.load(fis2);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mainSetup() {
        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/"), caps);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void turnOffImplicitWait() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    public void turnOnImplicitWait() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void validateAttribute(WebElement element,String attribute,Boolean value){
        try{
            Assert.assertTrue(Boolean.parseBoolean(element.getAttribute(attribute))==value);
        } catch (Exception e){
            throw new AssertionError(e);
        }
    }
    public void validateText(WebElement element, String message) {
        String actualMessage = "";
        try {
            actualMessage = element.getText();
            Assert.assertTrue(actualMessage.contains(message));
            System.out.println(actualMessage);
        }catch (AssertionError | NoSuchElementException e) {
            System.out.println("Expect " + actualMessage + " to contain "+ message);
            throw new AssertionError(e);
        }
    }

    public static void validateContentDesc(WebElement element, String expectedContentDesc) {
        String actualContentDesc = "";
        try {
            actualContentDesc = element.getAttribute("content-desc");
            Assert.assertTrue(actualContentDesc.contains(expectedContentDesc));
            System.out.println("Actual Content Desc: " + actualContentDesc);
        } catch (AssertionError | java.util.NoSuchElementException e) {
            System.out.println("Expected Content Desc: " + expectedContentDesc + " but found: " + actualContentDesc);
            throw new AssertionError(e);
        }
    }
    public void DynamicWait(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void flingGesture(WebElement el, String direction ) {
        ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) el).getId(),
                "direction", direction,
                "speed", 1800
        ));
    }

    public void ScrollGesture(WebElement el, String direction, double percent) { //percent is the amount of screen to scroll
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) el).getId(),
                "direction", direction,
                "percent", percent

        ));
    }
    public void scrollGesture(WebElement el, String direction, int speed, double percent) { //percent is the amount of screen to scroll
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) el).getId(),
                "direction", direction,
                "percent", percent,
                "speed", speed
                ));
    }

    public void ScrollToEndAction() {
        boolean canScrollMore;
        do{
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 372, "top", 1800, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }while(canScrollMore);
    }
  
    public void ScrollToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
    }

    public String convertDateFormat(String inputDate) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
            Date date = inputFormat.parse(inputDate);

            SimpleDateFormat outputFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    @BeforeClass
    public void setup() {
        device = deviceProp.getProperty("device1");
        try {
            switch (device) {
                case "SamsungA32":
                    DeviceCaps.SamsungA32();
                    break;
                case "Infinix12":
                    DeviceCaps.Infinix12();
                    break;
                case "TecnoNote5":
                    DeviceCaps.TecnoNote5();
                    break;
                case "TecnoCamon19":
                    DeviceCaps.TecnoCamon19();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            mainSetup();
        }
    }

    @AfterClass
    public void tearDown() {
        if(null != driver) {
            driver.quit();
        }
    }
}
