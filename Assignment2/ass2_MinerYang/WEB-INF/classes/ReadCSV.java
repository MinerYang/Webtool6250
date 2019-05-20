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
import org.relique.jdbc.csv.CsvDriver;
import java.sql.*;



public class ReadCSV extends HttpServlet{

    @SuppressWarnings("unchecked")
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String filename = request.getParameter("filename");
        String sql= "SELECT * FROM "+filename;
        out.println("<p>~~~~the file name is"+filename+"</p>");

    try{
      Class.forName("org.relique.jdbc.csv.CsvDriver");
      Connection conn = DriverManager.getConnection("jdbc:relique:csv:/Library/Tomcat/webapps/ass2_MinerYang/part5");
      Statement stmt = conn.createStatement();
      ResultSet results = stmt.executeQuery(sql);
      out.println("<TABLE BORDER=1 ALIGN=\"LEFT\">\n" + "<TR BGCOLOR=\"#FFAD00\">\n" + "<TH>SalesOrderID<TH>RevisionNumber");
     while (results.next())
      {
        out.println("<TR><TD>"+results.getString("SalesOrderID"));
        out.println("<TD>"+results.getString("RevisionNumber"));
        out.println("<TD>"+results.getString("OrderDate"));
        out.println("<TD>"+results.getString("DueDate"));
        out.println("<TD>"+results.getString("ShipDate"));
        out.println("<TD>"+results.getString("Status"));
        out.println("<TD>"+results.getString("OnlineOrderFlag"));
        out.println("<TD>"+results.getString("SalesOrderNumber"));
        out.println("<TD>"+results.getString("PurchaseOrderNumber"));
        out.println("<TD>"+results.getString("AccountNumber"));
        out.println("<TD>"+results.getString("CustomerID"));
        out.println("<TD>"+results.getString("SalesPersonID"));
        out.println("<TD>"+results.getString("TerritoryID"));
        out.println("<TD>"+results.getString("BillToAddressID"));
        out.println("<TD>"+results.getString("ShipToAddressID"));
        out.println("<TD>"+results.getString("ShipMethodID"));
        out.println("<TD>"+results.getString("CreditCardID"));
        out.println("<TD>"+results.getString("CreditCardApprovalCode"));
        out.println("<TD>"+results.getString("CurrencyRateID"));
        out.println("<TD>"+results.getString("SubTotal"));
        out.println("<TD>"+results.getString("TaxAmt"));
        out.println("<TD>"+results.getString("Freight"));
        out.println("<TD>"+results.getString("TotalDue"));
        out.println("<TD>"+results.getString("Comment"));
        out.println("<TD>"+results.getString("ModifiedDate"));
      }
      out.println("</TABLE>");

    } catch (Exception e) {
			e.printStackTrace();
    }
    // Load the driver.
    // Class.forName("org.relique.jdbc.csv.CsvDriver");

    // Create a connection. The first command line parameter is
    // the directory containing the .csv files.
    // A single connection is thread-safe for use by several threads.
    // Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + args[0]);
    
    // Create a Statement object to execut  A Statement is not thread-safe.
    // Statement stmt = conn.createStatement();

    // Select the ID and NAME columns from sample.csv
    // ResultSet results = stmt.executeQuery("SELECT SalesOrderID, RevisionNumber FROM SalesOrder");

    // Dump out the results to a CSV file with the same format
    // out.println("<TABLE BORDER=1 ALIGN=\"LEFT\">\n" + "<TR BGCOLOR=\"#FFAD00\">\n" + "<TH>SalesOrderID<TH>RevisionNumber");
    // while (results.next())
    //   {
    //     out.println("<TR><TD>"+results.getString("SalesOrderID"));
    //     out.println("<TD>"+results.getString("RevisionNumber"));

    //   }
    // out.println("</TABLE>");
    // // using CsvJdbc helper function
    // boolean append = true;
    // CsvDriver.writeToCsv(results, System.out, append);

    // Clean up
    //conn.close();
    
       
 
       
    }

}
