import java.util.Arrays;

public class SearchAlgorithms {
    
    // Linear Search - O(n)
    public static int linearSearch(Product[] products, String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equalsIgnoreCase(targetName)) {
                return i; // Found at index i
            }
        }
        return -1; // Not found
    }
    
    // Binary Search - O(log n)
    public static int binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);
            
            if (comparison == 0) {
                return mid; // Found at mid
            } else if (comparison < 0) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1; // Not found
    }
    
    // Sort products by name for binary search
    public static void sortProductsByName(Product[] products) {
        Arrays.sort(products, (p1, p2) -> 
            p1.getProductName().compareToIgnoreCase(p2.getProductName())
        );
    }
}

