-- Exercise 1b: Set VIP flag for customers with balance over $10,000
DECLARE
    -- Add IsVIP column if it doesn't exist
    v_count NUMBER;
BEGIN
    -- Check if IsVIP column exists
    SELECT COUNT(*) INTO v_count
    FROM USER_TAB_COLUMNS
    WHERE TABLE_NAME = 'CUSTOMERS' AND COLUMN_NAME = 'ISVIP';
    
    -- Add column if it doesn't exist
    IF v_count = 0 THEN
        EXECUTE IMMEDIATE 'ALTER TABLE Customers ADD IsVIP VARCHAR2(5) DEFAULT ''FALSE''';
        DBMS_OUTPUT.PUT_LINE('Added IsVIP column to Customers table');
    END IF;
    
    -- Update VIP status using CASE statement
    UPDATE Customers
    SET IsVIP = CASE 
        WHEN Balance > 10000 THEN 'TRUE'
        ELSE 'FALSE'
    END;
    
    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' customers processed for VIP status');
    COMMIT;
    
    -- Display VIP customers
   -- Display VIP customers
DBMS_OUTPUT.PUT_LINE('');
DBMS_OUTPUT.PUT_LINE('VIP Customers:');
FOR vip_cust IN (SELECT CustomerID, Name, Balance, IsVIP 
                 FROM Customers 
                 WHERE IsVIP = 'TRUE') LOOP
    DBMS_OUTPUT.PUT_LINE('Customer: ' || vip_cust.Name || 
        ' (Balance: $' || vip_cust.Balance || ')');
END LOOP;
END;
/