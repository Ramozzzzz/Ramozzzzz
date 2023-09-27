//分数类
public class Fraction {
    int denominator;//分母
    int numerator;//分子

    public Fraction(){
    }
    public Fraction(int d,int n){
        denominator=d;
        numerator=n;
    }

    //获得分子与分母的最大公约数
    public int getGCD(int n,int d){
        if (n % d == 0) {
            return d;
        }
        return getGCD(d, n % d);
    }

    //化简分子分母
    public void toSimplify(){
        int gcd = getGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    //两个分数相加
    public Fraction addFraction(Fraction f){
        int d=denominator;
        int n=numerator;
        denominator=f.denominator*d;//使两个分数分母相同
        numerator=(f.numerator*d)+(f.denominator*n);//分子相加
        toSimplify();//化简
        return new Fraction(denominator,numerator);
    }

    public  Fraction subFraction(Fraction f){//两个分数相减
        int d=denominator;
        int n=numerator;
        denominator=f.denominator*d;//使分母相同
        int temp1=f.numerator*d;
        int temp2=f.denominator*n;
        numerator=temp1-temp2;
        toSimplify();
        return new Fraction(denominator,numerator);
    }

    public  Fraction multFraction(Fraction f){//分数相乘
        denominator=denominator*f.denominator;//分子分母分别相乘
        numerator=numerator*f.numerator;
        toSimplify();
        return new Fraction(denominator,numerator);
    }
}
