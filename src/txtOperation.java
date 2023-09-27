import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class txtOperation {
    public static List<String> Read(String path) throws IOException {
        List<String> article = new ArrayList<>();
        try {
            //打开path路径的文件
            File read = new File(path);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(read));
            BufferedReader r = new BufferedReader(reader);
            String line = r.readLine();
            String str1;
            //循环读取每一行的文字并加入到表中
            while (line != null) {
                str1=line.substring(0,line.indexOf("."));
                line = line.substring(str1.length()+3);
                article.add(line);
                line = r.readLine();
            }
        } catch (IOException e) {
            System.out.println("文件打开失败，请检查文件路径是否正确");
        }
        return article;
    }



    public static void writeOperations(List<String> operations) throws IOException {
        FileWriter write=new FileWriter("Operations.txt");//结果保存在相应的txt文件
        //将结果写入到当前目录中
        int size=operations.size();
        for(int i=0;i<size;i++){
            write.write((i+1) + ".  ");
            write.write(operations.get(i) + "\n");

        }
        write.flush();
        write.close();
    }

    public static void writeAnswers(List<String> answers) throws IOException {
        FileWriter write=new FileWriter("Answer.txt");
        //将结果写入到当前目录中
        int size=answers.size();
        for(int i=0;i<size;i++){
            write.write((i+1) + ".  ");
            write.write(answers.get(i) + "\n");
        }
        write.flush();
        write.close();
    }

    public static void writeGrade(int[] id,int length) throws IOException {
        FileWriter write=new FileWriter("Grade.txt");
        //将结果写入到当前目录中
        int size= id.length;
        String[] temp1=new String[size];
        write.write("Wrong: " + size + "(");
        for(int i=0;i<size;i++){
            temp1[i]=id[i]+", ";
        }
        if (size != 0) {
            temp1[size-1]=temp1[size-1].substring(0,temp1[size-1].length()-2);
            for(int i=0;i<size;i++){
                write.write(temp1[i]);
            }
        }
        write.write(")" + "\n");
        int t=length-size;
        String[] temp2=new String[t];
        boolean flag=false;
        write.write("Correct: " + t + "(");
        int p=0;
        for(int i=1;i<=length;i++){
            for (int k : id) {
                if (i == k) {
                    flag = true;
                    break;
                }
            }
            if(!flag)
                temp2[p++]=i + ", ";
            flag=false;
        }
        if(t!=0){
            temp2[t-1]=temp2[t-1].substring(0,temp2[t-1].length()-2);
            for(int i=0;i<t;i++){
                write.write(temp2[i]);
            }
        }
        write.write(")");
        write.flush();
        write.close();
    }

    public static void answersMatch(List<String> answers,String path) throws IOException {
        List<String> str=Read(path);
        List<String> difference = str.stream()
                .filter(element -> !answers.contains(element))
                .toList();
        int num=difference.size();
        int[] id =new int[num];
        for(int i=0;i<num;i++){
            String s=difference.get(i);
            id[i]= str.indexOf(s)+1;
        }
        writeGrade(id,str.size());
    }


}

