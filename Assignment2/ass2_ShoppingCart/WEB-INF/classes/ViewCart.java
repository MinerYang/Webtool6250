import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class ViewCart extends HttpServlet {

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession(); //得到当前的 session或创建一个 
        // ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart"); //读session 中的变量
        HashMap<String,Integer> cart=(HashMap<String,Integer>) session.getAttribute("cart");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Books</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p><b>These items are in your cart</b></p>");
        
        // if(cart.size()!=0){
        //         for(String i:cart){
        //            // out.println("<form action='mycart' method='get'>");
        //             out.println("<li>"+i+"</li>");
        //         }
        //         }
        out.println("<form action='mycart' method='get'>");
        out.println("<TABLE BORDER=1 ALIGN=\"LEFT\">\n" + "<TR BGCOLOR=\"#FFAD00\">\n" + "<TH>Item<TH>Amount");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
 
            //out.println("<li>items:" + entry.getKey() + "amount:" + entry.getValue()+"</li>");
            out.println("<TR><TD>" + entry.getKey());
            out.println(" <TD>" + "<input type='text' name='"+entry.getKey()+"' value='"+entry.getValue()+"'>");
        }
        out.println("</TABLE>");
        out.println("<p><input type='submit' name='Confirm change' value='Submit'></p>");
        //response.sendRedirect("index.html");
        out.println("<a href='welcome.html'>Back to the main page</a>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        
       
    }
}
