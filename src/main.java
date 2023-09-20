
public class main {
    public static void main(String[] args){
        System.out.println(PostfixExpression.postfixChange("2 ' 1 / 4 + 2 ' 1 / 4"));

        System.out.println(Calculator.fractionCalculator(PostfixExpression.postfixChange("2 ' 1 / 4 + 2 ' 1 / 4")));
//        Fraction f1=new Fraction(5,3);
//        Fraction f2=new Fraction(6,1);
//        f1=f1.subFraction(f2);
//        System.out.println(f1.denominator);
//        System.out.println(f1.numerator);
    }
}
