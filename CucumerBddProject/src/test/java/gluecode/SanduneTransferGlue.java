package gluecode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import utils.Kernel;

public class SanduneTransferGlue extends Kernel {

	@Then("^validate that the user able to change the transfer type \"([^\"]*)\"$")
	public void validate_that_the_user_able_to_change_the_transfer_type(String transfer_type) throws Throwable {

		if (transfer_type.equals("Private")) {
			String transferText = driver.findElement(By.xpath("(//div[@name='transfer']//li//span)[1]"))
					.getText();
			validateAssertion(transferText.equals("Private transfer"));
		} else {

			clickAction(dubaiPage.getHotelAirportTransfer());
			Thread.sleep(5000);
			String transferairportText = driver
					.findElement(By.xpath("(//div[@name='transfer']//li[2]/span)[2]")).getText();
			System.out.println(transferairportText);
			validateAssertion(transferairportText.equals("Shared transfer"));

		}

	}

}
