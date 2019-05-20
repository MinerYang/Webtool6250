/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TagHandller;

/**
 *
 * @author cestdrama
 */
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class tagS extends SimpleTagSupport{
  private String csvname;

  public void setCsvname(String csvname) {
        this.csvname = csvname;
    }
  
  public void doTag() throws JspException, IOException {
      if (csvname != null) {
          /* 从属性中使用消息 */
          JspWriter out = getJspContext().getOut();
          out.println( csvname+".csv\n" );
          String filename = csvname;
          String sql= "SELECT * FROM "+filename;
           try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            Connection connection = DriverManager.getConnection("jdbc:relique:csv:/Library/Tomcat/webapps/ass2_MinerYang/part5");
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            ResultSetMetaData data = results.getMetaData();
            // get titles
            int columnCount = data.getColumnCount();
            out.print("<table border=\"1\">\n"+"<tr bgcolor=\"#FFAD29\"/>\n");
            for (int i = 1; i <= columnCount; i++) {
                String title = data.getColumnName(i);
                out.print("<th/>"+title);
            }
           
            // get results 
            while (results.next()) {
                out.print("<tr/>");
                for (int i = 1; i <= columnCount; i++) {
                    String value = results.getString(i);
                    out.print("<td/>"+value);
                }
            }
            
            out.println("</table>");
            results.close();
            statement.close();
            connection.close();
            //request.getRequestDispatcher("part6/showCSV.jsp").forward(request, response);
          }
           catch (Exception e) {
            e.printStackTrace();
          }
       }
  }
  
}
