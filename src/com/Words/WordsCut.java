package com.Words;

import com.hankcs.hanlp.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class WordsCut {
    public static List<String> splitWords(String s1){
        Stream<String> s2=HanLP.segment(s1).stream().map(str->str.word);
        return s2.filter(s->!"`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？ "
                .contains(s)).toList();
    }

    public static List<String> Merge(List<String> s1, List<String> s2){
        List<String> str1=new ArrayList<>();
        List<String> str2=new ArrayList<>();
        str1.addAll(s1);
        str1.addAll(s2);
        str2=str1.stream().distinct().collect(Collectors.toList());
        return str2;
    }
}
