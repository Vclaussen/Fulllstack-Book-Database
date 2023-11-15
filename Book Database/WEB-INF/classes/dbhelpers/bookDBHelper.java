package dbhelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Book;


public class bookDBHelper {
	private Connection connection;

	public bookDBHelper() {
		connection = MyDBConnection.getConnection();
	}

	public void doAdd(Book book){
		String query = "INSERT INTO books (title, author, pages) values (?, ?, ?)";

		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setInt(3, book.getPages());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doDelete(int bookID) {
		String query = "DELETE FROM books WHERE bookID = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, bookID);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doUpdate(Book book){
		String query = "UPDATE books SET title=?, author=?, pages=? WHERE bookID=?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setInt(3, book.getPages());
			ps.setInt(4, book.getBookID());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public ResultSet doReadAll(){

		String query = "SELECT bookID, title, author, pages FROM books"; // <-- Better

		ResultSet results = null;
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			results = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}


	public String getHTMLTable(ResultSet results){
		String table ="";
		table += "<table border=1>\n";

		try {
			while(results.next()) {

				Book book = new Book(
						results.getInt("bookID"),
						results.getString("title"),
						results.getString("author"),
						results.getInt("pages")
						);

				table +="<tr>";
				table +="\t<td>";
				table += book.getTitle();
				table +="</td>";
				table +="<td>";
				table += "<a href=\"ByAuthor?author=" + book.getAuthor() + "\">" + book.getAuthor() + "</a>";
				table +="</td>";
				table +="<td>";
				table += book.getPages();
				table +="</td>";
				table +="\n\t<td>";
				
				
				table += "<form action=\"update\" method=\"post\">";
				table += "<input type=\"hidden\" name=\"bookID\" value=\"" + book.getBookID() + "\">";
				table += "<input type=\"submit\" value=\"Update\">";
				table += "</form>";
				
				table += "<form action=\"delete\" method=\"post\">";
				table += "<input type=\"hidden\" name=\"bookID\" value=\"" + book.getBookID() + "\">";
				table += "<input type=\"submit\" value=\"Delete\">";
				table += "</form>";
				
				table +="</td>\n";
				
				table +="</tr>\n";

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		table += "</table>";
		return table;
	}

	public Book doReadOne(int bookId) {
		String query = "SELECT * FROM books WHERE bookID = ?";

		Book book = null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, bookId);
			ResultSet results = ps.executeQuery();

			results.next();

			book = new Book(
					results.getInt("bookID"),
					results.getString("title"),
					results.getString("author"),
					results.getInt("pages")
					);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return book;
	}
	
	public ResultSet doReadByAuthor(String authorName) {
	    String query = "SELECT bookID, title, author, pages FROM books WHERE author = ?";
	    ResultSet results = null;

	    try {
	        PreparedStatement ps = this.connection.prepareStatement(query);
	        ps.setString(1, authorName);
	        results = ps.executeQuery();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return results;
	}
	
}
