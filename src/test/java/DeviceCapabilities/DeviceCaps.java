package DeviceCapabilities;

import BaseClasses.TestBase;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DeviceCaps extends TestBase {
    public DeviceCaps() {
        super();
    }
    public static void SamsungA32() {
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("udid", "RZ8T30532KZ");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "samsung SM-A325F");
        caps.setCapability("appPackage", "com.mtn.ppk");
        caps.setCapability("appActivity", "com.mtn.ppk.MainActivity");
        caps.setCapability("autoGrantPermissions", false);
        caps.setCapability("unicodeKeyboard", true);
        caps.setCapability("resetKeyboard", true);
        caps.setCapability("noReset", false);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
    }

    public static void Infinix12() {
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("udid", "088073727E001356");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Infinix HOT 12i");
        caps.setCapability("appPackage", "com.mtn.ppk");
        caps.setCapability("appActivity", "com.mtn.ppk.MainActivity");
        caps.setCapability("autoGrantPermissions", false);
        caps.setCapability("unicodeKeyboard", true);
        caps.setCapability("resetKeyboard", true);
        caps.setCapability("noReset", false);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
    }
    public static void TecnoNote5() {
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("udid", "032852586O002272");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("deviceName", "Infinix X604");
        caps.setCapability("appPackage", "com.mtn.ppk");
        caps.setCapability("appActivity", "com.mtn.ppk.MainActivity");
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("noReset", false);

    }
    public static void TecnoCamon19() {
        caps = new DesiredCapabilities();
//        caps.setCapability(MobileCapabilityType.UDID, "061172513H008297");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "TECNO CAMON 19");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.mtn.ppk");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.mtn.ppk.MainActivity");
        caps.setCapability("unicodeKeyboard", true);
        caps.setCapability("resetKeyboard", true);
//        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 40);
        caps.setCapability("noReset", false);
    }



}
