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
import java.sql.*;
import java.util.*;

public class ReadCSV extends HttpServlet  {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String filename = request.getParameter("filename");
        session.setAttribute("filename", filename);
        String sql= "SELECT * FROM "+filename;
         try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            Connection connection = DriverManager.getConnection("jdbc:relique:csv:/Library/Tomcat/webapps/ass2_MinerYang/part5");
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            ResultSetMetaData data = results.getMetaData();
             // get titles
            int columnCount = data.getColumnCount();
            String[] titles = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                String title = data.getColumnName(i);
                titles[i-1] = title;
            }
            session.setAttribute("titles", titles);
            // get results 
            List<String[]> result = new ArrayList<>();
            while (results.next()) {
                String[] row = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    String value = results.getString(i);
                    row[i-1] = value;
                }
                result.add(row);
            }
            session.setAttribute("results", result);
            results.close();
            statement.close();
            connection.close();
            request.getRequestDispatcher("part6/showCSV.jsp").forward(request, response);
         }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
