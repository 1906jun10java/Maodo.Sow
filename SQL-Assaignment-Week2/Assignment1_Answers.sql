
--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

--Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';

--Task elect all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' and REPORTSTO is NULL;

-------------------------------------------------------------------------------------------------------------------------
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM
ORDER BY title DESC;

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT  FIRSTNAME, CITY FROM CUSTOMER
ORDER BY CITY ASC;
----------------------------------------------------------------------------------------------------------------------------
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO GENRE VALUES (26, 'Mbalakh');
INSERT INTO GENRE VALUES (27, 'Blue Jazz2');

SELECT * FROM GENRE;

--Task – Insert two new records into Employee table
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) 
VALUES (9, 'Malick', 'Sow', 'CEO', TO_DATE('1990-8-12 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2012-1-10 00:00:00','yyyy-mm-dd hh24:mi:ss'), '257 West 12th Street', 'Montreal', 'Quebec', 'Canada', 'G8T 3H1', '+1 (514) 488-8956', '+1 (514) 578-3457', 'msow@gmail.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) 
VALUES (10, 'Edwards', 'Nancy', 'Sales Associate', 2, TO_DATE('1979-12-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2010-7-29 00:00:00','yyyy-mm-dd hh24:mi:ss'), '240 East 118 North Drive', 'Longueil', 'Quebec', 'Canada', 'G8T 4FT', '+1 (813) 262-34567', '+1 (813) 457-4567', 'emily12@gmail.com');

SELECT * FROM EMPLOYEE;
----------------------------------------------------------------------------------------------------------------------------
--Task – Insert two new records into Customer table
SELECT * FROM CUSTOMER;

INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) 
VALUES (60, 'Abdoul', 'CALIF', 'Revatur- Florida LTD', 'Av. Bruce BLVD', 'Tampa', 'FL', 'USA', '33672-2341', '+1 (813) 3923-5555', '+1 (813) 3443-5566', 'abdoul23@revature.com', 4);
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) 
VALUES (61, 'John', 'Smith', '22 Rue de la marche', 'Paris', 'France', '33765', '+33 (674) 939- 3827', 'jsmith@gmail.com', 3);

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter

UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME ='Walter'
WHERE  (FIRSTNAME = 'Aaron' AND LASTNAME ='Mitchell');

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”  

UPDATE ARTIST
SET NAME = 'CCR'
WHERE  NAME = 'Creedence Clearwater Revival';

------------------------------------------------------------------------------------------------------------------
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';
------------------------------------------------------------------------------------------------------------------
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL  BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN  TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') AND TO_DATE('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss');
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
--If we try to delete this record (Robert Walter) from the table CUSTOMER, it will  generate an error due to fereign key constraint violotion. 
--Therefore, to do so, I checked out other tables where the table CUSTOMER is acting as parent (customerID = foreign key), and delete those records first, 
-- before to proceed our CUSTOMER table. After checking, we can see that CUSTOMER is related directly to INVOICE, and indirectly to INVOICELINE via INVOICE.

DELETE FROM INVOICELINE
WHERE     INVOICEID IN (SELECT  INVOICEID FROM INVOICE WHERE CUSTOMERID =32);

DELETE FROM INVOICE
WHERE CUSTOMERID = 32;

DELETE FROM CUSTOMER
WHERE CUSTOMERID =32;
-----------------------------------------------------------------------------------------------------------------------------------------
--3 SQL Functions
--3.1 System Defined Functions
--Task – Create a function that returns the current time.

CREATE OR REPLACE PROCEDURE Current_Time_Tapa
is
    BEGIN
         DBMS_OUTPUT.PUT_LINE('The current time in Tampa is: '      
         ||    TO_CHAR(CURRENT_DATE, 'MON-DD-YYYY HH:MI:SS') );
END;
/
EXEC Current_Time_Tampa;
 /
  
--Task – create a function that returns the length of a mediatype from the mediatype table.

CREATE OR REPLACE FUNCTION Media_Length(MediaID IN NUMBER)
RETURN  NUMBER IS
Length_NUMBER NUMBER;
BEGIN
SELECT LENGTH(NAME) INTO Length_NUMBER  FROM MEDIATYPE
WHERE MEDIATYPEID=MediaID;
RETURN (length_Number);
END;
/
SELECT Media_Length(1) FROM DUAL;
/
-------------------------------------------------------------------------------------------------------------------------------------------
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices 

CREATE OR REPLACE FUNCTION AveTotal
RETURN  NUMBER  AS  Ave_Total_Invoice NUMBER;
DECLARE
Total_Invoice := 0;
BEGIN
SELECT TOTAL  INTO Ave_Total_Invoice FROM INVOICE
WHERE TOTAL = TOTAL;
RETURN Total_Invoice = Ave(Total);
END;

/

Task – Create a function that returns the most expensive track




-------------------------------------------------------------------------------------------------------------------------
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table

CREATE OR REPLACE FUNCTION  INVOICELINE_TOTAL  (invoice_id IN NUMBER)
RETURN  NUMBER
IS
tNumber NUMBER := 0;
CURSOR C1 IS
SELECT UNITPRICE, QUANTITY FROM INVOICELINE
WHERE INVOICEID= invoice_id;
    
