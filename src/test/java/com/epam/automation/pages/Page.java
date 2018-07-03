package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Page {
    Logger log = LoggerFactory.getLogger(Page.class);
    final WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goByLinkText(String mainMenuItem, String subMenuItem) {
        driver.findElement(By.linkText(mainMenuItem)).click();
        driver.findElement(By.linkText(subMenuItem)).click();
    }
}
