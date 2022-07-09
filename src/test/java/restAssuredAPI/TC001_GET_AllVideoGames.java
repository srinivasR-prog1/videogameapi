package restAssuredAPI;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_AllVideoGames {

	@Test
	public void getVideoGames() {

		RestAssured.baseURI = "http://localhost:8080";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON);
		Response response = httpRequest.get("/app/videogames");
		Assert.assertEquals(response.getStatusCode(), 200);
		List<Map<String, String>> totalData = JsonPath.from(response.asString()).get();
		System.out.println(totalData.size());
		for (int i = 0; i < totalData.size(); i++) {
			Object vgId = totalData.get(i).get("id");
			String nvgId = String.valueOf(vgId);
			String vgName = totalData.get(i).get("name");
			String vgRelease = totalData.get(i).get("releaseDate");
			Object vgreScore = totalData.get(i).get("reviewScore");
			String vgrScore = String.valueOf(vgreScore);
			String vgCategory = totalData.get(i).get("category");
			String vgRating = totalData.get(i).get("rating");
			System.out.println(nvgId + "\t" + vgName+"                         "+vgRelease+"            "+vgrScore+"        "+vgCategory+"           "+vgRating);
			

		}

	}

}
