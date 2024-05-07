/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec None
 * @since 2024-05-06
 */
public class Sum_of_Two_Integers_371 {
    /**
     * @param a an integer
     * @param b an integer
     * @return int - the sum of the two integers
     * @implSpec Given two integers a and b, return the sum of the two integers without using the operators + and -.
     * @author Brian Qu
     * @since 2024-05-06 20:05
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }

        return a;
    }

    public static void main(String[] args) {
        int a = 1, b = 2;
        Sum_of_Two_Integers_371 test = new Sum_of_Two_Integers_371();
        System.out.println(test.getSum(a, b));
    }
}
