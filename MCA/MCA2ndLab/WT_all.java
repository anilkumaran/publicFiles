17. Write a program reading data from web form controls using php program
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

Output:
Data Received
Name: Anil
Age: 28
<!-- ----------------------------------------------------------------------------------------------------------------------- -->

18. Write a program php on string function
<!DOCTYPE html>
<html>
<body>
    <?php
        $text = "Hello World";

        echo "Original String: " . $text . "<br>";
        echo "Length: " . strlen($text) . "<br>";
        echo "Word Count: " . str_word_count($text) . "<br>";
        echo "Reverse: " . strrev($text) . "<br>";
        echo "Position of 'World': " . strpos($text, "World") . "<br>";
        echo "Replace 'World' with 'PHP': " . str_replace("World", "PHP", $text);
    ?>
</body>
</html>
<!-- ----------------------------------------------------------------------------------------------------------------------- -->
19. Write a php program using arrays
<!DOCTYPE html>
<html>
<body>
<?php
// 1. Indexed Array
$colors = array("Red", "Green", "Blue");

echo "<b>Indexed Array:</b><br>";
echo "I like " . $colors[0] . " and " . $colors[1] . ".<br><br>";

// 2. Associative Array
$ages = array("Peter" => 35, "Ben" => 37, "Joe" => 43);

echo "<b>Associative Array:</b><br>";
echo "Peter is " . $ages['Peter'] . " years old.";
?>
</body>
</html>
<!-- ----------------------------------------------------------------------------------------------------------------------- -->
20. Write a JDBC program to create a student (sno, sname, course, fee) table using TYPE-I Driver
import java.sql.*;

public class CreateStudentTable {
    public static void main(String[] args) throws Exception {
        // Load Type-1 Driver
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

        // Establish Connection (DSN: MyDSN)
        Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN", "system", "manager");

        // Create Statement
        Statement stmt = con.createStatement();

        // SQL query to create table
        String q = "CREATE TABLE student (sno NUMBER(5), sname VARCHAR(20), course VARCHAR(20), fee NUMBER(7,2))";

        // Execute query
        stmt.executeUpdate(q);

        System.out.println("Table 'student' created successfully.");

        // Close resources
        stmt.close();
        con.close();
    }
}

Output:
Table 'student' created successfully.

<!-- ----------------------------------------------------------------------------------------------------------------------- -->
21. Write a JDBC program to insert records into the table using command line arguments
import java.sql.*;

public class InsertRecord {
    public static void main(String[] args) throws Exception {
        // Load Type-1 Driver
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

        // Establish Connection
        Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN", "system", "manager");

        // Parse Command Line Arguments
        int sno = Integer.parseInt(args[0]);
        String sname = args[1];
        String course = args[2];
        double fee = Double.parseDouble(args[3]);

        // Prepare SQL Query using PreparedStatement
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO student VALUES(?, ?, ?, ?)");
        pstmt.setInt(1, sno);
        pstmt.setString(2, sname);
        pstmt.setString(3, course);
        pstmt.setDouble(4, fee);

        // Execute Update
        int i = pstmt.executeUpdate();

        System.out.println(i + " record inserted successfully.");

        // Close resources
        pstmt.close();
        con.close();
    }
}

Output:
C:\> java InsertRecord 101 "John" "Java" 5000.00
1 record inserted successfully.

<!-- ----------------------------------------------------------------------------------------------------------------------- -->
22. Write a JDBC program to retrieve records from the table it must be displayed in tabular format
import java.sql.*;

