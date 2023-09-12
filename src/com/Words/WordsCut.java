package com.Words;

import com.hankcs.hanlp.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class WordsCut {
    static List<String> splitWords(String s1){
        Stream<String> s2=HanLP.segment(s1).stream().map(str->str.word);
        return s2.filter(s->!"`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？ "
                .contains(s)).toList();
    }
}
