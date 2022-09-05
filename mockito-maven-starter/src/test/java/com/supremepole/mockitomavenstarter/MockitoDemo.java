package com.supremepole.mockitomavenstarter;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

public class MockitoDemo {

    @Test
    public void randomTest(){
        Random random= Mockito.mock(Random.class);
        System.out.println(random.nextInt());
    }
    
}
