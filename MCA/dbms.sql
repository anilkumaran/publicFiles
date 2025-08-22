DBMS, SQL, and PL/SQL Reference Guide
1. Database Management System (DBMS)
A DBMS is a software system that allows users to define, create, maintain, and control access to a database. It acts as an interface between the user/applications and the database itself.
2. Structured Query Language (SQL) SQL Commands
SQL is the standard language for managing relational databases. It is divided into several sub-languages.
Data Definition Language (DDL)
DDL is used to define the database schema.
•	CREATE: Creates database objects.
•	ALTER: Modifies database object structure.
•	DROP: Deletes database objects.
•	TRUNCATE: Removes all data from a table, but keeps the structure.
-- CREATE a new table
CREATE TABLE employees (
    employee_id NUMBER(6) PRIMARY KEY,
    first_name VARCHAR2(20),
    last_name VARCHAR2(25) NOT NULL,
    email VARCHAR2(25) UNIQUE,
    hire_date DATE DEFAULT SYSDATE,
    job_id VARCHAR2(10) NOT NULL,
    salary NUMBER(8, 2),
    commission_pct NUMBER(2, 2)
);

-- ALTER a table to add a new column
ALTER TABLE employees ADD (location_id NUMBER(4));

-- DROP a table
DROP TABLE employees;

-- TRUNCATE a table to remove all data
TRUNCATE TABLE employees;

Data Manipulation Language (DML)
DML is used for managing data within schema objects.
•	INSERT: Adds new rows.
•	UPDATE: Modifies existing rows.
•	DELETE: Removes rows.
-- INSERT a new row into the employees table
INSERT INTO employees (employee_id, first_name, last_name, email, job_id, salary)
VALUES (101, 'John', 'Doe', 'john.doe@example.com', 'IT_PROG', 60000);

-- UPDATE an existing row
UPDATE employees SET salary = 65000 WHERE employee_id = 101;

-- DELETE a row
DELETE FROM employees WHERE employee_id = 101;

Data Control Language (DCL)
DCL is used to control access to data.
•	GRANT: Gives user privileges.
•	REVOKE: Takes back privileges.
-- GRANT SELECT privilege on the employees table to user 'SCOTT'
GRANT SELECT ON employees TO SCOTT;

-- REVOKE the SELECT privilege from user 'SCOTT'
REVOKE SELECT ON employees FROM SCOTT;

Transaction Control Language (TCL)
TCL is used to manage transactions.
•	COMMIT: Saves changes permanently.
•	ROLLBACK: Undoes changes.
•	SAVEPOINT: Sets a temporary marker.
-- Start a transaction
INSERT INTO employees (employee_id, first_name, last_name, email, job_id, salary)
VALUES (102, 'Jane', 'Smith', 'jane.smith@example.com', 'IT_PROG', 70000);

-- Savepoint after the first insert
SAVEPOINT first_insert;

-- Another DML operation
UPDATE employees SET salary = 75000 WHERE employee_id = 102;

-- Rollback to the savepoint, undoing the UPDATE but keeping the INSERT
ROLLBACK TO first_insert;

-- Finalize the transaction by saving all changes
COMMIT;

3. SQL Operators
SQL operators perform comparisons and logical operations.
Operator	Description
AND	Logical AND
OR	Logical OR
NOT	Logical NOT
BETWEEN	Checks if a value is within a range
IN	Checks if a value is in a list
LIKE	Pattern matching
=	Equality comparison
-- Examples for SQL Operators
-- Use AND to find employees in department 10 with a salary over 3000
SELECT first_name, salary, department_id FROM employees WHERE department_id = 10 AND salary > 3000;

-- Use OR to find managers or employees with a salary over 5000
SELECT first_name, job_id, salary FROM employees WHERE job_id = 'MANAGER' OR salary > 5000;

-- Use NOT and IN to find employees not in departments 10, 20, or 30
SELECT first_name, department_id FROM employees WHERE department_id NOT IN (10, 20, 30);

-- Use LIKE to find all employees whose name starts with 'S'
SELECT first_name FROM employees WHERE first_name LIKE 'S%';

-- Use BETWEEN to find all employees with a salary between 1500 and 2500
SELECT first_name, salary FROM employees WHERE salary BETWEEN 1500 AND 2500;

