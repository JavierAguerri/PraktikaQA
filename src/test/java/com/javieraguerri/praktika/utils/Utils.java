package com.javieraguerri.praktika.utils;

import com.javieraguerri.praktika.steps.PermissionsSteps;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {
    private static final Logger logger = LogManager.getLogger(PermissionsSteps.class);

    public static File takeScreenshot(String name) {
        File screenshot = DriverManager.getDriver().getScreenshotAs(OutputType.FILE);
        Path destPath = Paths.get("target", "screenshots", name + ".png");
        try {
            Files.createDirectories(destPath.getParent());
            Files.copy(screenshot.toPath(), destPath);
        } catch (IOException e) {
            logger.warn("Failed screenshot: {}", e.getMessage());
        }
        return destPath.toFile();
    }

    public static void attachScreenshot(File screenshotFile, String name) {
        try {
            byte[] screenshotBytes = Files.readAllBytes(screenshotFile.toPath());
            Allure.addAttachment(name, new ByteArrayInputStream(screenshotBytes));
        } catch (IOException e) {
            logger.warn("Failed to attach screenshot {}: {}", name, e.getMessage());
        }
    }

    public static void createAndAttachScreenshot(String name) {
        File screenshot = takeScreenshot(name);
        attachScreenshot(screenshot, name);
    }

}
