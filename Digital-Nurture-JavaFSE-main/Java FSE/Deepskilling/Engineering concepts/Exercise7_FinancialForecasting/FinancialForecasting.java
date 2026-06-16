public class FinancialForecasting {
    
    // Recursive method to calculate future value
    // Formula: FV = PV * (1 + rate)^years
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case: if no years left, return current value
        if (years == 0) {
            return presentValue;
        }
        
        // Recursive case: calculate for one year, then recurse for remaining years
        double nextYearValue = presentValue * (1 + growthRate);
        return calculateFutureValue(nextYearValue, growthRate, years - 1);
    }
    
    // Optimized version using iteration (for comparison)
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int years) {
        double result = presentValue;
        for (int i = 0; i < years; i++) {
            result *= (1 + growthRate);
        }
        return result;
    }
    
    // Most efficient: Mathematical formula
    public static double calculateFutureValueFormula(double presentValue, double growthRate, int years) {
        return presentValue * Math.pow(1 + growthRate, years);
    }
}
