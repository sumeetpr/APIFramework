package apiVerification;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.google.gson.JsonObject;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import utils.ExtentReportListner;

public class APIVerification extends ExtentReportListner {

	public static void ResponseStatusCodeValidation(Response response, int statusCode) {

		try {

			Assert.assertEquals(response.getStatusCode(), statusCode);
			test.log(LogStatus.PASS, "Sucessfully validated the status code, the status code is "+ response.getStatusCode());

		} catch (AssertionError ae) {
			test.log(LogStatus.FAIL, ae.fillInStackTrace());
			test.log(LogStatus.FAIL,
					"The expected status code was" + statusCode + "but found " + response.getStatusCode());
		} catch (Exception e) {

			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}

	
	public static void ResponseKeyValidation (Response response, String key) {
		
		try {
			JSONArray array = new JSONArray(response.getBody().asString());
			for (int i = 0; i < array.length(); i++) {


				JSONObject obj = array.getJSONObject(i);
				test.log(LogStatus.INFO, "The validated values are " + obj.getString(key));
		} 
		}
		catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}

	public static void ResponseTimeValidation (Response response) {
		
		try {
			
			long time = response.getTime();
			test.log(LogStatus.INFO, "The response time is :: " + time);
		} catch (Exception e) {
			
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
		
		
	}
	
	public static void ResponseKeyValidationFromJsonObject (Response response, String key) {
		
		
		try {
			
			JSONObject json = new JSONObject(response.getBody().asString());
			
			
			if (json.has(key) && json.get(key)!=null) {
				
				test.log(LogStatus.PASS, "Sucessfully validated value of "+key+" and it value is "+ json.get(key));
				
			}
			else {
				test.log(LogStatus.FAIL, "The key not found");
			}
			
		} catch (Exception e) {
			
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			
		}
		
	}
}
