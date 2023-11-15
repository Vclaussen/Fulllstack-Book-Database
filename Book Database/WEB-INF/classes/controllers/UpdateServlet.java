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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/updateBook")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// NEVER make database changes via a GET request.
		// You don't want a web crawler accidentally modifying your data!
		throw new RuntimeException();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get form data and set up a book object
		int bookId = Integer.parseInt(request.getParameter("bookID"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int pages = Integer.parseInt(request.getParameter("pages"));
		
		//create a book object with values
		Book book = new Book();
		book.setBookID(bookId);
		book.setAuthor(author);
		book.setTitle(title);
		book.setPages(pages);
		
		//create an dbHelper object and use it to update the book
		bookDBHelper dbd = new bookDBHelper();
		dbd.doUpdate(book);
		
		//pass control on to the ReadServlet
		String url = "/read";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