public class RetrieveRecords {
    public static void main(String[] args) throws Exception {
        // Load Type-1 Driver
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

        // Establish Connection
        Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN", "system", "manager");

        // Create Statement
        Statement stmt = con.createStatement();

        // Execute Query to retrieve data
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");

        // Print Table Header
        System.out.println("---------------------------------------------------------");
        System.out.println("SNO\tSNAME\t\tCOURSE\t\tFEE");
        System.out.println("---------------------------------------------------------");

        // Iterate through ResultSet and print records
        while (rs.next()) {
            System.out.print(rs.getInt("sno") + "\t");
            System.out.print(rs.getString("sname") + "\t\t");
            System.out.print(rs.getString("course") + "\t\t");
            System.out.println(rs.getDouble("fee"));
        }
        System.out.println("---------------------------------------------------------");

        // Close resources
        rs.close();
        stmt.close();
        con.close();
    }
}
Output:
---------------------------------------------------------
SNO     SNAME           COURSE          FEE
---------------------------------------------------------
101     John            Java            5000.0
102     Alice           Python          4500.0
103     Bob             C++             3000.0
---------------------------------------------------------
<!-- ----------------------------------------------------------------------------------------------------------------------- -->
23. Write a JDBC program to demonstrate DBMD (Data baseMetaData) you must take 10-12 important methods to get the comprehensive information about the used/choosen database in detail
import java.sql.*;

public class DBMDDemo {
    public static void main(String[] args) throws Exception {
        // Load the Driver (using Type-1 as per previous context)
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

        // Establish Connection
        Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN", "system", "manager");

        // Create DatabaseMetaData object
        DatabaseMetaData dbmd = con.getMetaData();

        System.out.println("=================================================");
        System.out.println("      Database Metadata Information             ");
        System.out.println("=================================================");

        // 1. Database Product Name
        System.out.println("1. Database Product Name    : " + dbmd.getDatabaseProductName());

        // 2. Database Product Version
        System.out.println("2. Database Product Version : " + dbmd.getDatabaseProductVersion());

        // 3. Driver Name
        System.out.println("3. Driver Name              : " + dbmd.getDriverName());

        // 4. Driver Version
        System.out.println("4. Driver Version           : " + dbmd.getDriverVersion());

        // 5. URL
        System.out.println("5. URL                      : " + dbmd.getURL());

        // 6. User Name
        System.out.println("6. User Name                : " + dbmd.getUserName());

        // 7. Supports Stored Procedures?
        System.out.println("7. Supports Stored Proc?    : " + dbmd.supportsStoredProcedures());

        // 8. Supports Outer Joins?
        System.out.println("8. Supports Outer Joins?    : " + dbmd.supportsOuterJoins());

        // 9. Supports Transactions?
        System.out.println("9. Supports Transactions?   : " + dbmd.supportsTransactions());

        // 10. Max Row Size
        System.out.println("10. Max Row Size            : " + dbmd.getMaxRowSize());

        // 11. Numeric Functions Supported
        System.out.println("11. Numeric Functions       : " + dbmd.getNumericFunctions());

        // 12. String Functions Supported
        System.out.println("12. String Functions        : " + dbmd.getStringFunctions());

        System.out.println("=================================================");

        // Close Connection
        con.close();
    }
}
Output:
=================================================
      Database Metadata Information             
=================================================
1. Database Product Name    : Oracle
2. Database Product Version : Oracle Database 10g Express Edition Release 10.2.0.1.0
3. Driver Name              : JDBC-ODBC Bridge (odbcjp.dll)
4. Driver Version           : 2.0001 (04.00.6200)
5. URL                      : jdbc:odbc:MyDSN
6. User Name                : SYSTEM
7. Supports Stored Proc?    : true
8. Supports Outer Joins?    : true
9. Supports Transactions?   : true
10. Max Row Size            : 0
11. Numeric Functions       : ABS, ACOS, ASIN, ATAN, CEILING, COS, EXP, FLOOR...
12. String Functions        : CHR, CONCAT, INITCAP, LOWER, LPAD, LTRIM, REPLACE...
=================================================
<!-- ----------------------------------------------------------------------------------------------------------------------- -->
24. Write a JDBC program to demonstrate RSMD (ResultSetMetaData) you must take 8-10 important methods to get the comprehensive information about the used/choosen table in detail
import java.sql.*;

