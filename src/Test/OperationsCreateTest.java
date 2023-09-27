package Test;

import Operations.OperationsCreate;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperationsCreateTest {

    @Test
    public void operationsCreate() {
        System.out.println(OperationsCreate.operationsCreate(1,5));
        System.out.println(OperationsCreate.operationsCreate(5,10));
        System.out.println(OperationsCreate.operationsCreate(10,20));
    }
}