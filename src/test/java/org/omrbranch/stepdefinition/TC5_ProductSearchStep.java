package org.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.omrbranch.baseclass.BaseClass;
import org.omrbranch.endpoints.Endpoints;
import org.omrbranch.pojo.productsearch.SearchProduct_Input_Pojo;
import org.omrbranch.pojo.productsearch.SearchProduct_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC5_ProductSearchStep extends BaseClass {
	Response response;
	@Given("user add header for product search")
	public void user_add_header_for_product_search() {
		List<Header> listheader= new ArrayList<>();
		Header h1= new Header("accept", "application/json");
		Header h2= new Header("Content-Type", "application/json");
		listheader.add(h1);
		listheader.add(h2);
		Headers headers= new Headers(listheader);
		addHeaders(headers);
	}

	@When("user add request body for product search {string}")
	public void user_add_request_body_for_product_search(String text) {
		SearchProduct_Input_Pojo searchproductinput= new SearchProduct_Input_Pojo(text);
		addRequestBody(searchproductinput);
	}

	@When("user send {string} request for product search endpoint")
	public void user_send_request_for_product_search_endpoint(String reqtype) {
		response = addRequestType(reqtype, Endpoints.SEARCHPRODUCT);
		int responsecode = getResponsecode(response);
		TC_1LoginStep.globaldatas.setResponsecode(responsecode);

	}
	@Then("user should verify the product search response message matches {string}")
	public void user_should_verify_the_product_search_response_message_matches(String expProductSearchMsg) {
		SearchProduct_Output_Pojo searchProduct_Output_Pojo = response.as(SearchProduct_Output_Pojo.class);
		String actProductSearchMsg = searchProduct_Output_Pojo.getMessage();
		Assert.assertEquals("verify product search msg", expProductSearchMsg, actProductSearchMsg);

	}







}
