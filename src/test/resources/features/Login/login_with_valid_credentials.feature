Feature: Login Functionality

  Scenario: Users can log in with valid credentials

    Given User navigate to login page
    When User enters valid credentials
    And User clicks login button
    Then User can see dashboard

