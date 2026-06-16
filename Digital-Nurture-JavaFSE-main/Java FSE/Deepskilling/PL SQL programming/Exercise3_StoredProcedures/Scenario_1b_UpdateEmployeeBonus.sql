-- Exercise 3b: Update employee bonus for a department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) AS
    v_updated_count NUMBER;
    v_old_total_salary NUMBER;
    v_new_total_salary NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('=== Updating Employee Bonus ===');
    DBMS_OUTPUT.PUT_LINE('Department: ' || p_department);
    DBMS_OUTPUT.PUT_LINE('Bonus Percentage: ' || p_bonus_percentage || '%');
    
    -- Get total salary before update
    SELECT NVL(SUM(Salary), 0) INTO v_old_total_salary
    FROM Employees
    WHERE Department = p_department;
    
    -- Update salaries with bonus
    UPDATE Employees
    SET Salary = Salary + (Salary * (p_bonus_percentage / 100))
    WHERE Department = p_department;
    
    v_updated_count := SQL%ROWCOUNT;
    
    -- Get total salary after update
    SELECT NVL(SUM(Salary), 0) INTO v_new_total_salary
    FROM Employees
    WHERE Department = p_department;
    
    DBMS_OUTPUT.PUT_LINE('Employees Updated: ' || v_updated_count);
    DBMS_OUTPUT.PUT_LINE('Total Salary Before: $' || TO_CHAR(v_old_total_salary, '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('Total Salary After: $' || TO_CHAR(v_new_total_salary, '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('Total Bonus Amount: $' || TO_CHAR(v_new_total_salary - v_old_total_salary, '999,999.99'));
    
    -- Display updated employees
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('Updated Employees:');
    FOR emp IN (SELECT EmployeeID, Name, Position, Salary 
                FROM Employees 
                WHERE Department = p_department) LOOP
        DBMS_OUTPUT.PUT_LINE(emp.Name || ' (' || emp.Position || '): $' || 
            TO_CHAR(emp.Salary, '999,999.99'));
    END LOOP;
    
    COMMIT;
    
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No employees found in department: ' || p_department);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonus: ' || SQLERRM);
        ROLLBACK;
END UpdateEmployeeBonus;
/

-- Test the procedure
BEGIN
    UpdateEmployeeBonus('IT', 10); -- 10% bonus for IT department
END;
/