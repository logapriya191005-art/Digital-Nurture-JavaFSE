-- Exercise 3a: Process monthly interest for savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
    v_interest_rate NUMBER := 0.01; -- 1% monthly interest
    v_updated_count NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('=== Processing Monthly Interest for Savings Accounts ===');
    
    -- Update balance for all savings accounts
    UPDATE Accounts
    SET Balance = Balance + (Balance * v_interest_rate),
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';
    
    v_updated_count := SQL%ROWCOUNT;
    
    DBMS_OUTPUT.PUT_LINE('Interest Rate Applied: ' || (v_interest_rate * 100) || '%');
    DBMS_OUTPUT.PUT_LINE('Accounts Updated: ' || v_updated_count);
    DBMS_OUTPUT.PUT_LINE('Processing completed on: ' || TO_CHAR(SYSDATE, 'DD-MON-YYYY HH24:MI:SS'));
    
    COMMIT;
    
    -- Display updated accounts
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('Updated Account Balances:');
    FOR acc IN (SELECT a.AccountID, c.Name, a.Balance 
                FROM Accounts a
                JOIN Customers c ON a.CustomerID = c.CustomerID
                WHERE a.AccountType = 'Savings') LOOP
        DBMS_OUTPUT.PUT_LINE('Account ' || acc.AccountID || ' (' || acc.Name || 
            '): $' || TO_CHAR(acc.Balance, '999,999.99'));
    END LOOP;
    
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
        ROLLBACK;
END ProcessMonthlyInterest;
/

-- Test the procedure
BEGIN
    ProcessMonthlyInterest;
END;
/