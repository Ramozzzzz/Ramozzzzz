package com.Words;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static com.Words.WordsCut.*;

public class txtOperation {
    public static List<String> Read(String path) throws IOException {
        List<String> article=new ArrayList<String>();
        File read=new File(path);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(read));
        BufferedReader r = new BufferedReader(reader);
        String line=r.readLine();
        while(line!=null){
            article.add(line);
            line=r.readLine();
        }
        return article;
    }

    public static void Write(String path,float result) throws IOException {
        FileWriter write=new FileWriter(path);
        write.write(String.valueOf(result));
        write.flush();
        write.close();
    }

    public static int[] Counter(List<String> split_article,List<String> merge){
        int number[]=new int[merge.size()];
        for(int i=0;i< merge.size();i++){
            number[i]=Collections.frequency(split_article, merge.get(i));
        }
        return number;
    }


}
