public class EcommerceSearchDemo {
    public static void main(String[] args) {
        // Create sample products
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "T-Shirt", "Clothing"),
            new Product(4, "Headphones", "Electronics"),
            new Product(5, "Jeans", "Clothing")
        };
        
        System.out.println("=== Linear Search ===");
        int linearResult = SearchAlgorithms.linearSearch(products, "Headphones");
        System.out.println("Search Result: " + 
            (linearResult != -1 ? products[linearResult] : "Not found"));
        
        // Sort for binary search
        SearchAlgorithms.sortProductsByName(products);
        System.out.println("\nProducts sorted for binary search:");
        for (Product p : products) {
            System.out.println("  " + p.getProductName());
        }
        
        System.out.println("\n=== Binary Search ===");
        int binaryResult = SearchAlgorithms.binarySearch(products, "Headphones");
        System.out.println("Search Result: " + 
            (binaryResult != -1 ? products[binaryResult] : "Not found"));
        
        // Analysis output
        System.out.println("\n=== Time Complexity Analysis ===");
        System.out.println("Linear Search: O(n) - checks each element one by one");
        System.out.println("Binary Search: O(log n) - divides search space in half");
        System.out.println("\nFor 1000 products:");
        System.out.println("  Linear Search worst case: 1000 comparisons");
        System.out.println("  Binary Search worst case: ~10 comparisons");
    }
}