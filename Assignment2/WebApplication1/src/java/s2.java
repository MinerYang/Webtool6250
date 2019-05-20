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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

public class s2 extends HttpServlet {
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String keyword=request.getParameter("keyword");
        String searchby= request.getParameter("searchby");
       // String redirectPage = "index.html";
        //
        java.sql.Connection connection = null;
        Statement stmt = null;
        
        // Search by the conditions
            
            try {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", "root", "12345678");
                stmt = connection.createStatement();
                String query = "SELECT * FROM movies where ";
                if(searchby.equals("title"))
                    query=query+"title = '" + keyword + "'";
                else if(searchby.equals("actor"))
                    query=query+"actor = '" + keyword + "'";
                else if(searchby.equals("actress"))
                    query=query+"actress = '" + keyword + "'";
                
                out.println("<p>"+query+"</p>");
                    
                //                
                out.println("<html>");
                out.println("<p>You searched for"+keyword+"</p><br/>");
                //out.println("<p>"+searchby+"</p>");
                out.println("<p><b>Here are the search result</b></p>");
                out.println("<ul>");
                ResultSet rs = stmt.executeQuery(query);
                   
                if (rs.next()) {
                    //System.out.println(userName + " authenticated");
                    //session.setAttribute("userName", userName);
                    out.println("<li>Movie Title:"+rs.getString("title")+"</li>");
                    out.println("<li>Lead Actor:"+rs.getString("actor")+"</li>");
                    out.println("<li>Lead Actress:"+rs.getString("actress")+"</li>");
                    out.println("<li>Genre:"+rs.getString("genre")+"</li>");
                    out.println("<li>Year:"+rs.getInt("year")+"</li>");
                    out.println("</ul>");
                   // redirectPage = "#";
                   out.println("<a href='index.html'>Click here to go back to the main page</a>");
                   out.println("</html>");
                } 
            } catch (SQLException ex) {
                System.out.println(ex);
            } catch (ClassNotFoundException ex) {
             Logger.getLogger(s2.class.getName()).log(Level.SEVERE, null, ex);
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
     
   //
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title=request.getParameter("title");
        String actor=request.getParameter("actor");
        String actress=request.getParameter("actress");
        String genre=request.getParameter("genre");
        int year=Integer.parseInt(request.getParameter("year"));
        
        
         java.sql.Connection connection = null;
            Statement stmt = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb?serverTimezone=UTC", "root", "12345678");
                stmt = connection.createStatement();
                String sqlQuery = "INSERT INTO movies (title, actor, actress, genre, year) "
                    + "VALUES ('" + title + "', '" + actor + "','" +actress + "' , '"+genre+"' , '"+year+"')";
                int result = stmt.executeUpdate(sqlQuery);
                //System.out.println(sqlQuery);
                response.sendRedirect("success.html");
                
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
