package com.supremepole.mockitomavenall;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class StaticTest {



    @Test
    public void testStatic(){
        try(MockedStatic<StaticUtils> staticUtilsMockedStatic= Mockito.mockStatic(StaticUtils.class)){
            staticUtilsMockedStatic.when(StaticUtils::name).thenReturn("123");
            System.out.println(StaticUtils.name());
        }
    }

}
