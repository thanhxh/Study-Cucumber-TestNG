Feature: Login to CRM
  As a user, I want to be able to log into the CRM system
  So that I can manage customer information

  Example: Successful login
    Given I am on the login page
    When I enter my username and password
    And I click the Login button
    Then I should be taken to the dashboard page
    And I should see the "Customers" menu
    And user should see the notification displays