4. SQL Functions
SQL functions perform calculations on data values.
Type	Function	Description
Aggregate	COUNT(), SUM(), AVG(), MIN(), MAX()	Perform calculations on a set of rows.
String	UPPER(), LOWER(), SUBSTR()	Manipulate string data.
Numeric	ROUND(), TRUNC(), ABS()	Perform operations on numbers.
Date	SYSDATE, MONTHS_BETWEEN()	Work with date and time values.
-- Examples for SQL Functions
-- Find the average salary of employees
SELECT AVG(salary) AS average_salary FROM employees;

-- Convert an employee's name to uppercase
SELECT UPPER(first_name) FROM employees WHERE employee_id = 101;

-- Extract a substring of a name
SELECT SUBSTR(first_name, 1, 3) FROM employees WHERE employee_id = 101;

5. SQL Clauses
SQL clauses are components of a query.
•	SELECT: Specifies the columns to retrieve.
•	FROM: Specifies the tables to query.
•	WHERE: Filters the rows based on a condition.
•	GROUP BY: Groups rows that have the same values in specified columns.
•	HAVING: Filters the groups created by GROUP BY.
•	ORDER BY: Sorts the result set.
-- Example demonstrating all major SQL clauses
SELECT
    department_id,
    COUNT(employee_id) AS number_of_employees,
    AVG(salary) AS average_salary
FROM
    employees
WHERE
    salary > 2000
GROUP BY
    department_id
HAVING
    COUNT(employee_id) > 5
ORDER BY
    average_salary DESC;

6. Constraints
Constraints are rules enforced on data columns to ensure data integrity.
•	NOT NULL: Ensures a column cannot have a NULL value.
•	UNIQUE: Ensures all values in a column are unique.
•	PRIMARY KEY: A column or set of columns that uniquely identifies each row (combines NOT NULL and UNIQUE).
•	FOREIGN KEY: A key that links two tables together by referencing the PRIMARY KEY of another table.
•	CHECK: Ensures all values in a column satisfy a specific condition.
-- Examples of adding constraints with ALTER TABLE
-- Add a PRIMARY KEY constraint to the employee_id column
ALTER TABLE employees ADD CONSTRAINT pk_emp PRIMARY KEY (employee_id);

-- Add a FOREIGN KEY constraint to the department_id column
ALTER TABLE employees ADD CONSTRAINT fk_emp_dept FOREIGN KEY (department_id) REFERENCES departments(department_id);

-- Add a CHECK constraint to ensure salary is always positive
ALTER TABLE employees ADD CONSTRAINT chk_salary CHECK (salary > 0);

7. Subqueries
A subquery is a query nested inside another query.
-- Find employees who have a salary greater than the average salary
SELECT first_name, salary FROM employees WHERE salary > (SELECT AVG(salary) FROM employees);

8. Set Operations (Relational Algebra)
Set operations combine the results of two or more SELECT statements.
•	UNION: Combines results and removes duplicates.
•	UNION ALL: Combines results and keeps all duplicates.
•	INTERSECT: Returns only the rows that are common to both result sets.
•	MINUS (or EXCEPT): Returns rows from the first query that are not in the second.
-- UNION example
SELECT employee_id FROM employees WHERE salary > 5000
UNION
SELECT employee_id FROM employees WHERE department_id = 10;

-- INTERSECT example
-- Find employee IDs that are in both departments 10 AND have a salary over 5000
SELECT employee_id FROM employees WHERE salary > 5000
INTERSECT
SELECT employee_id FROM employees WHERE department_id = 10;

-- MINUS example
-- Find employee IDs that have a salary over 5000 but are NOT in department 10
SELECT employee_id FROM employees WHERE salary > 5000
MINUS
SELECT employee_id FROM employees WHERE department_id = 10;

9. Views
A view is a virtual table based on the result set of an SQL query.
CREATE VIEW high_salary_employees AS SELECT first_name, salary FROM employees WHERE salary > 3000;

10. PL/SQL
PL/SQL is a procedural extension of SQL.
11. Control Structures
Control structures determine the flow of execution in PL/SQL.
•	Conditional: IF-THEN-ELSIF-ELSE statement
•	Looping: LOOP, FOR LOOP, WHILE LOOP
•	Sequential: Simple block execution
-- Example of an IF-THEN-ELSE control structure
DECLARE
    v_salary NUMBER := 3500;
