package gluecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.Kernel;

public class CouponAndLoyalityCreditsGlue extends Kernel {
	
	public static int Totalcreditcoins ;
	int discountapplied = 0;
	boolean disablehsbc ;
	boolean disablecouponcode ;
	
	
		@Then("^apply \"([^\"]*)\" in live price screen$")
		public void apply_in_live_price_screen(String couponcode) throws Throwable {
		scrollDown();
		pollingWait(psp.getApplydiscount(), 50);
		clickJavaScriptElement(psp.getApplydiscount());
		pollingWait(psp.getEntercouponcode(), 15);
		typeText(psp.getEntercouponcode(),couponcode); 
		clickAction(psp.getApply());
		Thread.sleep(1000);
	}
		@Then("^apply loyality credit \"([^\"]*)\" in live price screen$")
		public void apply_loyality_credit_in_live_price_screen(String amt) throws Throwable {
		scrollDown();
		pollingWait(psp.getApplyLoyality(), 25);
		clickJavaScriptElement(psp.getApplyLoyality());
		pollingWait(psp.getEnterLoyality(), 15);
		String value = psp.getEnterLoyality().getAttribute("value");
		System.out.println("value--"+value);
		if(value.contains(amt)) {
			clickAction(psp.getApply());
		}
		}
		
		
		@Then("^Validate coupon code is displayed or not$")
		public void validate_coupon_code_is_displayed_or_not() throws Throwable {
		Thread.sleep(1000);
		validateAssertion(elementDisplayed(sDetails.getCouponText()));
		}

		@Then("^Validate after applied coupon code offer loyality and HSBC offer should be disabled$")
		public void validate_after_applied_coupon_code_offer_loyality_and_HSBC_offer_should_be_disabled() throws Throwable {
			
		boolean disableloyaltycredit=verifyEnabled(sDetails.getEnableApplyLoyaltyCredits());
        System.out.println(validateAssertion(!disableloyaltycredit));
//		boolean disablehsbc = verifyEnabled(sDetails.getEnableapplyHsbc());
//		System.out.println(validateAssertion(!disablehsbc));
		
		}

		@Then("^Validate once user removes the coupon other offers such as loyality and HSBC offer should be enabled$")
		public void validate_once_user_removes_the_coupon_other_offers_such_as_loyality_and_HSBC_offer_should_be_enabled() throws Throwable {
		clickAction(sDetails.getOfferClose());
		
//		 boolean enablehbsc = verifyEnabled(sDetails.getApplyHsbc());
//    	 validateAssertion(enablehbsc);
		 boolean enableloyaltycredit = verifyEnabled(sDetails.getApplyloyaltycredits());
		 validateAssertion(enableloyaltycredit);
			 
		}
		@Then("^Validate once user removes the coupon other offers such as loyality and HSBC offer should be enabled on pdf flow$")
		public void validate_once_user_removes_the_coupon_other_offers_such_as_loyality_and_HSBC_offer_should_be_enabled_on_pdf_flow() throws Throwable {
			clickAction(sDetails.getOfferClose());
			
//			 boolean enablehbsc = verifyEnabled(sDetails.getApplyHsbc());
//	    	 validateAssertion(enablehbsc);
	    	 boolean enableloyalcreditpdf = verifyEnabled(sDetails.getApplyLoyaltyCreditPdg());
	    	 validateAssertion(enableloyalcreditpdf);
		}

				
		@And("^verify total loyality coins in my account section$")
		public void verify_total_loyality_coins_in_my_account_section() throws Throwable {
			Thread.sleep(1000);
			clickAction(ac.getLoyaltyCreditTab());
			Thread.sleep(1000);
			String internationalcredits = ac.getInternationalCreditCoins().getText();
			String domesticcredits = ac.getDomesticCoins().getText();
			Totalcreditcoins = Integer.parseInt(internationalcredits.replaceAll("[^0-9]", "")) + Integer.parseInt(domesticcredits.replaceAll("[^0-9]", ""));
			clickAction(hp.getPytLogo());
			Thread.sleep(2000);
		   
		}
		
	
		@And("^verify loyality on your account section amount should be shown on respective deals and International page$")
		public void verify_loyality_on_your_account_section_amount_should_be_shown_on_respective_deals_and_International_page() throws Throwable {
			  scrollDown();
			  waitForMe(sDetails.getLoyaltycreditcoins());
			  String loyaltycoins = sDetails.getLoyaltycreditcoins().getText();
			  String[] loyaltycoinssplit =loyaltycoins.split(" ");
			  String loyaltycoinspart0 = loyaltycoinssplit[0];
			  int loyaltycoinsint = Integer.parseInt(loyaltycoinspart0.replaceAll("[^0-9]", ""));
			  Thread.sleep(3000);
			  validateAssertion(Totalcreditcoins == loyaltycoinsint);
		}
		
