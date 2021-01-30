package StudendAPITest;

import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import apiBuilders.PostAPIBuilder;
import apiUtils.ApiPath;
import apiUtils.ApiPath.apiPath;
import apiUtils.HeaderConfigs;
import apiVerification.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.JavaCustomUtils;

public class PostApitest extends BaseTest{
	
	
	@Test
	public void testPostAPI() {
		
		PostAPIBuilder builder = new PostAPIBuilder();
		
		
		
		Map<String, String> body = builder.postRequestBody( JavaCustomUtils.getRandomNumberAsString(), JavaCustomUtils.getRandomString(),JavaCustomUtils.getRandomString());
		
		Response response = RestAssured.given()
				   .when()
				   .headers(new HeaderConfigs().defaultHeaders())
				   .body(body)
				   .post(ApiPath.apiPath.CREATE_USER);
		
		System.out.println(response.body().asPrettyString());
		
		APIVerification.ResponseKeyValidationFromJsonObject(response, "title");
		APIVerification.ResponseStatusCodeValidation(response, 201);
		APIVerification.ResponseTimeValidation(response);
				   
	}

}
