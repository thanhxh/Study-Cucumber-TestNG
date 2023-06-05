package com.anhtester.pages;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConstantGlobal;
import com.anhtester.helpers.PropertiesHelpers;
import org.openqa.selenium.By;

import static com.anhtester.keywords.WebUI.*;
import static com.anhtester.keywords.WebUI.openURL;

public class LoginCMSPage extends CommonPage {

    static {
        PropertiesHelpers.loadAllFiles();
    }
    //Khai báo Objects
    private By labelLoginPage = By.xpath("//p[normalize-space()='Login to your account.']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By messageAlert = By.xpath("//div[@role='alert']");

    public void goToLoginPage(){
        openURL(ConstantGlobal.URL);
        verifyElementVisible(labelLoginPage);
    }
    public void verifyRedirectToAdminPage() {
        verifyElementVisible(avatarProfile, "Can not redirect to Admin page.");
    }
    public void userShouldSeeAnErrorMessage() {
        verifyElementVisible(messageAlert, "The Error message not visible.");
        verifyEquals(getElementText(messageAlert), "Invalid login credentials", "The content of Error message not match.");
    }

    //Hàm xử lý đặc trưng cho Login Page
    public void enterEmailAndPassword(String email, String password) {
        setText(inputEmail, email);
        setText(inputPassword, password);
    }

    public void clickLoginButton() {
        clickElement(buttonLogin);
    }
    public CommonPage loginAdminRole() {

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
