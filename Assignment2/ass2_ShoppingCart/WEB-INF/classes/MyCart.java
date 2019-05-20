import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class MyCart extends HttpServlet {

    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(); //得到当前的 session或创建一个 
        // ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart"); //读session 中的变量
        HashMap<String,Integer> cart=(HashMap<String,Integer>) session.getAttribute("cart");
        if(cart==null){
            // cart=new ArrayList<String>();
            cart=new HashMap<String,Integer>();
        }
        
        String[] books= request.getParameterValues("books");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Books</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p><b>The following items has been added to your shopping cart successfully:</b></p>");
        out.println("<ul>");
        if(books!=null){
        for(String s:books){
            out.println("<li>"+s+"</li>");
            // 
            if(cart.containsKey(s)){
                int num=cart.get(s);
                cart.put(s,num+1);
            }
            else{ cart.put(s,1); }
        }
        }
        out.println("</ul>");
        

        String[] music= request.getParameterValues("music");
        out.println("<ul>");
         if(music!=null){
         for(String s:music){
            out.println("<li>"+s+"</li>");
            //
            if(cart.containsKey(s)){
                int num=cart.get(s);
                cart.put(s,num+1);
            }
            else{ cart.put(s,1); }
         }
        }
        out.println("</ul>");

        
        out.println("<body>");
        out.println("<ul>");
        // out.println("<p><b>The following items has been added to your shopping cart successfully:</b></p>");
        String[] computers= request.getParameterValues("computers");
        if(computers!=null){
        for(String s:computers){
            out.println("<li>"+s+"</li>");
            // 
            if(cart.containsKey(s)){
                int num=cart.get(s);
                cart.put(s,num+1);
            }
            else{ cart.put(s,1); }
        }
       }
       out.println("</ul>");
       out.println("<a href='viewcart'>View Cart  </a>&nbsp;");
       out.println("<a href='books.html'>Goto Books Page  </a>&nbsp;");
       out.println("<a href='music.html'>Goto Music Page  </a>&nbsp;");
       out.println("<a href='computers.html'>Goto Computers Page  </a>&nbsp;");
       
     session.setAttribute("cart", cart); //写session，向session中储存内容
       
     out.println("<p>^^^^^^^^items in the cart:"+cart.size()+"</p>");
    //  out.println("<ul>");
    //     if(cart.size()!=0){
    //     for(String i:cart){
    //         out.println("<li>"+i+"</li>");
    //     }
    //     }
    //     out.println("</ul>");
        out.println("</body>");
        out.println("</html>");      
    }

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(); //得到当前的 session或创建一个 
        HashMap<String,Integer> cart=(HashMap<String,Integer>) session.getAttribute("cart");
        if (cart == null) {
			cart = new HashMap<String, Integer>();
		}
		Enumeration<String> items = request.getParameterNames();
		while (items.hasMoreElements()) {
			String item = items.nextElement();
			if (item.equals("Confirm change")) continue;
			String amount = request.getParameter(item);
			cart.put(item, Integer.parseInt(amount));
		}
		Iterator<Map.Entry<String, Integer>> it = cart.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			if (entry.getValue() == 0) {
				it.remove();
			}
		}
        session.setAttribute("cart", cart);
        request.getRequestDispatcher("viewcart").forward(request, response);


        }


}
