/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-04
 */
public class Multiply_Strings_43 {
    /**
     * @param num1 the non-negative integer represented as string
     * @param num2 the non-negative integer represented as string
     * @return String - the product of the two integers
     * @implSpec Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
     * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
     * @author Brian Qu
     * @since 2024-05-04 22:08
     */
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] products = new int[m + n];

        // reverse both numbers to start from the least significant digit
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        // multiply each digit and add to the corresponding position in products
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                products[i + j] += d1 * d2;
            }
        }

        // handle carries and build the final result
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < products.length; i++) {
            int mod = products[i] % 10;
            int carry = products[i] / 10;
            if (i + 1 < products.length) {
                products[i + 1] += carry;
            }
            res.insert(0, mod);
        }

        // remove leading zeros
        while (!res.isEmpty() && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        return res.isEmpty() ? "0" : res.toString();
    }
}
