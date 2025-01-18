Feature: All Admin features in Flight only itinerary

  #Share Itinerary
  Scenario Outline: validating share itinerary functionality working as expected
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether the Signup is successful
    Then Create an itinerary with "<region>"
    Then validate that the itinerary is created succesfully
    Then Add the flights in edit details option
    Then Switch to flights itinerary
    Then Share the itinerary with customer mobile number using "<mobileNo>"
    Then Validate whether the itinerary shared successfully

    Examples: 
      | adminNo    | iPin   | region | mobileNo   |
      | 6383589200 | 666666 | Europe | 9080934240 |

  #Send To Plato
  Scenario Outline: validating send to plato functionality working as expected
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether the Signup is successful
    Then Create an itinerary with "<region>"
    Then validate that the itinerary is created succesfully
    Then Add the flights in edit details option
    Then Switch to flights itinerary
    Then Share the itinerary with customer mobile number using "<mobileNo>"
    Then Validate whether the itinerary shared successfully
    Then Click on send to plato button
    Then validate whether the data send to Plato

    Examples: 
      | adminNo    | iPin   | region | mobileNo   |
      | 6383589200 | 666666 | Europe | 9080934240 |

  #Overrride Exposure
  Scenario Outline: validating override exposure payment functionality working as expected
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether the Signup is successful
    Then Create an itinerary with "<region>"
    Then validate that the itinerary is created succesfully
    Then Add the flights in edit details option
    Then Switch to flights itinerary
    Then Share the itinerary with customer mobile number using "<mobileNo>"
    Then Validate whether the itinerary shared successfully
    Then Click on Override exposure payment button
    Then Validate exposure payment was overrided
    Then Click on the Reset Override exposure payment button
    Then Validate Override payment was reseted

    Examples: 
      | adminNo    | iPin   | region | mobileNo   |
      | 6383589200 | 666666 | Europe | 9080934240 |

  #Cancellation Policy
  Scenario Outline: validating cancellation policy functionality working as expected
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether the Signup is successful
    Then Create an itinerary with "<region>"
    Then validate that the itinerary is created succesfully
    Then Add the flights in edit details option
    Then Switch to flights itinerary
    Then Share the itinerary with customer mobile number using "<mobileNo>"
    Then Validate whether the itinerary shared successfully
    Then Click on cancellation policy button
    Then Validate whether cancellation policy displayed

    Examples: 
      | adminNo    | iPin   | region | mobileNo   |
      | 6383589200 | 666666 | Europe | 9080934240 |

  #Change Email
  Scenario Outline: validating change email functionality working as expected
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether the Signup is successful
    Then Create an itinerary with "<region>"
    Then validate that the itinerary is created succesfully
    Then Add the flights in edit details option
    Then Switch to flights itinerary
    Then Share the itinerary with customer mobile number using "<mobileNo>"
    Then Validate whether the itinerary shared successfully
    Then Click on change email button
    Then Enter a valid email address
    Then Validate whether new email id was updated

    Examples: 
      | adminNo    | iPin   | region | mobileNo   |
      | 6383589200 | 666666 | Europe | 9080934240 |

  #Share PDF in Whatsapp
  Scenario Outline: validating share PDF WA functionality working as expected
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether the Signup is successful
    Then Create an itinerary with "<region>"
    Then validate that the itinerary is created succesfully
    Then Add the flights in edit details option
    Then Switch to flights itinerary
    Then Share the itinerary with customer mobile number using "<mobileNo>"
    Then Validate whether the itinerary shared successfully
    Then Click on share pdf in Whatsapp button
    Then Validate whether user redirected to WA url

    Examples: 
      | adminNo    | iPin   | region | mobileNo   |
      | 6383589200 | 666666 | Europe | 9080934240 |

  #Add HOD
  Scenario Outline: validating Add HOD functionality working as expected
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether the Signup is successful
    Then Create an itinerary with "<region>"
    Then validate that the itinerary is created succesfully
    Then Add the flights in edit details option
    Then Switch to flights itinerary
    Then Share the itinerary with customer mobile number using "<mobileNo>"
    Then Validate whether the itinerary shared successfully
    Then Click on add hod button
    Then Validate whether user an add comments in HOD
    Then Validate whether the added comments where reflecting in itinerary page

    Examples: 
      | adminNo    | iPin   | region | mobileNo   |
      | 6383589200 | 666666 | Europe | 9080934240 |

  #Add booking message
  Scenario Outline: validating Add booking message functionality working as expected
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether the Signup is successful
    Then Create an itinerary with "<region>"
    Then validate that the itinerary is created succesfully
    Then Add the flights in edit details option
    Then Switch to flights itinerary
    Then Share the itinerary with customer mobile number using "<mobileNo>"
    Then Validate whether the itinerary shared successfully
    Then Click on Add booking message button
    Then Validate whether user can able to Add booking message
    Then Validate whether the added comments where reflecting in itinerary page

    Examples: 
      | adminNo    | iPin   | region | mobileNo   |
      | 6383589200 | 666666 | Europe | 9080934240 |

  #Enable/Disable Bank tranfer
  Scenario Outline: validating Enable/Disable Bank tranfer functionality working as expected
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether the Signup is successful
    Then Create an itinerary with "<region>"
    Then validate that the itinerary is created succesfully
    Then Add the flights in edit details option
    Then Switch to flights itinerary
    Then Share the itinerary with customer mobile number using "<mobileNo>"
    Then Validate whether the itinerary shared successfully
    Then Click on Enable Bank tranfer button
    Then Validate whether Bank transfer option enabled
    Then Click on Disable Bank tranfer button
    Then Validate whether Bank transfer option disabled

    Examples: 
      | adminNo    | iPin   | region | mobileNo   |
      | 6383589200 | 666666 | Europe | 9080934240 |

  #Change Locale
  @FOT
  Scenario Outline: validating Change Locale functionality working as expected
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether the Signup is successful
    Then Create an itinerary with "<region>"
    Then validate that the itinerary is created succesfully
    Then Add the flights in edit details option
    Then Switch to flights itinerary
    Then Share the itinerary with customer mobile number using "<mobileNo>"
    Then Validate whether the itinerary shared successfully
    Then Click on Change Locale button
    Then Validate whether locale has changed
    
    Examples: 
      | adminNo    | iPin   | region | mobileNo   |
      | 6383589200 | 666666 | Europe | 9080934240 |
      

