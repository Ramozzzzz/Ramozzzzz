package test;

import com.Words.txtOperation;
import org.junit.Test;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class txtOperationTest extends txtOperation {

    @Test
    public void read() throws IOException {
        //正常读取
        List<String> t1=Read("F:\\program\\c\\software\\txt\\1.txt");
        System.out.println(t1);
        //读取不存在的文件
        List<String> t2=Read("F:\\program\\c\\software\\txt\\111.txt");
        //读取错误格式的文件
        List<String> t3=Read("F:\\program\\c\\software\\txt\\");
    }

    @Test
    public void write() throws IOException {
        Write("F:\\program\\c\\software\\txt\\3.txt",(float)1.11);
    }

    @Test
    public void counter() {
        List<String> t1=new ArrayList<>();
        t1.add("aa");    t1.add("aa");    t1.add("ab");    t1.add("bb");
        List<String> t2=new ArrayList<>();
        t2.add("aa");    t1.add("a");    t1.add("ab");    t1.add("bb");
        int[] a=Counter(t1,t2);
        System.out.println(Arrays.toString(a));
    }
}