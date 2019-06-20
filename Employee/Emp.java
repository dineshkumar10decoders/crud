package com.sample.Employee;

import java.util.*;
import java.sql.*;

interface Circle{
	void create();
	void delete();
	void show();
	void update();
	void exit();
}
class Emp implements Circle
{
//		ArrayList<Employee> obj = new ArrayList<Employee>();
      Scanner s=new Scanner(System.in);
    	      public Connection con;
    	      Database co=new Database();
     void select()
     {
 
     for(int i=0;i<100;i++)
     {
    	 System.out.println("Enter your choice");
			System.out.println("1 create");
		      System.out.println("2 delete");
		      System.out.println("3 viewall");
		      System.out.println("4 update");
		      System.out.println("5 exit");
		      int op=s.nextInt();
		      if(op==5)
		      {
		    	  System.out.println("Successfully exit");
		    	  break;
		      }
      switch(op) 
      {
      case 1:
    	  try {
          create();
    	  }catch(Exception m) {System.out.println("Exception occured: "+m);} 
      	  break;
      case 2:
    	  delete();
    	  break;
      case 3:
    	  show();
    	  break;
      case 4:
    	  update();
    	  break;
      case 5:
    	  exit();
    	  break;
      }
   }
 }
	
		
	public void create()
      {
		try {
//		  Employee emp=new Employee();
			
					
		    		System.out.println("enter name");
					String name=s.next();
					
					System.out.println("enter id");
				       int id=s.nextInt();
				      
				       
				      System.out.println("enter address");
				       String address=s.next();
				       
				       System.out.println("enter email");
				       String email=s.next();
			       
			      	  String reg="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
			      	  if(email.matches(reg))
			      	  {
			      		  email=s.next();
			      	  }
			      	  else
			      	  {
			      		  
			      		  System.out.println("enter valid email id");
			          	  email=s.next();
			       		  
			  
			      	  }

			         	PreparedStatement ps=co.con.prepareStatement("insert into list values(?,?,?,?)");
			  	  
			  	  
				ps.setString(1,name);
				ps.setInt(2,id);
				ps.setString(3,address);
				ps.setString(4,email);
				
				ps.executeUpdate();
				System.out.println("values added successfully");
		}catch(Exception e) {
			System.out.println(e);
				System.out.println("Enter options"+"  "+"1-create"+"  "+"2-delete"+"  "+"3-viewall"+"  "+"4-update"+" "+"5-exit");
				
		  
		  
//    	  System.out.println("Enter your name");
//    	  String name=s.next();
//    	  if(name.equalsIgnoreCase("rajini")) {
//					throw new InvalidException ("not valid");
//    	  }
//			else {
//				System.out.println("continue your process");	
//			} 
//    	  emp.setName(name);
    	  
    	  
//    	  System.out.println("Enter id");
//    	  int id=s.nextInt();
//    	  
//    	  emp.setId(id);
//    	  
//    	  System.out.println("Enter address");
//    	  String address=s.next();
//    	  emp.setAddress(address);
//    	  
//    	  
//    	  
//    	  System.out.println("Enter email");
//    	  String email=s.next();
//    	  String reg="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
//    	  if(email.matches(reg))
//    	  {
//    		  emp.setEmail(email);
//    	  }
//    	  else
//    	  {
//    		  
//    		  System.out.println("enter valid");
//        	  email=s.next();
//     		  emp.setEmail(email);
//
//    	  }
//    		  
//    	  
//    	 
//    	  
//    	  
////    	  obj.add(emp);
//    	  System.out.println("Added successfully");
//    	  }
//    	  catch (InvalidException e1) {
//				e1.printStackTrace();
			}
      }
	
	public void delete()
	{
		try {
			
		
		PreparedStatement ps=co.con.prepareStatement("delete from list where name=?");  
		
		System.out.println("enter name");
		ps.setString(1,s.next());  
		
		
		  
		ps.executeUpdate();  
		System.out.println("records deleted"); 
//		System.out.println("Enter the name you want to delete");
//		String name= s.next();
		
//		for(int i=0; i < obj.size(); i++) {
			
			
//			if (obj.get(i).getName().contains(name) ){
			
				
				
//				obj.remove(i);
		}catch(Exception e)
		{
			System.out.println("Error occured");
		}
				System.out.println("Successfully deleted");
			}
//		}
//	}
	
	public void show()
	{
		try {
		System.out.println("All employee list");
		PreparedStatement ps=co.con.prepareStatement("select * from list");
		
		ResultSet rs=ps.executeQuery();
	
		
		
		while(rs.next())
		{
			System.out.println(rs.getString(1)+","+rs.getInt(2)+","+rs.getString(3)+","+rs.getString(4));
			}
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
//		for (Employee str : obj) {
//			System.out.println(str.toString());
		}
//	}
	public void update()
	{
		try {
//		Employee ob=new Employee();
		
		
		
		PreparedStatement ps=co.con.prepareStatement("update list set id=?"+",address=?,email=? where name=?");  
		
		System.out.println("Enter name");
		ps.setString(4, s.next());
		
		
		System.out.println("enter id");
		ps.setInt(1,s.nextInt());  
		
		System.out.println("enter address");
		ps.setString(2, s.next());
		
		System.out.println("enter email");
		ps.setString(3,s.next());
		  
		 ps.executeUpdate();   
		  
		
		System.out.println(" records updated");
		}catch(Exception e)
		{
			System.out.println("e");
		}
//		String name = s.next();
		
//		for (int i = 0; i < obj.size(); i++) {
			
//			if (obj.get(i).getName().contains(name)) {
				
//				ob.setName(name);
//			
//				
//				System.out.println("Enter id");
//				ob.setId(s.nextInt());
//				
//				System.out.println("Enter address");
//				ob.setAddress(s.next());
//				
//				System.out.println("Enter  email");
//				ob.setEmail(s.next());
//				
////                 obj.set(i, ob);
//                 System.out.println("Updated successful");
			}
//		}
//	}
	
	public void exit()
	{
		System.out.println("successfully exit");
		
	}
	public class Employee {
		private String name;
		private int id;
		private String address;
		private String email;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		@Override
		public String toString() {
			return "employee [name=" + name + ", id=" + id + ", address=" + address + ", email=" + email + "]";
		}

	}

		public static void main(String margs[])
    	  {
			
    		  Emp ob=new Emp();
    		  ob.select();
    		  
    	  }
      }