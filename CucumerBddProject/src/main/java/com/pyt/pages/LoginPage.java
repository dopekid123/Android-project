package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginPage {

	// Home Page Footer

	@FindBy(xpath = "//*[contains(text(),'Travel Troops Global Private Ltd')]")
	private WebElement footerLinkPyt;

	@FindBy(xpath="//div[contains(text(),'Login')] | (//button[contains(text(),'Login')])[2]")
	private WebElement login;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement uncostedPacklogin;

//	@FindBy(xpath="//*/div/*[contains(text(),'Login')]")
	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement gcmHeaderLogin;
	
	//@FindBy(xpath="//div[@class='atom-web-c-gqwkJN atom-web-c-gqwkJN-iTKOFX-direction-column atom-web-c-gqwkJN-irEjuD-align-stretch atom-web-c-gqwkJN-awKDG-justify-start atom-web-c-gqwkJN-kVNAnR-wrap-noWrap atom-web-c-gqwkJN-ifTQxoS-css']//div[@class='atom-web-c-lesPJm atom-web-c-gBnSef atom-web-c-gBnSef-ibPNjhd-css']//input[@id='name'] | //label[contains(text(),'Mobile Number')]/../input")
	@FindBy(xpath="//label[contains(text(),'Mobile Number')]/../input | //label[contains(text(),'mobile number')]/../input | //input[contains(@placeholder,'mobile number')]")
	private WebElement userName;

	@FindBy(xpath="//input[@placeholder='Password'] | (//div[contains(text(),'Password')])[2]/../input")
	private WebElement password;

	@FindBy(xpath="//button[text()='Continue'] | (//div[contains(text(),'Login')])[2] | //div[text()='Login'] | //button[text()='Login']")
//	@FindBy(xpath="//*[contains(text(),'Login')]")
	private WebElement loginButton;

	@FindBy(xpath="//button[contains(text(),'Sign up')]")
	private WebElement signupButton;

	@FindBy(xpath="//button[contains(text(),'Forgot')]")
	private WebElement forgotPasswordButton;

	@FindBy(xpath="//span[@class='user-initials'] | //nav[@data-orientation='horizontal']//li[7]")
	private WebElement menuButton;

	@FindBy(xpath="//a[@class='danger-hover']")
	private WebElement logoutButton1;

	@FindBy(xpath="//span[text()='Registered mobile number is not valid']")
	private WebElement invalidUserAlert;

	@FindBy(xpath="//span[text()='Invalid username or password.']")
	private WebElement invalidPasswordAlert;

	@FindBy(xpath="//button[contains(@class,'login-cta-in-modal')] | //button[text()='Continue'] | (//button[text()='Login'])[1]")
	private WebElement packCtaLogin;

	@FindBy(xpath="//button[contains(text(),'Get my personalized itinerary')]")
	private WebElement vacCtaLogin;
	
	@FindBy(xpath="//span[@class='slider']")
	private WebElement toggleButton;
	
	@FindBy(xpath="(//*[@class='pyt-close-16'])[2]")
	private WebElement closeLoginModal;
	
	@FindBy(xpath="//span[@class='help-block']")
	private WebElement errorMsg;
	
//	@FindBy(xpath="//*[contains(@class,'HeaderSubmenu') and not(contains(@class,'hidden-xs header-submenu'))]")
//	@FindBy(xpath="(//span[@class='user-initials'] | (//a[@class='dropdown-toggle'])[3]/div)[2]")
	@FindBy(xpath="//span[contains(@class,'user-initials')] | //div[contains(@class,'Navbar__Avatar')] | //div[contains(@class,'NavbarWrapper__Avatar')] |(//div[contains(text(),'Q')])[2]")
	private WebElement subMenu;
	
	@FindBy(xpath="(//span[@class='user-initials'] | //a[@class='dropdown-toggle'])[3]/div | //a[contains(text(),'Logout']")
	private WebElement secondLogoutHeader;

	@FindBy(xpath="//*[contains(text(),'Login')]")
	private WebElement loginButtonAfterLogOut;
	
	@FindBy(xpath="(//div[contains(text(),'Login')])[2]")
	private WebElement SecondloginButton;
	
	@FindBy(xpath="//img[contains(@src,'logo/deals')]")
	private WebElement dealsLogo;
	
	@FindBy(xpath="//span[text()='Search your favourite destination']")
	private WebElement HolidayPackagesSearchCTA;
	
	@FindBy(xpath="//div[contains(@class,'maldives-page')]")
	private WebElement maldivesHomePage;
	
	@FindBy(xpath="//div[contains(@class,'testimonial')]")
	private WebElement testimonial;
	
	@FindBy(xpath="//div[contains(@class,'contact-us')]")
	private WebElement contactUs;
	
	@FindBy(xpath="//div[contains(@id,'faqheader')]")
	private WebElement faqHeader;
	
	@FindBy(xpath="//section[contains(@class,'careers')]")
	private WebElement careers;
	
	@FindBy(xpath="//section[contains(@class,'aboutus-page')]")
	private WebElement aboutUs;
	
	@FindBy(xpath="//button[contains(text(),'Check availability')]")
	private WebElement maldivesUncostedPage;
	
	@FindBy(xpath="//span[contains(text(),'Packages')]")
	private WebElement packages;
	
	@FindBy(xpath="(//a[text()='Logout'])")
	private WebElement logoutButtonMle;
	
	@FindBy(xpath="(//a[text()='Logout'])[2]")
	private WebElement uncostedPacklogoutButton;
	
	@FindBy(xpath="//button[text()='Get OTP']")
	private WebElement Otp;
	
	@FindBys(@FindBy(xpath="(//div[@style='display: flex; justify-content: space-between;'])[1]//div"))
	private List<WebElement> otpPwd;
	
	@FindBy(xpath="//nav[@aria-label='Main']//li[7]/div | //span[@class='user-initials']")
	private WebElement userAvatar;
	
	@FindBy(xpath="//span[contains(text(),'Wrong OTP Entered')]")
	private WebElement wrongOTP;
	
	@FindBy(xpath="//span[text()='Enter OTP']")
	private WebElement enterOTPScreen;
	
	@FindBy(xpath="(//span[contains(text(),'Enter OTP')]/../..//*[name()='svg'])[2]")
	private WebElement closeOTP;
	
	@FindBy(xpath="//button[text()='No'] | (//button[text()='No'])[1]")
	private WebElement exitNo;

	@FindBy(xpath="//button[text()='Yes'] | (//button[text()='Yes'])[1]")
	private WebElement exitYes;
	
	@FindBy(xpath="//span[text()='Resend OTP'] | //span[contains(text(),'Resend OTP')]")
	private WebElement resendOTP;
	
	@FindBy(xpath="//span[text()='Edit'] | //span[contains(text(),'OTP has been sent to your Mobile number')]/../*[name()='svg'] | //span[contains(text(),'OTP has been sent')]/../div/span[2]/*[name()='svg']")
	private WebElement editNo;
	
	@FindBy(xpath="//span[text()='Edit']")
	private WebElement editIcon;
	
	@FindBy(xpath="//*[text()='tamil']")
	private WebElement languageSelection;
	
	@FindBy(xpath = "//button[text()='Sign up']")
	private WebElement signupbutton;

	@FindBy(xpath = "(//div[@role='dialog']//*[name()='svg'])[5]")
	private WebElement invalidotpsign;

	@FindBy(xpath = "(//button[text()='Get OTP'])[1]")
	private WebElement otpbutton;

	@FindBy (xpath = "//input[@id='name']")
    private WebElement headerusername;
	
	@FindBy(xpath="//button[text()='Continue']")
	private WebElement packCtaContinue;
	
	@FindBy(xpath="//a[@class='veho-c-bxEmRG veho-c-bxEmRG-igsmDXe-css'][normalize-space()='Logout']")
	private WebElement logoutButton2;
	
	@FindBy(xpath="//button[contains(text(),'Verify & Save Itinerary')]")
	private WebElement verifyAndSaveItinerary;
	
	public WebElement getVerifyAndSaveItinerary() {
		return verifyAndSaveItinerary;
	}

	public WebElement getEditIcon() {
		return editIcon;
	}
	
	public WebElement getheaderusername() {
		return headerusername;
	}

	public WebElement getotpbutton() {
		return otpbutton;
	}

	public WebElement getinvalidotp() {
		return invalidotpsign;
	}

	public WebElement getsignupbutton() {
		return signupbutton;
	}

	public WebElement getLanguageSelection() {
		return languageSelection;
	}

	public WebElement getEditNo() {
		return editNo;
	}

	public WebElement getResendOTP() {
		return resendOTP;
	}
	
	public WebElement getEnterOTPSreen() {
		return enterOTPScreen;
	}

	public WebElement getExitNo() {
		return exitNo;
	}
	
	public WebElement getExitYes() {
		return exitYes;
	}
	
	public WebElement getCloseOTP() {
		return closeOTP;
	}

	public WebElement getWrongOTP() {
		return wrongOTP;
	}

	public WebElement getOtp() {
		return Otp;
	}
	
	public WebElement getUncostedPacklogin() {
		return uncostedPacklogin;
	}
	
	public WebElement getUncostedPacklogoutButton() {
		return uncostedPacklogoutButton;
	}
	
	public WebElement getLogoutButtonMle() {
		return logoutButtonMle;
	}
	
	public WebElement getDealsLogo() {
		return dealsLogo;
	}
	
	public WebElement gettHolidayPackagesSearchCTA() {
		return HolidayPackagesSearchCTA;
	}
	
	public WebElement getMaldivesHomePage() {
		return maldivesHomePage;
	}
	
	public WebElement getTestimonial() {
		return testimonial;
	}
	
	public WebElement getContactUs() {
		return contactUs;
	}
	
	public WebElement getFaqHeader() {
		return faqHeader;
	}
	
	public WebElement getCareers() {
		return careers;
	}
	public WebElement getAboutUs() {
		return aboutUs;
	}
	public WebElement getMaldivesUncostedPage() {
		return maldivesUncostedPage;
	}
	
	public WebElement getpackages() {
		return packages;
	}
	
	public WebElement getSecondLoginButton() {
		return SecondloginButton;
	}
	
	public WebElement getSecondLogoutHeader() {
		return secondLogoutHeader;
	}
	
	public WebElement getloginButtonAfterLogOut()
	{
		return loginButtonAfterLogOut;
	}
	
	public WebElement getToggleButton()
	{
		return toggleButton;
	}

	public WebElement getvacCtaLogin()
	{
		return vacCtaLogin;
	}

	public WebElement getpackCtaLogin()
	{
		return packCtaLogin;
	}
	public WebElement getGCMHeaderLogin()
	{
		return gcmHeaderLogin;
	}

	public WebElement getfooterLinkPyt() {
		return footerLinkPyt;
	}
	public WebElement getLogin() {
		return login;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getSignupButton() {
		return signupButton;
	}

	public WebElement getforgotPasswordButton() {
		return forgotPasswordButton;
	}

	public WebElement getmenuButton() {
		return menuButton;
	}

	public WebElement getlogoutButton1() {
		return logoutButton1;
	}

	public WebElement getInvalidUserAlert()
	{
		return invalidUserAlert;
	}

	public WebElement getInvalidPasswordAlert()
	{
		return invalidPasswordAlert;
	}
	
	public WebElement getCloseLoginModal()
	{
		return closeLoginModal;
	}
	
	public WebElement getErrorMsg()
	{
		return errorMsg;
	}
	
	public WebElement getSubMenu()
	{
		return subMenu;
	}
	
	public WebElement getUserAvatar() {
		return userAvatar;
	}
	
	public WebElement getPackCtaContinue() {
		return packCtaContinue;
	}
	
	public WebElement getlogoutButton2() {
		return logoutButton2;
	}
	
}