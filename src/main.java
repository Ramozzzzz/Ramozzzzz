import org.w3c.dom.css.Counter;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.Words.WordsCut.*;
import static com.Words.txtOperation.*;
import static com.Words.CosineSimilarity.*;

public class main {
    public static void main(String[] args) throws IOException {
        String path1= "";
        String path2= "";
        String path3= "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入论文原文的文件的绝对路径");
        path1=scanner.next();
        System.out.println("请输入抄袭版论文的文件的绝对路径");
        path2=scanner.next();
        System.out.println("输出的答案文件的绝对路径");
        path3=scanner.next();
        List<String> article1=Read(path1);
        List<String> article2=Read(path2);
        List<String> article3=new ArrayList<>();
        article1=splitWords(article1.toString());
        article2=splitWords(article2.toString());
        article3=Merge(article1,article2);
        int[] n1 = Counter(article1,article3);
        int[] n2 = Counter(article2,article3);
        System.out.println(getSimilarity(n1,n2));
        Write(path3,getSimilarity(n1,n2));
    }


}
