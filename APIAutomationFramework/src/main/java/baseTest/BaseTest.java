package baseTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import io.restassured.RestAssured;
import utils.ExtentReportListner;
import utils.FileAndEnv;

@Listeners(ExtentReportListner.class)
public class BaseTest extends ExtentReportListner {
	
	@BeforeTest
	public void beforetest() {
		
		
		RestAssured.baseURI = FileAndEnv.envAndfile().get("ServerUrl");
		
		
	}

}
