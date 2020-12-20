package com.pragmatic.selenium.pageobject.pages;

import com.pragmatic.selenium.other.HRMConstants;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {

    private final WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public LoginPageObject typeUsername(String username) {
        driver.findElement(HRMConstants.TXT_USERNAME).sendKeys(username);
        return this;
    }

    public LoginPageObject typePassword(String password) {
        driver.findElement(HRMConstants.TXT_PASSWORD).sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        driver.findElement(HRMConstants.BTN_LOGIN).click();
    }

    public String getErrorMsg() {
        String errorMessage = driver.findElement(HRMConstants.ERROR_MESSAGE).getText();
        return errorMessage;
    }
}
