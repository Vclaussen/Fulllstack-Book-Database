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
 * implementation class AddServlet
 */
@WebServlet("/addBook")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data
		String title = request.getParameter("title");
		String author = request.getParameter("Author");
		int pages = Integer.parseInt(request.getParameter("pages"));
		
		//set up a book object
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPages(pages);
		
		//set up a dbHelper object
		bookDBHelper dbd = new bookDBHelper();
		
		//pass the book to addQuery to add to the database
		dbd.doAdd(book);
		//pass execution control to the read 
		String url = "/read";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
