package com.pragmatic.selenium.other;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavascriptPopupExamples {

    private WebDriver driver;


    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://demosite.pragmatictestlabs.com/Alerts.html");

    }



    @Test
    public void testBasicAlert() {

        //Define Xpath to find specific location
        driver.findElement(By.xpath("//*[@id=\"cid_16\"]/div/div/button")).click();

        //Verify the text
        String strMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(strMessage, "This Is Simple Alert");

        driver.switchTo().alert().accept();

        //Verify the message in the web page
        String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals(confirmation, "Alert is gone.");
    }


    @Test
    public void testConfirmationOK() {

        //Define Xpath to find specific location
        driver.findElement(By.xpath("//*[@id=\"cid_8\"]/div/div/div/button")).click();

        //Verify the text
        String strMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(strMessage, "Press a button!");

        //Click the OK/Yes button
        driver.switchTo().alert().accept();

        //Verify the message in the web page
        String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals(confirmation, "Confirmed.");
    }


    @Test
    public void testConfirmationCancel() {

        //Define Xpath to find specific location
        driver.findElement(By.xpath("//*[@id=\"cid_8\"]/div/div/div/button")).click();

        //Verify the text
        String strMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(strMessage, "Press a button!");

        //Click the OK/Yes button
        driver.switchTo().alert().dismiss();

        //Verify the message in the web page
        String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals(confirmation, "Rejected!");
    }


    @Test
    public void testPrompt() {

        String name = "PTL";

        //Define Xpath to find specific location
        driver.findElement(By.xpath("//button[text()='Prompt Alert']")).click();
        //Verify the text
        String strMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(strMessage, "Please enter your name");

        //Type text
        driver.switchTo().alert().sendKeys(name);

        //Click the OK/Yes button
        driver.switchTo().alert().accept();

        //Verify the message in the web page
        String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals(confirmation, name);
    }

    @Test
    public void testTimingAlert() {

        //Define Xpath to find specific location
        driver.findElement(By.xpath("//button[text()='Timing Alert']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        //Click the OK/Yes button
        driver.switchTo().alert().accept();

        //Verify the message in the web page
        String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals(confirmation, "0");


    }

    @AfterMethod
    public void afterMethod() {
        //driver.close();
    }
}
