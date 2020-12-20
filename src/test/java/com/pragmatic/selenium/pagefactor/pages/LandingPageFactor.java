package com.pragmatic.selenium.pagefactor.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageFactor {

    private final WebDriver driver;

    @FindBy(id = "welcome")
    WebElement welcomeMsg;


    public LandingPageFactor(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getWelcomeMessage() {
        String welcomeMessage = welcomeMsg.getText();
        return welcomeMessage;
    }
}
