package com.pragmatic.selenium.pageobject.tests;

import com.pragmatic.selenium.other.HRMConstants;
import com.pragmatic.selenium.pageobject.pages.LandingPageObject;
import com.pragmatic.selenium.pageobject.pages.LoginPageObject;
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
        LoginPageObject loginPageObject = new LoginPageObject(driver);

        loginPageObject.typeUsername(HRMConstants.USERNAME)
                .typePassword(HRMConstants.PASSWORD)
                .clickLoginButton();

        LandingPageObject landingPageObject = new LandingPageObject(driver);

        Assert.assertEquals(landingPageObject.getWelcomeMessage(),"Welcome Admin");

    }
    @Test
    public void testUserLoginWithoutUsernameAndPassword(){
        //Login page object creation
        LoginPageObject loginPageObject = new LoginPageObject(driver);

        loginPageObject.typeUsername("")
                .typePassword("")
                .clickLoginButton();

        LandingPageObject landingPageObject = new LandingPageObject(driver);

        Assert.assertEquals(loginPageObject.getErrorMsg(),"Username cannot be empty");

    }

    @Test
    public void testUserLoginWithoutPassword(){
        //Login page object creation
        LoginPageObject loginPageObject = new LoginPageObject(driver);

        loginPageObject.typeUsername(HRMConstants.USERNAME)
                .typePassword("")
                .clickLoginButton();

        LandingPageObject landingPageObject = new LandingPageObject(driver);

        Assert.assertEquals(loginPageObject.getErrorMsg(),"Password cannot be empty");

    }
    @Test
    public void testUserLoginWithInvalidUsernameAndPassword(){
        //Login page object creation
        LoginPageObject loginPageObject = new LoginPageObject(driver);

        loginPageObject.typeUsername("user")
                .typePassword("123")
                .clickLoginButton();

        LandingPageObject landingPageObject = new LandingPageObject(driver);

        Assert.assertEquals(loginPageObject.getErrorMsg(),"Invalid credentials");

    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }


}
