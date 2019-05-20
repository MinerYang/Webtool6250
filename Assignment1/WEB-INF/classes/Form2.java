import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Form2 extends HttpServlet{

   // @Override
    public void doGet(HttpServletRequest request,
                     HttpServletResponse response) throws ServletException, IOException 
   {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Showing information"; String docType =
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
    "Transitional//EN\">\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" + "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" + "<BR><BR>\n" 
                + "<TABLE BORDER=1 ALIGN=\"CENTER\">\n" + "<TR BGCOLOR=\"#FFAD00\">\n" + "<TH>Parameter Name<TH>Parameter Value");
    Enumeration<String> parameterNames = request.getParameterNames();
    while(parameterNames.hasMoreElements()) {
        String name = (String)parameterNames.nextElement(); 
        out.println("<TR><TD>" + name);
        out.println(" <TD>" + request.getParameter(name));
     }
    out.println("</TABLE>\n</BODY></HTML>"); 
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException { doGet(request, response);
    }    

}