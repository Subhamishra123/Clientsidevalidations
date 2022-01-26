
package com.nt.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoronaVaccineEligibility extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		String uname = req.getParameter("uname");
		String address = req.getParameter("uaddress");
		String uage = req.getParameter("uage");
		String csvFlag = req.getParameter("vflag");
		int age = 0;
		if (csvFlag.equalsIgnoreCase("no")) {
			System.out.println("Server Side Validations....");
			List<String> errors = new ArrayList<String>();
			if (uname == null || uname.length() == 0 || uname.equalsIgnoreCase("")) {
				errors.add("Person Name is required");
			}
			if (address == null || address.length() == 0 || address.equalsIgnoreCase("")) {
				errors.add("Person Address is required");
			} else if (address.length() < 10) {
				errors.add("Person Address should be minimum 10 characters");
			}
			if (uage == null || uage.length() == 0 || uage.equalsIgnoreCase("")) {
				errors.add("Person Age is required");
			} else {
				try {
					age = Integer.parseInt(uage);
					if (age < 0 || age > 125) {
						errors.add("Person Age should be in between 1 to 125");
					}
				} catch (NumberFormatException nfe) {
					errors.add("Person Age should be number");
				}
			}
			if (errors.size() != 0) {
				writer.println("<ul style='color:red'>");
				for (String error : errors) {
					writer.println("<li>" + error + "</li>");
				}
				writer.println("</ul>");
				return;
			}
		}
		age=Integer.parseInt(uage);
		if (age < 18)
			writer.println("<h1 style='color:red;text-align:center'> Mr/Ms " + uname + "You are not "
					+ " Eligible for vaccination</h1>");
		else
			writer.println("<h1 style='color:green;text-align:center'> Mr/Ms " + uname + "You are  "
					+ " Eligible for vaccination Make it Happen !!</h1>");
		writer.println("<a href='index.html'><img src='images/home.jfif'></a>");

		writer.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		LocalDateTime ldt = LocalDateTime.now();
		int hour = ldt.getHour();
		if (hour < 12)
			writer.println("<h1 style='color:red;text-align:center'>Good Morning</h1>");
		else if (hour < 16)
			writer.println("<h1 style='color:orange;text-align:center'>Good Afternoon</h1>");
		else if (hour < 18)
			writer.println("<h1 style='color:pink;text-align:center'>Good Evening</h1>");
		else
			writer.println("<h1 style='color:green;text-align:center'>Good Night</h1>");
		writer.close();
	}
}
