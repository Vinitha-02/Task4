package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;


public class ModifyEmployee {
	private static final Logger log = LogManager.getLogger(ModifyEmployee.class);
 public static void modify(String EmpType) throws SQLException, ClassNotFoundException{
    	 
         try {
        	 Connection con=null;
             PreparedStatement stat=null;
             Statement st =null;
             ResultSet rs=null;
             JSONArray data= new JSONArray();
             Class.forName("com.mysql.cj.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","12345");
             log.info("Driver is connected");
             System.out.println("Enter the no of the Employee you want to modify");

            
             Scanner sc=new Scanner(System.in);
             int length= sc.nextInt();

             for(int i=1;i<=length;i++) {
            	 System.out.println("Enter the employeeCode");
            	 int empCode =sc.nextInt();
            	 sc.nextLine();
            	 System.out.println("Enter the salary");
            	 Double Salary=sc.nextDouble();
            	 sc.nextLine();
            	 
            	 if("Permanent".equalsIgnoreCase(EmpType)) {
            	 String update = "UPDATE permanentemployee SET Salary = " + Salary + " WHERE empCode = "+empCode+";"; 
            	 stat= con.prepareStatement(update);
                  stat.executeUpdate();}
            	 if("PartTime".equalsIgnoreCase(EmpType)) {
                	 String update = "UPDATE parttimeemployee SET Salary = " + Salary + " WHERE empCode = "+empCode+";"; 
                	 stat= con.prepareStatement(update);
                      stat.executeUpdate();}
            	 else if("Contract".equalsIgnoreCase(EmpType)) {
                	 String update = "UPDATE contractemployee SET Salary = " + Salary + " WHERE empCode = "+empCode+";"; 
                	 stat= con.prepareStatement(update);
                      stat.executeUpdate();}
            	 else {
           		  System.out.println("Please Enter the Correct EmployeeType");  
           		  log.warn("Please enter the Correct EmployeeType");
           	 }
                  log.info("Sucessfully modify the details");
             }}
               
         catch(Exception e) 
         {
	 e.printStackTrace();
	 log.fatal(e.getMessage());
	 }
         }}