public class RSMDDemo {
    public static void main(String[] args) throws Exception {
        // Load Type-1 Driver
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

        // Establish Connection
        Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN", "system", "manager");

        // Create Statement and Execute Query
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");

        // Get ResultSetMetaData object
        ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println("=================================================");
        System.out.println("      ResultSet Metadata Information             ");
        System.out.println("=================================================");

        // 1. Get Total Column Count
        int colCount = rsmd.getColumnCount();
        System.out.println("Total Columns Detected: " + colCount);
        System.out.println("-------------------------------------------------");

        // Iterate through each column to get details
        for (int i = 1; i <= colCount; i++) {
            System.out.println("Column Index          : " + i);
            
            // 2. Get Column Name
            System.out.println("Column Name           : " + rsmd.getColumnName(i));
            
            // 3. Get Column Type Name (e.g., VARCHAR, NUMBER)
            System.out.println("Column Type Name      : " + rsmd.getColumnTypeName(i));
            
            // 4. Get Column Type (Integer constant for SQL type)
            System.out.println("Column SQL Type (Int) : " + rsmd.getColumnType(i));
            
            // 5. Get Column Display Size
            System.out.println("Column Display Size   : " + rsmd.getColumnDisplaySize(i));
            
            // 6. Get Table Name
            System.out.println("Table Name            : " + rsmd.getTableName(i));
            
            // 7. Get Schema Name
            System.out.println("Schema Name           : " + rsmd.getSchemaName(i));
            
            // 8. Is the column Nullable?
            System.out.println("Is Nullable?          : " + (rsmd.isNullable(i) == 1 ? "Yes" : "No"));
            
            // 9. Is the column Auto Increment?
            System.out.println("Is Auto Increment?    : " + rsmd.isAutoIncrement(i));
            
            // 10. Is the column Case Sensitive?
            System.out.println("Is Case Sensitive?    : " + rsmd.isCaseSensitive(i));
            
            System.out.println("-------------------------------------------------");
        }

        // Close resources
        stmt.close();
        con.close();
    }
}
Output:
=================================================
      ResultSet Metadata Information             
=================================================
Total Columns Detected: 4
-------------------------------------------------
Column Index          : 1
Column Name           : SNO
Column Type Name      : NUMBER
Column SQL Type (Int) : 2
Column Display Size   : 6
Table Name            : STUDENT
Schema Name           : SYSTEM
Is Nullable?          : Yes
Is Auto Increment?    : false
Is Case Sensitive?    : false
-------------------------------------------------
Column Index          : 2
Column Name           : SNAME
Column Type Name      : VARCHAR2
Column SQL Type (Int) : 12
Column Display Size   : 20
Table Name            : STUDENT
Schema Name           : SYSTEM
Is Nullable?          : Yes
Is Auto Increment?    : false
Is Case Sensitive?    : true
-------------------------------------------------
... (Repeats for Course and Fee) ...
<!-- ----------------------------------------------------------------------------------------------------------------------- -->
25. Write a servlet program to display your complete address using GenericServlet (TOMCAT 6.0)
import javax.servlet.*;
import java.io.*;

public class AddressServlet extends GenericServlet {
    // The service method handles the request and generates the response
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        // Set the content type to HTML
        res.setContentType("text/html");
        
        // Get the PrintWriter object to send data to the client
        PrintWriter out = res.getWriter();
        
        // Write HTML content
        out.println("<html><body bgcolor='lightblue'>");
        out.println("<h2><font color='red'>My Complete Address</font></h2>");
        out.println("<b>Name:</b> Student Name<br>");
        out.println("<b>Door No:</b> 12-34/A<br>");
        out.println("<b>Street:</b> Gandhi Nagar, 2nd Lane<br>");
        out.println("<b>City:</b> Hyderabad<br>");
        out.println("<b>State:</b> Telangana - 500001<br>");
        out.println("</body></html>");
        
        out.close();
    }
}

// Web.xml
<web-app>
    <servlet>
        <servlet-name>AddressServlet</servlet-name>
        <servlet-class>AddressServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>AddressServlet</servlet-name>
        <url-pattern>/myaddress</url-pattern>
    </servlet-mapping>
</web-app>

Output:
My Complete Address
Name: Student Name
Door No: 12-34/A
Street: Gandhi Nagar, 2nd Lane
City: Hyderabad
State: Telangana - 500001

