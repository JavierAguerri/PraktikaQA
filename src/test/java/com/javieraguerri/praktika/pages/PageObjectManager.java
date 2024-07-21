package com.javieraguerri.praktika.pages;

import com.javieraguerri.praktika.utils.DriverManager;
import io.appium.java_client.AppiumDriver;

import static com.javieraguerri.praktika.utils.Constants.*;

public class PageObjectManager {

    private static PageObjectManager instance;
    private final AppiumDriver driver;
    private WelcomePage welcomePage;
    private PermissionsPage permissionsPage;
    private OnboardingGenderPage onboardingGenderPage;
    private OnboardingAgePage onboardingAgePage;
    private OnboardingNamePage onboardingNamePage;
    private OnboardingLanguagePage onboardingLanguagePage;
    private OnboardingInterestsPage onboardingInterestsPage;

    private PageObjectManager() {
        this.driver = DriverManager.getDriver();
    }

    public static PageObjectManager getInstance() {
        if (instance == null) {
            instance = new PageObjectManager();
        }
        return instance;
    }

    public PermissionsPage getPermissionsPage() {
        if (permissionsPage == null) {
            String platform = driver.getCapabilities().getPlatformName().toString();
            if (ANDROID_PLATFORM_NAME.equalsIgnoreCase(platform)) {
                permissionsPage = new AndroidPermissionsPage(driver);
            }
            else if (IOS_PLATFORM_NAME.equalsIgnoreCase(platform)) {
                permissionsPage = new IosPermissionsPage(driver);
            } else {
                throw new RuntimeException(platform);
            }
        }
        return permissionsPage;
    }

    public <T> T getPage(Class<T> pageClass) {
        try {
            T page = pageClass.getDeclaredConstructor(AppiumDriver.class).newInstance(driver);
            return page;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create page: " + pageClass.getSimpleName(), e);
        }
    }
}
