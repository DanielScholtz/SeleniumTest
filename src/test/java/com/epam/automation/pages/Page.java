package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Page {
    final WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void goByLinkText(String mainMenuItem, String subMenuItem) {
        driver.findElement(By.linkText(mainMenuItem)).click();
        driver.findElement(By.linkText(subMenuItem)).click();
    }
}
