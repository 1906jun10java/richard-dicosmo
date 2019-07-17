--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;
/
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
/
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
/
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY TITLE DESC;
/
--Task – Select first name from Customer and sort result set in ascending order by city.
SELECT CUSTOMERID FROM CUSTOMER ORDER BY CITY ASC;
/
--2.3 INSERT INTO
--Task – Insert two new records into Genre table 
INSERT INTO GENRE VALUES(26, 'TRANCE');
INSERT INTO GENRE VALUES(27, 'LOUNGE');
/
--Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME)
VALUES(9, 'RICHARD', 'DICOSMO');
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME)
VALUES(10, 'TOBIAS', 'YOUNG');
/
--Task – Insert two new records into Customer table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
VALUES(60, 'RICHARD', 'DICOSMO', 'RJDICOSMO@GMAIL.COM');
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
VALUES(61, 'TOBIAS', 'YOUNG', 'TYOUNG@GMAIL.COM');
/
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
/
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';
/
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';
/
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
/
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-2003' AND '01-MAR-2004';
/
--2.7 DELETE
DELETE FROM INVOICELINE
    WHERE INVOICEID IN (
           SELECT INVOICEID FROM INVOICE
                WHERE CUSTOMERID IN(
                    SELECT CUSTOMERID FROM CUSTOMER
                        WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'));
DELETE FROM INVOICE
      WHERE CUSTOMERID IN (
           SELECT CUSTOMERID FROM CUSTOMER
                WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');               
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
/
--3 SQL FUNCTIONS
--3.1 SYSTEM DEFINED FUNCTIONS
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION RETURN_TIME
RETURN VARCHAR2
IS THIS_TIME VARCHAR2(50);
BEGIN
SELECT CURRENT_TIMESTAMP
INTO THIS_TIME
FROM DUAL;
RETURN THIS_TIME;
END;
/
SELECT RETURN_TIME FROM DUAL;
--Task – create a function that returns the length of name in MEDIATYPE table
SELECT LENGTH(NAME) AS LengthOfName FROM MEDIATYPE;
/
--3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
--Task – Create a function that returns the average total of all invoices
SELECT AVG(TOTAL) AS AVERAGE FROM INVOICE;
/
--Task – Create a function that returns the most expensive track
SELECT MAX(UNITPRICE) AS MAXIMUM_COST FROM TRACK;
/
--3.3 USER DEFINED SCALAR FUNCTIONS
--Task – Create a function that returns the average price of invoice line items in the invoiceline table
SELECT AVG(UNITPRICE) AS AVERAGE FROM INVOICELINE;
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who were born after 1968.
SELECT * FROM EMPLOYEE WHERE BIRTHDATE > 01-JAN-68;
--4.0 STORED PROCEDURES
--4.1 BASIC STORED PROCEDURE
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE SELECT_ALL_NAMES
(FIRST_NAME OUT VARCHAR2, LAST_NAME OUT VARCHAR2) AS
BEGIN
SELECT FIRSTNAME, LASTNAME INTO FIRST_NAME, LAST_NAME FROM EMPLOYEE;
END;
EXEC SELECT_ALL_NAMES;
--4.2 STORED PROCEDURE INPUT PARAMETERS
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE
(CURRENT_EMPLOYEEID IN INTEGER, NEW_LASTNAME IN VARCHAR2, NEW_FIRSTNAME IN VARCHAR2, NEW_TITLE IN VARCHAR2) AS 
BEGIN
UPDATE EMPLOYEE
SET FIRSTNAME = NEW_FIRSTNAME, LASTNAME = NEW_LASTNAME, TITLE = NEW_TITLE
WHERE EMPLOYEEID = CURRENT_EMPLOYEEID;
END;
--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE FIND_MANAGER
(CURRENT_EMPLOYEEID IN INTEGER, CURRENT_MANAGERID IN INTEGER)
AS
BEGIN
SELECT * FROM EMPLOYEE WHERE EMPLOYEEID = CURRENT_EMPLOYEEID AND REPORTSTO = CURRENT_MANAGERID;
END;
--4.3 STORED PROCEDURE OUTPUT PARAMATERS
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE FIND_COMPANY
(CURRENT_CUSTOMERID IN INTEGER)
AS
BEGIN
SELECT FIRTNAME, LASTNAME, COMPANY FROM CUSTOMER WHERE CUSTOMERID = CURRENT_CUSTOMERID;
END;

--5.0 TRANSACTIONS
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE INVOICE
    DROP CONSTRAINT FK_INVOICECUSTOMERID;
ALTER TABLE INVOICE
    ADD CONSTRAINT FK_INVOICECUSTOMERID_CASCADE
    FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER ON DELETE CASCADE;
DELETE FROM INVOICE WHERE INVOICEID = 1;
COMMIT;
--6.0 Triggers
--6.1 after/for
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER INSERT_TRIGGER
    BEFORE INSERT ON EMPLOYEE
    FOR EACH ROW
    WHEN (NEW.EMPLOYEEID IS NULL)
    BEGIN
    SELECT EMPLOYEESEQ.NEXTVAL
    INTO :NEW.EMPLOYEEID
    FROM DUAL;
    END;
/
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER UPDATE_TRIGGER
    BEFORE UPDATE ON ALBUM
    FOR EACH ROW
    BEGIN
    SELECT ALBUMSEQ.NEXTVAL
    INTO :ARTISTID
    FROM DUAL;
    END;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER DELETE_TRIGGER
    BEFORE INSERT ON CUSTOMER
    FOR EACH ROW
    BEGIN
    SELECT CUSTOMERSEQ.NEXTVAL
    INTO :CUSTOMERID
    FROM DUAL;
    END;
/

--7.0 JOINS
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.CUSTOMERID, INVOICE.INVOICEID FROM CUSTOMER INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL 
FROM CUSTOMER OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST RIGHT JOIN ALBUM
ON ARTIST.ARTISTID = ALBUM.ALBUMID;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST CROSS JOIN ALBUM
ON ARTIST.ARTISTID = ALBUM.ALBUMID
ORDER BY ARTIST.NAME;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT EMPLOYEEID, REPORTSTO FROM EMPLOYEE A LEFT JOIN EMPLOYEE B ON A.EMPLOYEEID = B.REPORTSTO;

--Week 3 Friday Review
CREATE OR REPLACE PROCEDURE SP_FEED_BEAR (B_ID IN NUMBER, H_ID IN NUMBER, HONEY_AMT IN NUMBER, AMT_FED OUT NUMBER)
IS
--VARIABLE DECLARATIONS
BB_EXISTS INTEGER;
BEGIN
    --CHECK THAT BEAR IS MATCHED CORRECTLY TO BEEHIVE
    SELECT COUNT(BB.BEAR_ID) INTO BB_EXISTS
    FROM BEAR_BEEHIVE BB
    WHERE BB.BEAR_ID = B_ID
    AND BB.BEEHIVE_ID = H_ID;
    --IS THE AMOUNT OF HONEY >0 AND LESS THAN THE HIVE'S WEIGHT?
    IF BB_EXISTS > 0 AND HONEY_AMT > 0 THEN
        --REDUCE HIVE WEIGHT
        UPDATE BEEHIVE SET LBS_HONEY = LBS_HONEY - HONEY_AMT
        WHERE BEEHIVE_ID = H_ID;
        --INCREASE BEAR WEIGHT
        UPDATE BEAR SET WEIGHT = WEIGHT + HONEY_AMT
        WHERE BEAR_ID = B_ID;
        --SET AMOUNT TO RETURN
        AMT_FED := HONEY_AMT;
    ELSE
        AMT_FED := 0;
    END IF;
    COMMIT;
    --EXCEPTION HANDLING!
    EXCEPTION 
    WHEN OTHERS THEN
    AMT_FED := 0;
    ROLLBACK;
END;

--EXECUTE PROCEDURE
DECLARE
AMT_FED NUMBER;
BEGIN
SP_FEED_BEAR(891,2,5,AMT_FED);
DBMS_OUTPUT.PUT_LINE('FED BEAR: ' ||AMT_FED||' POUNDS OF HONEY');
END;