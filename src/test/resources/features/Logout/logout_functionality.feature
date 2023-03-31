
Feature: Logout Functionality

  @UPGNX10-320
  Scenario:User can log out and ends up in login page

    Given User already logged in
    When user click to his own username
    And  user click to Log Out button
    Then User in on log in page

  @UPGNX10-321
  Scenario: User can not go to the home page again by clicking the step back button after successfully logged out

    Given User already logged in
    When user click to his own username
    And  user click to Log Out button
    Then User in on log in page
    And User clicks the step back button after successfully logged out.
    Then can not go to the home page again.

  @UPGNX10-322
  Scenario:User must be logged out if the user closes the open tab

    Given User already logged in
    When  User closes tab
    And   User navigates back to homepage
    Then  User must be logged out


