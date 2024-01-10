package org.stepdefinition;

import org.base.BaseClass;
import org.sample.PageObjectModel1;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberPro1 extends BaseClass {

	@Given("To launch the Chrome browser and maximize the window")
	public void to_launch_the_Chrome_browser_and_maximize_the_window() {
		launchBrowser();
		windowMaximize();
	    
	}

	@When("To launch the url of the flipkart applications")
	public void to_launch_the_url_of_the_flipkart_applications() {
		launchUrl("https://www.flipkart.com/");
	}

	@When("To pass valid username in email field")
	public void to_pass_valid_username_in_email_field() {
		PageObjectModel1 p = new PageObjectModel1();
		passText("seleniuminmakes@gmail.com", p.getEmail());
	}

	

	@When("To check whether navigate to homePage or not")
	public void to_check_whether_navigate_to_homePage_or_not() {
	    System.out.println("To check the Flipkart credential");
	}

	@Then("To close the Browser")
	public void to_close_the_Browser() {
	    closeEntireBrowser();
	}


}