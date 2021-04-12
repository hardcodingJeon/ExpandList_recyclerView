package com.bnctech.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by JSY on 2016-02-04.
 */
public class ExpandAdapter extends BaseExpandableListAdapter {
    private Context context;
    private int groupLayout = 0;
    private int chlidLayout = 0;
    private ArrayList<MainActivity.MyGroup> DataList;
    private LayoutInflater myinf = null;

    public ExpandAdapter(Context context,int groupLay,int chlidLay,ArrayList<MainActivity.MyGroup> DataList){
        this.context = context;
        this.groupLayout = groupLay;
        this.chlidLayout = chlidLay;
        this.DataList = DataList;
        this.myinf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if(convertView == null){
            convertView = myinf.inflate(this.groupLayout, parent, false);
        }
        TextView groupName = (TextView)convertView.findViewById(R.id.groupName);
        groupName.setText(DataList.get(groupPosition).groupName);

//        Animation ani = AnimationUtils.loadAnimation(context,R.anim.set);
//        convertView.setAnimation(ani);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if(convertView == null){
            convertView = myinf.inflate(this.chlidLayout, parent, false);
        }
        RecyclerView recyclerView = convertView.findViewById(R.id.recyclerView);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(context,DataList.get(groupPosition).items);
        LinearLayoutManager mManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mManager);
        recyclerView.setAdapter(recyclerAdapter);


        TextView childName = (TextView)convertView.findViewById(R.id.childName);
//        childName.setText(DataList.get(groupPosition).child.get(childPosition));

        //애니메이션
//        Animation ani = AnimationUtils.loadAnimation(context,R.anim.set);
//        convertView.setAnimation(ani);

        return convertView;
    }
    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
//        return DataList.get(groupPosition).child.get(childPosition);
        return DataList.get(groupPosition).items.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return childPosition;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // TODO Auto-generated method stub
//        return DataList.get(groupPosition).child.size();
        return DataList.get(groupPosition).items.size();
    }

    @Override
    public MainActivity.MyGroup getGroup(int groupPosition) {
        // TODO Auto-generated method stub
        return DataList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return DataList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        // TODO Auto-generated method stub
        return groupPosition;
    }

}
