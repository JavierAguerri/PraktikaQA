package com.javieraguerri.praktika.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

import static com.javieraguerri.praktika.utils.Constants.*;
import static com.javieraguerri.praktika.utils.Constants.LOCAL_APPIUM_URL;

public class DriverManager {

    private static AppiumDriver driver;

    public static void initialize(String platform) throws MalformedURLException {
        if (driver == null) {
            driver = startDriver(platform);
        }
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException(DRIVER_IS_NOT_INITIALIZED_CALL_INITIALIZE_FIRST);
        }
        return driver;
    }

    private static AppiumDriver startDriver(String platform) throws MalformedURLException {
        if(ANDROID_PLATFORM_NAME.equalsIgnoreCase(platform)) {
            return startAppium_Android();
        } else if (IOS_PLATFORM_NAME.equalsIgnoreCase(platform)) {
            return startAppium_iOS();
        } else {
            throw new IllegalArgumentException(UNKNOWN_PLATFORM_SPECIFIED + platform);
        }
    }

    public static AndroidDriver startAppium_Android() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(ANDROID_PLATFORM_NAME)
                .setUdid(ANDROID_DEVICE_UDID)
                .setDeviceName(ANDROID_DEVICE_NAME)
                .setAutomationName(UI_AUTOMATOR_2_NAME)
                .setAppPackage(ANDROID_APP_PACKAGE)
                .setApp(APK_PATH)
                .setFullReset(true);
        options.setCapability("appium:disableIdLocatorAutocompletion", true);
        return new AndroidDriver(new URL(LOCAL_APPIUM_URL), options);
    }

    public static AndroidDriver startAppium_iOS() {
        return null;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
