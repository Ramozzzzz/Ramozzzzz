package Operations;

import java.util.*;

public class PostfixExpression {

    private static int getPriority(String str) {//获得符号的优先级，数字越大优先级越高
        return switch (str) {
            case "+", "-" -> 1;
            case "*" -> 2;
            case "/" -> 3;
            case "'" -> 4;
            default -> 0;
        };
    }

    private static List<String> toList(String str) {//将字符串转成List
        List<String> s1 = new ArrayList<>();
        String[] s2=str.split(" ");
        Collections.addAll(s1,s2);
        return s1;
    }

    public static boolean isOperator(String str) {//判断字符串是否为计算符号
        return str.compareTo("+") == 0 || str.compareTo("-") == 0
                || str.compareTo("*") == 0 || str.compareTo("/") == 0 ||
                str.compareTo("(") == 0 || str.compareTo(")") == 0;
    }

    public static List<String> postfixChange(String fix){//中缀表达式转后缀表达式
        Stack<String> s1=new Stack<>();
        List<String> s2=new ArrayList<>();
        List<String> infix=toList(fix);
        int size=infix.size();
        int priority;
        int i=0;
        while(i<size){
            if(isOperator(infix.get(i))){//如果该元素不是数字
                if(infix.get(i).compareTo("(")==0){//左括号无条件入栈s1
                    s1.push(infix.get(i));
                    i++;
                    continue;
                }
                else if(infix.get(i).compareTo(")")==0){
                    while(s1.peek().compareTo("(")!=0){//当碰见右括号时依次让s1栈顶的元素出栈并加入到s2，直到栈顶元素为左括号
                        s2.add(s1.pop());
                    }
                    if(Objects.equals(s1.peek(), "("))//左括号出栈
                        s1.pop();
                    i++;
                    continue;
                }
                priority=getPriority(infix.get(i));//若不是左括号，则计算该符号的优先级
                if(s1.isEmpty() || priority > getPriority(s1.peek())){//若栈空或优先级高于栈顶元素优先级，则直接入栈
                    s1.push(infix.get(i));
                }
                else{
                    while (!s1.isEmpty() && priority <= getPriority(s1.peek()))
                    {
                        s2.add(s1.pop());//若优先级小于栈顶则栈顶出栈并加入s2，直到优先级大于栈顶或栈空
                    }
                    s1.push(infix.get(i));
                }
            }
            else{
                s2.add(infix.get(i));//若为数字则加入s2
            }
            i++;
        }
        while (!s1.isEmpty()) {//将s1剩余元素加入到s2
            s2.add(s1.pop());
        }
        return s2;
    }

}
