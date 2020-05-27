package com.ngcusdirlogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;

import org.json.JSONObject;

@WebServlet("/CalculateResTime")
public class CalculateResTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CalculateResTime() {super();}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
		      
//		      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//		      String inputLine;
//		      StringBuffer response1=new StringBuffer();
//		      while ((inputLine = in.readLine()) != null) {
//		    	response1.append(inputLine);
//		      }
//		      //System.out.println(response1);
//		      in.close();

		      try {
				Thread.sleep(60000);
		      }catch (InterruptedException e) {
				e.printStackTrace();
		      }
			}//end of while loop
	}
}
