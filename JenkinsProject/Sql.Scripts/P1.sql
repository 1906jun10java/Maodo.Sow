DROP USER project1 CASCADE;
/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER project1
IDENTIFIED BY mypassword
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 100M ON users;

GRANT connect to project1;
GRANT resource to project1;
GRANT create session TO project1;
GRANT create table TO project1;
GRANT create view TO project1;

conn project1/mypassword

/

DROP TABLE REIMBURSEMENT ;
DROP TABLE LOGINT;
DROP TABLE EMPLOYEE;

CREATE TABLE EMPLOYEE(
    EMP_ID INTEGER PRIMARY KEY,
    EMP_ROLE VARCHAR2(50),
    FIRSTNAME VARCHAR2(50) , 
    LASTNAME VARCHAR2(50) , 
    DEPARTMENT VARCHAR2(50),
    MANAGER_ID INTEGER
    
    );
    /
    
CREATE TABLE REIMBURSEMENT(
    R_ID INTEGER PRIMARY KEY,
    R_AMOUNT NUMBER(10, 0),
    R_TYPE VARCHAR2(50),
    R_RECEIPT  BLOB,
    R_STATUS VARCHAR2(50),
    R_DATE DATE,
    EMP_ID INTEGER
     );
     /

--ALTER TABLE REIMBURSEMENT
--DROP COLUMN MANAGER_ID;
/
--Date   date       = format.parse ( "2009-12-31" ); in Java
          

CREATE TABLE  LOGINT(  
    USERNAME VARCHAR2(50) PRIMARY KEY,
    PW VARCHAR2(50),
    EMP_ID INTEGER
    );
    /

    ALTER TABLE REIMBURSEMENT
    ADD  CONSTRAINT FK_R_EMP FOREIGN KEY  (EMP_ID)  REFERENCES EMPLOYEE (EMP_ID);
    /
        
    
    ALTER TABLE LOGINT
    ADD  CONSTRAINT FK_L0G_EMP FOREIGN KEY  (EMP_ID)  REFERENCES EMPLOYEE (EMP_ID);
    /
---------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Employee id TRIGGER GENERATOR
DROP SEQUENCE EMPSEQ;
 CREATE SEQUENCE EMPSEQ
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;

CREATE OR REPLACE TRIGGER  emp_trigga
BEFORE INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
SELECT EMPSEQ.NEXTVAL INTO :NEW.EMP_ID FROM DUAL;
END;
/
    --Trigger to insert Reimbursement id

 CREATE SEQUENCE REIMBSEQ
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;

CREATE OR REPLACE TRIGGER  reimb_trigga
BEFORE INSERT ON REIMBURSEMENT
FOR EACH ROW
BEGIN
SELECT REIMBSEQ.NEXTVAL INTO :NEW.R_ID FROM DUAL;
END;
/
    
    
    -------------------------------------------Inserting our Managers (4 of them for 4 different departments)--------------------------------------------------
    
    INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Manager','Larry','Monsen', '1Accounting', 8);
  
     INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Manager','Malick','Jonhson', '2Finance', 6);
  
  INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Manager','Katy','Baraka', '3Humana Resource', 4);
  
  INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Manager','Stephanie','Page', '4Maketing', 2);
/

-----------------------Login credentials for our 4 Managers --------------------------------------------------------------------------    
/      
    INSERT INTO LOGINT (USERNAME, PW, EMP_ID)
    VALUES ('mlarry@gmail.com', 'pw123',2);
      
      INSERT INTO LOGINT (USERNAME, PW, EMP_ID)
    VALUES ('mjohnson@gaol.com', 'password',4);
    
      INSERT INTO LOGINT (USERNAME, PW, EMP_ID)
    VALUES ('bkaty@revature.com', 'java',6);

  INSERT INTO LOGINT (USERNAME, PW, EMP_ID)
    VALUES ('spage@revature.com', 'coder',8);
-------------------------------------------Inserting our Employees (20 of them in 4 different departments)--------------------------------------------------

--2Finance Dep
    
    INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Wilber','Barquero', '2Finance', 4);
    
    INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Kiro','Wilson', '2Finance', 4);
    
    INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Wamba','Zareth', '2Finance', 4);
    
    INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Alpha','Blondy', '2Finance', 4);
    
    INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Amien','Sarro', '2Finance', 4);
    
    INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Mankeur','Kalvi', '2Finance', 4);
    /
    --1Accounting
    
     INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Lora','Sow', '1Accounting', 2);
    
       INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Mustapha','Samir', '1Accounting', 2);
    
       INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','David','Taylor', '1Accounting', 2);
    
       INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Alvis','Roy', '1Accounting', 2);
    
       INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Kelly','Larson', '1Accounting', 2);
    /
    
    --3Human Resource
    
      INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Samira','Barry', '3Humana Resource', 6);
    
    INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Abdoul','Arr', '3Humana Resource', 6);
    
     INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Johnass','LeBlanc', '3Humana Resource', 6);
    
     INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Chriss','Levier', '3Humana Resource', 6);
    
     INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Absa','Sierra', '3Humana Resource', 6);
    /
    
    --4Marketing Department
    
      INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Korri','LeBlanc', '4Maketing', 8);
    
        INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Samuel','Kasse', '4Maketing', 8);
    
        INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Emily','Merlin', '4Maketing', 8);
    
        INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Jolie','Gascon', '4Maketing', 8);
    
        INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
    VALUES (EMPSEQ.NEXTVAL,'Employee','Huggen','Gramis', '4Maketing', 8);
    /
    
