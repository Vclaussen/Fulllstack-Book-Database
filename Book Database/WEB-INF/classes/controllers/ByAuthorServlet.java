package controllers;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbhelpers.bookDBHelper;

/**
 * implementation class ByAuthorServlet
 */
@WebServlet("/ByAuthor")
public class ByAuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ByAuthorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);	

	}


	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // Get the author parameter from the request
	        String authorName = request.getParameter("author");

	        // Create dbHelper object
	        bookDBHelper dbd = new bookDBHelper();

	        // Do the query for books by the specified author
	        ResultSet results = dbd.doReadByAuthor(authorName);

	        // Get the HTML table from the dbHelper object
	        String table = dbd.getHTMLTable(results);

	        // Pass execution control to read.jsp along with the table
	        request.setAttribute("table", table);
	        String url = "/read.jsp";

	        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	        dispatcher.forward(request, response);
	    }
	}




