package gluecode;

import io.cucumber.java.en.Then;
import utils.Kernel;

public class VisaGlue extends Kernel {

	@Then("^validate that admin is able to add the visa$")
	public void validate_the_admin_able_to_add_the_visa() throws Throwable {
	 validateAssertion(VisaValidationAdd());
	}

	@Then("^validate that admin is able to removed the visa$")
	public void validate_the_admin_able_to_removed_the_visa() throws Throwable {
		 validateAssertion(VisaValidationRemove());

	}


	@Then("^validate that user is able to add the visa$")
	public void validate_that_user_is_able_to_add_the_visa() throws Throwable {
		 validateAssertion(VisaValidationAdd());
	}

	@Then("^validate that user is able to remove and add the visa$")
	public void validate_that_user_is_able_to_remove_and_add_the_visa() throws Throwable {
		 validateAssertion(VisaValidationRemove());
	}




	}



