package com.epam.automation;

import com.epam.automation.enums.MainMenuItem;
import com.epam.automation.enums.SubMenuItem;
import com.epam.automation.pages.CheckboxPage;
import com.epam.automation.pages.DemoFormPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest extends  BasicTest {

    @Test
    public void toAndBackNavigationTest() {
        DemoFormPage formDemoPage = new DemoFormPage(driver);
        assertThat(driver.getTitle()).isEqualTo("Selenium Easy Demo - Simple Form to Automate using Selenium");
        formDemoPage.goByLinkText(MainMenuItem.DATE_PICKERS, SubMenuItem.BOOTSTRAP_DATE_PICKER);
        assertThat(driver.getTitle()).isEqualTo("Selenium Easy - Best Demo website for Bootstrap Date picker");

        CheckboxPage checkboxPage = new CheckboxPage(driver);
        checkboxPage.goByLinkText(MainMenuItem.TABLE, SubMenuItem.TABLE_PAGINATION);

    }

}

//*[@id="select-box-location-1n-container"]
//*[@id="select-box-location-ra-container"]
//*[@id="select-box-location-vw-container"]

