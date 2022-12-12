package resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	
	public AddPlace addPlacePayload(String name, String Language, String address) {
		
		
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setName(name);
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
		p.setLanguage(Language);
		return p;
		
		
	}
	
	
	
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}     
	
}