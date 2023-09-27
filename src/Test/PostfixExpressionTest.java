package Test;

import org.junit.Test;
import Operations.*;

import static org.junit.Assert.*;

public class PostfixExpressionTest {

    @Test
    public void isOperator() {
        if(PostfixExpression.isOperator("+"))
            System.out.println("该符号是计算符号");
        if(PostfixExpression.isOperator("-"))
            System.out.println("该符号是计算符号");
        if(PostfixExpression.isOperator("*"))
            System.out.println("该符号是计算符号");
        if(PostfixExpression.isOperator("/"))
            System.out.println("该符号是计算符号");
        if(!PostfixExpression.isOperator("3"))
            System.out.println("该符号不是计算符号");
        if(!PostfixExpression.isOperator("111"))
            System.out.println("该符号不是计算符号");
        if(!PostfixExpression.isOperator("ra"))
            System.out.println("该符号不是计算符号");
    }

    @Test
    public void postfixChange() {
        System.out.println(PostfixExpression.postfixChange("1 + 2 * 9"));
        System.out.println(PostfixExpression.postfixChange("( 1 + 2 ) * 9"));
        System.out.println(PostfixExpression.postfixChange("4 * 2 * 9"));
        System.out.println(PostfixExpression.postfixChange("5 - 2 * 9"));
        System.out.println(PostfixExpression.postfixChange("( 5 - 2 ) * 9"));
        System.out.println(PostfixExpression.postfixChange("1 / 5 + 2 / 5"));
        System.out.println(PostfixExpression.postfixChange("4 / 5 - 2 / 5 * 3 / 5"));
        System.out.println(PostfixExpression.postfixChange("( 4 / 5 - 2 / 5 ) * 3 / 5"));
    }
}