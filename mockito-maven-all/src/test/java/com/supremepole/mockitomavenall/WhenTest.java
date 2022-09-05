package com.supremepole.mockitomavenall;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WhenTest {

    @Test
    public void returnTest() {
        Random random = Mockito.mock(Random.class);
        Mockito.when(random.nextInt()).thenReturn(100);
        assertEquals(100, random.nextInt());
    }

    @Test
    public void throwTest() {
        Random random = Mockito.mock(Random.class);
        Mockito.when(random.nextInt()).thenThrow(new RuntimeException("Exception"));
        try{

        }catch(Exception ex){
            assertTrue(ex instanceof RuntimeException);
            assertEquals("Exception", ex.getMessage());
        }
    }

}
