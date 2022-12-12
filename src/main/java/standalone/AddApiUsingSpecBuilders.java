
package standalone;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class AddApiUsingSpecBuilders {

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
		
		
         
          
   RequestSpecification reque =  new RequestSpecBuilder().setBaseUri("http://rahulshettyacademy.com").
   addQueryParam("key","qaclick123").setContentType(ContentType.JSON).build();
   
   ResponseSpecification respo = new ResponseSpecBuilder().expectStatusCode(200).
   expectContentType(ContentType.JSON).build();
   
   RequestSpecification rqst =  given().log().all().spec(reque).body(p);
   
   Response rspns = rqst.when().post("/maps/api/place/add/json").
   then().spec(respo).extract().response();
		
		String res = rspns.asString();
		System.out.println(res);
		
		
		
		
		
	}

}


