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
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class s1  extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String select=request.getParameter("selection");
        out.println("<html>");
        out.println("<p>"+select+"</p>");
        if(select.equals("browse"))
           response.sendRedirect("browse.html");
        else if(select.equals("add"))
          // out.println("<a href'add.html'></a>");
           response.sendRedirect("add.html");
        
        out.println("</html>");
    }
}
