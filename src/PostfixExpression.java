
import java.util.*;

public class PostfixExpression {

    public static int getPriority(String str) {
        return switch (str) {
            case "+", "-" -> 1;
            case "*" -> 2;
            case "/" -> 3;
            case "'" -> 4;
            default -> 0;
        };
    }

    public static List<String> toList(String str) {
        List<String> s1 = new ArrayList<>();
        String[] s2=str.split(" ");
        Collections.addAll(s1,s2);
        return s1;
    }

    public static boolean isOperator(String str) {
        return str.compareTo("+") == 0 || str.compareTo("-") == 0
                || str.compareTo("*") == 0 || str.compareTo("/") == 0 ||
                str.compareTo("(") == 0 || str.compareTo(")") == 0;
    }

    public static List<String> postfixChange(String fix){
        Stack<String> s1=new Stack<>();
        List<String> s2=new ArrayList<>();
        List<String> infix=toList(fix);
        int size=infix.size();
        int priority;
        int i=0;
        while(i<size){
            if(isOperator(infix.get(i))){
                if(infix.get(i).compareTo("(")==0){
                    s1.push(infix.get(i));
                    i++;
                    continue;
                }
                else if(infix.get(i).compareTo(")")==0){
                    while(s1.peek().compareTo("(")!=0){
                        s2.add(s1.pop());
                    }
                    if(Objects.equals(s1.peek(), "("))
                        s1.pop();
                    if(!s1.isEmpty())
                        s2.add(s1.pop());
                    i++;
                    continue;
                }
                priority=getPriority(infix.get(i));
                if(s1.isEmpty() || priority > getPriority(s1.peek())){
                    s1.push(infix.get(i));
                }
                else{
                    while (!s1.isEmpty() && priority <= getPriority(s1.peek()))
                    {
                        s2.add(s1.pop());
                    }
                    s1.push(infix.get(i));
                }
            }
            else{
                s2.add(infix.get(i));
            }
            i++;
        }
        while (!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        return s2;
    }

}
