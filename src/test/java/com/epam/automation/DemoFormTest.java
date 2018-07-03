package com.epam.automation;

import com.epam.automation.pages.DemoFormPage;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;


public class DemoFormTest extends BasicTest {


    @Test
    public void messageText() {
            DemoFormPage demoFormPage = new DemoFormPage(driver);
            String message = demoFormPage.messageVisualizer("123");
            assertThat(message).isEqualTo("123");
    }

    @Test
    public void sum() {
        DemoFormPage demoFormPage = new DemoFormPage(driver);
        int sum = demoFormPage.add(13,25);
        assertThat(sum).isEqualTo(38);
    }


}
