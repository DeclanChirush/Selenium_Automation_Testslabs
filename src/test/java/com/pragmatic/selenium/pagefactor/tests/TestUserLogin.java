package com.pragmatic.selenium.pagefactor.tests;

import com.pragmatic.selenium.other.HRMConstants;
import com.pragmatic.selenium.pagefactor.pages.LandingPageFactor;
import com.pragmatic.selenium.pagefactor.pages.LoginPageFactor;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestUserLogin {

    private static final String BASE_URL = HRMConstants.BASE_URL;
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
    }


    @Test
    public void testValidUserLogin(){
    //Login page object creation
        LoginPageFactor loginPageFactor = new LoginPageFactor(driver);

        loginPageFactor.typeUsername(HRMConstants.USERNAME)
                .typePassword(HRMConstants.PASSWORD)
                .clickLoginButton();

        LandingPageFactor landingPageFactor = new LandingPageFactor(driver);

        Assert.assertEquals(landingPageFactor.getWelcomeMessage(),"Welcome Admin");

    }
    @Test
    public void testUserLoginWithoutUsernameAndPassword(){
        //Login page object creation
        LoginPageFactor loginPageFactor = new LoginPageFactor(driver);

        loginPageFactor.clearUsername()
                .clearPassword()
                .clickLoginButton();

        LandingPageFactor landingPageFactor = new LandingPageFactor(driver);

        Assert.assertEquals(loginPageFactor.getErrorMessage(),"Username cannot be empty");

    }

    @Test
    public void testUserLoginWithoutPassword(){
        //Login page object creation
        LoginPageFactor loginPageFactor = new LoginPageFactor(driver);

        loginPageFactor.typeUsername(HRMConstants.USERNAME)
                .clearPassword()
                .clickLoginButton();

        LandingPageFactor landingPageFactor = new LandingPageFactor(driver);

        Assert.assertEquals(loginPageFactor.getErrorMessage(),"Password cannot be empty");

    }
    @Test
    public void testUserLoginWithInvalidUsernameAndPassword(){
        //Login page object creation
        LoginPageFactor loginPageFactor = new LoginPageFactor(driver);

        loginPageFactor.typeUsername("user")
                .typePassword("123")
                .clickLoginButton();

        LandingPageFactor landingPageFactor = new LandingPageFactor(driver);

        Assert.assertEquals(loginPageFactor.getErrorMessage(),"Invalid credentials");

    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }


}
