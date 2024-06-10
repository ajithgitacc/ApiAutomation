package org.omrbranch.stepdefinition;

import java.util.ArrayList;

import org.junit.Assert;
import org.omrbranch.baseclass.BaseClass;
import org.omrbranch.endpoints.Endpoints;
import org.omrbranch.pojo.address.StateList_Output_Pojo;
import org.omrbranch.pojo.address.statedata;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC2_StateListStep extends BaseClass{
	Response response;
	@Given("user add headers for statelist")
	public void user_add_headers_for_statelist() {
		addHeader("accept", "application/json");
		
	}
	@When("user send {string} request for statelist endpoint")
	public void user_send_request_for_statelist_endpoint(String reqtype) {
		response = addRequestType(reqtype,Endpoints.STATELIST);
		int responsecode = getResponsecode(response);
		TC_1LoginStep.globaldatas.setResponsecode(responsecode);
			
	}
	@Then("user should verify the statelist response message matches {string} and saved stateid")
	public void user_should_verify_the_statelist_response_message_matches_and_saved_stateid(String expStateName) {
		
		StateList_Output_Pojo stateList_Output_Pojo = response.as(StateList_Output_Pojo.class);
		ArrayList<statedata> statelists = stateList_Output_Pojo.getData();
		for (statedata eachstatelist : statelists) {
			String actstatename = eachstatelist.getName();
			if (actstatename.equals(expStateName)) {
				int stateidnum = eachstatelist.getId();
				TC_1LoginStep.globaldatas.setStateIdNum(stateidnum);
				System.out.println("Stateidnum:"+stateidnum);
				String stateid = String.valueOf(stateidnum);
				TC_1LoginStep.globaldatas.setStateIdText(stateid);
				Assert.assertEquals("verify statename", expStateName,actstatename);
				break;
				
			}
			
		}
	}



}
