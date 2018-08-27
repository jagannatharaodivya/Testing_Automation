Feature: Driver & Vehicle Licensing Agency website provides Vehicle Details 

In order to see the vehicle details
The User should visit DVLA website "https://www.gov.uk/get-vehicle-information-from-dvla"


Scenario: DLVA
    Given One single excel file having vehicle registration details considered as Test Data
    But   Check The excel file is not empty
    And   I read the excel file line by line for data   
    When  I navigate to the DVLA website 
    And   I click on Start Now button
    And   I enter Vehicle Regnumber in the text box followed by Clicking on Continue button
    Then  I validate the Vehicle information populated on the webpage against test data
    



    