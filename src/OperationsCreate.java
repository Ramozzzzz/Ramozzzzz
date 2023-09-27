import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OperationsCreate {//算式生成类
    public static List<String> operationsCreate(int n, int r){
        Random random=new Random();
        List<String> op=new ArrayList<>();
        int t;
        String operation;
        String[] symbol ={" "," "," "};//一个算式最多包含三个符号
        for(int i=0;i<n;i++){
            t= random.nextInt(4);//根据随机数的结果选择生成何种算式
            if(t<2){//随机数结果小于2，生成只包含整数的算式
                for(int j=0;j<3;j++){
                    t= random.nextInt(3);//根据随机数结果生成符号
                    if(t==0)
                        symbol[j]="+";
                    else if(t==1)
                        symbol[j]="-";
                    else
                        symbol[j]="*";
                }
                t=random.nextInt(5);//根据随机数结果生成某种形式的算式
                if(t==0)
                    //生成包含两个数字一个符号的算式
                    operation = (random.nextInt(r)+1) + " " + symbol[0] + " " +
                            (random.nextInt(r)+1);
                else if(t==1)
                    //生成包含三个数字两个符号的算式
                    operation = (random.nextInt(r)+1) + " " + symbol[0] + " " +
                            (random.nextInt(r)+1) + " " + symbol[1] + " " + (random.nextInt(r)+1);
                else if(t==2)
                    //生成包含四个数字三个符号的算式
                    operation = (random.nextInt(r)+1) + " " + symbol[0] + " " +
                            (random.nextInt(r)+1) + " " + symbol[1] + " " + (random.nextInt(r)+1) + " " +
                            symbol[2] + " " + (random.nextInt(r)+1);
                else if(t==3)
                    //生成包含四个数字三个符号且后两个数字带有括号的算式
                    operation = (random.nextInt(r)+1) + " " + symbol[0] + " " +
                            (random.nextInt(r)+1) + " " + symbol[1] + " " + "( " + (random.nextInt(r)+1) + " " +
                            symbol[2] + " " + (random.nextInt(r)+1) + " )";
                else
                    //生成包含四个数字三个符号且前两个数字带有括号的算式
                    operation = "( " + (random.nextInt(r)+1) + " " + symbol[0] + " " +
                            (random.nextInt(r)+1) + " ) " + symbol[1] + " " + (random.nextInt(r)+1) + " " +
                            symbol[2] + " " + (random.nextInt(r)+1);
            }
            else{//生成只包含分数的算式
                symbol[0]="/"; symbol[2]="/";
                t=random.nextInt(3);
                switch (t){
                    case 0->symbol[1]="+";
                    case 1->symbol[1]="-";
                    case 2->symbol[1]="*";
                }
                t=random.nextInt(3);
                if(t>0)
                    //生成包含两个分数一个符号的算式
                    operation = (random.nextInt(r)+1) + " " + symbol[0] + " " +
                            (random.nextInt(r)+1) + " " + symbol[1] + " " + (random.nextInt(r)+1) + " " +
                        symbol[2] + " " + (random.nextInt(r)+1);
                else
                    //生成包含"'"、两个分数和一个符号的算式
                    operation = (random.nextInt(r)+1) + " " + symbol[0] + " " +
                            (random.nextInt(r)+1) + " " + symbol[1] + " " + (random.nextInt(r)+1) + " ' " +
                            (random.nextInt(r)+1)+ " " +  symbol[2] + " " + (random.nextInt(r)+1);

            }
            op.add(operation);
        }
        return op;
    }

}