<!-- ----------------------------------------------------------------------------------------------------------------------- -->
26. Write a servlet program to retrieve the records from a result (id, name, mark, during exp, dept)
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
Output:
ID	    Name	    Mark	Experience	Dept
101	    Smith	    85	    2 Years	    CSE
102	    Johnson	    90	    3 Years	    ECE
103	    Williams	78	    1 Year	    EEE
<!-- ----------------------------------------------------------------------------------------------------------------------- -->
27. Write a servlet program to communicate HttpServlet

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloHttp extends HttpServlet {
    
    // Process GET requests
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // Set response content type
        res.setContentType("text/html");
        
        // Get output stream to write response
        PrintWriter out = res.getWriter();
        
        // Write HTML response
        out.println("<html><body bgcolor='lightgreen'>");
        out.println("<h1>Hello from HttpServlet!</h1>");
        out.println("<p>You requested this page using the <b>GET</b> method.</p>");
        out.println("<p>Server Time: " + new java.util.Date() + "</p>");
        out.println("</body></html>");
        
        out.close();
    }
}
// web.xml
<web-app>
    <servlet>
        <servlet-name>HelloHttp</servlet-name>
        <servlet-class>HelloHttp</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>HelloHttp</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
</web-app>

Output:
Hello from HttpServlet!

You requested this page using the GET method.

Server Time: Thu Dec 28 19:15:08 IST 2025
<!-- ----------------------------------------------------------------------------------------------------------------------- -->
// LoginProcess.java
28. Write a servlet program to check whether the userid is correct you could display "valid user" if not "invalid user" try to use sendredirect() method
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginProcess extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 1. Read the UserID from the request
        String uid = req.getParameter("userid");
        
        // 2. Validate the UserID (Hardcoded check for demonstration)
        // If UserID is "admin", we consider it valid
        if ("admin".equals(uid)) {
            // Redirect to the ValidServlet URL pattern
            res.sendRedirect("valid"); 
        } else {
            // Redirect to the InvalidServlet URL pattern
            res.sendRedirect("invalid");
        }
    }
}
// ValidServlet.java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ValidServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1>Valid User</h1>");
        out.println("<p>Welcome to the system.</p>");
    }
}

// InvalidServlet.java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InvalidServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1 style='color:red'>Invalid User</h1>");
        out.println("<p>Please check your User ID and try again.</p>");
    }
}


Output:

Case 1: User enters URL http://localhost:8080/MyApp/login?userid=admin

    Browser Output: Valid User Welcome to the system.

Case 2: User enters URL http://localhost:8080/MyApp/login?userid=guest

    Browser Output: Invalid User Please check your User ID and try again.



<!-- ----------------------------------------------------------------------------------------------------------------------- -->
29. Write a servlet program to insert records into database table emp (empid, ename, job, sal, dept loc) using statement interface
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InsertEmpServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // Reading parameters from the request (URL or Form)
        // Example URL: http://localhost:8080/App/insert?id=101&name=John&job=Clerk&sal=5000&dept=HR&loc=NY
        String empid = req.getParameter("id");
        String ename = req.getParameter("name");
        String job = req.getParameter("job");
        String sal = req.getParameter("sal");
        String dept = req.getParameter("dept");
        String loc = req.getParameter("loc");

        try {
            // 1. Load Driver
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            // 2. Establish Connection
            Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN", "system", "manager");

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. Construct Query (Note: String values need single quotes)
            String query = "INSERT INTO emp VALUES(" + empid + ", '" + ename + "', '" + job + "', " + sal + ", '" + dept + "', '" + loc + "')";

            // 5. Execute Update
            int i = stmt.executeUpdate(query);

            out.println("<html><body>");
            if (i > 0) {
                out.println("<h3>" + i + " record inserted successfully!</h3>");
            } else {
                out.println("<h3>Failed to insert record.</h3>");
            }
            out.println("</body></html>");

            // Close resources
            stmt.close();
            con.close();

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}

// web.xml
<web-app>
    <servlet>
        <servlet-name>LoginProcess</servlet-name>
        <servlet-class>LoginProcess</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>LoginProcess</servlet-name>
        <url-pattern>/login</url-pattern>
    </servlet-mapping>

    <servlet>
        <servlet-name>ValidServlet</servlet-name>
        <servlet-class>ValidServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>ValidServlet</servlet-name>
        <url-pattern>/valid</url-pattern>
    </servlet-mapping>

    <servlet>
        <servlet-name>InvalidServlet</servlet-name>
        <servlet-class>InvalidServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>InvalidServlet</servlet-name>
        <url-pattern>/invalid</url-pattern>
    </servlet-mapping>
