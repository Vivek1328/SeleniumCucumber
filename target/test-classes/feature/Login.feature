Feature: To Login in application

Background: Application up
Given I enter the telestaff url




Scenario: Forgot Password link exist
Given I navigate to login page
Then I verify that forgot password fild exists


Scenario: Login with valid credentials 
Given I navigate to login page
When I enter email addess "vivlv@yopmail.com"
And I enter password "Welcometoukg@123"
Then I verify that user logged in successfully


