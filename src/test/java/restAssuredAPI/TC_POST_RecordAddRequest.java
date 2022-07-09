package restAssuredAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC_POST_RecordAddRequest {
	
	@Test
	public void  postAddRequest()
	{
		
		RestAssured.baseURI="http://localhost:8080";
		RequestSpecification httpRequest=RestAssured.given();
		httpRequest.header("Content-Type","application/json");
		JSONObject requestParms= new JSONObject();
		requestParms.put("id", "12");
		requestParms.put("name", "Super Smash Brothers1");
		requestParms.put("releaseDate", "2021-06-24");
		requestParms.put("reviewScore", "10");
		requestParms.put("category", "Action");
		requestParms.put("rating", "Universal");
		
		Response response=httpRequest.body(requestParms.toJSONString()).post("/app/videogames");
		Assert.assertEquals(response.getStatusCode(), 200);
		ResponseBody body = response.getBody();
		boolean conditionCheck = body.asString().contains("Record Added Successfully");
		Assert.assertTrue(true);
		String postResponse = response.asString();
		Assert.assertEquals(postResponse.contains("Record Added Successfully"), true);
		
		
		
	}
	
	
	

}
