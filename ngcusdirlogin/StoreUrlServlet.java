package com.ngcusdirlogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StoreUrlServlet")
public class StoreUrlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StoreUrlServlet() {super();}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String urlLink=request.getParameter("getUrl");
		
		response.setContentType("html/text");
        Mydb db = new Mydb();
        Connection con = db.getCon();
        try {
        	PreparedStatement ps=con.prepareStatement("insert into storeUrl(urllink) values(?)");  
            ps.setString(1,urlLink);
        	int rs = ps.executeUpdate();
         }catch (Exception ex) {
             System.out.println(ex);
         }
	}

}
