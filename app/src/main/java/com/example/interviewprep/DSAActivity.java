package com.example.interviewprep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DSAActivity extends AppCompatActivity {
    private ExpandableListView listView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHashMap;
    private ExpandableListAdapter listAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsaactivity);
listView=findViewById(R.id.lvDSA);
        // Prepare the list data
        initializeData();

        // Set the custom adapter
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHashMap);
        listView.setAdapter(listAdapter);
    }

    private void initializeData() {
        listDataHeader = new ArrayList<>();
        listHashMap= new HashMap<>();

        // Adding headers (languages)
        listDataHeader.add("Graph");
        listDataHeader.add("Array");
        listDataHeader.add("Linked List");
        listDataHeader.add("Binary Tree");
        listDataHeader.add("Hashing");
        listDataHeader.add("Advanced Data Structure");
        listDataHeader.add("String");

        // Adding child data (subtopics)
        List<String> graphSubtopics = new ArrayList<>();
        graphSubtopics.add("Introduction , DFS, BFS");
        graphSubtopics.add("Graph Cycle");
        graphSubtopics.add("Topological Sorting");
        graphSubtopics.add("Minimum spanning tree");
        graphSubtopics.add("Backtracking");
        graphSubtopics.add("Shortest Path");
        graphSubtopics.add("Connectivity");
        graphSubtopics.add("HardProblems");
        graphSubtopics.add("STL");

        List<String> ArraySubtopics = new ArrayList<>();
        ArraySubtopics.add("Array Rotation");
        ArraySubtopics.add("Arrangement Rearrangement");
        ArraySubtopics.add("Order Statictis");
        ArraySubtopics.add("Range Queries");
        ArraySubtopics.add("Searching and Sorting");
        ArraySubtopics.add("Optimization Problems");
        ArraySubtopics.add("Matrix");


        List<String> LLSubtopics = new ArrayList<>();
        LLSubtopics.add("Singly Linked List");
        LLSubtopics.add("Doubly Linked List");
        LLSubtopics.add("Circular Linked List");


        List<String> BTSubtopics = new ArrayList<>();
        BTSubtopics.add("Introduction");
        BTSubtopics.add("Traversal");
        BTSubtopics.add("Construction and Conversion");


        List<String> HashSubtopics = new ArrayList<>();
        HashSubtopics.add("Basics");
        HashSubtopics.add("Easy");
        HashSubtopics.add("Intermediate");
        HashSubtopics.add("Hard");

        List<String> ADSSubtopics = new ArrayList<>();
        ADSSubtopics.add("Advanced List");
        ADSSubtopics.add("Segment Tree");
        ADSSubtopics.add("Binary Indexed Tree");
        ADSSubtopics.add("Suffix Array and Tree");
        ADSSubtopics.add("Self-Balancing BSTs");
        ADSSubtopics.add("K-Dimensional Tree");
        ADSSubtopics.add("n-ary Tree");

        List<String> StringsSubtopics = new ArrayList<>();
        StringsSubtopics.add("Basics");
        StringsSubtopics.add("Palindrome");
        StringsSubtopics.add("Binary String");
        StringsSubtopics.add("Subsequence");
        StringsSubtopics.add("Pattern Searching");


        // Map headers to their subtopics
        listHashMap.put(listDataHeader.get(0), graphSubtopics);
        listHashMap.put(listDataHeader.get(1), ArraySubtopics);
        listHashMap.put(listDataHeader.get(2), LLSubtopics);
        listHashMap.put(listDataHeader.get(3), BTSubtopics);
        listHashMap.put(listDataHeader.get(4), HashSubtopics);
        listHashMap.put(listDataHeader.get(5), ADSSubtopics);
        listHashMap.put(listDataHeader.get(6), StringsSubtopics);

    }
}
