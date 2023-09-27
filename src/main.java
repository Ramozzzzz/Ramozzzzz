import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        int n = 0,r = 0;
        String pathe=" ",patha=" ";
        List<String> commands = new ArrayList<>(Arrays.asList(args));
        List<String> answers=new ArrayList<>();
        List<String> op=new ArrayList<>();
        if(commands.contains("-n") && commands.contains("-r")){
            n=Integer.parseInt(commands.get(commands.indexOf("-n")+1));
            r=Integer.parseInt(commands.get(commands.indexOf("-r")+1));
            op=OperationsCreate.operationsCreate(n, r);
        }
        if(commands.contains("-e") && commands.contains("-a")){
            pathe=commands.get(commands.indexOf("-e")+1);
            patha=commands.get(commands.indexOf("-a")+1);
            op=txtOperation.Read(pathe);
        }
        String str=" ";
        for(int i=0;i< op.size();i++){
            str=op.get(i);
            if(str.contains("/"))
                answers.add(String.valueOf(Calculator.fractionCalculator(PostfixExpression.postfixChange(str))));
            else
                answers.add(String.valueOf(Calculator.integerCalculator(PostfixExpression.postfixChange(str))));
        }
        if(commands.contains("-e") || commands.contains("-a")){
            txtOperation.answersMatch(answers,patha);
        }
        else{
            txtOperation.writeOperations(op);
            txtOperation.writeAnswers(answers);
        }
    }
}
