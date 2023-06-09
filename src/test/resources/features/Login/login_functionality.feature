Feature: Login Functionality
  @UPGNX10-261
  Scenario: Users can log in with valid credentials

    Given User navigate to login page
    When User enters valid credentials
    And User clicks login button
    Then User can see dashboard

  @UPGNX10-262
  Scenario Outline: User should see "Wrong login/password" message displayed when entering with incorrect credentials

    When User navigate to login page
    And  User enters invalid "<Email>" and "<Password>"
    And  User clicks login button
    Then User sees the Wrong login and password message displayed


    Examples: Email-Password
      | Email                 | Password     |
      | salesmanager@info.com | salesmanger! |

  @UPGNX10-263
  Scenario Outline:Please fill out this field message should be displayed

    When User navigate to login page
    And  User enters valid "<Email>" and leaves password field empty
    Then User should see message

    Examples: Email-Password
      | Email                   | Password |
      | salesmanager15@info.com |          |


  @UPGNX10-265
  Scenario: Enter button has to be work correctly

    Given User navigate to login page
    When User enters valid credentials
    Then User clicks enter button


  @UPGNX10-264
  Scenario: User should see bullet signs by default in password field

    Given User navigate to login page
    When User enters valid credentials
    Then User can see bullet signs by default