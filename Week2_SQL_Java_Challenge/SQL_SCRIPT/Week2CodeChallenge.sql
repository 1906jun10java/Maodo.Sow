DROP USER Week2CDB CASCADE;
/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER Week2CDB
IDENTIFIED BY mypassword
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to Week2CDB;
GRANT resource to Week2CDB;
GRANT create session TO Week2CDB;
GRANT create table TO Week2CDB;
GRANT create view TO Week2CDB;

conn Week2CDB/mypassword

/
DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;


    CREATE TABLE EMPLOYEE(
    EMPLOYEE_ID INTEGER PRIMARY KEY,
    EMP_FIRSTNAME VARCHAR2(30) , 
    EMP_LASTNAME VARCHAR2(30) , 
    DEPARTMENT_ID INTEGER,
    SALARY NUMBER(10, 0),
    EMP_EMAIL VARCHAR2(50) 
    );
    /
    CREATE TABLE DEPARTMENT(
    DEPARTMENT_ID INTEGER PRIMARY KEY,
     DEPARTMENT_NAME VARCHAR2(30) 
     );
     /

    ALTER TABLE EMPLOYEE
    ADD  CONSTRAINT FK_EMP_DEP FOREIGN KEY  (DEPARTMENT_ID)  REFERENCES DEPARTMENT (DEPARTMENT_ID);
    /
    
---------------------------------------------------------------------------------------------------------------------------------------------------------------------

--CAR ID TRIGGER GENERATOR
DROP SEQUENCE EMP;
 CREATE SEQUENCE EMPIDSEQ
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;

CREATE OR REPLACE TRIGGER  emp_trigga
BEFORE INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
SELECT EMPIDSEQ.NEXTVAL INTO :NEW.EMPLOYEE_ID FROM DUAL;
END;
/
    
    
    INSERT INTO EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, DEP_ID, SALARY, EMP_EMAIL)
    VALUES (EMPIDSEQ.NEXTVAL,'Larry','Monsen', 1, 25000, 'larry@gmail.com');
    INSERT INTO EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, DEP_ID, SALARY, EMP_EMAIL)
    VALUES (EMPIDSEQ.NEXTVAL,'Emily','Smith', 1, 78000, 'emily@gmail.com');
    INSERT INTO EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, DEP_ID, SALARY, EMP_EMAIL)
    VALUES (EMPIDSEQ.NEXTVAL,'Adams','Sarr', 3, 58000, 'adams@gmail.com');
  INSERT INTO EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, DEP_ID, SALARY, EMP_EMAIL)
    VALUES (EMPIDSEQ.NEXTVAL,'Abdoul','Tylor', 2, 45000, 'abdoul@aol.com');
   INSERT INTO EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, DEP_ID, SALARY, EMP_EMAIL)
    VALUES (EMPIDSEQ.NEXTVAL,'Moussa','Alstrom', 2, 45000, 'moussa@yahoo.com');
  INSERT INTO EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, DEP_ID, SALARY, EMP_EMAIL)
    VALUES (EMPIDSEQ.NEXTVAL,'Sophy','Kareme', 2, 55000, 'sphie@aol.com');


--------------------------------------------------------------------------------------------------------------------------------------------------------------

--CAR ID TRIGGER GENERATOR
 CREATE SEQUENCE DEPIDSEQ
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;

CREATE OR REPLACE TRIGGER  dep_trigga
BEFORE INSERT ON DEPARTMENT
FOR EACH ROW
BEGIN
SELECT DEPIDSEQ.NEXTVAL INTO :NEW.DEP_ID FROM DUAL;
END;

    
    
    INSERT INTO DEPARTMENT (DEP_ID, DEP_NAME)
    VALUES (DEPIDSEQ.NEXTVAL,'ACCOUNTING');
       INSERT INTO DEPARTMENT (DEP_ID, DEP_NAME)
    VALUES (DEPIDSEQ.NEXTVAL,'HUMAN RESOURCE');
       INSERT INTO DEPARTMENT (DEP_ID, DEP_NAME)
    VALUES (DEPIDSEQ.NEXTVAL,'INFO- TECH');
       INSERT INTO DEPARTMENT (DEP_ID, DEP_NAME)
    VALUES (DEPIDSEQ.NEXTVAL,'AMINISTRATION');



------------------------------------------------Stored procedure to insert data in Employee table---------------------------------------------------

CREATE OR REPLACE PROCEDURE insertEMP(
      
	   fname IN EMPLOYEE.FIRSTNAME%TYPE,
       lname IN EMPLOYEE.LASTNAME%TYPE,
       depid IN EMPLOYEE.DEP_ID%TYPE,
       empsal IN EMPLOYEE.SALARY%TYPE,
       email IN EMPLOYEE.EMP_EMAIL%TYPE
	  ) 
IS
BEGIN
INSERT INTO EMPLOYEE (EMPLOYEE_ID, FIRSTNAME, LASTNAME, DEP_ID, SALARY, EMP_EMAIL)
VALUES (EMPIDSEQ.NEXTVAL,fname, lname, depid, empsal, email);
COMMIT;

END;
/




