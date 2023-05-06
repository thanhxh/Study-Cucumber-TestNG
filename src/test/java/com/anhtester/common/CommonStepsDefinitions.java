package com.anhtester.common;

import io.cucumber.java.en.And;

public class CommonStepsDefinitions {
    @And("user should see the notification displays")
    public void userShouldSeeTheNotificationDisplays() {
        BaseTest.closeDriver();
    }
}
