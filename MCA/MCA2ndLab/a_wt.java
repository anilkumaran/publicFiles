<!-- 8 Write a javascript program for onfocus -->

<!DOCTYPE html>
<html>
<head>
    <title>OnFocus Event Example</title>
    <script>
        function highlightInput(element) {
            element.style.background = "yellow";
            element.style.color = "red";
        }

        function removeHighlight(element) {
            element.style.background = "white";
            element.style.color = "black";
        }
    </script>
</head>
<body>

    <h2>JavaScript onfocus Example</h2>

    <p>Click inside the text fields to see the effect:</p>

    First Name: <input type="text" onfocus="highlightInput(this)" onblur="removeHighlight(this)"><br><br>
    Last Name:  <input type="text" onfocus="highlightInput(this)" onblur="removeHighlight(this)">

</body>
</html>


<!-- 21. Write a JDBC program to insert records into the table using command line arguments -->
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


<!-- 33. Write a program to implement declaration tag in JSP -->
<!-- declaration_tag.jsp -->
<html>
<body>
    <h2>JSP Declaration Tag Example</h2>

    <%! 
        // 1. Declaration Tag (<%! ... %>)
        // Variables and methods declared here are global to the JSP class (instance variables/methods)
        int accessCount = 0; 

        public int square(int n) {
            return n * n;
        }
    %>

    <% 
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








How to run servlet
-----------------------------------
1. Go to your Apache Tomcat installation directory (e.g., C:\apache-tomcat-6.0). Navigate to the webapps folder and create a new folder named MyApp. Inside it, create the following structure:


webapps/
 └── MyApp/
      └── WEB-INF/
           ├── web.xml           <-- (The XML code provided previously)
           └── classes/
                └── ViewResult.java  <-- (The Java code provided previously)
cd C:\apache-tomcat-6.0\webapps\MyApp\WEB-INF\classes
javac -classpath "C:\apache-tomcat-6.0\lib\servlet-api.jar" ViewResult.java

Step 3: Verify Database & DSN
Since the code uses sun.jdbc.odbc.JdbcOdbcDriver:

Ensure you have a DSN named MyDSN configured in your Windows ODBC Data Source Administrator.

Ensure your database has a table named result with columns: id, name, mark, exp, dept.


Step 4: Start the Server
Go to the bin folder of Tomcat (e.g., C:\apache-tomcat-6.0\bin).

Double-click startup.bat (Windows) or run ./startup.sh (Linux/Mac).

Wait for the server to start (you will see "Server startup in ... ms").

http://localhost:8080/MyApp/view
------------------------------------------------