		@And("^verify loyality with \"([^\"]*)\" is applied or not and verify the amount deduction- International$")
		public void verify_loyality_with_is_applied_or_not_and_verify_the_amount_deduction_International(String Amount) throws Throwable {
			scrollDown();
			pollingWait(psp.getApplyLoyality(), 150);
			clickJavaScriptElement(psp.getApplyLoyality());
		    pollingWait(psp.getEnterLoyality(), 150);
		    clickAction(psp.getEnterLoyality());
		    psp.getEnterLoyality().clear();
		    
		    String[] eachamount = Amount.split(",");
		       
		    for (String amt : eachamount)
		    {


		    switch (amt) {
		    
		    case "0": {
		    	 typeText(psp.getEnterLoyality(),amt); 
		    	 clickAction(psp.getApply());
		    	 validateAssertion(elementExist(psp.getApply()));
				break;
			}
		   
		   
		    
		    
		    
		    case "3010": {
		    	 typeText(psp.getEnterLoyality(),amt); 
		    	 clickAction(psp.getApply());
		    	 Thread.sleep(2000);
		    	 validateAssertion(elementExist(psp.getApply()));
		    	 break;
		    }
		    
		    case "1500": {
		    	 typeText(psp.getEnterLoyality(),amt); 
		         clickAction(psp.getApply());
		         
		         boolean disablehsbcpdg = verifyEnabled(sDetails.getEnableapplyHsbcpdf());
		         validateAssertion(!disablehsbcpdg);
		         
		         boolean disableicicpdg = verifyEnabled(sDetails.getEnableApplyIcicpdg());
		         validateAssertion(!disableicicpdg);
				 
				 boolean disablehdfcpdg = verifyEnabled(sDetails.getEnableApplyHdfcpdg());
				 validateAssertion(!disablehdfcpdg);
				 
				 boolean disablecouponcode = verifyEnabled(sDetails.getEnablecouponcode());
				 validateAssertion(!disablecouponcode);
				 
		         
		         
		         Thread.sleep(2000);
		         clickAction(psp.getBackLink());
					Thread.sleep(2000);
					driver.findElement(By.xpath("//span[contains(@class,'SplitPrice__ShowMore')]")).click();
					String discount = driver
							.findElement(By.xpath(
									"//div[contains(@class,'RightSidePanel')]//span[contains(@class,'SplitPrice__BoldData')]"))
							.getText();
					String discountstr = discount.replaceAll("[^\\d]", "");
				

					compareTwoStrings(discountstr, amt);
		         break;
		    }
		    
		    case "10": {
		    	 typeText(psp.getEnterLoyality(),amt); 
		         clickAction(psp.getApply());
		         
		         validateAssertion(!disablehsbc);
		         validateAssertion(!disablecouponcode);
		         
		         boolean disableicicdeals = verifyEnabled(sDetails.getEnableICICDeals());
		         validateAssertion(!disableicicdeals);
				 
				 boolean disablehdfcdeals = verifyEnabled(sDetails.getEnableHdfcDeals());
				 validateAssertion(!disablehdfcdeals);
				 
		         
		         
		         Thread.sleep(2000);
		        
		    }
		  		   
		}}
			
}}

