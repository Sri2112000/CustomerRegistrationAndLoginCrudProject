package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccessPage;

@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path=request.getServletPath();
		
		switch(path)
		{
		case "/log":
			getLoginPage(request,response);
			break;
		case "/reg":
			getRegistrationPage(request,response);
			break;
		case "/regCustomer":
			insertCustomer(request,response);
			break;
		case "/logCustomer":
			validateCustomer(request,response);
			break;
		
			default:
					getStartUpPage(request,response);
					break;
		}
	}

	private void validateCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		//Read email and password from jsp page
		String e=request.getParameter("tbEmailLog");
		String p=request.getParameter("tbPassLog");
		
		//call the methiod present in dao
		boolean res=DataAccess.validateCustometr(e, p);
		
		//condition and Redirect user to destination page(success)
		if(res)
		{
			try 
			{
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
				//store the success page class data inside RD
				SuccessPage sp=new SuccessPage();
				request.setAttribute("successDetails", sp);
				
				rd.forward(request, response);
			} 
			catch (ServletException e1)
			{
				e1.printStackTrace();
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}	

		}
		else
		{
			getLoginPage(request,response);
		}
	}

	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
	//Read the data from jsp page
		String name=request.getParameter("tbName");
		String email=request.getParameter("tbEmail");
		String password=request.getParameter("tbPass");
		long mobile=Long.parseLong(request.getParameter("tbMobile"));
		String state=request.getParameter("ddlStates");
		
	//store that data in customet object
		Customer cus=new Customer(name,email,mobile,password,state);
		
	//passing insertCustomer method present in dao by passing 
		DataAccess.insertCustomer(cus);
	
		//redirect user to login page with email and password
		try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("custermer_login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	
	private void getRegistrationPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("custermer_login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
			
			try 
			{
				RequestDispatcher rd=request.getRequestDispatcher("custemer_management.jsp");
				rd.forward(request, response);
			} 
			catch (ServletException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				
				e.printStackTrace();
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}

