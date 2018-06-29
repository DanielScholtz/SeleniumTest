package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoFormPage extends Page {

    public DemoFormPage(WebDriver driver) {
        super(driver);
        driver.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
    }

    @Test
    public int add(Integer a, Integer b) {
        WebElement operandA = driver.findElement(By.id("sum1"));
        operandA.sendKeys(a.toString());
        WebElement operandB = driver.findElement(By.id("sum2"));
        operandB.sendKeys(b.toString());

        WebElement getTotal = driver.findElement(By.cssSelector("button.btn:nth-child(3)"));
        getTotal.click();

        WebElement sum = driver.findElement(By.id("displayvalue"));
        return Integer.parseInt(sum.getText());
    }


    public String messageVisualizer(String message) {
        WebElement messageInput = driver.findElement(By.id("user-message"));
        messageInput.sendKeys(message);

        WebElement sendMessage = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/form/button"));
        sendMessage.click();

        WebElement messageText = driver.findElement(By.id("display"));
        return messageText.getText();
    }

    @Test
    public void toAndBackNavigationTest() {
        DemoFormPage formDemoPage = new DemoFormPage(driver);
        assertThat(driver.getTitle()).isEqualTo("Selenium Easy Demo - Simple Form to Automate using Selenium");
        formDemoPage.goByLinkText("Date pickers", "Bootstrap Date Picker");
        assertThat(driver.getTitle()).isEqualTo("Selenium Easy - Best Demo website for Bootstrap Date picker");

    }
}
