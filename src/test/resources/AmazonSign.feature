Feature:To validate the account creation of Amazon application

Scenario:To create new account
Given To launch the browser and maximize the window
When To launch the url of the Amazon application
And To click the sign in button

# One dimensional map data
And To pass the email in email field
#Key       value
|email1|shifa@gmail.com|
|email2|azar@gmail.com|
|email3|sait@gmail.com|
|email4|jeri@gmail.com|

And To pass the last name in last name field

# Two dimensional map data
And To pass mobileno or email in required field
|password1|password2|password3|
|1233554|aaaaaaa|ddddddoooo|
|2345676|rrrrrrrr|wwwwwwww|
|hjuifh123|wertghy|tghifds|
|oenfutnf|hjiufg|hsjiudgooo|

And To create new password in new password field
Then To close the Browser


