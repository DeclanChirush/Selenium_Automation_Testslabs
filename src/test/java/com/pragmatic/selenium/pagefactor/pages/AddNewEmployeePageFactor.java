package com.pragmatic.selenium.pagefactor.pages;

import com.github.javafaker.Faker;
import com.pragmatic.selenium.other.HRMConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddNewEmployeePageFactor {


    private final WebDriver driver;
    private WebDriverWait wait;
    private Faker faker = new Faker();

    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String username = String.format("%s.%s", firstName, lastName);


    //Define the element
    @FindBy(id = "firstName")
    WebElement FIRSTNAME;

    @FindBy(id = "lastName")
    WebElement LASTNAME;

    @FindBy(id = "btnSave")
    WebElement BTN_SAVE;

    @FindBy(id = "chkLogin")
    WebElement CHECK_LOGIN;

    @FindBy(id = "user_name")
    WebElement TXT_LOGIN_USERNAME;

    @FindBy(id = "user_password")
    WebElement TXT_LOGIN_PASSWORD;

    @FindBy(id = "re_password")
    WebElement TXT_LOGIN_PASSWORD_CONFIRM;

    @FindBy(id = "photofile")
    WebElement PROFILE_PICTURE;

    @FindBy(id = "menu_pim_viewPimModule")
    WebElement MENU_PIM;




    public AddNewEmployeePageFactor(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public AddNewEmployeePageFactor getMenuPIM() {
        MENU_PIM.click();
        return this;
    }

    public void getWebDriverWait() {
         wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void getMenuAddEmployee() {
        wait.until(ExpectedConditions.elementToBeClickable(HRMConstants.MENU_ADD_EMPLOYEE)).click();
    }


    public AddNewEmployeePageFactor typeFirstname() {
        FIRSTNAME.sendKeys(firstName);
        return this;
    }

    public AddNewEmployeePageFactor typeLastname() {
        LASTNAME.sendKeys(lastName);
        return this;
    }

    public AddNewEmployeePageFactor addProfilePicture(){
        PROFILE_PICTURE.sendKeys("C:\\Users\\Hirush\\IdeaProjects\\Selenium_Automation_Testslabs\\test_data\\profile_picture.jpg");
        return this;
    }

    public AddNewEmployeePageFactor getUsername() {
        TXT_LOGIN_USERNAME.sendKeys(username);
        return this;

    }

    public AddNewEmployeePageFactor getPassword() {
        TXT_LOGIN_PASSWORD.sendKeys(HRMConstants.PASSWORD);
        return this;

    }

    public AddNewEmployeePageFactor getConfirmPassword() {
        TXT_LOGIN_PASSWORD_CONFIRM.sendKeys(HRMConstants.PASSWORD);
        return this;

    }

    public AddNewEmployeePageFactor getDisableStatus() {
        Select status = new Select(driver.findElement(HRMConstants.LAST_STATUS));
        status.selectByVisibleText("Disabled");
        status.selectByIndex(0);
        status.selectByValue("Disabled");
        return this;

    }
    public AddNewEmployeePageFactor getEnableStatus() {
        Select status = new Select(driver.findElement(HRMConstants.LAST_STATUS));
        status.selectByVisibleText("Enabled");
        status.selectByIndex(1);
        status.selectByValue("Enabled");
        return this;

    }


    public void checkLogin() {
        CHECK_LOGIN.click();
    }

    public void clickSaveButton() {
        BTN_SAVE.click();
    }


}
