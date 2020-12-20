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
}