BEGIN
    IF v_salary > 5000 THEN
        DBMS_OUTPUT.PUT_LINE('High salary');
    ELSIF v_salary >= 3000 THEN
        DBMS_OUTPUT.PUT_LINE('Medium salary');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Low salary');
    END IF;
END;
/

12. Stored Procedures
A stored procedure is a precompiled set of SQL statements stored in the database.
CREATE OR REPLACE PROCEDURE get_employee_count (
    p_dept_id IN NUMBER,
    p_emp_count OUT NUMBER
) AS
BEGIN
    SELECT COUNT(*) INTO p_emp_count FROM employees WHERE department_id = p_dept_id;
END;
/

13. Armstrong number
An Armstrong number is a number that is equal to the sum of the cubes of its digits.
-- PL/SQL to check if a number is an Armstrong number
DECLARE
    num NUMBER := 153;
    temp NUMBER := num;
    sum_cubes NUMBER := 0;
    digit NUMBER;
BEGIN
    WHILE temp > 0 LOOP
        digit := MOD(temp, 10);
        sum_cubes := sum_cubes + POWER(digit, 3);
        temp := TRUNC(temp / 10);
    END LOOP;

    IF num = sum_cubes THEN
        DBMS_OUTPUT.PUT_LINE(num || ' is an Armstrong number.');
    ELSE
        DBMS_OUTPUT.PUT_LINE(num || ' is not an Armstrong number.');
    END IF;
END;
/

14. Reverse of given number
To reverse a number, you repeatedly take the last digit and build a new number.
-- PL/SQL to reverse a number
DECLARE
    num NUMBER := 12345;
    reversed_num NUMBER := 0;
    temp NUMBER := num;
    digit NUMBER;
BEGIN
    WHILE temp > 0 LOOP
        digit := MOD(temp, 10);
        reversed_num := (reversed_num * 10) + digit;
        temp := TRUNC(temp / 10);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Original number: ' || num);
    DBMS_OUTPUT.PUT_LINE('Reversed number: ' || reversed_num);
END;
/

15. Factorial of given number
The factorial of a non-negative integer n is the product of all positive integers up to n.
-- PL/SQL to find the factorial of a number
DECLARE
    n NUMBER := 5;
    factorial NUMBER := 1;
BEGIN
    FOR i IN 1..n LOOP
        factorial := factorial * i;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Factorial of ' || n || ' is: ' || factorial);
END;
/

16. Sum of digits of given number -> Palindrome
This is a two-part question. Here is the code for the sum of digits and for checking if a number/string is a palindrome.
-- PL/SQL to find the sum of digits
DECLARE
    num NUMBER := 12345;
    sum_digits NUMBER := 0;
    temp NUMBER := num;
    digit NUMBER;
BEGIN
    WHILE temp > 0 LOOP
        digit := MOD(temp, 10);
        sum_digits := sum_digits + digit;
        temp := TRUNC(temp / 10);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Sum of digits of ' || num || ' is: ' || sum_digits);
END;
/

17. Multiple Table Queries (co) Types of Joins
Joins combine rows from two or more tables.
•	INNER JOIN: Returns rows with a match in both tables.
•	LEFT (OUTER) JOIN: Returns all rows from the left table.
•	RIGHT (OUTER) JOIN: Returns all rows from the right table.
•	FULL (OUTER) JOIN: Returns all rows when there is a match in either table.
•	CROSS JOIN: Returns the Cartesian product of the two tables.
•	SELF JOIN: A table joined with itself.
-- Example of a basic INNER JOIN
SELECT
    e.first_name,
    e.salary,
    d.dept_name
FROM
    employees e
INNER JOIN
    departments d ON e.department_id = d.department_id;

18. Index
An index improves data retrieval speed.
CREATE INDEX idx_emp_salary ON employees(salary);

19. Triggers
A trigger is a procedure that automatically executes on an event (INSERT, UPDATE, DELETE).
CREATE OR REPLACE TRIGGER before_employee_insert
BEFORE INSERT ON employees
FOR EACH ROW
BEGIN
    -- Set the hire date to the current date if not provided
    :new.hire_date := SYSDATE;
