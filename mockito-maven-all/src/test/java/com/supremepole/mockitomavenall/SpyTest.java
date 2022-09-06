package com.supremepole.mockitomavenall;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class SpyTest {

    @Spy
    private Calculator calculator;

    @Test
    public void spyTest() {
        Calculator calculator=spy(new Calculator());
        int res = calculator.add(1, 2);
        assertEquals(3, res);
    }

    @Test
    public void spyAnnotationTest() {
        //没有下面这一行，将会产生空指针异常
        MockitoAnnotations.initMocks(this);
        int res = calculator.add(1, 2);
        assertEquals(3, res);
    }

    @Test
    public void spyWhenTest() {
        Calculator calculator=spy(new Calculator());
        //对于spy方法，默认走真实方法
        assertEquals(3, calculator.add(1, 2));
        //打桩之后，走打桩方法
        when(calculator.add(1,2)).thenReturn(10);
        assertEquals(10, calculator.add(1, 2));
        //与打桩参数值不匹配，走真实方法
        assertEquals(3, calculator.add(2, 1));
    }

    @Test
    public void spyVSMockTest(){
        Calculator calculator= Mockito.mock(Calculator.class);
        //对于mock方法，默认走mock对象方法，因为没对其行为进行定义，mock对象方法的返回值为返回类型的默认值
        assertEquals(0, calculator.add(1, 2));
        //对其行为进行定义，即打桩，则走mock对象方法
        when(calculator.add(1, 2)).thenReturn(10);
        assertEquals(10, calculator.add(1, 2));
        //与打桩参数值不匹配，则相当于a=2,b=1的行为未定义，mock对象方法的返回值为返回类型的默认值
        assertEquals(0, calculator.add(2, 1));
    }

}
