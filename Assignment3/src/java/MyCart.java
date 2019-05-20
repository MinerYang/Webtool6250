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
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class MyCart extends HttpServlet{
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            Cart cart = (Cart)session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
            }
            Enumeration<String> items = request.getParameterNames();
            while (items.hasMoreElements()) {
                String name = items.nextElement();
                if (name.equals("submit")) continue;
                String amount = request.getParameter(name);
                int count = Integer.parseInt(amount);
                if (count == 0) {
                   cart.deleteItem(name);
                }else {
                cart.modifyItemCount(name, count);
                }
            }
            
            session.setAttribute("cart", cart);
            request.getRequestDispatcher("part5/ViewCart.jsp").forward(request, response);
            
     }
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] items = request.getParameterValues("books");
	if (items == null)
            items = request.getParameterValues("music");
	if (items == null)
            items = request.getParameterValues("computers");
        HttpSession session = request.getSession();
	Cart cart = (Cart)session.getAttribute("cart");
	if (cart == null) {
            cart = new Cart();
	}
        if (items == null) {
            session.setAttribute("items", items);
            session.setAttribute("cart", cart);
            request.getRequestDispatcher("part5/success.jsp").forward(request, response);
            return;
        }
        
        for (String name : items) {
            Item item = cart.SearchItem(name);
            if (item != null) {
                int amount = item.getCount();
                cart.modifyItemCount(name, ++amount);
            } else {
                cart.addItem(new Item(name, 1));
            }
        }
        session.setAttribute("items", items);
        session.setAttribute("cart", cart);
        request.getRequestDispatcher("part5/success.jsp").forward(request, response);
        
     }
}
