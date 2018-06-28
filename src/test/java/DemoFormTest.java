import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DemoFormTest {
    @Test
    public void messageText() {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html");

        WebElement messageInput = driver.findElement(By.id("user-message"));
        messageInput.sendKeys("123");

        WebElement sendMessage = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/form/button"));
        sendMessage.click();

        WebElement messageText = driver.findElement(By.id("display"));
        String message = messageText.getText();

        assert message.equals("123");
        driver.quit();


    }

    @Test
    public void sum() {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html");

        WebElement sum1 = driver.findElement(By.id("sum1"));
        sum1.sendKeys("16");

        WebElement sum2 = driver.findElement(By.id("sum2"));
        sum2.sendKeys("36");

        WebElement getTotal = driver.findElement(By.cssSelector("button.btn:nth-child(3)"));
        getTotal.click();

        WebElement showTotal = driver.findElement(By.id("displayvalue"));
        String total = showTotal.getText();

        assert total.equals("52");
        driver.quit();


    }


}
