import java.util.*;

public class PolynomialFromRoots {

    // Function to convert string of given base to decimal
    public static long convertToDecimal(String value, int base) {
        long result = 0;
        for (char c : value.toCharArray()) {
            int digit;
            if (Character.isDigit(c)) {
                digit = c - '0';
            } else {
                digit = Character.toLowerCase(c) - 'a' + 10;
            }
            result = result * base + digit;
        }
        return result;
    }

    // Function to compute polynomial coefficients given roots
    public static List<Long> buildPolynomial(List<Long> roots) {
        List<Long> coeffs = new ArrayList<>();
        coeffs.add(1L); // Start with P(x) = 1

        for (long root : roots) {
            List<Long> newCoeffs = new ArrayList<>(Collections.nCopies(coeffs.size() + 1, 0L));
            for (int i = 0; i < coeffs.size(); i++) {
                newCoeffs.set(i, newCoeffs.get(i) + coeffs.get(i));
                newCoeffs.set(i + 1, newCoeffs.get(i + 1) - coeffs.get(i) * root);
            }
            coeffs = newCoeffs;
        }
        return coeffs;
    }

    public static void main(String[] args) {
        // Example test case (replace with JSON parsing if required)

        // First test case
        int[][] inputs = {
                {10, 4},       // (base, value in that base but stored as int for simplicity)
                {2, 111},
                {10, 12},
                {4, 213}
        };

        List<Long> roots = new ArrayList<>();
        // Convert to decimal
        roots.add(convertToDecimal("4", 10));
        roots.add(convertToDecimal("111", 2));
        roots.add(convertToDecimal("12", 10));
        roots.add(convertToDecimal("213", 4));

        // Build polynomial coefficients
        List<Long> coeffs = buildPolynomial(roots);

        // Print result in required format
        System.out.println("Polynomial Coefficients:");
        System.out.print("[ ");
        for (int i = 0; i < coeffs.size(); i++) {
            System.out.print(coeffs.get(i));
            if (i != coeffs.size() - 1) System.out.print(", ");
        }
        System.out.println(" ]");
    }
}
