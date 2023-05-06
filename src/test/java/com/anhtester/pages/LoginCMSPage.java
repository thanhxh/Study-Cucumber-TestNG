package com.anhtester.pages;

import com.anhtester.common.BaseTest;
import com.anhtester.helpers.PropertiesHelpers;
import org.openqa.selenium.By;

import static com.anhtester.keywords.WebUI.*;
import static com.anhtester.keywords.WebUI.openURL;

public class LoginCMSPage {

    static {
        PropertiesHelpers.loadAllFiles();
    }
    //Khai báo Objects
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By messageAlert = By.xpath("//div[@class='text-center alert alert-danger']");


    //Hàm xử lý đặc trưng cho Login Page
    public void enterEmailAndPassword(String email, String password) {
        setText(inputEmail, email);
        setText(inputPassword, password);
    }

    public void clickLoginButton() {
        clickElement(buttonLogin);
    }
    public CommonPage loginAdminRole() {
        BaseTest.createDriver();
        openURL(PropertiesHelpers.getValue("URL"));
        setText(inputEmail, PropertiesHelpers.getValue("EMAIL"));
        setText(inputPassword, PropertiesHelpers.getValue("PASSWORD"));
        clickLoginButton();
        return new CommonPage();
    }

    public CommonPage loginProjectRole() {
        openURL(PropertiesHelpers.getValue("URL"));
        setText(inputEmail, PropertiesHelpers.getValue("EMAIL"));
        setText(inputPassword, PropertiesHelpers.getValue("PASSWORD"));
        clickLoginButton();
        return new CommonPage();
    }
}
