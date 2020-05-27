package com.ngcusdirlogin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;

public class CalculateResponseTime {
	public static void main(String []args) throws IOException, InterruptedException {
		
		while(true) {
		  LocalDateTime currDateTime = LocalDateTime.now();
		 
		  URL url = new URL("https://www.youtube.com/results?search_query=For+a+given+website+url%2C+how+to+get++what+is+the+response+time+to+access+it.");
	      HttpURLConnection con = (HttpURLConnection) url.openConnection();
	      con.setRequestMethod("GET");
	      con.setRequestProperty("Accept", "application/json");
	      
	      long startTime=0;
	      long finishTime = 0;
	      startTime = System.currentTimeMillis();
	      
	      con.connect();
	      
	      if(con.getResponseCode() == 200) {
	    	  finishTime = System.currentTimeMillis();
	    	  System.out.println("stack_url"+" - 200 " + con.getResponseMessage() + " took " + (finishTime-startTime) + " Milli Seconds.");
	      }
	      con.disconnect();
	      float responseTime=(float) (((finishTime-startTime))/1000.0);
	      System.out.println(responseTime);
	      System.out.println("---------");
	      
	      StoreResTimeInDb.storeResTimeInDb(responseTime, currDateTime);
	     
	      
//	      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//	      String inputLine;
//	      StringBuffer response1=new StringBuffer();
//	      while ((inputLine = in.readLine()) != null) {
//	    	response1.append(inputLine);
//	      }
//	      //System.out.println(response1);
//	      in.close();

		  Thread.sleep(60000);
		}//end of while loop
	}
}
