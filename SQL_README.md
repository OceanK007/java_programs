# SQL Clauses:
	- WHERE
	- IN
	- BETWEEN
	- GROUP BY
	- ON
	- ORDER BY
	
# SQL functions:
	- count(CITY) - total rows of city column 
	- length(CITY) - total length of city value
	- SUBSTRING(MyColumn, 1, 1) = For first character (1 index based)
	- SUBSTRING(MyColumn, 1, 2) = For first two character
	- LEFT(MyColumn, 1) = For first character from left side
	- RIGHT(MyColumn, 1) = First first character from Right side

# Aggregate functions:
	- count(*) : Return the number of rows in a group, including rows with NULL values
	- count(0) : Return the number of rows in a group, including rows with NULL values
	- count(1) : Return the number of rows in a group, including rows with NULL values
	- count(2) : Return the number of rows in a group, including rows with NULL values
	- count(columnName) : Return the count of all non-null values in column
	- avg()
	- sum()
	- min()
	- max()


# Predefined functions:
	- ROUND(135.375, 2) - 2 digits after decimal
	- FLOOR(columnValue) - Round to nearest/lowest integer value 
	- CEIL(columnValue) - Round to upper integer value
	- REPLACE('0349010330', '0', '') - Replacing 0 with empty value
	- TRUNCATE(135.375, 2) - Return the value truncated to 2 decimal places i.e. 135.37
	- SELECT REPEAT("SQL Tutorial", 3)	- It will print: SQL TutorialSQL TutorialSQL Tutorial
	- CONCAT - Example: SELECT CONCAT("Hi ", "How ", "are ", "you?"); | Hi How are you?
	- LOWER(columnName) - To convert to lower case. E.g: LOWER("Hello") = hello
	- UPPER(columnName) - To conver to upper case. E.g: UPPER("hello") = HELLO
	- POW(4,2) - To calculate value of a number raised to the power : E.g.: SELECT POW(4,2); = 16

# Defining variables and assigning values:
	- Example 1:
		------------------------
		SET @var1 = 2+6;
		Set @var2 := @var1-2;
		
		SELECT @var1, @var2;
		
		Output:
		8, 6
		------------------------
		
	- Example 2: 
		------------------------
		SELECT @var3;
		
		Output:
		NULL
		------------------------

# SQL FULL JOIN / FULL OUTER JOIN / UNION (ALL SAME)
	- UNION

# SQL Conditional statements:
	- CASE
		--------------------------- EXAMPLE ------------------------
		SELECT OrderID, Quantity,
		CASE
		    WHEN Quantity > 30 THEN "The quantity is greater than 30"
		    WHEN Quantity = 30 THEN "The quantity is 30"
		    ELSE "The quantity is under 30"
		END
		FROM OrderDetails;
		------------------------------------------------------------
		
	- IF 
		--------------------------- EXAMPLE ------------------------
		SELECT IF(500<1000, "YES", "NO");
		------------------------------------------------------------

# SQL Limitations:
	- You can’t use aggregate functions with WHERE clause. You have to use GROUP BY followed by HAVING clause where you can use aggregate functions
	- You can’t use limit inside an inner query