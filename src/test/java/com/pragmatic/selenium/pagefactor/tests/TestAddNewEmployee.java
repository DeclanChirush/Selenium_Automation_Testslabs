package com.pragmatic.selenium.pagefactor.tests;

import com.pragmatic.selenium.other.HRMConstants;
import com.pragmatic.selenium.pagefactor.pages.AddNewEmployeePageFactor;
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
    private AddNewEmployeePageFactor addNewEmployeePageFactor;

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

        addNewEmployeePageFactor = new AddNewEmployeePageFactor(driver);

        //Click the PIM menu and set a delay
        addNewEmployeePageFactor.getMenuPIM()
                .getWebDriverWait();
        //Click the Menu Add Employee
        addNewEmployeePageFactor.getMenuAddEmployee();


    }

    @Test
    public void testAddNewEmployee(){

        addNewEmployeePageFactor = new AddNewEmployeePageFactor(driver);

        addNewEmployeePageFactor.typeFirstname()
                .typeLastname()
                .clickSaveButton();

    }

    @Test
    public void testAddNewEmployeeWithProfilePicture(){

        addNewEmployeePageFactor = new AddNewEmployeePageFactor(driver);

        addNewEmployeePageFactor.typeFirstname()
                        .typeLastname()
                        .addProfilePicture()
                        .clickSaveButton();

    }

    @Test
    public void testAddNewEmployeeWithLoginDetails() {

        addNewEmployeePageFactor = new AddNewEmployeePageFactor(driver);

        addNewEmployeePageFactor.typeFirstname()
                .typeLastname()
                .checkLogin();

        addNewEmployeePageFactor.getUsername()
                        .getPassword()
                        .getConfirmPassword()
                        .clickSaveButton();
    }

    @Test
    public void testAddNewEmployeeWithLoginDetailsEnabled() {

        addNewEmployeePageFactor = new AddNewEmployeePageFactor(driver);

        addNewEmployeePageFactor.typeFirstname()
                .typeLastname()
                .checkLogin();

        addNewEmployeePageFactor.getEnableStatus()
                        .getUsername()
                        .getPassword()
                        .getConfirmPassword()
                        .clickSaveButton();
    }

    @Test
    public void testAddNewEmployeeWithLoginDetailsDisabled() {

        addNewEmployeePageFactor = new AddNewEmployeePageFactor(driver);

        addNewEmployeePageFactor.typeFirstname()
                .typeLastname()
                .checkLogin();

        addNewEmployeePageFactor.getDisableStatus()
                .getUsername()
                .getPassword()
                .getConfirmPassword()
                .clickSaveButton();
    }

}
