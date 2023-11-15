package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbhelpers.bookDBHelper;
import model.Book;

/**
 * Servlet implementation class UpdateFormServlet
 */
@WebServlet("/update")
public class UpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//get the bookID
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		
	//create dbHelper class
		bookDBHelper dbd = new bookDBHelper();
	
	//use method to get the book data
		Book book = dbd.doReadOne(bookID);
		
	//pass book and control to the updateForm.jsp
		request.setAttribute("book",  book);
		
		String url = "/updateForm.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	
	
	}

}
