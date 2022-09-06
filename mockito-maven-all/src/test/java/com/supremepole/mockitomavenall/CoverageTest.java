package com.supremepole.mockitomavenall;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CoverageTest {

    /**
     * 运行该方法，calculator的add未被覆盖测试
     */
    @Test
    public void coverageVerifyTest(){
        Calculator calculator= Mockito.mock(Calculator.class);
        calculator.add(1, 2);
        verify(calculator).add(1, 2);
    }

    /**
     * 运行该方法，calculator的add被覆盖测试
     */
    @Test
    public void coverageAssertTest(){
        Calculator calculator= Mockito.mock(Calculator.class);
        when(calculator.add(1, 2)).thenReturn(3);
        assertEquals(3, calculator.add(1, 2));
    }

}
