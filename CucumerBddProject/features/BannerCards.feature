@bannercard
Feature: Validating all banner cards in Home page

  #Maldives
  @sanity
  Scenario Outline: Validating maldives banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Maldives banner card
    When Click on the View Deal button from the first package itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # Dubai
  @sanity
  Scenario Outline: Validating Dubai banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Dubai banner card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # Europe
  @sanity
  Scenario Outline: Validating Europe banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Europe banner card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # Thailand
  @sanity
  Scenario Outline: Validating Thailand banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Thailand banner card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # Bali
  @sanity
  Scenario Outline: Validating Bali banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Bali banner card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # Austria
  Scenario Outline: Validating Austria banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Austria banner card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # Finland
  Scenario Outline: Validating Finland banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Finland banner card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # Norway
  @sanity
  Scenario Outline: Validating Norway banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Norway banner card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # Italy
  @sanity
  Scenario Outline: Validating Italy banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Italy banner card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # Switzerland
  @sanity
  Scenario Outline: Validating Switzerland banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Switzerland banner card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # France
  @sanity
  Scenario Outline: Validating France banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on France banner card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # United Kingdom
  Scenario Outline: Validating United Kingdom banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on United Kingdom banner card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # Turkey
  Scenario Outline: Validating Turkey banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Turkey banner card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # Spain
  Scenario Outline: Validating Spain banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Spain card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # Azerbijan
  @sanity
  Scenario Outline: Validating Azerbaijan banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Azerbijan card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # Australia
  @sanity
  Scenario Outline: Validating Australia banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Australia card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # New zealand
  @sanity
  Scenario Outline: Validating New zealand banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on New zealand card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # Singapore
  @sanity
  Scenario Outline: Validating Singapore banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Singapore card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # Vietnam
  Scenario Outline: Validating Vietnam banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Vietnam card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |

  # Srilanka
  @sanity
  Scenario Outline: Validating Srilanka banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Srilanka card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |
      
      
   # Philippines
  Scenario Outline: Validating Philippines banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Philippines card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |
      
  # Malaysia
  Scenario Outline: Validating Malaysia banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Malaysia card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |
      
       # Japan
       @sanity
  Scenario Outline: Validating Japan banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Japan card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |
      
      
       # Denmark
  Scenario Outline: Validating Denmark banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Denmark card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |
      
       # Iceland
  Scenario Outline: Validating Iceland banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Iceland card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |
      
       # Sweden
  Scenario Outline: Validating Sweden banner card
    Given Login to the product with admin credential using "<adminNo>" and "<iPin>"
    Then validate whether user logged in successfully
    Then Click on Sweden card
    When Create an Itinerary
    Then validate that the itinerary is created succesfully

    Examples: 
      | adminNo    | iPin   |
      | 6383589200 | 666666 |
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
