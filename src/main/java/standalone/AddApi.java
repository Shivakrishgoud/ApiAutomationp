
package standalone;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class AddApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress("Varikolu village, karimnagar dist, Telangana 09");
		p.setName("shivakrishna");
		p.setPhone_number("9676954276");
		p.setWebsite("http://google.com");
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		List<String> mylist = new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		
		p.setTypes(mylist);
		p.setLanguage("Telugu");
		
		
          RestAssured.baseURI = "http://rahulshettyacademy.com";
          Response responce =  given().log().all().queryParam("key", "qaclick123").body(p).when().post("/maps/api/place/add/json").
            then().assertThat().statusCode(200).extract().response();
		
		String res = responce.asString();
		System.out.println(res);
		
		
		
		
		
	}

}


