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
    private WebDriver driver;

    @BeforeMethod
    private WebDriver beforeMethod() {
        driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        return driver;
    }

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void testValidUserLogin() {

        driver = beforeMethod();

        driver.findElement(By.id("txtUsername")).sendKeys(USERNAME);
        driver.findElement(By.id("txtPassword")).sendKeys(PASSWORD + Keys.ENTER);

        /**** Different methods to hit Login Button ****/
        //driver.findElement(By.id("txtPassword")).submit();
        //driver.findElement(By.id("btnLogin")).click();
        //driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321" + Keys.ENTER);

        String welcomeMsg = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(welcomeMsg, "Welcome Admin");



    }

    @Test
    public void testValidUserLoginWithoutUsernameAndPassword() {

        driver = beforeMethod();

        driver.findElement(By.id("txtUsername")).sendKeys("");
        driver.findElement(By.id("txtPassword")).sendKeys("" + Keys.ENTER);

        String errorMsg = driver.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(errorMsg,"Username cannot be empty");


    }

    @Test
    public void testValidUserLoginWithOnlyUsername() {

        driver = beforeMethod();

        driver.findElement(By.id("txtUsername")).sendKeys(USERNAME);
        driver.findElement(By.id("txtPassword")).sendKeys("" + Keys.ENTER);

        String errorMsg = driver.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(errorMsg,"Password cannot be empty");


    }


    @Test
    public void testValidUserLoginWithInvalidCredentials() {

        driver = beforeMethod();

        driver.findElement(By.id("txtUsername")).sendKeys("User");
        driver.findElement(By.id("txtPassword")).sendKeys("123" + Keys.ENTER);

        String errorMsg = driver.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(errorMsg,"Invalid credentials");


    }

    @Test
    public void testValidUserLoginWithCaseSensitiveForPassword() {

        driver = beforeMethod();

        driver.findElement(By.id("txtUsername")).sendKeys(USERNAME);
        driver.findElement(By.id("txtPassword")).sendKeys("pTL@#321" + Keys.ENTER);

        String errorMsg = driver.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(errorMsg,"Invalid credentials");


    }
    @AfterMethod
    private void afterMethod() {
        driver.close();
    }


}
