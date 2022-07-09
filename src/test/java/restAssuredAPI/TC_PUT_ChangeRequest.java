package restAssuredAPI;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_PUT_ChangeRequest {
	
	@Test
	public void putChangeRequest()
	{
		int vgId=5;
		RestAssured.baseURI="http://localhost:8080";
		RequestSpecification httpRequest=RestAssured.given();
		httpRequest.header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON);
		HashMap<String,String> map= new HashMap<String,String>();
		map.put("id", "5");
		map.put("name", "Adventure");
		map.put("releaseDate", "2021-06-04");
		map.put("reviewScore", "95");
		map.put("category", "Strategy");
		map.put("rating", "Universal");
		Response response=httpRequest.body(map).put("/app/videogames/"+vgId);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.prettyPrint();
		
		
		
	}
	
	
	
	

}
