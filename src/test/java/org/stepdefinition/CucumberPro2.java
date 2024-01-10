package org.stepdefinition;

import org.base.BaseClass;
import org.sample.PageObjectModel1;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberPro2 extends BaseClass {

	PageObjectModel1 p ;
	@Given("To launch the url of the  G-mail applications")
	public void to_launch_the_url_of_the_G_mail_applications() {
	    launchBrowser();
	    windowMaximize();
	}

	@When("User has to hit the G-mail url")
	public void user_has_to_hit_the_G_mail_url() {
	    launchUrl("https://www.gmail.com/");
	}

	@When("User has to pass the data {string} in email field")
	public void user_has_to_pass_the_data_in_email_field(String em) {
	   p = new PageObjectModel1();
	   passText(em,p.getEmail());
	}

	@When("User has to  click next button")
	public void user_has_to_click_next_button() {
	    p = new PageObjectModel1();
	    clickBtn(p.getNext());
	}

	@Then("User has to close the browser")
	public void user_has_to_close_the_browser() {
	    closeEntireBrowser();
	}


}
