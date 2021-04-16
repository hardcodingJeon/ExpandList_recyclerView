package com.bnctech.expandablelistview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
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

        ArrayList<GroupItem> DataList = new ArrayList<>();
        listView = (ExpandableListView)findViewById(R.id.mylist);

        for (int i=1;i<25;i++) {
            GroupItem temp = new GroupItem("A"+i);
            temp.childItems.add(new GroupItem.ChildItem("1","2"));
            temp.childItems.add(new GroupItem.ChildItem("2","3"));
            temp.childItems.add(new GroupItem.ChildItem("4","5"));
            DataList.add(temp);
        }



        ExpandAdapter adapter = new ExpandAdapter(getApplicationContext(), R.layout.group_row, R.layout.activity_child, DataList);
        listView.setIndicatorBounds(width - 50, width); //이 코드를 지우면 화살표 위치가 바뀐다.
        listView.setAdapter(adapter);

    }

}

