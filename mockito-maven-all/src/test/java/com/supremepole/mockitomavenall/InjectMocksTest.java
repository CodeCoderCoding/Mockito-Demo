package com.supremepole.mockitomavenall;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class InjectMocksTest {

    @Mock
    private HttpService httpService;

    //如果使用@Mock则会产生空指针异常
    @InjectMocks
    private UseHttpService useHttpService;

    @Test
    public void injectMocksTest(){
        MockitoAnnotations.initMocks(this);
        when(httpService.queryStatus()).thenReturn(0);
        Assert.assertEquals("你好",useHttpService.hello());
    }
}
