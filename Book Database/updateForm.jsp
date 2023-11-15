<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<%@ page import="model.Book" %>
    
<% Book book = (Book) request.getAttribute("book"); %>    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Sci Fi Library - Update a Book</title>
</head>
<body>

<h1>Sci Fi Library - Update a Book</h1>

<form name=updateForm action=updateBook method=post >

    <label>
      Book ID:
   </label>
   <!--  Changed this field to disabled. Users should not be able to update the ID! -->
   <input type=text name=bookID value="<%= book.getBookID() %>" readonly="readonly" />
   <br />

   <label>
      Book title:
   </label>
   <input type=text name=title value="<%= book.getTitle() %>" />
   <br />
   <label>
      Book author:
   </label>
   <input type=text name=author value="<%= book.getAuthor() %>" />
   <br />
   
   <label>
      Book pages:
   </label>
   <input type=text name=pages value="<%= book.getPages() %>" />
   <br />
   
   <input type=submit name=submit value="Update the Book" />

</form>

</body>
</html>