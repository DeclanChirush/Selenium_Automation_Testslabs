package com.pragmatic.selenium.pageobject.tests;

import com.pragmatic.selenium.other.HRMConstants;
import com.pragmatic.selenium.pageobject.pages.AddNewEmployeePageObject;
import com.pragmatic.selenium.pageobject.pages.LoginPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAddNewEmployee {

    private static final String BASE_URL = HRMConstants.BASE_URL;
    private WebDriver driver;
    private AddNewEmployeePageObject addNewEmployeePageObject;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        testValidUserLogin();
        navigateToAddEmployeePage();
    }

    private void testValidUserLogin(){
        //Login page object creation
        LoginPageObject loginPageObject = new LoginPageObject(driver);

        loginPageObject.typeUsername(HRMConstants.USERNAME)
                .typePassword(HRMConstants.PASSWORD)
                .clickLoginButton();
    }

    private void navigateToAddEmployeePage() {

        addNewEmployeePageObject = new AddNewEmployeePageObject(driver);

        //Click the PIM menu and set a delay
        addNewEmployeePageObject.getMenuPIM()
                .getWebDriverWait();
        //Click the Menu Add Employee
        addNewEmployeePageObject.getMenuAddEmployee();


    }

    @Test
    public void testAddNewEmployee(){

        addNewEmployeePageObject = new AddNewEmployeePageObject(driver);

        addNewEmployeePageObject.typeFirstname()
                .typeLastname()
                .clickSaveButton();

    }

    @Test
    public void testAddNewEmployeeWithProfilePicture(){

        addNewEmployeePageObject = new AddNewEmployeePageObject(driver);

        addNewEmployeePageObject.typeFirstname()
                        .typeLastname()
                        .addProfilePicture()
                        .clickSaveButton();

    }

    @Test
    public void testAddNewEmployeeWithLoginDetails() {

        addNewEmployeePageObject = new AddNewEmployeePageObject(driver);

        addNewEmployeePageObject.typeFirstname()
                .typeLastname()
                .checkLogin();

        addNewEmployeePageObject.getUsername()
                        .getPassword()
                        .getConfirmPassword()
                        .clickSaveButton();
    }

    @Test
    public void testAddNewEmployeeWithLoginDetailsEnabled() {

        addNewEmployeePageObject = new AddNewEmployeePageObject(driver);

        addNewEmployeePageObject.typeFirstname()
                .typeLastname()
                .checkLogin();

        addNewEmployeePageObject.getEnableStatus()
                        .getUsername()
                        .getPassword()
                        .getConfirmPassword()
                        .clickSaveButton();
    }

    @Test
    public void testAddNewEmployeeWithLoginDetailsDisabled() {

        addNewEmployeePageObject = new AddNewEmployeePageObject(driver);

        addNewEmployeePageObject.typeFirstname()
                .typeLastname()
                .checkLogin();

        addNewEmployeePageObject.getDisableStatus()
                .getUsername()
                .getPassword()
                .getConfirmPassword()
                .clickSaveButton();
    }

}
