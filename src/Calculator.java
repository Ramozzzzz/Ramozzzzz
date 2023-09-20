import java.util.List;
import java.util.Stack;

public class Calculator extends Fraction{
    public static int Calculate(String a,String b,String c){
        int result=0;
        int ai=Integer.parseInt(a);
        int bi=Integer.parseInt(b);
        switch(c) {
            case "+" -> result = ai + bi;
            case "-" -> result = bi - ai;
            case "*" -> result = ai * bi;
        }
        return result;
    }

    public static Fraction fractionCreate(String d,String n){
        int di=Integer.parseInt(d);
        int ni=Integer.parseInt(n);
        return new Fraction(di,ni);
    }

    public static String fractionCalculate(String a1,String b1,String a2,String b2,String c){
        Fraction f1=fractionCreate(a1,b1);
        Fraction f2=fractionCreate(a2,b2);
        switch (c){
            case "+"->f1= f1.addFraction(f2);
            case "-"->f1=f1.subFraction(f2);
            case "*"->f1=f1.multFraction(f2);
        }
        return f1.numerator+"/"+f1.denominator;
    }

    public static int integerCalculator(List<String> equation){
        Stack<String> s1=new Stack<>();
        int result=0;
        int size=equation.size();
        for(int i=0;i<size;i++){
            if(!PostfixExpression.isOperator(equation.get(i))){
                s1.push(equation.get(i));
            }
            else{
                result=Calculate(s1.pop(),s1.pop(),equation.get(i));
                s1.push(String.valueOf(result));
            }
        }
        return  result;
    }
    public static String fractionCalculator(List<String> equation){
        for(int j=0;j<2;j++){
            if(equation.contains("'")){
                int temp=equation.indexOf("'");
                int t1=Integer.parseInt(equation.get(temp-1));
                int t2=Integer.parseInt(equation.get(temp+1));
                int t3=Integer.parseInt(equation.get(temp+2));
                int t4=t1*t3+t2;
                equation.remove(temp+1); equation.remove(temp);
                equation.set(temp-1,String.valueOf(t4));
            }
        }
        int i=0;
        String n1= equation.get(i++);
        String d1= equation.get(i++);
        i++;
        String n2= equation.get(i++);
        String d2= equation.get(i++);
        i++;
        return fractionCalculate(d1,n1,d2,n2,equation.get(i));
    }
}
