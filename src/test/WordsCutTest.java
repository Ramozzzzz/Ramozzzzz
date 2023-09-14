package test;

import com.Words.WordsCut;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WordsCutTest extends WordsCut {

    @Test
    public void testSplitWords() {
        String t="这是一个用于测试中文分词函数的语句。";
        System.out.println(splitWords(t));
        t="This is a test aim to test the SplitWords Function of English.";
        System.out.println(splitWords(t));
    }

    @Test
    public void testmerge() {
        String t1="这是第一个字符串";
        List<String>s1=splitWords(t1);
        String t2="This is the second string";
        List<String>s2=splitWords(t2);
        System.out.println(Merge(s1,s2));
    }
}