package com.supremepole.mockitomavenall;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class WhenTest {

    @Test
    public void returnTest() {
        Random random = Mockito.mock(Random.class);
        when(random.nextInt()).thenReturn(100);
        assertEquals(100, random.nextInt());
    }

    @Test
    public void throwTest() {
        Random random = Mockito.mock(Random.class);
        when(random.nextInt()).thenThrow(new RuntimeException("Exception"));
        try{

        }catch(Exception ex){
            assertTrue(ex instanceof RuntimeException);
            assertEquals("Exception", ex.getMessage());
        }
    }

    @Test
    public void answerTest(){
        Calculator calculator=Mockito.mock(Calculator.class);
        when(calculator.add(anyInt(),anyInt())).thenAnswer((new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                // 获取参数
                Integer a = (Integer) args[0];
                Integer b = (Integer) args[1];

                // 根据第1个参数，返回不同的值
                if (a == 1) {
                    return 9;
                }
                if (a == 2) {
                    return 99;
                }
                if (a == 3) {
                    throw new RuntimeException("异常");
                }
                return 999;
            }
        }));

        Assert.assertEquals(9, calculator.add(1, 100));
        Assert.assertEquals(99, calculator.add(2, 100));

        try {
            calculator.add(3, 100);
            Assert.fail();
        } catch (RuntimeException ex) {
            Assert.assertEquals("异常", ex.getMessage());
        }
    }

}
