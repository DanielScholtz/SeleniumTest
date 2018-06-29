package com.epam.automation;

import com.epam.automation.pages.CheckboxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckboxTest extends BasicTest {

    @Test
    public void singleCheckboxTest() {
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        driver.findElement(By.id("isAgeSelected")).click();
        assertThat(driver.findElement(By.id("txtAge")).getText()).isEqualTo("Success - Check box is checked");
        List<WebElement> checkboxes = driver.findElements(By.id("txtAge"));
        assertThat(checkboxes.size()).isGreaterThan(0);
        assertThat(checkboxes.get(0).isDisplayed()).isTrue();

    }
}
