package com.epam.automation;

import com.epam.automation.core.DriverProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class BasicTest {
    Logger log = LoggerFactory.getLogger(BasicTest.class);
    WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {
        driver = DriverProvider.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(Method method, ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(testResult);
        }
        driver.quit();
    }

    private void takeScreenshot(ITestResult testResult) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String pathname = "screenshots/" + testResult.getInstanceName() + "-" + testResult.getName() + ".png";
        try {
            FileUtils.moveFile(screenshot, new File(pathname));
        } catch (IOException e) {
            log.error("Screenshot cannot be created", e);
        }
    }

}
