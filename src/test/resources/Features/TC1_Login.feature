@Login
Feature: Login module API Automation
	Scenario: Get user logtoken from login endpoint
			Given user add header
			When user add basic authentication for login
			And user send "POST" request for login endpoint
			Then user should verify the status code is 200
			And user verify the login response body firstName present as "AJITHKUMAR" and get the logtoken saved