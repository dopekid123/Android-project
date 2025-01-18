@seochecks

Feature: Validating different SEO Checks across different URLs

@seochecks
Scenario Outline: Validating SEO Checks like Meta tags, Breadcrumbs, Interlinking, Popup, Canonical, Itineraries and CTAs(PDG/View Details/Call Now/GCM)

#	Given Initialise the Output file "<outputFilePath>"	
	#Given User reads the urls from the input csv file "<seoChecksUrl>"
	When Navigate to the SEO "<seoUrl>"
	Then Validate whether Popup is displayed
	Then Validate whether Meta tags are present
	Then Validate whether Canonical is present
	Then Validate whether CTAs are present
	Then Validate whether Interlinking links are displayed and not repeated
	When Click on the "<clickOn>" button from the first package itinerary
 	Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
 	Then Validate whether you are able to cost the itinerary using View Details

	Examples: 
      |seoUrl																						| clickOn  | uName			|passwd|
      |https://pickyourtrail.com/honeymoon-packages/bali|View Deal|8917374415	|666666|
      |https://pickyourtrail.com/honeymoon-packages/greece| View Deal|8917374415	|666666|
      |https://pickyourtrail.com/honeymoon-packages/maldives| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/honeymoon-packages/vietnam| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/honeymoon-packages/switzerland| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/honeymoon-packages/thailand| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/honeymoon-packages/iceland| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/honeymoon-packages/philippines| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/honeymoon-packages/turkey| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/honeymoon-packages/paris| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/honeymoon-packages/europe| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/honeymoon-packages/italy| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/honeymoon-packages/international-honeymoon-packages-under-1lakh| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/honeymoon-packages/finland| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/honeymoon-packages/singapore| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/honeymoon-packages/dubai| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/us/honeymoon-packages/italy| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/honeymoon-packages/australia| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/honeymoon-packages/santorini| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/honeymoon-packages/malaysia| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-chennai| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-chennai/bali| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-kochi/thailand| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-bengaluru| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-kochi/bali| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-mumbai/bali| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-bengaluru/bali| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-ahmedabad/bali| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-hyderabad| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-chennai/malaysia| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-chennai/singapore| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-trivandrum| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-delhi| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-chennai/thailand| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-kochi/malaysia| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-delhi/bali| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-hyderabad/bali| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-kochi/maldives| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-kochi| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages-from-kochi/singapore| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/northern-lights-tours| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/maldives| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/bali| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/europe| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/greece| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/singapore-malaysia| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/dubai| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/italy| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/japan| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/greece-turkey| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/greece-italy| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/thailand| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/vietnam| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/baku| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/turkey| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/malaysia-thailand-singapore| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/singapore| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/paris-switzerland| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/paris-switzerland-italy| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/packages/austria| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/best-gifts-to-buy-in-thailand| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/best-things-to-buy-in-bangkok| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/bali-in-july| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/bali-vs-vietnam| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/what-to-buy-in-bali| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/sri-lanka-vs-thailand| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/phuket-in-may| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/attractions/xxxx-brewery-tours-australia| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/best-time-to-visit-pattaya| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/things-to-do/bungee-jumping-dubai| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/phuket-in-august| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/new-attractions-in-dubai| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/phuket-in-july| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/phuket-in-june| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/best-time-to-visit-chiang-mai| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/phuket-in-april| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/bangkok-in-august| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/bangkok-in-september| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/bangkok-in-april| View Deal|8917374415	|666666|
			|https://pickyourtrail.com/thailand-in-june| View Deal|8917374415	|666666|