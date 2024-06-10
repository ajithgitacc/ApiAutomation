package org.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.omrbranch.baseclass.BaseClass;
import org.omrbranch.endpoints.Endpoints;
import org.omrbranch.pojo.address.CityList_Input_pojo;
import org.omrbranch.pojo.address.CityList_Output_Pojo;
import org.omrbranch.pojo.address.citydata;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC3_CityListStep extends BaseClass {
	Response response;
	@Given("user add header for citylist")
	public void user_add_header_for_citylist() {
		List<Header> listheader= new ArrayList<>();
		Header h1= new Header("accept", "application/json");
		Header h2= new Header("Content-Type", "application/json");
		listheader.add(h1);
		listheader.add(h2);
		Headers headers= new Headers(listheader);
		addHeaders(headers);
			
	}
	@When("user add requestbody stateid for get citylist")
	public void user_add_requestbody_stateid_for_get_citylist() {
		CityList_Input_pojo citylistinput= new CityList_Input_pojo(TC_1LoginStep.globaldatas.getStateIdText());
		addRequestBody(citylistinput);
		
	}
	@When("user send {string} request for citylist endpoint")
	public void user_send_request_for_citylist_endpoint(String reqtype) {
		response = addRequestType(reqtype, Endpoints.CITYLIST);
		int responsecode = getResponsecode(response);
		TC_1LoginStep.globaldatas.setResponsecode(responsecode);
		
	}
	@Then("user should verify the city list response message matches {string} and saved cityid")
	public void user_should_verify_the_city_list_response_message_matches_and_saved_cityid(String expCityName) {
		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);
		ArrayList<citydata> citylists = cityList_Output_Pojo.getData();
		for (citydata eachcitylist : citylists) {
			String actcityname = eachcitylist.getName();
			if (actcityname.equals (expCityName)) {
				int cityidnum = eachcitylist.getId();
				TC_1LoginStep.globaldatas.setCityIdNum(cityidnum);
				System.out.println("Cityidnum:"+cityidnum);
				Assert.assertEquals("verify city name", expCityName, actcityname);
				break;
				
			}
		}
		
		
	}



}
