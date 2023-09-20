public class Fraction {
    int denominator;
    int numerator;

    public Fraction(){
    }
    public Fraction(int d,int n){
        denominator=d;
        numerator=n;
    }

    public int getGCD(int n,int d){
        if (n % d == 0) {
            return d;
        }
        return getGCD(d, n % d);
    }

    public void toSimplify(){
        int gcd = getGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    public Fraction addFraction(Fraction f){
        int d=denominator;
        int n=numerator;
        denominator=f.denominator*d;
        numerator=(f.numerator*d)+(f.denominator*n);
        toSimplify();
        return new Fraction(denominator,numerator);
    }

    public  Fraction subFraction(Fraction f){
        int d=denominator;
        int n=numerator;
        denominator=f.denominator*d;
        int temp1=f.numerator*d;
        int temp2=f.denominator*n;
        if(temp1>temp2)
            numerator=temp1-temp2;
        else
            numerator=temp2-temp1;
        toSimplify();
        return new Fraction(denominator,numerator);
    }

    public  Fraction multFraction(Fraction f){
        denominator=denominator*f.denominator;
        numerator=numerator*f.numerator;
        toSimplify();
        return new Fraction(denominator,numerator);
    }
}
