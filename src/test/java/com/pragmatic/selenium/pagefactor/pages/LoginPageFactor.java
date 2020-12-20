package com.pragmatic.selenium.pagefactor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactor {

    private final WebDriver driver;

    //Define the element
    @FindBy(id = "txtUsername")
    WebElement txtUsername;

    @FindBy(id = "txtPassword")
    WebElement txtPassword;

    @FindBy(id = "btnLogin")
    WebElement btnLogin;

    @FindBy(id = "spanMessage")
    WebElement spanMessage;

    public LoginPageFactor(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    public LoginPageFactor typeUsername(String username) {
        txtUsername.sendKeys(username);
        return this;
    }

    public LoginPageFactor typePassword(String password) {
        txtPassword.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        btnLogin.click();
    }

    public String getErrorMessage() {
        String errorMessage = spanMessage.getText();
        return errorMessage;

    }
    public LoginPageFactor clearUsername() {
        txtUsername.clear();
        return this;
    }

    public LoginPageFactor clearPassword() {
        txtPassword.clear();
        return this;
    }
}
