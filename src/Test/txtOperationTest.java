package Test;

import Operations.txtOperation;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class txtOperationTest {

    @Test
    public void read() throws IOException {
        List<String> t1= txtOperation.Read("F:\\program\\c\\software\\txt\\1.txt");
        System.out.println(t1);
        //读取不存在的文件
        List<String> t2=txtOperation.Read("F:\\program\\c\\software\\txt\\111.txt");
        //读取错误格式的文件
        List<String> t3=txtOperation.Read("F:\\program\\c\\software\\txt\\");
    }

    @Test
    public void writeOperations() throws IOException {
        List<String> op= List.of(new String[]{"1", "2", "3"});
        txtOperation.writeOperations(op);
    }

    @Test
    public void writeAnswers() throws IOException {
        List<String> answer= List.of(new String[]{"4", "5", "6"});
        txtOperation.writeOperations(answer);
    }

    @Test
    public void answersMatch() throws IOException {
        List<String> answer= List.of(new String[]{"1.  4", "2.  5", "3.  6"});
        txtOperation.answersMatch(answer,"F:\\program\\Java\\ideaWorkplace\\Operations\\1.txt");
    }
}