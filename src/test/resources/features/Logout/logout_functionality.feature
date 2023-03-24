Feature: Logout Functionality
  Scenario:User can log out and ends up in login page.
    Given User already logged in
    When user click to his own username
    And  user click to Log Out button
    Then User in on log in page


  Scenario: User can not go to the home page again by clicking the step back button after successfully logged out
    Given User already logged in
    When user click to his own username
    And  user click to Log Out button
    Then User in on log in page
    And User clicks the step back button after successfully logged out.
    Then can not go to the home page again.


    Scenario:User must be logged out if the user closes the open tab
      Given User already logged inn
      When user click to his own username
      And  user click to Log Out button
      Then User in on log in page
      And Already logged user, closes tab
      Then User navigates to home page