</web-app>
Output: (Assuming you execute the URL: http://localhost:8080/MyApp/insert?id=500&name=Smith&job=Manager&sal=9000&dept=Sales&loc=Dallas)

1 record inserted successfully!


<!-- ----------------------------------------------------------------------------------------------------------------------- -->
30. Write a program to implement a simple JSP
// simple.jsp
<html>
<head>
    <title>Simple JSP Page</title>
</head>
<body>
    <h2>Welcome to JSP!</h2>
    
    <% 
        // Java code inside scriptlet tag
        String name = "User";
        java.util.Date date = new java.util.Date();
    %>

    <p>Hello, <%= name %>!</p> <p>Current Date and Time: <%= date %></p>
</body>
</html>
Output: 
Welcome to JSP!

Hello, User! Current Date and Time: Thu Jan 08 21:42:05 IST 2026

<!-- ----------------------------------------------------------------------------------------------------------------------- -->
31. Write a program to implement a scriptlet tag in JSP
// scriptlet_demo.jsp
<html>
<body>
    <h2>JSP Scriptlet Example</h2>
    
    <% 
        // This is a Scriptlet Tag containing Java logic
        int a = 10;
        int b = 20;
        int sum = a + b;
        
        // Using System.out.println (prints to server console, not browser)
        System.out.println("Calculation done inside scriptlet.");
    %>

    <p>The value of A is: <%= a %></p>
    <p>The value of B is: <%= b %></p>
    
    <p><b>Sum is: <%= sum %></b></p>

    <hr>
    
    <h3>Logic inside Scriptlet (Loop)</h3>
    <%
        for(int i = 1; i <= 3; i++) {
            out.println("Count: " + i + "<br>");
        }
    %>
</body>
</html>

Output: 
JSP Scriptlet Example
The value of A is: 10
The value of B is: 20
Sum is: 30
Logic inside Scriptlet (Loop)
Count: 1
Count: 2
Count: 3

<!-- ----------------------------------------------------------------------------------------------------------------------- -->
32. Write a program to implement expression tag in JSP
// expression_tag.jsp
<html>
    <body>
        <h2>JSP Expression Tag Example</h2>

        <%
            // Defining variables in a scriptlet to use later
            String username = "Student";
            int num1 = 50;
            int num2 = 15;
        %>

        <p><b>Welcome, <%= username %></b></p>

        <p>Number 1: <%= num1 %></p>
        <p>Number 2: <%= num2 %></p>
        
        <p>Multiplication Result: <%= num1 * num2 %></p>
        
        <p>Current Time: <%= new java.util.Date() %></p>
        
        <p>Uppercase Name: <%= username.toUpperCase() %></p>
    </body>
</html>


Output: 
JSP Expression Tag Example

Welcome, Student

Number 1: 50
Number 2: 15
Multiplication Result: 750
Current Time: Thu Jan 08 21:55:00 IST 2026
Uppercase Name: STUDENT

<!-- ----------------------------------------------------------------------------------------------------------------------- -->
33. Write a program to implement declaration tag in JSP
// declaration_tag.jsp
<html>
<body>
    <h2>JSP Declaration Tag Example</h2>

    <%! 
        // 1. Declaration Tag (<%! ... %>)
        // Variables and methods declared here are global to the JSP class (instance variables/methods)
        int accessCount = 0; 

        // Method declaration
        public int square(int n) {
            return n * n;
        }
    %>

    <% 
        // Scriptlet Tag (<% ... %>)
        // Code here runs every time the page executes (service method)
        accessCount++; 
    %>

    <p><b>Page Access Count:</b> <%= accessCount %></p>
    
    <p>The square of 5 is: <%= square(5) %></p>
    <p>The square of 9 is: <%= square(9) %></p>

</body>
</html>


Output: 
JSP Declaration Tag Example

Page Access Count: 1 
The square of 5 is: 25
oThe square of 9 is: 81

<!-- ----------------------------------------------------------------------------------------------------------------------- -->


