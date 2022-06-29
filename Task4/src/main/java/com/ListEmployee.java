package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class ListEmployee {
	private static final Logger log = LogManager.getLogger(ListEmployee.class);

	public static void list() throws SQLException, ClassNotFoundException{

	 try {
		 
		 System.out.println("select the EmployeeType you want to print");
		 Scanner sc= new Scanner(System.in);
		 String EmpType= sc.nextLine();
    	 
    	 Connection con=null;
         Statement stat=null;
         ResultSet rs=null;
         JSONArray data= new JSONArray();
         Class.forName("com.mysql.cj.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","12345");
         stat=con.createStatement();
         log.info("Driver is connected");
         
         if("Permanent".equalsIgnoreCase(EmpType)) {
	rs=  stat.executeQuery("SELECT * FROM employee.permanentemployee");
    while(rs.next()) {
    JSONObject   record= new JSONObject();                  
    record.put("empCode", rs.getInt("empCode"));
 record.put("empName", rs.getString("empName"));
 record.put("Salary", rs.getDouble("Salary"));	   
 record.put("EmpType",rs.getString("EmpType"));
 data.add(record);
 log.info("list of employee is display");
} System.out.println(data);}
         else if("partTime".equalsIgnoreCase(EmpType)){    
        	 rs=  stat.executeQuery("SELECT * FROM employee.parttimeemployee");
        	    while(rs.next()) {
        	    JSONObject   record= new JSONObject();                  
        	    record.put("empCode", rs.getInt("empCode"));
        	 record.put("empName", rs.getString("empName"));
        	 record.put("Salary", rs.getDouble("Salary"));	 
        	 record.put("EmpType",rs.getString("EmpType"));
        	 data.add(record);
        	 log.info("list of employee is display");
         } System.out.println(data);
	 } else if("Contract".equalsIgnoreCase(EmpType)) {
		 rs=  stat.executeQuery("SELECT * FROM employee.contractemployee");
 	    while(rs.next()) {
 	    JSONObject   record= new JSONObject();                  
 	    record.put("empCode", rs.getInt("empCode"));
 	 record.put("empName", rs.getString("empName"));
 	 record.put("Salary", rs.getDouble("Salary"));	     
 	 record.put("EmpType",rs.getString("EmpType"));
 	 data.add(record);
 	log.info("list of employee is display");
 	    } System.out.println(data);
	 }
	 else {
		  
			  System.out.println("enter the correct EmployeeType");
			  log.warn("select the correct EmployeeType");
		  
	 }
         }
	 
	 catch(Exception e) 
	 {
		 e.printStackTrace();
		 log.fatal(e.getMessage());
	}
	 }
	}



