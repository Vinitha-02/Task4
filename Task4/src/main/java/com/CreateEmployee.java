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

public class CreateEmployee {
	
	private static final Logger log = LogManager.getLogger(CreateEmployee.class);
 public static void create(String EmpType) throws SQLException, ClassNotFoundException{
    	 
         try {
        	 
        	 Connection con=null;
             Statement stat=null;
             ResultSet rs=null;
             JSONArray data= new JSONArray();
             Class.forName("com.mysql.cj.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","12345");
             stat=con.createStatement();
             log.info("Driver is connected");
             System.out.println("Enter the no of the Employee you want to create");
             Scanner sc=new Scanner(System.in);
             int length= sc.nextInt();

             for(int i=1;i<=length;i++) {
            	 System.out.println("Enter the employeeCode");
            	 int empCode =sc.nextInt();
            	 sc.nextLine();
            	 System.out.println("Enter the employeeName");
            	 String empName=sc.nextLine();
            	 System.out.println("Enter the Salary");
            	 Double Salary=sc.nextDouble();
            	 sc.nextLine();
            	 
            	
            	
            	 if("Permanent".equalsIgnoreCase(EmpType)) {
                 String insert= "INSERT INTO permanentemployee VALUES ("+empCode+", '"+empName+"', "+Salary+", '"+EmpType+"');";
                 stat.executeUpdate(insert);}
            	 else if("partTime".equalsIgnoreCase(EmpType)){
            		 String insert= "INSERT INTO parttimeemployee VALUES ("+empCode+", '"+empName+"', "+Salary+", '"+EmpType+"');";
            		 stat.executeUpdate(insert);
            	 }else if("Contract".equalsIgnoreCase(EmpType)) {
            		 String insert= "INSERT INTO contractemployee VALUES ("+empCode+", '"+empName+"', "+Salary+", '"+EmpType+"');";
            		 stat.executeUpdate(insert);
            	 }
            	 else {
            		  System.out.println("Please Enter the Correct EmployeeType");  
            		  log.warn("Please enter the Correct EmployeeType");
            	 }
                 log.info("Successfully Inserted");}
               
           
     }
             catch(Exception e) 
             {
            	 e.printStackTrace();
            	 log.fatal(e.getMessage());
             }
         }
     
}
