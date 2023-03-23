Feature: Logout Functionality
  Scenario:User can log out and ends up in login page.


    Given User already logged in
    When user click to his own username
    And  user click to Log Out button
    Then User in on log in page