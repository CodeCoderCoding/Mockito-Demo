package com.supremepole.mockitomavenall;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

public class VerifyTest {

    @Test
    public void verifyTest(){
        Random random= Mockito.mock(Random.class);
        random.nextInt();
        Mockito.verify(random).nextInt();
    }

    @Test
    public void verifyWithTimesTest(){
        Random random= Mockito.mock(Random.class);
        random.nextInt();
        Mockito.verify(random, Mockito.times(1)).nextInt();
    }

}
