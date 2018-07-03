package com.epam.automation.pages;

import com.epam.automation.enums.MainMenuItem;
import com.epam.automation.enums.SubMenuItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoFormPage extends Page {

    @FindBy(id = "sum1")
    private WebElement operandA;
    @FindBy(id = "sum2")
    private WebElement operandB;
    @FindBy(css = "button.btn:nth-child(3)")
    private WebElement getTotal;
    @FindBy(id = "displayvalue")
    private WebElement sum;
    @FindBy(id = "user-message")
    private WebElement messageInput;
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[1]/div[2]/form/button")
    private WebElement sendMessage;
    @FindBy(id = "display")
    private WebElement messageText;


    public DemoFormPage(WebDriver driver) {
        super(driver);
        driver.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
        log.info("Demo Form Page has been opened");
    }

    @Test
    public int add(Integer a, Integer b) {
        operandA.sendKeys(a.toString());
        operandB.sendKeys(b.toString());
        getTotal.click();
        return Integer.parseInt(sum.getText());
    }


    public String messageVisualizer(String message) {
        messageInput.sendKeys(message);
        sendMessage.click();
        return messageText.getText();
    }

    @Test
    public void toAndBackNavigationTest() {
        DemoFormPage formDemoPage = new DemoFormPage(driver);
        assertThat(driver.getTitle()).isEqualTo("Selenium Easy Demo - Simple Form to Automate using Selenium");
        formDemoPage.goByLinkText(MainMenuItem.DATE_PICKERS, SubMenuItem.BOOTSTRAP_DATE_PICKER);
        assertThat(driver.getTitle()).isEqualTo("Selenium Easy - Best Demo website for Bootstrap Date picker");

    }
}
