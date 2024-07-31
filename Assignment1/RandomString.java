public class RandomString {
    public static void main(String[] args) {
        char[] alphabets = {'A', 'B', 'C', 'D'};
        char[] result = new char[alphabets.length];
        for (int i = 0; i < alphabets.length;i++){
            double j = Math.random() * alphabets.length;
            result[i] = alphabets[(int) j];
        }
        System.out.println(result);
    }
}
