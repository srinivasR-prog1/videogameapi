package restAssuredAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_GET_SingleVideoGame {
	
	@Test
	public void getSingleGame()
	{
		
		int vgId=5;
		RestAssured.baseURI="http://localhost:8080";
		RequestSpecification httpRequest=RestAssured.given();
		httpRequest.header("Content-Type","application/json").
		                   contentType(ContentType.JSON).
		                   accept(ContentType.JSON);
		Response response=httpRequest.get("/app/videogames/"+vgId);
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		String vgRelease=JsonPath.from(response.asString()).get("releaseDate");
		Object vgreScore=JsonPath.from(response.asString()).get("reviewScore");
		 String vgrScore= String.valueOf(vgreScore);
		String vgCategory=JsonPath.from(response.asString()).get("category");
		String vgRating=JsonPath.from(response.asString()).get("rating");
		
		System.out.println(vgRelease+"\t"+vgrScore+"\t"+vgCategory+"\t"+vgRating);
		
		
	}

}
