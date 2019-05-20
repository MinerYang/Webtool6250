import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Form3 extends HttpServlet{

   // @Override

@SuppressWarnings("unchecked")
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
    Map map = request.getParameterMap();
    Set s=map.entrySet();
    Iterator it=s.iterator();
    while(it.hasNext()){
        Map.Entry<String,String[]> entry=(Map.Entry<String,String[]>)it.next();
        String key=entry.getKey();
        String[] value=entry.getValue();
        for(int i=0;i<value.length;i++){
            out.println("<TR><TD>" + key+ " <TD>" + value[i].toString());
            }
    }
    out.println("</TABLE>\n</BODY></HTML>"); 

   }



    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException { doGet(request, response);
    }    

}
