package com.supremepole.mockitomavenall;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Random;

public class MockTest {

    @Mock
    private Random random;

    @Test
    public void randomMethodTest(){
        Random random= Mockito.mock(Random.class);
        System.out.println(random.nextInt());
    }

    @Test
    public void randomAnnotationTest(){
        MockitoAnnotations.initMocks(this);
        System.out.println(random.nextInt());
    }

}
