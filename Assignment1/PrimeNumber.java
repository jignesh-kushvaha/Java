public class PrimeNumber {

    public static boolean isPrimeNumber(int n){
        for(int i = 2; i < n; i++){
            if(n%i==0) { return false;}
        }
        return true;
    }

    public static void main(String[] args) {
        int ct=0;
        int val = 2;
        while(ct<20){
            if(isPrimeNumber(val)) {
                System.out.print(val + " ");
                ct++;
            }
            val++;
        }
    }
}
