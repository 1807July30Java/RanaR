--**********************************************TASK 2.1 SELECT**************************************************
--Task – Select all records from the Employee table.
SELECT * FROM CHINOOK.EMPLOYEE;

--Task – Select all records from the Employee table where last name is King.
SELECT * FROM CHINOOK.EMPLOYEE WHERE CHINOOK.EMPLOYEE.LASTNAME = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM CHINOOK.EMPLOYEE WHERE CHINOOK.EMPLOYEE.FIRSTNAME = 'Andrew' AND CHINOOK.EMPLOYEE.REPORTSTO IS NULL;

--**********************************************TASK 2.2 ORDER BY**************************************************
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM CHINOOK.ALBUM ORDER BY CHINOOK.ALBUM.TITLE DESC;

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT CHINOOK.CUSTOMER.FIRSTNAME FROM CHINOOK.CUSTOMER ORDER BY CHINOOK.CUSTOMER.CITY;

--**********************************************TASK 2.3 INSERT INTO****************************************************
--Task – Insert two new records into Genre table 
INSERT INTO CHINOOK.GENRE (GENREID, Name) VALUES (26, 'Action Adventure');
INSERT INTO CHINOOK.GENRE (GENREID, Name) VALUES (27, 'Superhero');

--Task – Insert two new records into Employee table
INSERT INTO CHINOOK.EMPLOYEE (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Allen', 'Barry', 'Data Forensics Specialist', 1, TO_DATE('1984-3-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-3-10 00:00:00','yyyy-mm-dd hh24:mi:ss'), '5737 Bowness Road NW', 'Calgary', 'AB', 'Canada', 'T3B 0C5', '+1 (403) 267-0712', '+1 (403) 267-0231', 'barry@chinookcorp.com');
INSERT INTO CHINOOK.EMPLOYEE (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'Hall', 'Fae', 'Sales Manager', 1, TO_DATE('1984-10-20 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2005-10-26 00:00:00','yyyy-mm-dd hh24:mi:ss'), '1123 6 Ave SW', 'Calgary', 'AB', 'Canada', 'T2P 5M5', '+1 (403) 142-0178', '+1 (403) 142-8917', 'fae@chinookcorp.com');

--Task – Insert two new records into Customer table
INSERT INTO CHINOOK.CUSTOMER (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (60, 'John', 'Marston', 'Theodor-Heuss-Straße 38', 'Stuttgart', 'Germany', '70174', '+49 0561 3542321', 'john@surfeu.de', 5);
INSERT INTO CHINOOK.CUSTOMER (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (61, 'Jacob', 'Lau', 'Theodor-Heuss-Straße 31', 'Stuttgart', 'Germany', '70174', '+49 0634 1832342', 'jacob@surfeu.de', 3);

--**********************************************TASK 2.4 UPDATE**************************************************
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CHINOOK.CUSTOMER SET CHINOOK.CUSTOMER.FIRSTNAME = 'Robert', CHINOOK.CUSTOMER.LASTNAME = 'Walter' 
WHERE CHINOOK.CUSTOMER.FIRSTNAME = 'Aaron' AND CHINOOK.CUSTOMER.LASTNAME = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	
UPDATE CHINOOK.ARTIST SET CHINOOK.ARTIST.NAME = 'CCR' WHERE CHINOOK.ARTIST.NAME = 'Creedence Clearwater Revival'; 

--**********************************************TASK 2.5 LIKE**************************************************
--Task – Select all invoices with a billing address like “T%” 
SELECT * FROM CHINOOK.INVOICE WHERE CHINOOK.INVOICE.BILLINGADDRESS LIKE 'T%';

--**********************************************TASK 2.6 BETWEEN**************************************************
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM CHINOOK.INVOICE WHERE CHINOOK.INVOICE.TOTAL BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM CHINOOK.EMPLOYEE WHERE CHINOOK.EMPLOYEE.HIREDATE BETWEEN TO_DATE('2003-6-1','yyyy-mm-dd') AND TO_DATE('2004-3-1','yyyy-mm-dd');

--**********************************************TASK 2.7 DELETE**************************************************
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM CHINOOK.INVOICELINE WHERE CHINOOK.INVOICELINE.INVOICEID IN (SELECT CHINOOK.INVOICE.INVOICEID FROM CHINOOK.INVOICE 
WHERE CHINOOK.INVOICE.CUSTOMERID IN (SELECT CHINOOK.CUSTOMER.CUSTOMERID FROM CHINOOK.CUSTOMER 
WHERE CHINOOK.CUSTOMER.FIRSTNAME = 'Robert' AND CHINOOK.CUSTOMER.LASTNAME = 'Walter'));

DELETE FROM CHINOOK.INVOICE WHERE CHINOOK.INVOICE.CUSTOMERID IN (SELECT CHINOOK.CUSTOMER.CUSTOMERID FROM CHINOOK.CUSTOMER 
WHERE CHINOOK.CUSTOMER.FIRSTNAME = 'Robert' AND CHINOOK.CUSTOMER.LASTNAME = 'Walter');

DELETE FROM CHINOOK.CUSTOMER WHERE CHINOOK.CUSTOMER.FIRSTNAME = 'Robert' AND CHINOOK.CUSTOMER.LASTNAME = 'Walter';

--**********************************************TASK 3.1 SYSTEM DEFINED FUNCTIONS**************************************************
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION RETURN_CURRENT_TIME
RETURN VARCHAR2 IS CURRTIME VARCHAR2(100);
BEGIN
    SELECT TO_CHAR(CURRENT_TIMESTAMP, 'HH.MI.SS') INTO CURRTIME FROM DUAL;
    RETURN CURRTIME;
END RETURN_CURRENT_TIME;
/
SELECT RETURN_CURRENT_TIME FROM DUAL;

--Task – create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION LENGTH_OF_NAME
RETURN NUMBER IS NAME_LENGTH NUMBER;
BEGIN
    SELECT DATA_LENGTH INTO NAME_LENGTH FROM ALL_TAB_COLUMNS WHERE TABLE_NAME='MEDIATYPE' AND COLUMN_NAME = 'NAME';
    RETURN NAME_LENGTH;
END LENGTH_OF_NAME;
/
SELECT LENGTH_OF_NAME FROM DUAL;

--**********************************************TASK 3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS**************************************************
--Task – Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION AVG_OF_INVOICES
RETURN INTEGER IS AVG_INVOICES INTEGER;
BEGIN
    SELECT AVG(CHINOOK.INVOICE.TOTAL) INTO AVG_INVOICES FROM CHINOOK.INVOICE;
    RETURN ROUND(AVG_INVOICES, 2);
END AVG_OF_INVOICES;
/
SELECT AVG_OF_INVOICES FROM DUAL;

--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK
RETURN VARCHAR2 IS MOST_EXPENSIVE VARCHAR2(100);
BEGIN
    SELECT CHINOOK.TRACK.NAME INTO MOST_EXPENSIVE 
    FROM CHINOOK.TRACK WHERE CHINOOK.TRACK.UNITPRICE = (SELECT MAX(CHINOOK.TRACK.UNITPRICE) 
    FROM CHINOOK.TRACK) AND ROWNUM = 1;
    RETURN MOST_EXPENSIVE;
END MOST_EXPENSIVE_TRACK;
/
SELECT MOST_EXPENSIVE_TRACK FROM DUAL;

--**********************************************TASK 3.3 USER DEFINED SCALAR FUNCTIONS**************************************************
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVG_PRICE_OF_INVOICELINE
RETURN NUMBER IS AVG_PRICE NUMBER;
BEGIN
    SELECT AVG(CHINOOK.INVOICELINE.UNITPRICE) INTO AVG_PRICE FROM CHINOOK.INVOICELINE;
    RETURN ROUND(AVG_PRICE, 2);
END AVG_PRICE_OF_INVOICELINE;
/
SELECT AVG_PRICE_OF_INVOICELINE FROM DUAL;

--**********************************************TASK 3.4 USER DEFINED TABLE VALUED FUNCTIONS**************************************************
--Task – Create a function that returns all employees who are born after 1968

CREATE OR REPLACE FUNCTION EMPLOYEES_BORN_AFTER_1968
RETURN SYS_REFCURSOR
IS EMPS_AFTER_1968 SYS_REFCURSOR;
BEGIN
    OPEN EMPS_AFTER_1968 FOR
    SELECT FIRSTNAME, LASTNAME 
    FROM CHINOOK.EMPLOYEE 
    WHERE BIRTHDATE > TO_DATE('1968-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss');
    RETURN EMPS_AFTER_1968;
END;

DECLARE 
CURR_CURSOR SYS_REFCURSOR;
FIRSTNAME CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
LASTNAME CHINOOK.EMPLOYEE.LASTNAME%TYPE;
BEGIN
 CURR_CURSOR := EMPLOYEES_BORN_AFTER_1968;
 DBMS_OUTPUT.PUT_LINE('TASK 3.4: EMPLOYEES BORN AFTER 1968:');
    LOOP
        FETCH CURR_CURSOR INTO FIRSTNAME, LASTNAME;
        EXIT WHEN CURR_CURSOR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRSTNAME||' '||LASTNAME);
    END LOOP;
    CLOSE CURR_CURSOR;
 DBMS_OUTPUT.PUT_LINE('********************************');
END;
--**********************************************TASK 4.1 BASIC STORED PROCEDURE********************************************
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE EMPLOYEE_FANDL_NAMES(EMP_FULLNAME OUT SYS_REFCURSOR)
IS EMP_NAMES SYS_REFCURSOR;
BEGIN
    OPEN EMP_NAMES FOR
    SELECT FIRSTNAME, LASTNAME FROM CHINOOK.EMPLOYEE;
    EMP_FULLNAME:= EMP_NAMES;
END;

DECLARE 
CURR_CURSOR SYS_REFCURSOR;
FIRSTNAME CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
LASTNAME CHINOOK.EMPLOYEE.LASTNAME%TYPE;
BEGIN
    EMPLOYEE_FANDL_NAMES(CURR_CURSOR);
    DBMS_OUTPUT.PUT_LINE('TASK 4.1: RETURNING ALL EMPLOYEE FIRST AND LAST NAMES');
    LOOP
        FETCH CURR_CURSOR INTO FIRSTNAME, LASTNAME;
        EXIT WHEN CURR_CURSOR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRSTNAME||' '||LASTNAME);
    END LOOP;
    CLOSE CURR_CURSOR;
END;

----**********************************************TASK 4.2 STORED PROCEDURE INPUT PARAMETERS********************************************
--Task – Create a stored procedure that returns the managers of an employee
CREATE OR REPLACE PROCEDURE EMPLOYEE_MANAGERS(EMP_MANGR OUT SYS_REFCURSOR)
IS EMP_MANG SYS_REFCURSOR;
BEGIN
    OPEN EMP_MANG FOR
    SELECT FIRSTNAME, LASTNAME FROM CHINOOK.EMPLOYEE
    WHERE EMPLOYEEID IN (SELECT REPORTSTO FROM CHINOOK.EMPLOYEE);
    EMP_MANGR:= EMP_MANG;
END;

DECLARE 
CURR_CURSOR SYS_REFCURSOR;
FIRSTNAME CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
LASTNAME CHINOOK.EMPLOYEE.LASTNAME%TYPE;
BEGIN
    EMPLOYEE_MANAGERS(CURR_CURSOR);
    DBMS_OUTPUT.PUT_LINE('TASK 4.1: RETURNING ALL MANAGERS');
    LOOP
        FETCH CURR_CURSOR INTO FIRSTNAME, LASTNAME;
        EXIT WHEN CURR_CURSOR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRSTNAME||' '||LASTNAME);
    END LOOP;
    CLOSE CURR_CURSOR;
