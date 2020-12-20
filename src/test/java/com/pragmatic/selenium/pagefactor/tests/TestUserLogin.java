package com.pragmatic.selenium.pagefactor.tests;

import com.pragmatic.selenium.other.HRMConstants;
import com.pragmatic.selenium.pagefactor.pages.LandingPage;
import com.pragmatic.selenium.pagefactor.pages.LoginPage;
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
        LoginPage loginPage = new LoginPage(driver);

        loginPage.typeUsername(HRMConstants.USERNAME)
                .typePassword(HRMConstants.PASSWORD)
                .clickLoginButton();

        LandingPage landingPage = new LandingPage(driver);

        Assert.assertEquals(landingPage.getWelcomeMessage(),"Welcome Admin");

    }
    @Test
    public void testUserLoginWithoutUsernameAndPassword(){
        //Login page object creation
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clearUsername()
                .clearPassword()
                .clickLoginButton();

        LandingPage landingPage = new LandingPage(driver);

        Assert.assertEquals(loginPage.getErrorMessage(),"Username cannot be empty");

    }

    @Test
    public void testUserLoginWithoutPassword(){
        //Login page object creation
        LoginPage loginPage = new LoginPage(driver);

        loginPage.typeUsername(HRMConstants.USERNAME)
                .clearPassword()
                .clickLoginButton();

        LandingPage landingPage = new LandingPage(driver);

        Assert.assertEquals(loginPage.getErrorMessage(),"Password cannot be empty");

    }
    @Test
    public void testUserLoginWithInvalidUsernameAndPassword(){
        //Login page object creation
        LoginPage loginPage = new LoginPage(driver);

        loginPage.typeUsername("user")
                .typePassword("123")
                .clickLoginButton();

        LandingPage landingPage = new LandingPage(driver);

        Assert.assertEquals(loginPage.getErrorMessage(),"Invalid credentials");

    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }


}
