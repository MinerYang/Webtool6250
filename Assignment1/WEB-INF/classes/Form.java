import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Random;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Form extends HttpServlet{

            
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    }
    @SuppressWarnings("unchecked")
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       // String[] languages = request.getParameterValues("languages");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String picpath=request.getParameter("picpath");
        String gender= request.getParameter("gender");
        String country= request.getParameter("country");
        String[] hobbies= request.getParameterValues("hobbies");
        String address= request.getParameter("address");

       
 
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Quiz</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>the email is " + email +"</p>");
        out.println("<p>the password is " + password +"</p>");
        out.println("<p>the picpath is " + picpath +"</p>");
        out.println("<p>the gender is " + gender +"</p>");
        out.println("<p>the contry is " + country +"</p>");
        out.println("<p>the hobby you chose:</p>");
        out.println("<ul>");
        for(String h: hobbies){
            out.println("<li>"+h+"</li>");
        }
        out.println("<p>the address is " + address +"</p>");

        out.println("</body>");
        out.println("</html>");
    }

}
