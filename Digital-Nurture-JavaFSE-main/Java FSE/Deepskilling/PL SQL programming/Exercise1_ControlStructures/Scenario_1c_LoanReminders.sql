-- Exercise 1c: Send reminders for loans due within 30 days
DECLARE
    CURSOR cur_loans_due IS
        SELECT c.CustomerID, c.Name, l.LoanID, l.EndDate,
               (l.EndDate - SYSDATE) as days_remaining
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
        ORDER BY l.EndDate;
    
    v_loan_count NUMBER := 0;
BEGIN
    DBMS_OUTPUT.PUT_LINE('=== LOAN PAYMENT REMINDERS ===');
    DBMS_OUTPUT.PUT_LINE('Loans due within the next 30 days:');
    DBMS_OUTPUT.PUT_LINE('-----------------------------------');
    
    FOR loan_rec IN cur_loans_due LOOP
        v_loan_count := v_loan_count + 1;
        
        DBMS_OUTPUT.PUT_LINE('REMINDER #' || v_loan_count);
        DBMS_OUTPUT.PUT_LINE('Customer: ' || loan_rec.Name || ' (ID: ' || loan_rec.CustomerID || ')');
        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || loan_rec.LoanID);
        DBMS_OUTPUT.PUT_LINE('Due Date: ' || TO_CHAR(loan_rec.EndDate, 'DD-MON-YYYY'));
        DBMS_OUTPUT.PUT_LINE('Days Remaining: ' || loan_rec.days_remaining);
        DBMS_OUTPUT.PUT_LINE('Message: Please ensure your loan payment is made on time.');
        DBMS_OUTPUT.PUT_LINE('-----------------------------------');
    END LOOP;
    
    IF v_loan_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No loans due within the next 30 days.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Total reminders sent: ' || v_loan_count);
    END IF;
END;
/