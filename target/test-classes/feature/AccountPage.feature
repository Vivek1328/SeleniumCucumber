Feature: Account Page Feature

Background: 
Given User has logged in to application
| username | password |
| vivlv@yopmail.com | Welcometoukg@123 |

Scenario: Account page title
Given I am on Account page
When I gets the title of the webpage
Then I print the webpage title

Scenario: Account section count
Given I am on Account page 
Then User gets on Login page
|My Account|
|My Orders|
|My Downloadable Products|
|My WishList|
|Address Book|
|Account Information|
|Stored payment Methods|
|My Product Reviews|
And account section count should be 10