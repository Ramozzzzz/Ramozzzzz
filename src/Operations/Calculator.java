package Operations;
import java.util.List;
import java.util.Stack;

public class Calculator extends Fraction{//计算类继承自分数类
    private static int Calculate(String a,String b,String c){//整数计算
        int result=0;
        int ai=Integer.parseInt(a);
        int bi=Integer.parseInt(b);
        switch(c) {//根据传入的符号进行相应的计算
            case "+" -> result = ai + bi;
            case "-" -> result = bi - ai;//对于减法，应考虑两个数字入栈的顺序
            case "*" -> result = ai * bi;
        }
        return result;
    }

    private static Fraction fractionCreate(String d,String n){//构造分数
        int di=Integer.parseInt(d);
        int ni=Integer.parseInt(n);
        return new Fraction(di,ni);
    }

    private static String fractionCalculate(String a1,String b1,String a2,String b2,String c){//分数具体计算
        Fraction f1=fractionCreate(a1,b1);//根据传入的分子分母数据构造分数
        Fraction f2=fractionCreate(a2,b2);
        switch (c){//根据符号选择对应的计算
            case "+"->f1= f1.addFraction(f2);
            case "-"->f1=f1.subFraction(f2);
            case "*"->f1=f1.multFraction(f2);
        }
        return f1.numerator+"/"+f1.denominator;//以分数形式返回结果
    }

    public static int integerCalculator(List<String> equation){//整数计算
        Stack<String> s1=new Stack<>();
        int result=0;
        for (String s : equation) {
            if (!PostfixExpression.isOperator(s)) {
                s1.push(s);//逐个扫描字符，若为数字则直接入栈
            } else {//若为符号则弹出两个数字与当前符号进行运算，并将结果入栈
                result = Calculate(s1.pop(), s1.pop(), s);
                s1.push(String.valueOf(result));
            }
        }
        return  result;
    }
    public static String fractionCalculator(List<String> equation){//分数计算
        for(int j=0;j<2;j++){
            if(equation.contains("'")){//判断分数形式，若为带"'"的真分数形式则化简为假分数形式
                int temp=equation.indexOf("'");//返回"'"所在的下标
                int t1=Integer.parseInt(equation.get(temp-1));//获取"'"前后的数字
                int t2=Integer.parseInt(equation.get(temp+1));
                int t3=Integer.parseInt(equation.get(temp+2));
                int t4=t1*t3+t2;//将"'"前的数字乘以分母后与分子相加
                equation.remove(temp+1); equation.remove(temp);
                equation.set(temp-1,String.valueOf(t4));
            }
        }
        int i=0;
        String n1= equation.get(i++);//提取两个分数的分子与分母
        String d1= equation.get(i++);
        i++;//跳过符号
        String n2= equation.get(i++);
        String d2= equation.get(i++);
        i++;
        return fractionCalculate(d1,n1,d2,n2,equation.get(i));
    }
}
