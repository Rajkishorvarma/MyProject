package com.durgasoft.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.durgasoft.beans.Student;
import com.durgasoft.factory.StudentServiceFactory;
import com.durgasoft.service.StudentService;

@WebServlet("*.do")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String sid="";
		String sname="";
		String saddr="";
		Student student = null;
		StudentService studentService = null;
		String status="";
		RequestDispatcher requestDispatcher =null;
		if (requestURI.endsWith("add.do")) {
			sid = request.getParameter("sid");
			sname= request.getParameter("sname");
			saddr= request.getParameter("saddr");
			student =new Student();
			student.setSid(sid);
			student.setSname(sname);
			student.setSaddr(saddr);
			studentService = StudentServiceFactory.getStudentService();
			status=studentService.addStudent(student);
			if(status.equals("success")) {
				requestDispatcher = request.getRequestDispatcher("success.html");
				requestDispatcher.forward(request, response);
			}
			if (status.equals("failure")) {
				requestDispatcher = request.getRequestDispatcher("failure.html");
				requestDispatcher.forward(request, response);
			}
			if (status.equals("existed")) {
				requestDispatcher = request.getRequestDispatcher("existed.html");
				requestDispatcher.forward(request, response);
			}
		}
		if (requestURI.endsWith("search.do")) {
			sid = request.getParameter("sid");
			studentService = StudentServiceFactory.getStudentService();
			student= studentService.searchStudent(sid);
			if(student!=null) {
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				out.println("<html>");
				out.println("<body bgcolor='lightblue'>");
				out.println("<br><br><br><br><br>");
				out.println("<table align='center' border='1'>");
				out.println("<tr><td>Student Id</td><td>"+student.getSid()+"</td></tr>");
				out.println("<tr><td>Student Name</td><td>"+student.getSname()+"</td></tr>");
				out.println("<tr><td>Student Address</td><td>"+student.getSaddr()+"</td></tr>");
				out.println("</table></body></html>");
			}else {
				requestDispatcher = request.getRequestDispatcher("notexisted.html");
				requestDispatcher.forward(request, response);
			}
		}
		if (requestURI.endsWith("editform.do")) {
			sid = request.getParameter("sid");
			studentService = StudentServiceFactory.getStudentService();
			student= studentService.searchStudent(sid);
			if (student == null) {
				requestDispatcher = request.getRequestDispatcher("notexisted.html");
				requestDispatcher.forward(request, response);
				
			} else {
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				out.println("<html>");
				out.println("<body bgcolor='lightblue'>");
				out.println("<br><br><br><br><br>");
				out.println("<form method='POST' action='update.do'>");
				out.println("<table align='center'>");
				out.println("<tr><td>Student Id</td><td>"+student.getSid()+"</td></tr>");
				out.println("<input type='hidden' name ='sid' value='"+student.getSid()+"'/>");
				out.println("<tr><td>Student Name</td><td><input type='text' name='sname' value ='"+student.getSname()+"'/></td></tr>");
				out.println("<tr><td>Student Address</td><td><input type='text' name='saddr' value ='"+student.getSaddr()+"'/></td></tr>");
				out.println("<tr><td><input type='submit' value='UPDATE'/></td></tr>");
				out.println("</table></form></body></html>");
			}
		}
		if (requestURI.endsWith("update.do")) {
			sid= request.getParameter("sid");
			sname= request.getParameter("sname");
			saddr= request.getParameter("saddr");
			student = new Student();
			student.setSid(sid);
			student.setSname(sname);
			student.setSaddr(saddr);
			
			studentService = StudentServiceFactory.getStudentService();
			status = studentService.updateStudent(student);
			if (status.equals("success")) {
				requestDispatcher = request.getRequestDispatcher("success.html");
				requestDispatcher.forward(request, response);
				
			} else {
				requestDispatcher = request.getRequestDispatcher("failure.html");
				requestDispatcher.forward(request, response);
			}
		}
		if (requestURI.endsWith("delete.do")) {
			sid = request.getParameter("sid");
			studentService = StudentServiceFactory.getStudentService();
			status= studentService.deleteStudent(sid);
			if (status.equals("success")) {
				requestDispatcher = request.getRequestDispatcher("success.html");
				requestDispatcher.forward(request, response);
			}
			if (status.equals("failure")) {
				requestDispatcher = request.getRequestDispatcher("failure.html");
				requestDispatcher.forward(request, response);
			}
			if (status.equals("notexisted")) {
				requestDispatcher = request.getRequestDispatcher("notexisted.html");
				requestDispatcher.forward(request, response);
			}
		}
		
	}

}
