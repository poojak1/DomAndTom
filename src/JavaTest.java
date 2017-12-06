import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;

public class JavaTest {

	List<String> myArrayList = new ArrayList<String>();
	 
	@Before
	public void setup() {
		myArrayList.add("Chrome");
		myArrayList.add("FireFox");
		myArrayList.add("IE");
		myArrayList.add("Safari");
		myArrayList.add("Chrome");
	}

	/**
	 * Testing general Java String function knowledge
	 */

	@Test
	public void funWithJavaStrings() {		
		
		String companyName = "Dom & Tom Inc.";
		// Assert that the word 'Dom' is present in companyName string
	
		String name1 = "Netflix";
		String name2 = "NETFLIX";
		// Assert that name1 equals name2 regardless of case and leading/trailing spaces
		
		String intValue1 = "100";
		String intValue2 = "20";
		// Convert the above 2 strings to integer values and display the sum
	}

	/**
	 * Testing knowledge of java Lists. The list 'myArrayList' has already been
	 * created and populated in @before method. Follow steps outlined below.
	 */

	@Test
	public void funWithArrayLists() {

		// Step 1 display the number of elements in myArrayList
		

		// Step 2 using enhanced for-loop loop thru myArrayList and display all values to console


		// Step 3 Display the 3rd element in myArrayList
		
		/**
		 * Step 4 Loop thru myArrayList to determine if any elements value = 'IE'
		 * if yes, display 'IE found @ index' and the index number in the  console then exit the loop	
		 */

		
		/**
		 * Step 5 Loop thru myArrayList to determine if any list elements value = 'Opera'
		 * if not , display 'Opera not found'
		 */
	}	 

	/**
	 * Testing knowledge of java HashMaps Follow steps outlined below
	 */

	@Test
	public void funWithHashMaps() {
		
		HashMap<Integer, String> myHashMap = new HashMap<Integer, String>();
		
		/*
		 * Step 1 Load the following into ' myHashMap'
		 * 
		 * Key: = 1 Value: = "XP" 
		 * Key: = 2 Value: = "WIN7" 
		 * Key: = 3 Value: = "WIN8"
		 */
		
		// Step 2 Display to console the value associated with key 2
		
		
		// Step 3 Display the number of elements in myHashMap

		
		// Step 4 Remove the last element in myHashMap and display the number of elements in myHashMap

	}

	/**
	 * Testing knowledge of calling and processing a RESTFUL WebService call using Apache HttpClient 
	 * Follow the steps outlined below
	 * @throws IOException 
	 * @throws ClientProtocolException
	 */

	/*@Test
	public void funWithWebServices() throws ClientProtocolException, IOException {
	 
		String webServiceUrl = "http://api.geonames.org/cities?north=44.1&south=-9.9&east=-22.4&west=55.2&username=demo";
		
		// Step 1 Create instance of httpClient

		
   		 * Step 2 Create the Get Request, call it myGetRequest using the HttpGet
		 * class and webServiceUrl
 	   	  	   
 		 
 		
		 * Step 3 Using the httpClient object created in step 1 execute
		 * myGetRequest and save the HttpResponse to myHttpResponse
 		 

		// Step 4 Using myHttpResponse display the statuscode and ReasonPhrase to console

 	    
 	    *//*******EXTRA CREDIT ****** 
	  	* Process the myHttpResponse and display the JSON to the console
	  	* ...hint the response content is returned in myHttpResponse.getEntity().getContent()  
		* use BufferedReader
	  	*//*
	}*/

	/**
	 * Testing knowledge of java HashSets Follow steps outlined below
	 * 
	 */
	@Test
	public void funWithHashSets() {

		// * Step 1 Create a HashSet of String objects called myHashSet
		Set<String> myHashSet = new HashSet<String>();

		/*
		 * Step 2 add the following String objecta to myHashSet "XP" "WIN7"
		 * "WIN8" "Safari" "XP"
		 */
		
		/* 
		 * Step 3 Display to console all the values of myHashSet ... hint use iterator
		 */	
        
		// Step 4 Remove from myHashSet where String = 'XP"


		// Step 5 Display to console the number of elements in myHashSet
	
	}	
}