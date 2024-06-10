@City
Feature: City module API Automation
	Scenario: verify user get citylist through api
		Given user add header for citylist
		When user add requestbody stateid for get citylist
		And user send "POST" request for citylist endpoint
		Then user should verify the status code is 200
		And user should verify the city list response message matches "Alandur" and saved cityid