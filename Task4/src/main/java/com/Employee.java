package com;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
public class Employee {
    private int empCode;
     private	String empName;
		private Double Salary;
		protected String EmpType;
		private static final Logger log = LogManager.getLogger(Employee.class);
	public Employee(String Emptype) {
			
		this.EmpType= EmpType;
			
	}

	public String getEmpType() {
		return EmpType;
	}
	public static class PermanentEmployee extends Employee 
	{
		
		public PermanentEmployee(String EmpType) throws ClassNotFoundException, SQLException  
		{
		super(EmpType);
		  System.out.println("Please Select the Function: Create, Modify, Delete:");
		 
		  Scanner sc= new Scanner(System.in);
		  String fun= sc.nextLine();
		  
		  if("Create".equalsIgnoreCase(fun)) {
			  CreateEmployee ce= new CreateEmployee();
			  System.out.println(EmpType);
			  ce.create(EmpType);
			  log.info("Create method is initated");
	}
		
		  else if("Modify".equalsIgnoreCase(fun)) {
		  ModifyEmployee me=new ModifyEmployee();
		  me.modify(EmpType);
		  log.info("Modify method is initated");}
		  else if("Delete".equalsIgnoreCase(fun)) {
		  DeleteEmployee de =new DeleteEmployee();
		  de.delete(EmpType);
		  log.info("Delete method is initated");}
		  else {
			  System.out.println("enter the correct function");
			  log.warn("select the correct function");
		  }
		 
		}

		

		}
	public static class  PartTimeEmployee extends Employee {
		
		public  PartTimeEmployee(String EmpType) throws ClassNotFoundException, SQLException
		{
			super(EmpType);
		  System.out.println("Please Select the Function: Create, Modify, Delete:");
		  Scanner sc= new Scanner(System.in);
		  String fun= sc.nextLine();
		  if("Create".equalsIgnoreCase(fun)) {
			  CreateEmployee ce= new CreateEmployee();
				 ce.create(EmpType);
				 log.info("Create method is initated");
		  }
		
		  else if("Modify".equalsIgnoreCase(fun)) {
		  ModifyEmployee me=new ModifyEmployee();
		  me.modify(EmpType);
		  log.info("Modify method is initated");}
		  else if("Delete".equalsIgnoreCase(fun)) {
		  DeleteEmployee de =new DeleteEmployee();
		  de.delete(EmpType);
		  log.info("Delete method is initated");}
		  else {
			  System.out.println("enter the correct function");
			  log.warn("select the correct function");
		  }
		 
		}
		}	
	public static class ContractEmployee extends Employee {
		
		public  ContractEmployee(String EmpType) throws ClassNotFoundException, SQLException
		{
		super(EmpType);
		  System.out.println("Please Select the Function: Create, Modify, Delete:");
		  Scanner sc= new Scanner(System.in);
		  String fun= sc.nextLine();
		  if("Create".equalsIgnoreCase(fun)) {
			  CreateEmployee ce= new CreateEmployee();
				 ce.create(EmpType);
				 log.info("Create method is initated");
		  }
		
		  else if("Modify".equalsIgnoreCase(fun)) {
		  ModifyEmployee me=new ModifyEmployee();
		  me.modify(EmpType);
		  log.info("Modify method is initated");}
		  else if("Delete".equalsIgnoreCase(fun)) {
		  DeleteEmployee de =new DeleteEmployee();
		  de.delete(EmpType);
		  log.info("Delete method is initated");}
		  else {
			  System.out.println("enter the correct function");
			  log.warn("select the correct function");
		  }
		 
		}	
	}}






