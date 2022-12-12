package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class Stepdefination extends Utils {

	ResponseSpecification respo;
	RequestSpecification rqst;
	Response rspns;
	static String place_id;
    TestDataBuild data = new TestDataBuild();
    
    
    
    @Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String Language, String address) throws IOException {
	     
				   
				   respo = new ResponseSpecBuilder().expectStatusCode(200).
				   expectContentType(ContentType.JSON).build();
				   
				    rqst =  given().log().all().spec(requestSpecification()).body(data.addPlacePayload(name, Language, address));
		
		
		
	}
	@When("user calls {string} with {string} http Request")
	public void user_calls_with_http_request(String resource, String method) {
	    
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		if(method.equalsIgnoreCase("POST")) {
		  rspns = rqst.when().post(resourceAPI.getResource());
		  
		}
				 
		else if (method.equalsIgnoreCase("GET")) {
			rspns = rqst.when().get(resourceAPI.getResource());}	
		
	}
	@Then("The Api call got success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
	    
		assertEquals(rspns.getStatusCode(),200);
		
		
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String Expectedvalue) {
	    
		 
		
		assertEquals(getJsonPath(rspns, keyvalue),Expectedvalue);
		
		
	}


	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedNmae, String resource) throws IOException {
	    
		 place_id = getJsonPath(rspns,"place_id");
		 
		rqst =  given().spec(requestSpecification()).queryParam("place_id",place_id);
		user_calls_with_http_request(resource,"GET");
	    String actualName = getJsonPath(rspns,"name");
	    assertEquals(actualName,expectedNmae);
	
	}
	
	

	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
	   
		rqst =  given().log().all().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
		
		
	}










}
