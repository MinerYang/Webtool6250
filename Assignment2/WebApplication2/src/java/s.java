/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cestdrama
 */
import java.io.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

public class s extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String num=request.getParameter("booksnum");
        out.println("<h1>Please input information:</h1>");
        out.println("<table>\n"+"<th>ISBN<th>Book Title<th>Authors<th>Price");
        out.println("<form action='servlet3' method='get'>");
        out.println("<input type=hidden name='num' value='"+num+"'>");
        for(int i=0;i<Integer.parseInt(num);i++){
            out.println(" <tr><td>" + "<input type='text' name='isbn"+i+"'>");
            out.println(" <td>" + "<input type='text' name='title"+i+"'>");
            out.println(" <td>" + "<input type='text' name='authors"+i+"'>");
            out.println(" <td>" + "<input type='text' name='price"+i+"'>");    
        }
        out.println("</table>");
        out.println("<input type='submit' name='submit' value='Add books'>");
        out.println("</form>");
        doGet(request, response);     
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //String isbn=request.getParameter("isbn");
        ArrayList<String> isbnarr = new ArrayList<>();
        ArrayList<String> titlearr = new ArrayList<>();
        ArrayList<String> authorsarr = new ArrayList<>();
        ArrayList<String> pricesarr = new ArrayList<>();
        int count=Integer.parseInt(request.getParameter("num"));
        //String text=request.getParameter("isbn"+String.valueOf(0));
        //out.println("<p>'"+text+"'</p>");
        for (int i = 0; i < count; i++) {
            isbnarr.add(request.getParameter("isbn"+String.valueOf(i)));
            titlearr.add(request.getParameter("title"+String.valueOf(i)));
            authorsarr.add(request.getParameter("authors"+String.valueOf(i)));
            pricesarr.add(request.getParameter("price"+String.valueOf(i)));
        }
        
        //
        java.sql.Connection connection = null;
            Statement stmt = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb?serverTimezone=UTC", "root", "12345678");
                stmt = connection.createStatement();
                for(int j=0;j<count;j++){
                String query = "insert into books (isbn, title, authors, price) value ('" + 
                        isbnarr.get(j) + "', '" + titlearr.get(j) + "', '" + authorsarr.get(j) + "', " + pricesarr.get(j) + ")"; 
                int result = stmt.executeUpdate(query);
                }
                //System.out.println(sqlQuery);
                //response.sendRedirect("success.html");
                out.println("<h1>'"+count+"'books added successfully</h1>");
                out.println("<a href='index.html'>Click here to go back to the main page</a>");
                
         } catch (SQLException sx) {
             out.println("<p>fial2</p>");
         } catch (ClassNotFoundException ex) {
             out.println("<p>fial1</p>");
         } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException ex) {
                    System.out.println("SQLException" + ex.getMessage());
                }
            }
    }
    
}
