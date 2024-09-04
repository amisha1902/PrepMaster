package com.example.interviewprep;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

     Context context;
     List<String> listDataHeader; // Header titles
    HashMap<String, List<String>> listHashMap; // Child data in format of header title, child title

    public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listHashMap) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listHashMap= listHashMap;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listHashMap.get(this.listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
         String childText = (String)getChild(groupPosition, childPosition);
         View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
         TextView textChild=view.findViewById(R.id.lv_list_item);
         textChild.setText(childText);
         return  view;

    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listHashMap.get(this.listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition)
    {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount()
    {
        return this.listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition)
    {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String)getGroup(groupPosition);
        View view = LayoutInflater.from(context).inflate(R.layout.list_group, parent,false);
        TextView lv_list_header= view.findViewById(R.id.lv_list_group);
        lv_list_header.setTypeface(null, Typeface.BOLD);
        lv_list_header.setText(headerTitle);
        return view;
    }

    @Override
    public boolean hasStableIds()
    {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
