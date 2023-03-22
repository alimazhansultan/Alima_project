Feature: Login Functionality

  Scenario Outline:Please fill out this field
When User navigate to login page
And  User enters valid "<Email>" and leaves password field empty
Then User should see message

Examples: Email-Password
| Email                   | Password     |
| salesmanager15@info.com |              |
