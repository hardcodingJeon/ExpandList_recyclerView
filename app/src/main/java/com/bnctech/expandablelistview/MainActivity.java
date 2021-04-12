package com.bnctech.expandablelistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ExpandableListView;
import java.util.ArrayList;

public class MainActivity extends Activity {
    private ExpandableListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Display newDisplay = getWindowManager().getDefaultDisplay();
        int width = newDisplay.getWidth();

//        ArrayList<myGroup> DataList = new ArrayList<myGroup>();
        ArrayList<MyGroup> DataList = new ArrayList<>();
        listView = (ExpandableListView)findViewById(R.id.mylist);
        MyGroup temp = new MyGroup("A");
//        temp.child.add("ㄱ");
//        temp.child.add("ㄴ");
//        temp.child.add("ㄷ");
        temp.items.add(new ChildItem("1","2"));
//        temp.items.add(new ChildItem("3","4"));
//        temp.items.add(new ChildItem("5","6"));
        DataList.add(temp);
        temp = new MyGroup("B");
//        temp.child.add("a");
//        temp.child.add("b");
//        temp.child.add("c");
        temp.items.add(new ChildItem("7","8"));
        temp.items.add(new ChildItem("9","10"));
//        temp.items.add(new ChildItem("11","12"));
        DataList.add(temp);
        temp = new MyGroup("C");
//        temp.child.add("1");
//        temp.child.add("2");
//        temp.child.add("3");
        temp.items.add(new ChildItem("13","14"));
        temp.items.add(new ChildItem("15","16"));
        temp.items.add(new ChildItem("17","18"));
        DataList.add(temp);

//        ExpandAdapter adapter = new ExpandAdapter(getApplicationContext(),R.layout.group_row,R.layout.child_row,DataList);
        ExpandAdapter adapter = new ExpandAdapter(getApplicationContext(), R.layout.group_row, R.layout.activity_child, DataList);
        listView.setIndicatorBounds(width - 50, width); //이 코드를 지우면 화살표 위치가 바뀐다.
        listView.setAdapter(adapter);
    }

    public class MyGroup {
        public String groupName;
//    public ArrayList<String> child;
//    myGroup(String name){
//        groupName = name;
//        child = new ArrayList<String>();
//    }

        public ArrayList<String> num;

        public ArrayList<ChildItem> items;
        MyGroup(String groupName){
            this.groupName = groupName;
            items = new ArrayList<>();
        }
    }
}

