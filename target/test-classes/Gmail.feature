Feature: To validate the login functionality of G-mail applications

Scenario Outline: to validate the positive and negative combination of login functionality
Given To launch the url of the  G-mail applications
When User has to hit the G-mail url
And User has to pass the data "<emaildatas>" in email field
And User has to  click next button
Then User has to close the browser

Examples:
|emaildatas       |
|selenium@gmailcom|
|inamkes@gmail.com|
|shifa@gmail.com  |
|azar@gmail.com   |

