
DROP USER mj_cardb1 CASCADE;
/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER mj_cardb1
IDENTIFIED BY mypassword
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to mj_cardb1;
GRANT resource to mj_cardb1;
GRANT create session TO mj_cardb1;
GRANT create table TO mj_cardb1;
GRANT create view TO mj_cardb1;

conn mj_cardb1/mypassword

/
DROP TABLE EMPLOYEES;
DROP TABLE CARS;
DROP TABLE CUSTOMERS;
DROP TABLE CUSTOMER_OFFER;
DROP TABLE CUSTOMER_PAYMENT;
/

CREATE TABLE EMPLOYEES(
    EMP_ID INTEGER NOT NULL,
    FIRSTNAME VARCHAR2(50), 
    LASTNAME VARCHAR2(50),
    EMP_EMAIL VARCHAR2(50),
    EMP_USERNAME VARCHAR(10), 
    EMP_PASSWORD VARCHAR2(10),
    CONSTRAINT PK_EMPLOYEES PRIMARY KEY (EMP_ID)
);
/

CREATE TABLE CUSTOMERS(
    CUSTOMER_ID INTEGER NOT NULL,
    FIRSTNAME VARCHAR2(50), 
    LASTNAME VARCHAR2(50), 
    CUST_EMAIL VARCHAR2(50),
    CUST_USERNAME VARCHAR(10), 
    CUST_PASSWORD VARCHAR2(10),
    CONSTRAINT PK_CUSTOMERS PRIMARY KEY (CUSTOMER_ID)
);
/

ALTER TABLE CARS ADD  EMP_ID INTEGER;
/
ALTER TABLE CARS ADD  CUSTOMER_ID INTEGER;
/
CREATE TABLE CARS(
    CAR_VIN VARCHAR2(10) NOT NULL,
    CAR_MAKE VARCHAR2(20), 
    CAR_MODEL VARCHAR2(50), 
    YEAR_MAKE INTEGER,
    PRICE NUMBER,
    MILEAGE NUMBER,
    LOT VARCHAR(50),
    EMP_ID INTEGER,
    CONSTRAINT PK_CARS PRIMARY KEY (CAR_VIN)
);
/

CREATE TABLE CUSTOMER_OFFER(
    OFFER_ID INTEGER NOT NULL,
    CUSTOMER_ID INTEGER,
    CAR_VIN VARCHAR2(10), 
    EMP_ID INTEGER, 
    OFFER_DATE DATE,
    OFFER_AMOUNT NUMBER(20),
    CONSTRAINT PK_CUSTOMER_OFFER PRIMARY KEY (OFFER_ID)
);
/

CREATE TABLE CUSTOMER_PAYMENT(
    PAYMENT_ID INTEGER NOT NULL,
    CUSTOMER_ID INTEGER,
    CAR_VIN VARCHAR2(10), 
    EMP_ID INTEGER, 
    TRANSACT_DATE DATE,
    AMOUNT_DUE NUMBER(20, 0),
    BALANCE NUMBER(20, 0),
    CONSTRAINT PK_CUSTOMER_PAYMENT PRIMARY KEY (PAYMENT_ID)
);
/
/*----------------------------------------------------------------------------------------
  OUR FOREIGN KEYS CONSTRAINTS
  --------------------------------------------------------------------------------------*/
  --FOR CUSTOMER OFFER
ALTER TABLE CUSTOMER_OFFER ADD CONSTRAINT FK_CUSTOMER_OFFER_EMPLOYEES 
FOREIGN KEY ("EMP_ID") REFERENCES EMPLOYEES (EMP_ID);

ALTER TABLE CUSTOMER_OFFER ADD CONSTRAINT FK_CUSTOMER_OFFER_CUSTOMERS 
FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS (CUSTOMER_ID);
      
ALTER TABLE CUSTOMER_OFFER ADD CONSTRAINT  "FK_CUSTOMER_OFFER_CARS" 
FOREIGN KEY (CAR_VIN) REFERENCES CARS (CAR_VIN);
/
--FOR CUSTOMER PAYMENT
ALTER TABLE CUSTOMER_PAYMENT ADD CONSTRAINT FK_CUSTOMER_PAYMENT_EMPLOYEES 
FOREIGN KEY ("EMP_ID") REFERENCES EMPLOYEES (EMP_ID);

ALTER TABLE CUSTOMER_PAYMENT ADD CONSTRAINT FK_CUSTOMER_PAYMENT_CUSTOMERS 
FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS (CUSTOMER_ID);
      
ALTER TABLE CUSTOMER_PAYMENT ADD CONSTRAINT  "FK_CUSTOMER_PAYMENT_CARS" 
FOREIGN KEY (CAR_VIN) REFERENCES CARS (CAR_VIN);
/
-- Adding foreign key to Table Cars

ALTER TABLE CARS ADD CONSTRAINT FK_CARS_EMPLOYEES 
FOREIGN KEY ("EMP_ID") REFERENCES EMPLOYEES (EMP_ID);
/
--ADDING FOREIGN KEY TO TABLE CARS

ALTER TABLE CARS ADD CONSTRAINT FK_CARS_CUSTOMERS 
FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS (CUSTOMER_ID);

-----------------------------------------------------------------------------------------------------------------------------------------------
CREATE SEQUENCE CUSTSEQ
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 100;
--DROP TRIGGER cust_trigga;

CREATE OR REPLACE TRIGGER  cust_trigga
BEFORE INSERT ON CUSTOMERS
FOR EACH ROW
BEGIN
SELECT CUSTSEQ.NEXTVAL INTO :NEW.EMPLOYEE_ID FROM DUAL;
END;


CREATE SEQUENCE EMPSEQ
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 100;

CREATE OR REPLACE TRIGGER  emp_trigga
BEFORE INSERT ON EMPLOYEES
FOR EACH ROW
BEGIN
SELECT EMPSEQ.NEXTVAL INTO :NEW.EMP_ID FROM DUAL;
END;
/

--DROP TRIGGER TRIGCAR;

--DROP SEQUENCE CARSEQ;

CREATE SEQUENCE CARSEQ
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 100;

CREATE OR REPLACE TRIGGER  car_trigga
BEFORE INSERT ON CARS
FOR EACH ROW
BEGIN
SELECT CARSEQ.NEXTVAL INTO :NEW.CAR_VIN FROM DUAL;
END;
/

DROP TRIGGER TRIGGA;
/

DROP TRIGGER CUSTOFF_TRIGGA;

DROP TRIGGER CUSTPAY_TRIGGA;
/

DROP SEQUENCE CUSTOFFSEQ;

DROP SEQUENCE CUSTPAYSEQ;


CREATE SEQUENCE OFFSEQ
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 100;

CREATE OR REPLACE TRIGGER  off_trigga
BEFORE INSERT ON CUSTOMER_OFFER
FOR EACH ROW
BEGIN
SELECT OFFSEQ.NEXTVAL INTO :NEW.OFFER_ID FROM DUAL;
END;
/



CREATE SEQUENCE PAYSEQ
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 100;

CREATE OR REPLACE TRIGGER  pay_trigga
BEFORE INSERT ON CUSTOMER_PAYMENT
FOR EACH ROW
BEGIN
SELECT PAYSEQ.NEXTVAL INTO :NEW.PAYMENT_ID FROM DUAL;
END;
/
