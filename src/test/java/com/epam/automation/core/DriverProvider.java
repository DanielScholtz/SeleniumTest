package com.epam.automation.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

public class DriverProvider  {
    public static WebDriver getDriver() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            throw new Error("The Java Property 'browser' is incorrect: " +browser+" , please run the application with -Dbrowser=<browser>, where " +
                    "allowed values for browser: " +BrowserType.CHROME+", " +BrowserType.FIREFOX );
        }
        switch (browser) {
            case BrowserType.FIREFOX:
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                return new FirefoxDriver();
            case BrowserType.CHROME:
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                return new ChromeDriver();
            default:
                throw new Error("The Java Property 'browser' is incorrect: " +browser+" , please run the application with -Dbrowser=<browser>, where " +
                        "allowed values for browser: " +BrowserType.CHROME+", " +BrowserType.FIREFOX );
        }

    }
}
