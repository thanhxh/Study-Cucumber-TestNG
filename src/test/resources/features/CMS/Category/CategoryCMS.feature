Feature: Add Category

  Background: Login as Admin role
    Given user logged in as an admin

  @AddCategory
  Scenario: Add a new category
    Given user on the category page
    When user click on the Add Category button
    And user enter the category information
    And user click on the Save button
    Then user should see a success message
    And the new category should be displayed on the category page