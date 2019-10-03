package com.cucum.stepDefinitions;

import com.cucum.utils.ConfigReader;
import com.cucum.utils.util_methods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class postget {
	
	@Given("JSON post API is hit")
	public void json_post_API_is_hit() {
	    // Write code here that turns the phrase above into concrete actions
	   util_methods.setBaseURL(ConfigReader.baseURL());
	   util_methods.hitGetRequest(ConfigReader.getPostsPath());
	}

	@Then("response should be {int}")
	public void response_should_be(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    util_methods.checkStatusCode(int1);
	}

}
