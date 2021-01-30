package apiUtils;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {
	
	public Map<String, String> defaultHeaders(){
		
		Map<String, String> defaultHeaders = new HashMap<String, String>();
		defaultHeaders.put("content-Type", "application/json");
		
		return defaultHeaders;
		
	}
	
public Map<String, String> HeadersWithToken(){
		
		Map<String, String> headersWithToken = new HashMap<String, String>();
		headersWithToken.put("content-Type", "application/json");
		headersWithToken.put("Access-Token", "dummytoken");
		
		return headersWithToken;
		
	}
	
	

}
