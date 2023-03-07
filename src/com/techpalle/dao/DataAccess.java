package com.techpalle.dao;

import java.sql.*;

import com.techpalle.model.Customer;

public class DataAccess 
{
		private static final  String  dbUrl="jdbc:mysql://localhost:3306/jdbc";
		private static final  String dbUsername="root";
		private static final  String  dbPassword="admin";
		
		private static Connection con=null;
		private static Statement s=null;
		private static PreparedStatement ps=null;
		private static ResultSet rs=null;
		
		private static final String insertQury="insert into customer(name,email,mobile,password,state) values(?,?,?,?,?)";
		private static final String validateQury="select email,password from customer where email=? and password=?";
		
		public static boolean validateCustometr(String email,String password)
		{
			boolean b=false;
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
				ps=con.prepareStatement(validateQury);
				
				ps.setString(1,email);
				ps.setString(2,password);
				
			
				rs=ps.executeQuery();
				
				b=rs.next();
				
			}
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					if(rs!=null)
						rs.close();
					if(ps!=null)
					ps.close();
					if(con!=null)
						con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			return b;
		}
		
		public static void insertCustomer(Customer c)
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
				ps=con.prepareStatement(insertQury);
				
				ps.setString(1,c.getName());
				ps.setString(2, c.getEmail());
				ps.setLong(3,c.getMobile());
				ps.setString(4, c.getPassword());
				ps.setString(5, c.getState());
				
				ps.executeUpdate();
				
	
			}
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					if(ps!=null)
					ps.close();
					if(con!=null)
						con.close();
				}
				catch (SQLException e) 
				{	
					e.printStackTrace();
				}
			}
		}
}
