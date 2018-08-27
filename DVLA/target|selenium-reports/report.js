$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/Features/V.feature");
formatter.feature({
  "line": 1,
  "name": "Driver \u0026 Vehicle Licensing Agency website provides Vehicle Details",
  "description": "\nIn order to see the vehicle details\nThe User should visit DVLA website \"https://www.gov.uk/get-vehicle-information-from-dvla\"",
  "id": "driver-\u0026-vehicle-licensing-agency-website-provides-vehicle-details",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1528857633,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "DLVA",
  "description": "",
  "id": "driver-\u0026-vehicle-licensing-agency-website-provides-vehicle-details;dlva",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "One single excel file having vehicle registration details considered as Test Data",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "Check The excel file is not empty",
  "keyword": "But "
});
formatter.step({
  "line": 10,
  "name": "I read the excel file line by line for data",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I navigate to the DVLA website",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I click on Start Now button",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I enter Vehicle Regnumber in the text box followed by Clicking on Continue button",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I validate the Vehicle information populated on the webpage against test data",
  "keyword": "Then "
});
formatter.match({
  "location": "CucumberTest.one_single_excel_file_having_vehicle_registration_details_considered_as_Test_Data()"
});
formatter.result({
  "duration": 109851821,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.check_The_excel_file_is_not_empty()"
});
formatter.result({
  "duration": 552510894,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.i_read_the_excel_file_line_by_line_for_data()"
});
formatter.result({
  "duration": 23390676,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.i_navigate_to_the_DVLA_website()"
});
formatter.result({
  "duration": 419050137,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.i_click_on_Start_Now_button()"
});
formatter.result({
  "duration": 436008134,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.i_enter_Vehicle_Regnumber_in_the_text_box_followed_by_Clicking_on_Continue_button()"
});
formatter.result({
  "duration": 4096330968,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.i_validate_the_Vehicle_information_populated_on_the_webpage_against_test_data()"
});
formatter.result({
  "duration": 1389680,
  "status": "passed"
});
formatter.after({
  "duration": 76252101,
  "status": "passed"
});
});