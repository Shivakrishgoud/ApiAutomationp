Feature: Validating place Apis
@AddPlace @Regression
Scenario Outline: Verify if place is being added Successfully Added using Add place Api
    Given Add place payload with "<name>" "<Language>" "<address>"
    When user calls "AddPlaceAPI" with "POST" http Request
    Then The Api call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_id created maps to "<name>" using "getPlaceAPI"
    
Examples:

  |name       |Language    |address         |
  |Ahouse     |Teleugu     |Telangana       |
  |Bhouse     |Hindi       |MH              |


@DeletePlace @Regression
Scenario: Verify if Delete Place functionality is working

	 Given DeletePlace Payload
	 When user calls "deletePlaceAPI" with "POST" http Request
   Then The Api call got success with status code 200
	 And "status" in response body is "OK"
	 