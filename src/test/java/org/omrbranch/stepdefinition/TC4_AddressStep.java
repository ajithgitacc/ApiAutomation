package org.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.omrbranch.baseclass.BaseClass;
import org.omrbranch.endpoints.Endpoints;
import org.omrbranch.pojo.address.Address_Input_Pojo;
import org.omrbranch.pojo.address.Address_Output_Pojo;
import org.omrbranch.pojo.address.DeleteAddress_Output_Pojo;
import org.omrbranch.pojo.address.Deleteaddress_Input_Pojo;
import org.omrbranch.pojo.address.Getuseraddress_Output_Pojo;
import org.omrbranch.pojo.address.Updateaddress_Input_pojo;
import org.omrbranch.pojo.address.Updateaddress_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC4_AddressStep extends BaseClass {
	Response response;
	
	//Adduseraddress
	@Given("user add header and bearer authorization for accessing address endpoints")
	public void user_add_header_and_bearer_authorization_for_accessing_address_endpoints() {
		List<Header> listheader= new ArrayList<>();
		Header h1= new Header("accept", "application/json");
		Header h2= new Header("Authorization", "Bearer "+ TC_1LoginStep.globaldatas.getLogToken());
		Header h3= new Header("Content-Type", "application/json");
		listheader.add(h1);
		listheader.add(h2);
		listheader.add(h3);
		Headers headers= new Headers(listheader);
		addHeaders(headers);
	}

	@When("user add requestbody for add new address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_add_requestbody_for_add_new_address(String first_name, String last_name, String mobile, String apartment, String state, String city, String country, String zipcode, String address, String addressType) {
		Address_Input_Pojo addressinputpojo= new Address_Input_Pojo(first_name, last_name, mobile,apartment, TC_1LoginStep.globaldatas.getStateIdNum(), TC_1LoginStep.globaldatas.getCityIdNum(),Integer.parseInt(country),zipcode ,address,addressType);
		addRequestBody(addressinputpojo);
	}

	@When("user send {string} request for add userddress endpoint")
	public void user_send_request_for_add_userddress_endpoint(String reqtype) {
		response = addRequestType(reqtype, Endpoints.ADDUSERADDRESS);
		int responsecode = getResponsecode(response);
		TC_1LoginStep.globaldatas.setResponsecode(responsecode);

	}
	@Then("user should verify the adduseraddress response message matches {string}")
	public void user_should_verify_the_adduseraddress_response_message_matches(String expAddAddressMsg) {
		Address_Output_Pojo address_Output_Pojo = response.as(Address_Output_Pojo.class);
		String actAddAddressmsg = address_Output_Pojo.getMessage();
		Assert.assertEquals("verify aadaddress success message", expAddAddressMsg, actAddAddressmsg);
		int address_id = address_Output_Pojo.getAddress_id();
		String addressid = String.valueOf(address_id);
		TC_1LoginStep.globaldatas.setAddressIdText(addressid);
	}
	
	//updateuseraddress


	@Given("user add header and bearer authorization for accessing updateuseraddress endpoints")
	public void user_add_header_and_bearer_authorization_for_accessing_updateuseraddress_endpoints() {
		List<Header> listheader= new ArrayList<>();
		Header h1= new Header("accept", "application/json");
		Header h2= new Header("Authorization", "Bearer "+ TC_1LoginStep.globaldatas.getLogToken());
		Header h3= new Header("Content-Type", "application/json");
		listheader.add(h1);
		listheader.add(h2);
		listheader.add(h3);
		Headers headers= new Headers(listheader);
		addHeaders(headers);
	}

	@When("user add requestbody to update new address {string} {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_add_requestbody_to_update_new_address(String address_id, String first_name, String last_name, String mobile, String apartment, String state, String city, String country, String zipcode, String address, String addressType) {
		Updateaddress_Input_pojo updateaddress= new Updateaddress_Input_pojo(TC_1LoginStep.globaldatas.getAddressIdText(),first_name ,last_name,mobile ,apartment ,TC_1LoginStep.globaldatas.getStateIdNum(),TC_1LoginStep.globaldatas.getCityIdNum() , Integer.parseInt(country), zipcode,address , addressType);
		addRequestBody(updateaddress);
	}


	@When("user send {string} request for update add userddress endpoint")
	public void user_send_request_for_update_add_userddress_endpoint(String reqtype) {
		response = addRequestType(reqtype, Endpoints.UPDATEUSERADDRESS);
		int responsecode = getResponsecode(response);
		TC_1LoginStep.globaldatas.setResponsecode(responsecode);

	}
	@Then("user should verify the updateuseraddress response message matches {string}")
	public void user_should_verify_the_updateuseraddress_response_message_matches(String expUpdateAddressMsg) {
		Updateaddress_Output_Pojo updateaddress_Output_Pojo = response.as(Updateaddress_Output_Pojo.class);
		String actupdatemessage = updateaddress_Output_Pojo.getMessage();
		Assert.assertEquals("verify updateaddress msg", expUpdateAddressMsg, actupdatemessage);
		

	}


	//getuseraddress

	@Given("user add headers and bearer authorization for accessing getuseraddress endpoints")
	public void user_add_headers_and_bearer_authorization_for_accessing_getuseraddress_endpoints() {
		List<Header> listheader= new ArrayList<>();
		Header h1= new Header("accept", "application/json");
		Header h2= new Header("Authorization", "Bearer "+ TC_1LoginStep.globaldatas.getLogToken());
		listheader.add(h1);
		listheader.add(h2);
		Headers headers= new Headers(listheader);
		addHeaders(headers);
	}
	@When("user send {string} request for getuseraddress endpoint")
	public void user_send_request_for_getuseraddress_endpoint(String reqtype) {
		response = addRequestType(reqtype, Endpoints.GETUSERADDRESS);
		int responsecode = getResponsecode(response);
		TC_1LoginStep.globaldatas.setResponsecode(responsecode);
		

	}
	@Then("user should verify the getuseraddress response message matches {string}")
	public void user_should_verify_the_getuseraddress_response_message_matches(String expgetuseraddmsg) {
		Getuseraddress_Output_Pojo getuseraddress_Output_Pojo = response.as(Getuseraddress_Output_Pojo.class);
		String actgetuseraddmsg = getuseraddress_Output_Pojo.getMessage();
		Assert.assertEquals("verify getuseraddress msg", expgetuseraddmsg, actgetuseraddmsg);
	}
	
	//deleteuseraddress

	@Given("user add headers and bearer authorization for accessing deleteuseraddress endpoints")
	public void user_add_headers_and_bearer_authorization_for_accessing_deleteuseraddress_endpoints() {
		List<Header> listheader= new ArrayList<>();
		Header h1= new Header("accept", "application/json");
		Header h2= new Header("Authorization", "Bearer "+ TC_1LoginStep.globaldatas.getLogToken());
		Header h3= new Header("Content-Type", "application/json");
		listheader.add(h1);
		listheader.add(h2);
		listheader.add(h3);
		Headers headers= new Headers(listheader);
		addHeaders(headers);

	}
	@When("user add request body for address id")
	public void user_add_request_body_for_address_id() {
		Deleteaddress_Input_Pojo deleteaddressinput= new Deleteaddress_Input_Pojo(TC_1LoginStep.globaldatas.getAddressIdText());
		addRequestBody(deleteaddressinput);

	}
	@When("user send {string} request for delete address endpoint")
	public void user_send_request_for_delete_address_endpoint(String reqtype) {
		response = addRequestType(reqtype, Endpoints.DELETEADDRESS);
		int responsecode = getResponsecode(response);
		TC_1LoginStep.globaldatas.setResponsecode(responsecode);
		

	}
	@Then("user should verify the deleteuseraddress response message matches {string}")
	public void user_should_verify_the_deleteuseraddress_response_message_matches(String expDeleteAddressMsg) {
		DeleteAddress_Output_Pojo deleteAddress_Output_Pojo = response.as(DeleteAddress_Output_Pojo.class);
		String actDeleteAddressMsg = deleteAddress_Output_Pojo.getMessage();
		Assert.assertEquals("verify deleteaddress success msg", expDeleteAddressMsg, actDeleteAddressMsg);

	}












}
