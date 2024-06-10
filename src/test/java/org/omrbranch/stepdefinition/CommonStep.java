package org.omrbranch.stepdefinition;

import org.junit.Assert;

import io.cucumber.java.en.Then;

public class CommonStep {
	@Then("user should verify the status code is {int}")
	public void user_should_verify_the_status_code_is(int expresponsecode) {
		int actresponsecode = TC_1LoginStep.globaldatas.getResponsecode();
		Assert.assertEquals("verify response code", expresponsecode, actresponsecode);
	
	}
}
