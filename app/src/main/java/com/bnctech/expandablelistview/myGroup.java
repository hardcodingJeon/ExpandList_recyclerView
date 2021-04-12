package com.bnctech.expandablelistview;

import java.util.ArrayList;
public class myGroup {
    public String groupName;
//    public ArrayList<String> child;
//    myGroup(String name){
//        groupName = name;
//        child = new ArrayList<String>();
//    }

    public ArrayList<ChildItem> items;
    myGroup(String groupName){
        this.groupName = groupName;
        items = new ArrayList<>();
    }


}

