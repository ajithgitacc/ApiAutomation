@Address
Feature: Address Module API Automation
 
	Scenario Outline: verify adduseraddress to the application through api
		Given user add header and bearer authorization for accessing address endpoints
		When user add requestbody for add new address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>","<addressType>"
		And user send "POST" request for add userddress endpoint
		Then user should verify the status code is 200
		And user should verify the adduseraddress response message matches "Address added successfully"
			Examples:
				|first_name|last_name|mobile    |apartment|state|city  |country|zipcode|address|addressType|
				|Bala      |Murugan  |9645878621|prince   |123  |11    |101    |600081 |chennai|Home       |
	
	Scenario Outline: verify updateuseraddress to the application through api
		Given user add header and bearer authorization for accessing updateuseraddress endpoints
		When user add requestbody to update new address "<addressid>" "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>","<addressType>"
		And user send "PUT" request for update add userddress endpoint
		Then user should verify the status code is 200
		And user should verify the updateuseraddress response message matches "Address updated successfully"
			Examples:
				|first_name|last_name|mobile    |apartment  |state|city |country|zipcode|address|addressType|
				|Bala      |Murugan  |9645878621|princess   |123  |11   |101    |600123 |chennai|Home       |
	
	Scenario Outline: verify getuseraddress to the application through api
		Given user add headers and bearer authorization for accessing getuseraddress endpoints
		When user send "GET" request for getuseraddress endpoint
		Then user should verify the status code is 200
		And user should verify the getuseraddress response message matches "OK"
		
	Scenario Outline: verify deleteuseraddress to the application through api
		Given user add headers and bearer authorization for accessing deleteuseraddress endpoints
		When user add request body for address id
		And user send "DELETE" request for delete address endpoint
		Then user should verify the status code is 200
		And user should verify the deleteuseraddress response message matches "Address deleted successfully"
		
	