--------------------------------------------------------------------------------------------------------------------------------------------------------------
SELECT * FROM EMPLOYEE 
ORDER BY DEPARTMENT;

------------------------------------------------inserting new rows on Reimbursement table------------------------------------------------------------

INSERT INTO REIMBURSEMENT (R_ID, R_AMOUNT, R_TYPE, R_STATUS, R_DATE, EMP_ID)
VALUES (REIMBSEQ.NEXTVAL,2000, 'Travel Expenses' , 'Pending', TO_DATE('2019-07-17', 'YYYY-MM-DD'), 12);
/

INSERT INTO REIMBURSEMENT (R_ID, R_AMOUNT, R_TYPE, R_STATUS, R_DATE, EMP_ID)
VALUES (REIMBSEQ.NEXTVAL,1500, 'Travel Expenses' , 'Pending', TO_DATE('2019-07-18', 'YYYY-MM-DD'), 18);
/
    
INSERT INTO REIMBURSEMENT (R_ID, R_AMOUNT, R_TYPE, R_STATUS, R_DATE, EMP_ID)
VALUES (REIMBSEQ.NEXTVAL,2000, 'Training Cost' , 'Pending', TO_DATE('2019-07-19', 'YYYY-MM-DD'), 12);
/

INSERT INTO REIMBURSEMENT (R_ID, R_AMOUNT, R_TYPE, R_STATUS, R_DATE, EMP_ID)
VALUES (REIMBSEQ.NEXTVAL,1000, 'Food Expenses' , 'Pending', TO_DATE('2019-07-16', 'YYYY-MM-DD'), 20);
/

INSERT INTO REIMBURSEMENT (R_ID, R_AMOUNT, R_TYPE, R_STATUS, R_DATE, EMP_ID)
VALUES (REIMBSEQ.NEXTVAL,1000, 'Certification' , 'Pending', TO_DATE('2019-07-16', 'YYYY-MM-DD'), 20);
/
    
------------------------------------------------Stored procedure to insert data in Employee table---------------------------------------------------

CREATE OR REPLACE PROCEDURE insertEMP(
        eid IN  EMPLOYEE.EMP_ID%TYPE,
       erole IN EMPLOYEE.EMP_ROLE%TYPE,
	   fname IN EMPLOYEE.FIRSTNAME%TYPE,
       lname IN EMPLOYEE.LASTNAME%TYPE,
       dep IN EMPLOYEE.DEPARTMENT%TYPE,
       emid IN EMPLOYEE.MANAGER_ID%TYPE
	  ) 
IS
BEGIN
INSERT INTO EMPLOYEE (EMP_ID, EMP_ROLE, FIRSTNAME, LASTNAME, DEPARTMENT, MANAGER_ID)
VALUES (EMPSEQ.NEXTVAL, erole, fname, lname, dep, emid);
COMMIT;
END;
/

----------------------------------------------------------Stored Procedure for Reimbursement table-----------------------------------------------
CREATE OR REPLACE PROCEDURE insertREIMB(
       rid IN  REIMBURSEMENT.R_ID%TYPE,
	   amount IN  REIMBURSEMENT.R_AMOUNT%TYPE,
       rtype IN  REIMBURSEMENT.R_TYPE%TYPE,
       receipt IN  REIMBURSEMENT.R_RECEIPT%TYPE,
       status IN  REIMBURSEMENT.R_STATUS%TYPE,
       rdate IN  REIMBURSEMENT.R_DATE%TYPE,
       empid IN  REIMBURSEMENT.EMP_ID%TYPE
	  ) 
IS
BEGIN
INSERT INTO REIMBURSEMENT (R_ID, R_AMOUNT, R_TYPE, R_RECEIPT, R_STATUS, R_DATE, EMP_ID)
VALUES (EMPSEQ.NEXTVAL, amount, rtype, receipt, status, rdate, empid);
COMMIT;
END;
/


SELECT * FROM REIMBURSEMENT WHERE  R_STATUS = 'Pending' AND EMP_ID IN  (SELECT EMP_ID FROM EMPLOYEE WHERE MANAGER_ID = 4);



-----------------------------------------------------------------Stored procedure for creating login (credentials for users)------------------------------

CREATE OR REPLACE PROCEDURE insertLOGIN(
       username IN  LOGINT.USERNAME%TYPE,
	   pw IN  LOGINT.PW%TYPE,
       empid IN  LOGINT.EMP_ID%TYPE
        ) 
IS
BEGIN
INSERT INTO LOGINT (USERNAME, PW, EMP_ID)
VALUES (username, pw, empid);
END;
/
       
       
       SELECT * FROM LOGINT;
------------------------------Testing the insertLOGIN stored procedure (successfull)------------------------------------------------------------------------------- 
        EXECUTE insertLOGIN ('asiarra@gmail.com', 'pw123',40);
        
        UPDATE LOGINT SET USERNAME = 'asiarra1@gmail.com', PW = 'pw123' WHERE EMP_ID = 40;
        
        
    SELECT EMP_ROLE, FIRSTNAME, LASTNAME, LOGINT.USERNAME FROM EMPLOYEE JOIN LOGINT ON EMPLOYEE.EMP_ID = LOGINT.EMP_ID  WHERE USERNAME ='asiarra23@gmail.com';
    
    SELECT * FROM EMPLOYEE JOIN LOGINT ON EMPLOYEE.EMP_ID = LOGINT.EMP_ID  WHERE USERNAME ='asiarra23@gmail.com' ;
    
    SELECT USERNAME, PW FROM LOGINT WHERE USERNAME='mlarry@gmail.com' AND PW='pw123'
-------------------------------------------------------------------Creating Employee profile view--------------------------------------------------------------------





--------------------------------------------------------------Manager view  
       