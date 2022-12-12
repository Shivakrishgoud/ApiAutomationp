package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	
	 public static RequestSpecification reque;
	
	
	
	public RequestSpecification requestSpecification() throws IOException {
		
		
		if(reque==null) {
		
		
		               PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		 reque =  new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).
				 addFilter(RequestLoggingFilter.logRequestTo(log)).
				 addFilter(ResponseLoggingFilter.logResponseTo(log)).
				 
				 addQueryParam("key","qaclick123").setContentType(ContentType.JSON).build();
		
		    return reque;
		}
		return reque;
		
		
	}
	
public static String getGlobalValue(String key ) throws IOException
	
	{
		
		
		Properties prop = new Properties();  //it helps us to read the file and fis gives the path of the file
		
		FileInputStream fis = new FileInputStream("C:/Users/shiva/Downloads/Api1/Api1/srctest/java/resources/global.properties");
	
       prop.load(fis);
       return prop.getProperty(key);
       
	}

    public String getJsonPath(Response rspns, String keyvalue) {
	
	
	String response = rspns.asString();
	
	JsonPath js = new JsonPath(response);
	
	return js.get(keyvalue).toString();
	
	
	   
	
	
	
}

	
	
	}


