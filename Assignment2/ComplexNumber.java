public class ComplexNumber {
    int real,imagine;

    public ComplexNumber(int real, int imagine){
        this.real = real;
        this.imagine = imagine;
    }

    public void show(){
        System.out.println(real + " + " + imagine + "i");
    }

    public ComplexNumber add(ComplexNumber n2){
        ComplexNumber newNumber = new ComplexNumber(0,0);
        newNumber.real = this.real + n2.real;
        newNumber.imagine = this.imagine + n2.imagine;
        return newNumber;
    }

    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(5,5);
        ComplexNumber c2 = new ComplexNumber(10,50);

        ComplexNumber sum = c1.add(c2);
        sum.show();

    }    
}
