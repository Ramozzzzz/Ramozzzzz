package Operations;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Operations.Calculator.*;
import static Operations.OperationsCreate.*;
import static Operations.PostfixExpression.*;
import static Operations.txtOperation.*;

public class main {
    public static void main(String[] args) throws IOException {
        int n ,r;
        String pathe,patha=" ";
        List<String> commands = new ArrayList<>(Arrays.asList(args));
        List<String> answers=new ArrayList<>();
        List<String> op=new ArrayList<>();
        if(commands.contains("-n") && commands.contains("-r")){//分析命令行参数
            n=Integer.parseInt(commands.get(commands.indexOf("-n")+1));
            r=Integer.parseInt(commands.get(commands.indexOf("-r")+1));
            op=operationsCreate(n, r);
        }
        if(commands.contains("-e") && commands.contains("-a")){
            pathe=commands.get(commands.indexOf("-e")+1);
            patha=commands.get(commands.indexOf("-a")+1);
            op=Read(pathe);
        }
        String str;
        for (String s : op) {//计算
            str = s;
            if (str.contains("/"))
                answers.add(fractionCalculator(postfixChange(str)));
            else
                answers.add(String.valueOf(integerCalculator(postfixChange(str))));
        }
        if(commands.contains("-e") || commands.contains("-a")){
            answersMatch(answers,patha);
        }
        else{//写入文件
            writeOperations(op);
            writeAnswers(answers);
        }
        System.out.println("操作完成");
    }
}
