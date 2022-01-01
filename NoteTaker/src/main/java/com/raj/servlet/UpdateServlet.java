package com.raj.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.raj.factory.FactoryProvider;
import com.raj.model.NoteModel;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public UpdateServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String title=request.getParameter("title");
			String content= request.getParameter("content");
			int noteId= Integer.parseInt(request.getParameter("noteId").trim());
			
			Session s=FactoryProvider.getFactory().openSession();
			Transaction tx= s.beginTransaction();
			
			NoteModel note=(NoteModel)s.get(NoteModel.class, noteId);
			note.setTitle(title);
			note.setContent(content);
			note.setAddDate(new Date());
			tx.commit();
			s.close();
			response.sendRedirect("all_notes.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
