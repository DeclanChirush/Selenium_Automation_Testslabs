package com.pragmatic.selenium.hrm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestUserLogins {

    public static final String USERNAME = "Admin";
    public static final String PASSWORD = "Ptl@#321";
    public static final By TXT_USERNAME = By.id("txtUsername");
    public static final By TXT_PASSWORD = By.id("txtPassword");
    private WebDriver driver;

    @BeforeMethod
    private WebDriver beforeMethod() {
        driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        userLogin();
        return driver;
    }

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    private void userLogin() {

        driver.findElement(TXT_USERNAME).sendKeys(USERNAME);
        driver.findElement(TXT_PASSWORD).sendKeys(PASSWORD + Keys.ENTER);

        /**** Different methods to hit Login Button ****/
        //driver.findElement(By.id("txtPassword")).submit();
        //driver.findElement(By.id("btnLogin")).click();
        //driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321" + Keys.ENTER);
    }

    @Test
    public void testValidUserLogin() {
        String welcomeMsg = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(welcomeMsg, "Welcome Admin");
    }

    @Test
    public void testValidUserLoginWithoutUsernameAndPassword() {
        String errorMsg = driver.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(errorMsg, "Username cannot be empty");
    }

    @Test
    public void testValidUserLoginWithOnlyUsername() {
        String errorMsg = driver.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(errorMsg, "Password cannot be empty");
    }


    @Test
    public void testValidUserLoginWithInvalidCredentials() {
        String errorMsg = driver.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(errorMsg, "Invalid credentials");
    }

    @Test
    public void testValidUserLoginWithCaseSensitiveForPassword() {
        String errorMsg = driver.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(errorMsg, "Invalid credentials");
    }

    @AfterMethod
    private void afterMethod() {
        driver.close();
    }


}
