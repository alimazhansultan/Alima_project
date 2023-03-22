Feature: Login Functionality

  Scenario Outline: User should see "Wrong login/password" message displayed when entering with incorrect credentials

    When User navigate to login page
    And  User enters invalid "<Email>" and "<Password>"
    And  User clicks login button
    Then User sees the Wrong login and password message displayed


    Examples: Email-Password
      | Email                    | Password      |
      | salesmanager@info.com    | salesmanger!  |
