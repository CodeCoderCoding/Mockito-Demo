package com.supremepole.mockitomavenall;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

public class ListMockTest {

    @InjectMocks
    private ListMock listMock;
    @Mock
    private ListUtil listUtil;

    @Mock
    private ArrayList<String> arrayList;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        listMock.setListUtil(listUtil);
    }

    @Test
    public void testList1() {
        //arrayList.add("s1");
        Mockito.when(listUtil.getList()).thenReturn(arrayList);
        Assert.assertFalse(listMock.testList());
    }

    @Test
    public void testList2() {

        ArrayList<String> arrayList1=new ArrayList<>();
        arrayList.add("s1");
        Mockito.when(arrayList1.isEmpty()).thenReturn(false);
        Mockito.when(listUtil.getList()).thenReturn(arrayList1);
        listMock.testList();
    }

}