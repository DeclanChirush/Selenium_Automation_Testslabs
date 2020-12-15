package com.pragmatic.selenium.hrm;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestAddNewEmployee {

    public static final String USERNAME = "Admin";
    public static final String PASSWORD = "Ptl@#321";

    private static final By TXT_USERNAME = By.id("txtUsername");
    private static final By TXT_PASSWORD = By.id("txtPassword");
    private static final By BTN_LOGIN = By.id("btnLogin");
    private static final By MENU_PIM= By.id("menu_pim_viewPimModule");
    private static final By MENU_ADD_EMPLOYEE= By.id("menu_pim_addEmployee");
    private static final By TXT_FIRSTNAME= By.id("firstName");
    private static final By TXT_LASTNAME= By.id("lastName");
    private static final By TXT_EMP_ID= By.id("employeeId");
    private static final By PROFILE_PICTURE = By.id("photofile");
    private static final By BTN_SAVE = By.id("btnSave");
    private static final By CHECK_LOGIN = By.id("chkLogin");
    private static final By LAST_STATUS = By.id("status");
    private static final By TXT_LOGIN_USERNAME = By.id("user_name");
    private static final By TXT_LOGIN_PASSWORD = By.id("user_password");
    private static final By TXT_LOGIN_PASSWORD_CONFIRM = By.id("re_password");
    private WebDriver driver;
    private Faker faker;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    private WebDriver beforeMethod() {
        //create faker object
        faker = new Faker();
        driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        userLogin();
        navigateToAddEmployeePage();
        return driver;
    }

    private void userLogin() {
        driver.findElement(TXT_USERNAME).sendKeys(USERNAME);
        driver.findElement(TXT_PASSWORD).sendKeys(PASSWORD);
        driver.findElement(BTN_LOGIN).click();

    }

    private void navigateToAddEmployeePage() {
        //Click the PIM menu
        driver.findElement(MENU_PIM).click();

        //set the 5 second delay
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Click the Add Employee menu
        wait.until(ExpectedConditions.elementToBeClickable(MENU_ADD_EMPLOYEE)).click();

    }

    @Test
    public void testAddNewEmployee(){

        driver.findElement(TXT_FIRSTNAME).sendKeys("Hirush");
        driver.findElement(TXT_LASTNAME).sendKeys("Gimhan");
        driver.findElement(BTN_SAVE).click();

    }

    @Test
    public void testAddNewEmployeeWithProfilePicture(){

        driver.findElement(TXT_FIRSTNAME).sendKeys("Hirush");
        driver.findElement(TXT_LASTNAME).sendKeys("Gimhan");
        driver.findElement(PROFILE_PICTURE).sendKeys("C:\\Users\\Hirush\\IdeaProjects\\Selenium_Automation_Testslabs\\test_data\\profile_picture.jpg");
        driver.findElement(BTN_SAVE).click();

    }

    @Test
    public void testAddNewEmployeeWithLoginDetails() {

        //create random names using faker object
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String username = String.format("%s.%s", firstName, lastName);

        driver.findElement(TXT_FIRSTNAME).sendKeys(firstName);
        driver.findElement(TXT_LASTNAME).sendKeys(lastName);
        driver.findElement(CHECK_LOGIN).click();

        driver.findElement(TXT_LOGIN_USERNAME).sendKeys(username);
        driver.findElement(TXT_LOGIN_PASSWORD).sendKeys(PASSWORD);
        driver.findElement(TXT_LOGIN_PASSWORD_CONFIRM).sendKeys(PASSWORD);

        driver.findElement(BTN_SAVE).click();
    }

    @Test
    public void testAddNewEmployeeWithLoginDetailsDisabled() {

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String username = String.format("%s.%s", firstName, lastName);

        driver.findElement(TXT_FIRSTNAME).sendKeys(firstName);
        driver.findElement(TXT_LASTNAME).sendKeys(lastName);
        driver.findElement(CHECK_LOGIN).click();

        //when you have drop down list, you can easily use select class to interact with
        Select status = new Select(driver.findElement(LAST_STATUS));
        status.selectByVisibleText("Disabled");

        status.selectByIndex(0);
        status.selectByValue("Disabled");

        driver.findElement(TXT_LOGIN_USERNAME).sendKeys(username);
        driver.findElement(TXT_LOGIN_PASSWORD).sendKeys(PASSWORD);
        driver.findElement(TXT_LOGIN_PASSWORD_CONFIRM).sendKeys(PASSWORD);

        driver.findElement(BTN_SAVE).click();
    }

    @Test
    public void testAddNewEmployeeWithLoginDetailsEnabled() {

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String username = String.format("%s.%s", firstName, lastName);

        driver.findElement(TXT_FIRSTNAME).sendKeys(firstName);
        driver.findElement(TXT_LASTNAME).sendKeys(lastName);
        driver.findElement(CHECK_LOGIN).click();

        //when you have drop down list, you can easily use select class to interact with
        Select status = new Select(driver.findElement(LAST_STATUS));
        status.selectByVisibleText("Enabled");

        status.selectByIndex(1);
        status.selectByValue("Enabled");

        driver.findElement(TXT_LOGIN_USERNAME).sendKeys(username);
        driver.findElement(TXT_LOGIN_PASSWORD).sendKeys(PASSWORD);
        driver.findElement(TXT_LOGIN_PASSWORD_CONFIRM).sendKeys(PASSWORD);

        driver.findElement(BTN_SAVE).click();
    }

    @AfterMethod
    private void afterMethod() {
        //driver.close();
    }


}
