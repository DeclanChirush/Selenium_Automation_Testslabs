package com.pragmatic.selenium.pageobject.pages;

import com.pragmatic.selenium.other.HRMConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    private final WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getWelcomeMessage() {
        String welcomeMessage = driver.findElement(HRMConstants.WELCOME_MESSAGE).getText();
        return welcomeMessage;
    }

}
