package Test;

import Operations.Fraction;
import org.junit.Test;

import static org.junit.Assert.*;

public class FractionTest {

    @Test
    public void addFraction() {
        Fraction f1=new Fraction(5,1);
        Fraction f2=new Fraction(5,2);
        f1=f1.addFraction(f2);
        System.out.println(f1.numerator + "/" + f1.denominator);
    }

    @Test
    public void subFraction() {
        Fraction f1=new Fraction(5,2);
        Fraction f2=new Fraction(5,4);
        f1=f1.subFraction(f2);
        System.out.println(f1.numerator + "/" +  f1.denominator);
    }

    @Test
    public void multFraction() {
        Fraction f1=new Fraction(5,1);
        Fraction f2=new Fraction(3,2);
        f1=f1.multFraction(f2);
        System.out.println(f1.numerator + "/" +  f1.denominator);
    }
}