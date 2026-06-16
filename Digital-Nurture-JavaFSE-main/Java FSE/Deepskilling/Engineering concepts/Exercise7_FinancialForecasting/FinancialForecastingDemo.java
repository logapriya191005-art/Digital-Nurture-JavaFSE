public class FinancialForecastingDemo {
    public static void main(String[] args) {
        double presentValue = 10000;  // $10,000 initial investment
        double growthRate = 0.08;     // 8% annual growth
        int years = 5;                 // 5 years
        
        System.out.println("=== Financial Forecasting Tool ===");
        System.out.println("Initial Investment: $" + presentValue);
        System.out.println("Annual Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Investment Period: " + years + " years\n");
        
        // Calculate using recursive method
        double futureValue = FinancialForecasting.calculateFutureValue(presentValue, growthRate, years);
        System.out.println("Future Value (Recursive): $" + String.format("%.2f", futureValue));
        
        // Show year-by-year breakdown
        System.out.println("\n=== Year-by-Year Forecast ===");
        for (int year = 1; year <= years; year++) {
            double value = FinancialForecasting.calculateFutureValue(presentValue, growthRate, year);
            System.out.println("Year " + year + ": $" + String.format("%.2f", value));
        }
        
        // Verify with iterative method
        double iterativeValue = FinancialForecasting.calculateFutureValueIterative(presentValue, growthRate, years);
        System.out.println("\nFuture Value (Iterative): $" + String.format("%.2f", iterativeValue));
        
        // Verify with formula (most efficient)
        double formulaValue = FinancialForecasting.calculateFutureValueFormula(presentValue, growthRate, years);
        System.out.println("Future Value (Formula): $" + String.format("%.2f", formulaValue));
        
        // Analysis
        System.out.println("\n=== Time Complexity Analysis ===");
        System.out.println("Recursive Approach:");
        System.out.println("  - Time Complexity: O(n) where n = number of years");
        System.out.println("  - Space Complexity: O(n) due to call stack");
        System.out.println("  - Pros: Simple, mirrors mathematical definition");
        System.out.println("  - Cons: Stack overflow risk for large n");
        
        System.out.println("\nIterative Approach:");
        System.out.println("  - Time Complexity: O(n)");
        System.out.println("  - Space Complexity: O(1)");
        System.out.println("  - Pros: No stack overflow, same speed");
        System.out.println("  - Cons: Slightly more code");
        
        System.out.println("\nFormula Approach (Best):");
        System.out.println("  - Time Complexity: O(1) - constant time!");
        System.out.println("  - Space Complexity: O(1)");
        System.out.println("  - Pros: Fastest, most efficient");
        System.out.println("  - Cons: Requires mathematical formula knowledge");
        
        System.out.println("\n=== Optimization Strategies ===");
        System.out.println("1. Memoization: Cache results to avoid recalculation");
        System.out.println("2. Iterative approach: Eliminate recursion overhead");
        System.out.println("3. Mathematical formula: Use FV = PV * (1+r)^n for O(1)");
        System.out.println("4. Tail recursion: Optimize recursive calls (if language supports)");
    }
}
