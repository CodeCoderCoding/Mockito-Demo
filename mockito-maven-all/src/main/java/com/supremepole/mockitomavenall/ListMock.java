package com.supremepole.mockitomavenall;

import java.util.List;

/**
 * @ClassName ArrayListMock
 * @Description
 * @Date 2022/9/21 17:33
 * @Version 1.0.0
 **/
public class ListMock {

    private ListUtil listUtil;

    public boolean testList(){
        List<String> list= listUtil.getList();
        if(list.size()==0){
            return true;
        }
        return false;
    }

    public ListUtil getListUtil() {
        return listUtil;
    }

    public void setListUtil(ListUtil listUtil) {
        this.listUtil = listUtil;
    }
}