BEGIN
FOR invoice_rec in C1
LOOP
    tNumber := invoice_rec.UNITPRICE * invoice_rec.QUANTITY + tNumber;
END LOOP;
RETURN tNumber;
END;

EXECUTE INVOICELINE_TOTAL(213);

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.


CREATE OR REPLACE FUNCTION  YEAR_BORN
RETURN   EMPLOYEE AS PERSON IN EMPLOYEE;

BEGIN SELECT BIRTHDATE  INTO PERSON FROM EMPLOYEE 
WHERE EXTRACT(YEAR FROM TO_DATE(BIRTHDATE, 'DD-MON-YYYY')) =1968 
RETURN  PERSON
END;
/
    
EXECUTE YEAR_BORN;
-----------------------------------------------------------------------------------------------------------------------------------------------------------
4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
SELECT * FROM EMPLOYEE;
CREATE OR REPLACE PROCEDURE EMPLOYEE_UPDATEPERSONALINFO
(
FIRSTNAME2 IN  VARCHAR2,
LASTNAME2 IN VARCHAR2,
BIRTHDATE2 IN DATE,
EMPLOYEEID2 IN NUMBER
)
AS
BEGIN
    
    UPDATE EMPLOYEE
    SET
    FIRSTNAME = FIRSTNAME2,
    LASTNAME = LASTNAME2,
    BIRTHDATE = BIRTHDATE2
    WHERE
    EMPLOYEEID = EMPLOYEEID2;
    
    END; 

--Task – Create a stored procedure that returns the managers of an employee.

SELECT * FROM EMPLOYEE;

CREATE OR REPLACE PROCEDURE EMPLOYEE_REPORTSTO
(
EMPLOYEE_ID IN NUMBER,
MANAGERID OUT NUMBER
)
AS
BEGIN
    SELECT REPORTSTO
    INTO MANAGERID
    FROM
    EMPLOYEE
    WHERE EMPLOYEE_ID = EMPLOYEEID;
    END;
    
   
--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.

*SELECT * FROM CUSTOMER;

CREATE OR REPLACE PROCEDURE CUSTOMER_NAMEANDCOMPANY
(
CUSTOMERID2 IN NUMBER,
FIRSTNAME2 OUT VARCHAR2,
LASTNAME2 OUT VARCHAR2,
COMPANY2 OUT VARCHAR2
)
AS
BEGIN
    
    SELECT FIRSTNAME, LASTNAME, COMPANY
    INTO FIRSTNAME2, LASTNAME2, COMPANY2
    FROM
    CUSTOMER
    WHERE CUSTOMERID = CUSTOMERID2;
    
    END;
    /
----------------------------------------------------------------------------------------------------------------------------------

--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.

--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE OR REPLACE TRIGGER  AFTER_INSERT_TRIGGER AFTER INSERT ON EMPLOYEE

FOR EACH ROW  
BEGIN 
UPDATE CUSTOMER
SET FIRSTNAME = 'Adam', LASTNAME = 'Smithy'
WHERE (FIRSTNAME = 'Margaret' AND LASTNAME = 'Park');
END;

--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


--Task – Create an after update trigger on the album table that fires after a row is inserted in the table

CREATE OR REPLACE TRIGGER AFTER_UPDATE_TRIGGER AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
UPDATE ARTIST
SET NAME = 'Whitney Houston'
WHERE NAME = 'Aerosmith';
END;


--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.

CREATE OR REPLACE TRIGGER AFTER_DELETE_TRIGGER AFTER DELETE ON CUSTOMER

FOR EACH ROW  
BEGIN 
DBMS_OUTPUT.PUT_LINE('customer row deleted...WAW');
END;
----------------------------------------------------------------------------------------------------------------------------------------------------





/*Task ? Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.*/
SELECT CUSTOMER.FIRSTNAME ||' '|| CUSTOMER.LASTNAME AS Name, INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.INVOICEID
ORDER BY Name;


/*Task ? Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.*/

SELECT  CUSTOMER.CUSTOMERID ,
        CUSTOMER.FIRSTNAME ||' '|| CUSTOMER.LASTNAME ,
        INVOICE.INVOICEID ,
        INVOICE.TOTAL 
FROM CUSTOMER
FULL OUTER JOIN INVOICE 
on CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;


/*Task ? Create a right join that joins album and artist specifying artist name and title.*/
SELECT ALBUM.TITLE, ARTIST.NAME
FROM ARTIST
RIGHT JOIN ALBUM
ON ALBUM.ARTISTID = ARTIST.ARTISTID;


/*Task ? Create a cross join that joins album and artist and sorts by artist name in ascending order.*/
SELECT *
FROM ALBUM
    CROSS JOIN ARTIST
ORDER BY ARTIST.NAME;


/*Task ? Perform a self-join on the employee table, joining on the reportsto column.*/
SELECT FIRST.EMPLOYEEID, FIRST.LASTNAME ||' '||FIRST.FIRSTNAME AS Name, SECOND.REPORTSTO
FROM EMPLOYEE FIRST, EMPLOYEE SECOND
WHERE FIRST.EMPLOYEEID = SECOND.REPORTSTO; 











