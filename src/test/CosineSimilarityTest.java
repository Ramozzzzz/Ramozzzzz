package test;

import com.Words.CosineSimilarity;
import org.junit.Test;

import static org.junit.Assert.*;

public class CosineSimilarityTest extends CosineSimilarity {

    @Test
    public void testGetSimilarity() {
        //计算余弦值并返回
        int t1[]={1,0};
        int t2[]={1,0};
        System.out.println(getSimilarity(t1,t2));
        int t3[]={1,0};
        int t4[]={0,1};
        System.out.println(getSimilarity(t3,t4));
        int t5[]={1,1};
        int t6[]={2,3};
        System.out.println(getSimilarity(t5,t6));
        int t7[]={1,5,5};
        int t8[]={1,6,2};
        System.out.println(getSimilarity(t7,t8));
        int t9[]={7,2,8,9};
        int t0[]={1,0,5,6};
        System.out.println(getSimilarity(t9,t0));
    }
}