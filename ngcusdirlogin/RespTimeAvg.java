package com.ngcusdirlogin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class RespTimeAvg {
	public static void main(String []args) throws InterruptedException {

	  while(true) {

		LocalDateTime currDateTime = LocalDateTime.now();
        LocalDateTime targetLocDateTime = currDateTime.minusMinutes(15);
        //LocalDateTime targetLocDateTime = currDateTime.minusSeconds(15);

        try{
			Connection con=HelperClass.getConnection();
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select avg(resTime) from responseData where dateandtime>='"+targetLocDateTime+"' and dateandtime<='"+currDateTime+"'");
			rs.next();
			Statement stmt1=con.createStatement();  
			stmt1.executeUpdate("insert into avgRespData(dateandtime,avgResTime)values('"+targetLocDateTime+"','"+rs.getFloat(1)+"')");

		}catch (SQLException e){
			e.printStackTrace();
		}  
        Thread.sleep(900000);
	  } //end of while loop
	}
}
