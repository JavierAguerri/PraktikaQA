package com.javieraguerri.praktika.utils;

public class Constants {

    public static final String APK_PATH = System.getProperty("user.dir") + "/src/test/resources/praktika_3.13.0.apk";
    public static final String LOCAL_APPIUM_URL = "http://127.0.0.1:4723";

    // Android emulator
    public static final String ANDROID_PLATFORM_NAME = "Android";
    public static final String ANDROID_DEVICE_UDID = "emulator-5554";
    public static final String ANDROID_DEVICE_NAME = "praktikaEmulator";
    public static final String ANDROID_APP_PACKAGE = "ai.praktika.android";
    public static final String UI_AUTOMATOR_2_NAME = "UiAutomator2";

    // iOS simulator
    public static final String IOS_PLATFORM_NAME = "iOS";

    // Exception messages
    public static final String UNKNOWN_PLATFORM_SPECIFIED = "Unknown platform specified: ";
    public static final String DRIVER_IS_NOT_INITIALIZED_CALL_INITIALIZE_FIRST = "Driver is not initialized. Call initialize() first.";

    // Others
    public static final String LANGUAGE_CHANGED = "LanguageChanged";

}
