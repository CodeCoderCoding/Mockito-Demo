package com.supremepole.mockitomavenall;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArgumentTest {

    @Test
    public void argumentTest(){
        List mockList = mock(List.class);
        //没有指定 size() 方法返回值，这里结果是默认值
        Assert.assertEquals(0, mockList.size());
        //没有指定 get(0) 返回值，这里结果是默认值
        Assert.assertNull(mockList.get(0));

        //调用 mock 对象的写方法，是没有效果的
        mockList.add("a");
        // 没有指定 size() 方法返回值，这里结果是默认值
        Assert.assertEquals(0, mockList.size());

        when(mockList.get(0)).thenReturn("a");
        when(mockList.get(1)).thenReturn("b");
        Assert.assertEquals("a", mockList.get(0));
        Assert.assertEquals("b", mockList.get(1));
    }

}
