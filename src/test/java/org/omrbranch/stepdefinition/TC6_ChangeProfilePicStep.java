package org.omrbranch.stepdefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.omrbranch.baseclass.BaseClass;
import org.omrbranch.endpoints.Endpoints;
import org.omrbranch.pojo.changeprofilepic.ChangeProfilePicture_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC6_ChangeProfilePicStep extends BaseClass {
	Response response;
	@Given("user add headers and bearer authorization for accessing changeprofilepic endpoints")
	public void user_add_headers_and_bearer_authorization_for_accessing_changeprofilepic_endpoints() {
		List<Header> listheader= new ArrayList<>();
		Header h1= new Header("accept", "application/json");
		Header h2= new Header("Authorization", "Bearer "+ TC_1LoginStep.globaldatas.getLogToken());
		Header h3= new Header("Content-Type", "multipart/form-data");
		listheader.add(h1);
		listheader.add(h2);
		listheader.add(h3);
		Headers headers= new Headers(listheader);
		addHeaders(headers);
		
	}
	@When("user add formdata for changeprofilepic")
	public void user_add_formdata_for_changeprofilepic() {
		addFormData("profile_picture", new File(getProjectPath() +"\\Images\\sele logo.png"));

	}
	@When("user send {string} request for changeprofilepic endpoint")
	public void user_send_request_for_changeprofilepic_endpoint(String reqtype) {
		response = addRequestType(reqtype, Endpoints.CHANGEPROFILEPIC);
		int responsecode = getResponsecode(response);
		TC_1LoginStep.globaldatas.setResponsecode(responsecode);
	}
	@Then("user should verify the changeprofilepic response message matches {string}")
	public void user_should_verify_the_changeprofilepic_response_message_matches(String expChangeProfilepicMsg) {
		ChangeProfilePicture_Output_Pojo changeProfilePicture_Output_Pojo = response.as(ChangeProfilePicture_Output_Pojo.class);
		String actChangeProfilePicMsg = changeProfilePicture_Output_Pojo.getMessage();
		Assert.assertEquals("verify change profilepic msg", expChangeProfilepicMsg, actChangeProfilePicMsg);

	}



}
