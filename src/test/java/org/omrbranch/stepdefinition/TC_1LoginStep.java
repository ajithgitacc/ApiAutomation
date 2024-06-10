package org.omrbranch.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.omrbranch.baseclass.BaseClass;
import org.omrbranch.endpoints.Endpoints;
import org.omrbranch.globaldata.GlobalDatas;
import org.omrbranch.pojo.login.Login_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC_1LoginStep extends BaseClass {
	Response response;
	static GlobalDatas globaldatas= new GlobalDatas();
	
	@Given("user add header")
	public void user_add_header() {
		addHeader("accept", "application/json");
	}
	@When("user add basic authentication for login")
	public void user_add_basic_authentication_for_login() throws FileNotFoundException, IOException {
		addAuthentication(getPropertyFileValue("userName"), getPropertyFileValue("password"));
	}
	@When("user send {string} request for login endpoint")
	public void user_send_request_for_login_endpoint(String reqtype) {
		response = addRequestType(reqtype, Endpoints.LOGIN);
		int responsecode = getResponsecode(response);
		globaldatas.setResponsecode(responsecode);
	}
	
	@Then("user verify the login response body firstName present as {string} and get the logtoken saved")
	public void user_verify_the_login_response_body_first_name_present_as_and_get_the_logtoken_saved(String expectedfirstname) {
		Login_Output_Pojo loginoutputpojo = response.as(Login_Output_Pojo.class);
		String actualfirstname = loginoutputpojo.getData().getFirst_name();
		String logtoken = loginoutputpojo.getData().getLogtoken();
		globaldatas.setLogToken(logtoken);
		Assert.assertEquals("verify firstname of login endpoint", expectedfirstname,actualfirstname );
			
	}




}
