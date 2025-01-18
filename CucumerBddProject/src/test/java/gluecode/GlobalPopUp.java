package gluecode;

import io.cucumber.java.en.Given;
import utils.Kernel;

public class GlobalPopUp extends Kernel {

	@Given("^user type the locale manually on the url and validate the popup \"([^\"]*)\"$")
	public void user_type_the_locale_manually_on_the_url(String arg1) throws Throwable {

		switch (arg1) {
		case "ae":
			driver.navigate().to(localEnvUrl + "ae/packages/greece");
			if (elementDisplayed(globalPage.getGlobalCountryConfirmationPopup())) {
				clickAction(globalPage.getGlobalPopUpUaeButton());
				System.out.println(getCurrentUrl());
				validate_String_Contains(getCurrentUrl(), "/ae");
			}

			break;
		case "us":
			driver.navigate().to(localEnvUrl + "us/packages/greece");
			if (elementDisplayed(globalPage.getGlobalCountryConfirmationPopup())) {
				clickAction(globalPage.getGlobalPopUpUsButton());
				validate_String_Contains(getCurrentUrl(), "/us");
			}

			break;
		case "india":
			driver.navigate().to(localEnvUrl + "us/packages/greece");
			if (elementDisplayed(globalPage.getGlobalCountryConfirmationPopup())) {
				clickAction(globalPage.getGlobalPopUpIndiaButton());
				validateAssertion(compareTwoStrings(getCurrentUrl(), localEnvUrl + "packages/greece"));
			}

		}
	}
}