END;
/

20. Cursors
A cursor allows you to process rows of a query one by one.
DECLARE
    CURSOR emp_cursor IS SELECT first_name, salary FROM employees;
    v_emp_name VARCHAR2(100);
    v_salary NUMBER;
BEGIN
    OPEN emp_cursor;
    LOOP
        FETCH emp_cursor INTO v_emp_name, v_salary;
        EXIT WHEN emp_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Employee Name: ' || v_emp_name);
    END LOOP;
    CLOSE emp_cursor;
END;
/

21. Determine names of employee who commission ranges
SELECT first_name FROM employees WHERE commission_pct BETWEEN 0.10 AND 0.50;

22. Determine names of employee who takes highest salary in a dept
SELECT first_name FROM employees WHERE (department_id, salary) IN (
    SELECT department_id, MAX(salary) FROM employees GROUP BY department_id
);

23. Determine employees who located at same place in …
SELECT first_name FROM employees WHERE location = 'DALLAS';

24. Determine employees whose total salary is > 1500
Assumes total salary is salary + (salary * commission).
SELECT first_name FROM employees WHERE (salary + NVL(commission_pct, 0) * salary) > 1500;

25. Info. Salary of any department
Assumes department ID 10.
SELECT first_name, salary FROM employees WHERE department_id = 10;

26. Update emp salary by 20% whose experience is 8 yr
UPDATE employees SET salary = salary * 1.20 WHERE (SYSDATE - hire_date) / 365 > 8;

27. Delete employees whose completed 25 years of service
DELETE FROM employees WHERE (SYSDATE - hire_date) / 365 > 25;

28. Determine commission of employee whose designation is clerk
SELECT commission_pct FROM employees WHERE job_id = 'CLERK';

29. Determine commission of employee taking commission exceeding 500
SELECT commission_pct FROM employees WHERE (commission_pct * salary) > 500;

30. Dept. whose id contains any employee
SELECT department_id FROM employees GROUP BY department_id;

31. Find out details of Top 5 earners of company
SELECT * FROM employees ORDER BY salary DESC FETCH FIRST 5 ROWS ONLY;

32. Display those employee names whose salary is more than 2500
SELECT first_name FROM employees WHERE salary > 2500;

33. Display those employees who had the company before 15th April 81
SELECT first_name FROM employees WHERE hire_date < TO_DATE('15-APR-81', 'DD-MON-YY');

34. Display manager whose salary more than employee working under him
SELECT m.first_name AS manager_name
FROM employees m
JOIN employees e ON m.employee_id = e.manager_id
WHERE m.salary > e.salary;

35. Raise 15% of employees changing his salary if less than 1500, if exactly 1500 change to 2000 salary, if > 2000 assign 5000.
UPDATE employees SET salary = CASE
    WHEN salary < 1500 THEN salary * 1.15
    WHEN salary = 1500 THEN 2000
    WHEN salary > 2000 THEN 5000
    ELSE salary
END;

36. Display those employees who had a salary less than 2000 but more than 1500
SELECT first_name FROM employees WHERE salary BETWEEN 1501 AND 1999;

37. Display those employees whose job is equal to that of ‘allen’
SELECT first_name FROM employees WHERE job_id = (SELECT job_id FROM employees WHERE first_name = 'Allen');

38. Display those employees whose dept is same as that of ‘smith’
SELECT first_name FROM employees WHERE department_id = (SELECT department_id FROM employees WHERE first_name = 'Smith');

39. Display ½ of salary of employee in uppercase & remainder in lowercase
This is a string manipulation query on the employee's name.
SELECT UPPER(SUBSTR(first_name, 1, TRUNC(LENGTH(first_name) / 2))) || LOWER(SUBSTR(first_name, TRUNC(LENGTH(first_name) / 2) + 1)) FROM employees;

40. Display first 3 letters of name in uppercase & remaining in lowercase
SELECT UPPER(SUBSTR(first_name, 1, 3)) || LOWER(SUBSTR(first_name, 4)) FROM employees;

