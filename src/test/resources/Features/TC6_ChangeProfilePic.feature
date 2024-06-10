@Profilepic
Feature: Changeprofilepic module API Automation
	Scenario: verify user changeprofilepic through api
		Given user add headers and bearer authorization for accessing changeprofilepic endpoints
		When user add formdata for changeprofilepic
		And user send "POST" request for changeprofilepic endpoint
		Then user should verify the status code is 200
		And user should verify the changeprofilepic response message matches "Profile updated Successfully"