package com.epam.automation.pages;

import org.openqa.selenium.WebDriver;

public class CheckboxPage extends Page {

    public CheckboxPage(WebDriver driver) {
        super(driver);
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    }
}
