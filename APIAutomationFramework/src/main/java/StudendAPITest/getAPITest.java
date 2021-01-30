package StudendAPITest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiUtils.ApiPath;
import apiVerification.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getAPITest extends BaseTest {

	@Test
	public void getAPITests() {

		test.log(LogStatus.INFO, "The test case started...");

		Response response = RestAssured.given().when().get(ApiPath.apiPath.GET_LIST_OF_ALL_USERS);

		APIVerification.ResponseStatusCodeValidation(response, 200);
		APIVerification.ResponseKeyValidation(response, "title");
		APIVerification.ResponseTimeValidation(response);
		test.log(LogStatus.PASS, "the test is passed..");

	}

}
