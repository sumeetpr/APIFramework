package StudendAPITest;

import java.util.ArrayList;
import java.util.List;

import com.google.common.primitives.Chars;

public class DemoClass {
	
	
	
	public static void main(String args[]){
		
		
		String city = "Bangalore";
		String str2 = "bala";
		
		char[] arr = city.toCharArray();
		char[] c = str2.toCharArray();
		List<Chars> ls = new ArrayList<Chars>();
		String str3 = "";
		char d = 0;
		
		for (int j = 0; j < c.length; j++) {
			d= c[j];
		
		for (int i = 0; i < arr.length; i++) {
			
			
			if (d==arr[i]) {
				

			}
			
			else {
				str3 = str3+arr[i];
			}
		}
		arr = str3.toCharArray();
		str3="";
		
		}
		System.out.println(arr);
	}

}
