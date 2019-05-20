
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;


// import statements 
public class POIRead extends HttpServlet{ 
//
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();

        out.println("<h1>^^^^^This is the excel</h1>");

        //
		try { 
			FileInputStream file = new FileInputStream(new File("/Users/cestdrama/Desktop/HW2/store.xls")); 

			// Create Workbook instance holding reference to .xlsx file 
			HSSFWorkbook workbook = new HSSFWorkbook(file); 
			for (int p = 0; p < workbook.getNumberOfSheets(); p++) {
			// Get each sheet from the workbook 
			  HSSFSheet sheet = workbook.getSheetAt(p); 
              out.println("<p>" + String.valueOf(p+1) + ". " + sheet.getSheetName() + "</p>");
			// Iterate through each rows one by one 
			  out.println("<table border=1>");
			  for (int i = 0; i < sheet.getLastRowNum()+1; i++) {
                HSSFRow row = sheet.getRow(i);
                out.println("<tr>");
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    HSSFCell cell = row.getCell(j);
                    if (i == 0) {
                        out.println("<th>" + cell.toString());
                    } else {
                        out.println("<td>" + cell.toString());
                    }
                 }
			  }
			  //Iterator<Row> rowIterator = sheet.iterator();
			//   while (rowIterator.hasNext()) { 
			// 	Row row = rowIterator.next(); 
			// 	// For each row, iterate through all the columns 
			// 	Iterator<Cell> cellIterator = row.cellIterator(); 
			// 	out.println("<tr>");
			// 	while (cellIterator.hasNext()) { 
			// 		Cell cell = cellIterator.next(); 
			// 		// Check the cell type and format accordingly 
			// 		 switch (cell.getCellType()) { 
			// 		 case NUMERIC: 
			// 			 //System.out.print(cell.getNumericCellValue() + "t"); 
			// 			 if（）
			// 			 out.println("<td>"+cell.getNumericCellValue());
						 
			// 		 	break; 
			// 		 case STRING: 
            //              // System.out.print(cell.getStringCellValue() + "t");
			// 			out.println("<td>"+cell.getStringCellValue()); 
			// 		 	break; 
			// 		 } 
			// 	} 
				
			//   } 
			    out.println("</table>"); 
				file.close(); 
		    }
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 

} 

