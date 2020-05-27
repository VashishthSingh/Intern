package com.ngcusdirlogin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class StoreResTimeInDb {
	public static void storeResTimeInDb(float responseTime,LocalDateTime currDateTime1) {
		try{
			Connection con=HelperClass.getConnection();
			Statement stmt=con.createStatement();  
			stmt.executeUpdate("insert into responseData(dateandtime,resTime)values('"+currDateTime1+"','"+responseTime+"')");
			con.close();
			stmt.close();
		}catch (SQLException e){
			e.printStackTrace();
		}  
	}
}
