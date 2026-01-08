<!-- 9. Write a program for onload, on-unload and onresize -->
<!-- events_demo.html -->

<!DOCTYPE html>
<html>
<body onload="alert('Page Loaded!')" 
      onunload="alert('Page Closed!')" 
      onresize="document.body.style.background='pink'">

    <h2>Event Test Page</h2>
    <p>1. When you open this page, you see an alert (<b>onLoad</b>).</p>
    <p>2. If you resize the window, the background turns pink (<b>onResize</b>).</p>
    <p>3. If you refresh or close the tab, it tries to alert you (<b>onUnload</b>).</p>

</body>
</html>



<!-- 17 Write a program reading data from web form controls using php program -->
 <!DOCTYPE html>
<html>
<body>
    <form method="post">
        Enter Name: <input type="text" name="user_name"><br><br>
        Enter Age:  <input type="text" name="user_age"><br><br>
        <input type="submit" name="submit" value="Submit Data">
    </form>

    <hr>

    <?php
    if (isset($_POST['submit'])) {
        $name = $_POST['user_name']; // Read name control
        $age = $_POST['user_age'];   // Read age control

        echo "<h3>Data Received:</h3>";
        echo "Name: " . $name . "<br>";
        echo "Age: " . $age;
    }
    ?>
</body>
</html>

Output: Accessing http://localhost:8080/MyApp/view
Data Received
Name: Anil
Age: 28




<!-- 26. Write a servlet program to retrieve the records from a result (id, name, mark, during exp, dept) -->

// ResultServlet.java
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ResultServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // Set content type
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        Connection con = null;
        Statement stmt = null;
        
        // 1. Load Driver (Type-1 as per previous context)
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        
        // 2. Establish Connection
        con = DriverManager.getConnection("jdbc:odbc:MyDSN", "system", "manager");
        
        // 3. Execute Query
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM result_table");
        
        // 4. Generate HTML Output
        out.println("<html><body bgcolor='#f0f0f0'>");
        out.println("<h2 align='center'>Student Results</h2>");
        out.println("<table border='1' align='center' width='80%'>");
        
        // Table Headers
        out.println("<tr bgcolor='orange'>");
        out.println("<th>ID</th><th>Name</th><th>Mark</th><th>Experience</th><th>Dept</th>");
        out.println("</tr>");
        
        // Table Rows
        while (rs.next()) {
            out.println("<tr>");
            out.println("<td align='center'>" + rs.getInt("id") + "</td>");
            out.println("<td>" + rs.getString("name") + "</td>");
            out.println("<td align='center'>" + rs.getInt("mark") + "</td>");
            out.println("<td align='center'>" + rs.getString("exp") + "</td>"); // Assuming 'during exp' maps to 'exp'
            out.println("<td align='center'>" + rs.getString("dept") + "</td>");
            out.println("</tr>");
        }
        out.println("</table></body></html>");
        out.close();
    }
}
// web.xml
<web-app>
    <servlet>
        <servlet-name>ViewResult</servlet-name>
        <servlet-class>ViewResult</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>ViewResult</servlet-name>
        <url-pattern>/view</url-pattern>
    </servlet-mapping>
</web-app>

Output:
ID	    Name	    Mark	Experience	Dept
101	    Smith	    85	    2 Years	    CSE
102	    Johnson	    90	    3 Years	    ECE
103	    Williams	78	    1 Year	    EEE