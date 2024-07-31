import java.math.BigInteger;

public class Factorial {
    public static BigInteger fact(int n){
        if (n >= 1) {
            return BigInteger.valueOf(n).multiply(fact(n - 1));
        } else {
            return BigInteger.ONE;
        }
    }

    public static void main(String[] args){
        int n = 50;
        System.out.println(n + " factorial is = " + fact(n) );
    }
}

// OR for shorter numbers

// public class Factorial {
//     public static void main(String[] args){
//         int n = 2;
//         int fact = 1;
//         if(n==0){
//             System.out.println("0");
//         }else{
//             for(int i=1; i<=n; i++){
//                 fact = fact * i;
//             }
//         }
//         System.out.println(fact);
//     }
// }