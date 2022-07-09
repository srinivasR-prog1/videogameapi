package restAssuredAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_DELETE_DeleteRequest {
	
	@Test
	public void deleteVideoRequest()
	{
		int vgId=12;
		RestAssured.baseURI="http://localhost:8080";
		RequestSpecification httpRequest=RestAssured.given();		
		httpRequest.header("Content-Type","application/json");
		Response response=httpRequest.delete("/app/videogames/"+vgId);
		Assert.assertEquals(response.getStatusCode(), 200);
		boolean condCheck = response.asString().contains("Record Deleted Successfully");
		
		Assert.assertTrue(condCheck);
		
		
	}

}
