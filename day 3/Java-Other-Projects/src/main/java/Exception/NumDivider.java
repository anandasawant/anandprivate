package Exception;

public class NumDivider {
    public double divideNumber(double num1,double num2){
        if (num2==0)
            return 0;
        return num1/num2;
    }

    public double divideNumberException(double num1 ,double num2){
        if(num2==0)throw new ArithmeticException("num2 is 0");
        return num1/num2;
    }
}
