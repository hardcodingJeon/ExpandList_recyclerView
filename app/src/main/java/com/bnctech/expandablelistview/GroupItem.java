package com.bnctech.expandablelistview;

import java.util.ArrayList;
public class GroupItem {
    public String groupTitle;
    public ArrayList<ChildItem> childItems = new ArrayList<>();

    public GroupItem(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public static class ChildItem {
        String beforePrice;
        String afterPrice;

        public ChildItem(String beforePrice, String afterPrice) {
            this.beforePrice = beforePrice;
            this.afterPrice = afterPrice;
        }
    }




}