41. Check given number is Armstrong or not
This is the same as question 13.
-- PL/SQL to check if a number is an Armstrong number
DECLARE
    num NUMBER := 153;
    temp NUMBER := num;
    sum_cubes NUMBER := 0;
    digit NUMBER;
BEGIN
    WHILE temp > 0 LOOP
        digit := MOD(temp, 10);
        sum_cubes := sum_cubes + POWER(digit, 3);
        temp := TRUNC(temp / 10);
    END LOOP;

    IF num = sum_cubes THEN
        DBMS_OUTPUT.PUT_LINE(num || ' is an Armstrong number.');
    ELSE
        DBMS_OUTPUT.PUT_LINE(num || ' is not an Armstrong number.');
    END IF;
END;
/

42. Check whether the given string is palindrome or not
This is a string palindrome check.
-- PL/SQL to check if a string is a palindrome
DECLARE
    str VARCHAR2(100) := 'madam';
    reversed_str VARCHAR2(100);
BEGIN
    reversed_str := REVERSE(str);
    IF str = reversed_str THEN
        DBMS_OUTPUT.PUT_LINE('"' || str || '" is a palindrome.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('"' || str || '" is not a palindrome.');
    END IF;
END;
/

43. Square 2 numbers without using third variable
SELECT 5 * 5 FROM dual;

44. Create multiplication tables from 2–9
BEGIN
    FOR i IN 2..9 LOOP
        DBMS_OUTPUT.PUT_LINE('--- Multiplication Table of ' || i || ' ---');
        FOR j IN 1..10 LOOP
            DBMS_OUTPUT.PUT_LINE(i || ' * ' || j || ' = ' || (i * j));
        END LOOP;
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
END;
/

45. Display sum of even numbers & sum of odd numbers from 1–100
DECLARE
    sum_even NUMBER := 0;
    sum_odd NUMBER := 0;
BEGIN
    FOR i IN 1..100 LOOP
        IF MOD(i, 2) = 0 THEN
            sum_even := sum_even + i;
        ELSE
            sum_odd := sum_odd + i;
        END IF;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Sum of even numbers: ' || sum_even);
    DBMS_OUTPUT.PUT_LINE('Sum of odd numbers: ' || sum_odd);
END;
/

46. Check the given number is palindrome or not
This is the same as question 16.
-- PL/SQL to check if a string is a palindrome
DECLARE
    str VARCHAR2(100) := 'madam';
    reversed_str VARCHAR2(100);
BEGIN
    reversed_str := REVERSE(str);
    IF str = reversed_str THEN
        DBMS_OUTPUT.PUT_LINE('"' || str || '" is a palindrome.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('"' || str || '" is not a palindrome.');
    END IF;
END;
/

47. Accept employee input salary and display net salary, PF, percentage
DECLARE
    v_salary NUMBER := &input_salary; -- & denotes a user input variable in SQL*Plus
    v_pf_rate NUMBER := 0.12; -- 12% for PF
    v_pf_amount NUMBER;
    v_net_salary NUMBER;
BEGIN
    v_pf_amount := v_salary * v_pf_rate;
    v_net_salary := v_salary - v_pf_amount;

    DBMS_OUTPUT.PUT_LINE('Input Salary: ' || v_salary);
    DBMS_OUTPUT.PUT_LINE('PF Percentage: ' || v_pf_rate * 100 || '%');
    DBMS_OUTPUT.PUT_LINE('PF Amount: ' || v_pf_amount);
    DBMS_OUTPUT.PUT_LINE('Net Salary: ' || v_net_salary);
END;
/

49. Raise emp salary by 10% where salary < 3000, 20% if salary ≥ 3000 & ≤ 5000, otherwise increase salary by 15%
UPDATE employees SET salary = CASE
    WHEN salary < 3000 THEN salary * 1.10
    WHEN salary BETWEEN 3000 AND 5000 THEN salary * 1.20
    ELSE salary * 1.15
END;

50. Procedure to update salary of employee not completed 10 years service
CREATE OR REPLACE PROCEDURE update_short_term_emp_salary (
    p_raise_percentage IN NUMBER
) AS
BEGIN
    UPDATE employees SET salary = salary * (1 + (p_raise_percentage / 100))
    WHERE (SYSDATE - hire_date) / 365 < 10;
    
    COMMIT; -- Commit the changes
END;
/


