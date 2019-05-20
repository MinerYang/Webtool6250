
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cestdrama
 */
public class transfer extends HttpServlet {
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String select=request.getParameter("selection");
        out.println("<html>");
        out.println("<p>"+select+"</p>");
        if(select.equals("browse"))
           response.sendRedirect("part7/browse.html");
        else if(select.equals("add"))
          // out.println("<a href'add.html'></a>");
           response.sendRedirect("part7/Insert.html");
        
        out.println("</html>");
    }
    
}