END;

--**********************************************TASK 4.3 INNER********************************************



--**********************************************TASK 6.1 AFTER/FOR********************************************
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table
CREATE OR REPLACE TRIGGER AFTER_INSERT_ON_EMP
AFTER INSERT ON CHINOOK.EMPLOYEE 
FOR EACH ROW
BEGIN 
    DBMS_OUTPUT.PUT_LINE('INSERTED NEW EMPLOYEE');
END;

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER AFTER_UPDATE_ALBUM_TITLE
AFTER UPDATE ON CHINOOK.ALBUM 
FOR EACH ROW
BEGIN 
    DBMS_OUTPUT.PUT_LINE('UPDATED ALBUM TABLE');
END;

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table
CREATE OR REPLACE TRIGGER AFTER_DELETE_CUSTOMER
AFTER DELETE ON CHINOOK.CUSTOMER 
FOR EACH ROW
BEGIN 
    DBMS_OUTPUT.PUT_LINE('DELETED FROM CUSTOMER TABLE');
END;

--**********************************************TASK 7.1 INNER********************************************
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId
SELECT CHINOOK.CUSTOMER.FIRSTNAME, CHINOOK.CUSTOMER.LASTNAME, CHINOOK.INVOICE.INVOICEID
FROM CHINOOK.CUSTOMER 
INNER JOIN CHINOOK.INVOICE ON CHINOOK.CUSTOMER.CUSTOMERID = CHINOOK.INVOICE.CUSTOMERID; 

