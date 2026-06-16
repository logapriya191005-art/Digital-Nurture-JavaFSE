-- Exercise 3c: Transfer funds between accounts
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_from_balance NUMBER;
    v_to_balance NUMBER;
    v_from_customer NUMBER;
    v_to_customer NUMBER;
    insufficient_funds EXCEPTION;
    invalid_account EXCEPTION;
    negative_amount EXCEPTION;
BEGIN
    DBMS_OUTPUT.PUT_LINE('=== Fund Transfer Request ===');
    DBMS_OUTPUT.PUT_LINE('From Account: ' || p_from_account_id);
    DBMS_OUTPUT.PUT_LINE('To Account: ' || p_to_account_id);
    DBMS_OUTPUT.PUT_LINE('Amount: $' || TO_CHAR(p_amount, '999,999.99'));
    
    -- Validate amount
    IF p_amount <= 0 THEN
        RAISE negative_amount;
    END IF;
    
    -- Check if accounts exist and get balances
    BEGIN
        SELECT Balance, CustomerID INTO v_from_balance, v_from_customer
        FROM Accounts WHERE AccountID = p_from_account_id;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE invalid_account;
    END;
    
    BEGIN
        SELECT Balance, CustomerID INTO v_to_balance, v_to_customer
        FROM Accounts WHERE AccountID = p_to_account_id;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE invalid_account;
    END;
    
    -- Check sufficient funds
    IF v_from_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;
    
    -- Perform the transfer
    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_from_account_id;
    
    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_to_account_id;
    
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('Transfer Successful!');
    DBMS_OUTPUT.PUT_LINE('Account ' || p_from_account_id || ' New Balance: $' || 
        TO_CHAR(v_from_balance - p_amount, '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('Account ' || p_to_account_id || ' New Balance: $' || 
        TO_CHAR(v_to_balance + p_amount, '999,999.99'));
    
    COMMIT;
    
EXCEPTION
    WHEN insufficient_funds THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: Insufficient funds in account ' || p_from_account_id);
        DBMS_OUTPUT.PUT_LINE('Available Balance: $' || TO_CHAR(v_from_balance, '999,999.99'));
        ROLLBACK;
    WHEN invalid_account THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: One or both accounts do not exist');
        ROLLBACK;
    WHEN negative_amount THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: Transfer amount must be positive');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: Transfer failed - ' || SQLERRM);
        ROLLBACK;
END TransferFunds;
/

-- Test the procedure
BEGIN
    TransferFunds(1, 2, 200); -- Transfer $200 from account 1 to account 2
END;
/