public class Fibonacci {

    public static void main(String[] args) {
        int n = 50;
        long[] fibonacciNumbers = fibonacci(n);
        for (int i = 0; i < fibonacciNumbers.length; i++) {
            System.out.print(fibonacciNumbers[i] + " ");
        }
    }
    public static long[] fibonacci(int n) {
        long[] result = new long[n];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }
}