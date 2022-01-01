package com.raj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.raj.factory.FactoryProvider;
import com.raj.model.NoteModel;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SaveNoteServlet() {
        super();
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String title=request.getParameter("title");
			String content= request.getParameter("content");
			
			NoteModel note= new NoteModel(title,content,new Date());
			//hibernate save
			Session s=FactoryProvider.getFactory().openSession();
			Transaction tx= s.beginTransaction();
			s.save(note);
			tx.commit();
			s.close();
			response.setContentType("text/html");
			PrintWriter out= response.getWriter();
			out.println("<h1 style='text-align:center;'>Your Note Has Been Saved Successfull<h1/>");
			out.println("<h1 style='text-align:center;'><a href='all_notes.jsp'> View All Note</a><h1/>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
