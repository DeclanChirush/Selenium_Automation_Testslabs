package com.pragmatic.selenium.other;

import org.openqa.selenium.By;

public class HRMConstants {

    public static final String BASE_URL = "http://hrm.pragmatictestlabs.com";

    public static final String USERNAME = "Admin";
    public static final String PASSWORD = "Ptl@#321";

    public static final By TXT_USERNAME = By.id("txtUsername");
    public static final By TXT_PASSWORD = By.id("txtPassword");
    public static final By BTN_LOGIN = By.id("btnLogin");
    public static final By WELCOME_MESSAGE = By.id("welcome");
    public static final By ERROR_MESSAGE = By.id("spanMessage");
    public static final By MENU_PIM= By.id("menu_pim_viewPimModule");
    public static final By MENU_ADD_EMPLOYEE= By.id("menu_pim_addEmployee");
    public static final By TXT_FIRSTNAME= By.id("firstName");
    public static final By TXT_LASTNAME= By.id("lastName");
    public static final By TXT_EMP_ID= By.id("employeeId");
    public static final By PROFILE_PICTURE = By.id("photofile");
    public static final By BTN_SAVE = By.id("btnSave");
    public static final By CHECK_LOGIN = By.id("chkLogin");
    public static final By LAST_STATUS = By.id("status");
    public static final By TXT_LOGIN_USERNAME = By.id("user_name");
    public static final By TXT_LOGIN_PASSWORD = By.id("user_password");
    public static final By TXT_LOGIN_PASSWORD_CONFIRM = By.id("re_password");
}
