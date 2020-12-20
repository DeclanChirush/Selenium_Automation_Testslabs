package com.pragmatic.selenium.pageobject.pages;

import com.github.javafaker.Faker;
import com.pragmatic.selenium.other.HRMConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddNewEmployeePageObject {


    private final WebDriver driver;
    private WebDriverWait wait;
    private Faker faker = new Faker();

    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String username = String.format("%s.%s", firstName, lastName);

    public AddNewEmployeePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AddNewEmployeePageObject getMenuPIM() {
        driver.findElement(HRMConstants.MENU_PIM).click();
        return this;
    }

    public void getWebDriverWait() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void getMenuAddEmployee() {
        wait.until(ExpectedConditions.elementToBeClickable(HRMConstants.MENU_ADD_EMPLOYEE)).click();
    }


    public AddNewEmployeePageObject typeFirstname() {
        driver.findElement(HRMConstants.TXT_FIRSTNAME).sendKeys(firstName);
        return this;
    }

    public AddNewEmployeePageObject typeLastname() {
        driver.findElement(HRMConstants.TXT_LASTNAME).sendKeys(lastName);
        return this;
    }

    public AddNewEmployeePageObject addProfilePicture(){
        driver.findElement(HRMConstants.PROFILE_PICTURE).sendKeys("C:\\Users\\Hirush\\IdeaProjects\\Selenium_Automation_Testslabs\\test_data\\profile_picture.jpg");
        return this;
    }

    public AddNewEmployeePageObject getUsername() {
        driver.findElement(HRMConstants.TXT_LOGIN_USERNAME).sendKeys(username);
        return this;

    }

    public AddNewEmployeePageObject getPassword() {
        driver.findElement(HRMConstants.TXT_LOGIN_PASSWORD).sendKeys(HRMConstants.PASSWORD);
        return this;

    }

    public AddNewEmployeePageObject getConfirmPassword() {
        driver.findElement(HRMConstants.TXT_LOGIN_PASSWORD_CONFIRM).sendKeys(HRMConstants.PASSWORD);
        return this;

    }

    public AddNewEmployeePageObject getDisableStatus() {
        Select status = new Select(driver.findElement(HRMConstants.LAST_STATUS));
        status.selectByVisibleText("Disabled");
        status.selectByIndex(0);
        status.selectByValue("Disabled");
        return this;

    }
    public AddNewEmployeePageObject getEnableStatus() {
        Select status = new Select(driver.findElement(HRMConstants.LAST_STATUS));
        status.selectByVisibleText("Enabled");
        status.selectByIndex(1);
        status.selectByValue("Enabled");
        return this;

    }


    public void checkLogin() {
        driver.findElement(HRMConstants.CHECK_LOGIN).click();
    }

    public void clickSaveButton() {
        driver.findElement(HRMConstants.BTN_SAVE).click();
    }


}
