@leadGen
Feature: Lead Gen validation from Packages page Itinerary title in Product and Plato


Scenario Outline: Create Lead from Packages page Itinerary title (Same Window) through GCM and Verify the activation channel and flows & methods in plato
	Then search the "<Query>" on google website 
	Then click on the respective "<URL>" showing on the results
	And click on the first package itinerary through "<clickOn>" and costs with "<departFrom>"
	And signup with "<name>" and "<emailid>" and "<mobileno>"
	Then Login into the plato using valid credentials 
	Then Search the trail using "<mobileno>" and validate the trail is showing on plato dashboard 
	Then Validate the "<activationchannel>" and "<flowsandmethods>" for the respective trail 
	
	
	Examples: 
		|Query|URL|name|emailid|mobileno|activationchannel|flowsandmethods|clickOn  |departFrom|
		|pickyourtrail greece packages|https://pickyourtrail.com/packages/greece|usergreece8|usergreece7193819144@gmail.com|7193819144|SEO|Packages|slug|Chennai|
		|pickyourtrail dubai packages|https://pickyourtrail.com/packages/dubai|userdubai8|userdubai7337036724@gmail.com|7337036724|SEO|Packages|slug|Chennai|


Scenario Outline: Create Lead from Packages page Itinerary title (New Tab) through GCM and Verify the activation channel and flows & methods in plato
	Then search the "<Query>" on google website 
	Then click on the respective "<URL>" showing on the results
	And click on the first package itinerary through "<clickOn>" and costs with "<departFrom>"
	And signup with "<name>" and "<emailid>" and "<mobileno>"
	Then Login into the plato using valid credentials 
	Then Search the trail using "<mobileno>" and validate the trail is showing on plato dashboard 
	Then Validate the "<activationchannel>" and "<flowsandmethods>" for the respective trail 
	
	
	Examples: 
		|Query|URL|name|emailid|mobileno|activationchannel|flowsandmethods|clickOn  |departFrom|
		|pickyourtrail greece packages|https://pickyourtrail.com/packages/greece|usergreece7|usergreece7525984983@gmail.com|7525984983|SEO|Packages|slugNewTab     |Chennai   |
		|pickyourtrail dubai packages|https://pickyourtrail.com/packages/dubai|userdubai7|userdubai7887008525@gmail.com|7887008525|SEO|Packages|slugNewTab     |Chennai   |
		

Scenario Outline: Create Lead from Packages page Itinerary title (Same Window) through CBR and Verify the activation channel and flows & methods in plato
	Then search the "<Query>" on google website 
	Then click on the respective "<URL>" showing on the results
	And click on the first package itinerary through "<clickOn>" and costs with "<departFrom>"
	And user fill the cbr value in the form"<name>","<mobileno>","<emailid>"
	And post cbr form
    Then Verify the cbr posted successfully from itinerary
	Then Login into the plato using valid credentials 
	Then Search the trail using "<mobileno>" and validate the trail is showing on plato dashboard 
	Then Validate the "<activationchannel>" and "<flowsandmethods>" for the respective trail 
	
	
	Examples: 
		|Query|URL|name|emailid|mobileno|activationchannel|flowsandmethods|clickOn  |departFrom|
		|pickyourtrail maldives packages|https://pickyourtrail.com/packages/maldives|usermle7|usermle7887927643@pyt.com|7887927643|SEO|CBR|slugCBR|Chennai|
		

Scenario Outline: Create Lead from Packages page Itinerary title (New Window) through CBR and Verify the activation channel and flows & methods in plato
	Then search the "<Query>" on google website 
	Then click on the respective "<URL>" showing on the results
	And click on the first package itinerary through "<clickOn>" and costs with "<departFrom>"
	And user fill the cbr value in the form"<name>","<mobileno>","<emailid>"
	And post cbr form
    Then Verify the cbr posted successfully from itinerary
	Then Login into the plato using valid credentials 
	Then Search the trail using "<mobileno>" and validate the trail is showing on plato dashboard 
	Then Validate the "<activationchannel>" and "<flowsandmethods>" for the respective trail 
	
	
	Examples: 
		|Query|URL|name|emailid|mobileno|activationchannel|flowsandmethods|clickOn  |departFrom|
		|pickyourtrail maldives packages|https://pickyourtrail.com/packages/maldives|usermle6|userml8917018242@pyt.com|8917018242|SEO|CBR|slugCBRNewTab|Chennai|
