@transfers @sanity
Feature: Transfers sanity validation
    Validate the Transfers functionality in the itinerary page.

  Scenario Outline: Validate able to replace the transfer in the itinerary
    Given Login as a existing user while creating itinerary for europe with Paris Barcelona "<region>", "<uName>", "<passwd>"
    Then validate whether the Signup is successful
    Then validate the itinerary is costed
    Then validate able to replace the transfer in the itinerary

    Examples: 
      | region | uName      | passwd |
      | Europe | 6383589200 | 666666 |


  Scenario Outline: Validate able to add the car transfer
    Given Login as a existing user while creating itinerary for europe with Paris Barcelona "<region>", "<uName>", "<passwd>"
    Then validate whether the Signup is successful
    Then validate the itinerary is costed
    Then validate able to add the car transfer on the itinerary page

    Examples: 
      | region | uName      | passwd |
      | Europe | 6383589200 | 666666 |


  Scenario Outline: Validate able to remove the car transfer
    Given Login as a existing user while creating itinerary for europe with Paris Barcelona "<region>", "<uName>", "<passwd>"
    Then validate whether the Signup is successful
    Then validate the itinerary is costed
    Then validate able to remove the car transfer on the itinerary page

    Examples: 
      | region | uName      | passwd |
      | Europe | 6383589200 | 666666 |

  Scenario Outline: Validate able to change the car transfer to private and shared as Admin
    Given Login as a existing user while creating itinerary for europe with Paris Barcelona "<region>", "<uName>", "<passwd>"
    Then validate whether the Signup is successful
    Then validate the itinerary is costed
    Then validate able to change the car transfer to private and shared on the itinerary page

    Examples: 
      | region | uName      | passwd |
      | Europe | 6383589200 | 666666 |

  Scenario Outline: Validate able to change the car transfer to private and shared as User
    Given Login as a existing user while creating itinerary for europe with Paris Barcelona "<region>", "<uName>", "<passwd>"
    Then validate whether the Signup is successful
    Then validate the itinerary is costed
    Then validate able to change the car transfer to private and shared on the itinerary page as User

    Examples: 
      | region | uName      | passwd |
      | Europe | 8917374415 | 666666 |

  Scenario Outline: Validate able to add the train transfer
    Given Login as a existing user while creating itinerary for europe with "<region>", "<uName>", "<passwd>"
    Then validate whether the Signup is successful
    Then validate able to add the train transfer

    Examples: 
      | region | uName      | passwd |
      | Europe | 6383589200 | 666666 |

  Scenario Outline: Validate able to remove the train transfer
    Given Login as a existing user while creating itinerary for europe with "<region>", "<uName>", "<passwd>"
    Then validate whether the Signup is successful
    Then validate able to remove the train transfer

    Examples: 
      | region | uName      | passwd |
      | Europe | 6383589200 | 666666 |

  Scenario Outline: Validate able to change the train transfer
    Given Login as a existing user while creating itinerary for europe with "<region>", "<uName>", "<passwd>"
    Then validate whether the Signup is successful
    Then validate able to change the train transfer

    Examples: 
      | region | uName      | passwd |
      | Europe | 6383589200 | 666666 |


  Scenario Outline: Validate able to change the Rental car transfer
    Given User navigates to the "<packages>" page
    When Click on the "<clickOn>" button from the first package itinerary
    Then Login to the application through packages with valid username and password with "<uName>" and "<passwd>"
    Then validate the itinerary is costed
    Then validate able to change the Rental car transfer

    Examples: 
      | packages                | clickOn   | uName      | passwd |
      | packages/south-africa   | View Deal | 6383589200 | 666666 |

  Scenario Outline: Validate able to add the Ferry transfer
    Given Login as a existing user while creating itinerary for Thailand "<region>", "<uName>", "<passwd>"
    Then validate the itinerary is costed
    Then validate able to add the Ferry transfer

    Examples: 
      | region   | uName      | passwd |
      | Thailand | 6383589200 | 666666 |

  Scenario Outline: Validate able to remove the Ferry transfer
    Given Login as a existing user while creating itinerary for Thailand "<region>", "<uName>", "<passwd>"
    Then validate the itinerary is costed
    Then validate able to remove the Ferry transfer

    Examples: 
      | region   | uName      | passwd |
      | Thailand | 6383589200 | 666666 |

  Scenario Outline: Validate able to change the Ferry transfer
    Given Login as a existing user while creating itinerary for Thailand "<region>", "<uName>", "<passwd>"
    Then validate the itinerary is costed
    Then validate able to change the Ferry transfer

    Examples: 
      | region   | uName      | passwd |
      | Thailand | 6383589200 | 666666 |
