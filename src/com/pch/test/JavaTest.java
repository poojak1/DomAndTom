package com.pch.test;
import domAndTom.DomAndTom;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class JavaTest {

	List<String> myArrayList = new ArrayList<>();
	DomAndTom domAndTom;
        
	@Before
	public void setup() {
            domAndTom = new DomAndTom();
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
		
		String expectedCompanyName = "Dom & Tom Inc.";
                String expectedString = "Dom";
		// Assert that the word 'Dom' is present in companyName string
                assertThat(expectedCompanyName).contains(expectedString);
                
		String expectedName1 = "Netflix";
		String expectedName2 = "NETFLIX";
		// Assert that name1 equals name2 regardless of case and leading/trailing spaces
		assertThat(expectedName1).isEqualToIgnoringCase(expectedName2);
                
		
		// Convert the above 2 strings to integer values and display the sum
                //Arrange
                String expectedIntValue1 = "100";
		String expectedIntValue2 = "20";
                int expectedSum = 120;
                
                //Act
                int actualSum = domAndTom.convertStringToIntAndReturnSum(expectedIntValue1, expectedIntValue2);
                
                //Assert
                assertThat(actualSum).isEqualTo(expectedSum);
	}

	/**
	 * Testing knowledge of java Lists. The list 'myArrayList' has already been
	 * created and populated in @before method. Follow steps outlined below.
	 */

	@Test
	public void funWithArrayLists() {

            // Step 1 display the number of elements in myArrayList
            System.out.println("Size of list: "+ myArrayList.size());

            // Step 2 using enhanced for-loop loop thru myArrayList and display all values to console
            System.out.println("Elements in the list: ");
            for (String item : myArrayList) {
                System.out.println(item);
            }
            
            // Step 3 Display the 3rd element in myArrayList
            System.out.println("Third element in list: "+ myArrayList.get(2));
            
            /**
             * Step 4 Loop thru myArrayList to determine if any elements value = 'IE'
             * if yes, display 'IE found @ index' and the index number in the  console then exit the loop	
             */
            for (int i=0; i< myArrayList.size(); i++) {
                if(myArrayList.get(i).equals("IE")){
                    System.out.println("IE found @ index: " + i);
                }
            }

            /**
             * Step 5 Loop thru myArrayList to determine if any list elements value = 'Opera'
             * if not , display 'Opera not found'
             *
             */ 
            while(!myArrayList.contains("Opera")){
                System.out.println("Opera not found");
                break;
            }
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
		myHashMap.put(1, "XP");
		myHashMap.put(2, "WIN7");
		myHashMap.put(3, "WIN8");
                
		// Step 2 Display to console the value associated with key 2
		System.out.println("Hashmap key 2 contains : "+myHashMap.get(2));
		
		// Step 3 Display the number of elements in myHashMap
                System.out.println("Number of elements: "+myHashMap.size());
		
		// Step 4 Remove the last element in myHashMap and display the number of elements in myHashMap
                myHashMap.remove(myHashMap.size()-1);
                System.out.println("Number of elements after removing last element: "+myHashMap.size());
                
	}

	/**
	 * Testing knowledge of calling and processing a RESTFUL WebService call using Apache HttpClient 
	 * Follow the steps outlined below
	 * @throws IOException 
	 * @throws ClientProtocolException
	 */

	@Test
	public void funWithWebServices() throws ClientProtocolException, IOException {
	 
            String webServiceUrl = "http://api.geonames.org/cities?north=44.1&south=-9.9&east=-22.4&west=55.2&username=demo";

            // Step 1 Create instance of httpClient
            HttpClient httpClient = new DefaultHttpClient();
            
            /*
             * Step 2 Create the Get Request, call it myGetRequest using the HttpGet
             * class and webServiceUrl
             */ 	   
            HttpGet myGetRequest = new HttpGet(webServiceUrl);
            
            /*
             * Step 3 Using the httpClient object created in step 1 execute
             * myGetRequest and save the HttpResponse to myHttpResponse
             */
            HttpResponse myHttpResponse = httpClient.execute(myGetRequest);
            
            // Step 4 Using myHttpResponse display the statuscode and ReasonPhrase to console
            System.out.println("Status Code & Reason Phrase: " + myHttpResponse.getStatusLine());
            
            /*******EXTRA CREDIT ****** 
            * Process the myHttpResponse and display the JSON to the console
            * ...hint the response content is returned in myHttpResponse.getEntity().getContent()  
            * use BufferedReader
            */
          
            if(myHttpResponse.getEntity().getContentLength() != 0){
                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(myHttpResponse.getEntity().getContent()));
                String line = null;
                
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                                
                System.out.println(stringBuilder.toString());
            }
            
	}

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
		myHashSet.add("XP");
                myHashSet.add("WIN7");
                myHashSet.add("WIN8");
                myHashSet.add("Safari");
                myHashSet.add("XP");
                
		/* 
		 * Step 3 Display to console all the values of myHashSet ... hint use iterator
		 */	
                Iterator<String> iterator = myHashSet.iterator();
                System.out.println("All elements in Hashset: ");
                while(iterator.hasNext()){  
                    System.out.println(iterator.next());  
                }
                
		// Step 4 Remove from myHashSet where String = 'XP"
                myHashSet.remove("XP");

		// Step 5 Display to console the number of elements in myHashSet
                 System.out.println("Hashset size after removing an element: "+ myHashSet.size());
	}	
}