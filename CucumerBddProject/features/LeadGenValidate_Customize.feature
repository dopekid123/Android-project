@leadGen
Feature: Lead Gen validation from Packages page through Customize button and PDG flow in Product and Plato


Scenario Outline: Verify the activation channel and flows and methods on plato when user signup from Package page via customise button 
	Then search the "<Query>" on google website 
	Then click on the respective "<URL>" showing on the results 
	Then Click on the customise button and fill the GCM form to signup using "<name>" and "<emailid>" and "<mobileno>" 
	Then Login into the plato using valid credentials 
	Then Search the trail using "<mobileno>" and validate the trail is showing on plato dashboard 
	Then Validate the "<activationchannel>" and "<flowsandmethods>" for the respective trail 
	
	
	Examples: 
		|Query|URL|name|emailid|mobileno|activationchannel|flowsandmethods|
		|pickyourtrail greece packages|https://pickyourtrail.com/packages/greece|usergreece1|usergreece8079433178@pyt.com|8079433178|SEO|Packages|
		|pickyourtrail maldives packages|https://pickyourtrail.com/packages/maldives|usermle1|usermle8167806603@pyt.com|8167806603|SEO|Packages|
		|pickyourtrail dubai packages|https://pickyourtrail.com/packages/dubai|userdubai1|userdubai8207273640@pyt.com|8207273640|SEO|Packages|

				
Scenario Outline: Verify the activation channel and flows and methods on plato when user signup from PDG flow via GCM form 
	Then search the "<Query>" on google website 
	Then click on the respective "<URL>" showing on the results 
	Then Signup as new user from GCM page with "<region>" and "<name>" and "<emailid>" and "<mobileno>" 
	Then Login into the plato using valid credentials 
	Then Search the trail using "<mobileno>" and validate the trail is showing on plato dashboard 
	Then Validate the "<activationchannel>" and "<flowsandmethods>" for the respective trail 
	
	
	Examples: 
		|Query|URL|region|name|emailid|mobileno|activationchannel|flowsandmethods|
		|Pickyourtrail|https://pickyourtrail.com/|Greece|usergreece2|usergreece7887382014@pyt.com|7887382014|SEO|PDG|

Scenario Outline: Verify the activation channel and flows and methods on plato when user signup from homepage packages 
	Then search the "<Query>" on google website 
	Then click on the respective "<URL>" showing on the results 
	Then Select the "<maldiveslink>" on the homepage 
	Then Click on the customise button and fill the GCM form to signup using "<name>" and "<emailid>" and "<mobileno>" 
	Then Login into the plato using valid credentials 
	Then Search the trail using "<mobileno>" and validate the trail is showing on plato dashboard 
	Then Validate the "<activationchannel>" and "<flowsandmethods>" for the respective trail 
	
	
	
	Examples: 
		|Query|URL|maldiveslink|name|emailid|mobileno|activationchannel|flowsandmethods|
		|Pickyourtrail|https://pickyourtrail.com/|packages/maldives|usermle2|usermle8079878724@pyt.com|8079878724|SEO|Packages|
		

#Scenario Outline: Verify the activation channel and flows and methods on plato when user signup and cost the paid itinerary 
#	Then Navigate to the paid campaign link 
#	Then Click on the customise button and fill the GCM form to signup using "<name>" and "<emailid>" and "<mobileno>" 
##	And click on the first package itinerary through "<clickOn>" and costs with "<departFrom>" 
##	And signup with "<name>" and "<emailid>" and "<mobileno>"
#	Then Login into the plato using valid credentials 
#	Then Search the trail using "<mobileno>" and validate the trail is showing on plato dashboard 
#	Then Validate the "<activationchannel>" and "<flowsandmethods>" for the respective trail 
#	
#	
#	Examples: 
#		|name|emailid|mobileno|activationchannel|flowsandmethods|clickOn  |departFrom|
#		|userdubaipaid1|userdubaipaid7887073931@pyt.com|7887073931|Paid_SEM|Packages|customizeUncosted|Chennai|
		
		
			