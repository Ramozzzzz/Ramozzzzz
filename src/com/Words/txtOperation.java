package com.Words;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static com.Words.WordsCut.*;

class txtOperation {
    private static List<String> Read(String path) throws IOException {
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



    public static void main(String[] args) throws IOException {
//        String path="F:\\program\\c\\software\\txt\\orig.txt";
//        System.out.println(splitWords(String.valueOf(Read(path))));

    }
}