--**********************************************TASK 7.2 OUTER********************************************
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CHINOOK.CUSTOMER.CUSTOMERID, CHINOOK.CUSTOMER.FIRSTNAME, CHINOOK.CUSTOMER.LASTNAME, CHINOOK.INVOICE.INVOICEID, CHINOOK.INVOICE.TOTAL
FROM CHINOOK.CUSTOMER
LEFT OUTER JOIN CHINOOK.INVOICE ON CHINOOK.CUSTOMER.CUSTOMERID = CHINOOK.INVOICE.CUSTOMERID;

--**********************************************TASK 7.3 RIGHT********************************************
--Task – Create a right join that joins album and artist specifying artist name and title
SELECT CHINOOK.ARTIST.NAME, CHINOOK.ALBUM.TITLE 
FROM CHINOOK.ARTIST
RIGHT JOIN CHINOOK.ALBUM ON CHINOOK.ARTIST.ARTISTID = CHINOOK.ALBUM.ARTISTID;

--**********************************************TASK 7.4 CROSS********************************************
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order
SELECT CHINOOK.ARTIST.NAME, CHINOOK.ALBUM.TITLE
FROM CHINOOK.ARTIST
CROSS JOIN CHINOOK.ALBUM 
ORDER BY CHINOOK.ARTIST.NAME ASC;

--**********************************************TASK 7.5 SELF********************************************
--Task – Perform a self-join on the employee table, joining on the reportsto column
SELECT A.EMPLOYEEID, B.REPORTSTO
FROM CHINOOK.EMPLOYEE A, CHINOOK.EMPLOYEE B
WHERE A.REPORTSTO = B.REPORTSTO;
