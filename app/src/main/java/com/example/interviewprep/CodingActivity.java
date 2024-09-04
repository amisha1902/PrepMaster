package com.example.interviewprep;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CodingActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHashMap;
    private ExpandableListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coding);
        listView = findViewById(R.id.exp_list_view);

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
        listDataHeader.add("C");
        listDataHeader.add("C++");
        listDataHeader.add("JAVA");
        listDataHeader.add("Python");
        listDataHeader.add("SQL");

        // Adding child data (subtopics)
        List<String> cSubtopics = new ArrayList<>();
        cSubtopics.add("Data Types");
        cSubtopics.add("Storage Classes");
        cSubtopics.add("Operators");
        cSubtopics.add("Input/Output");
        cSubtopics.add("Control Structures");
        cSubtopics.add("Arrays & Strings");
        cSubtopics.add("Functions");
        cSubtopics.add("Pointers");
        cSubtopics.add("Memory Management");
        cSubtopics.add("File Handling");

        List<String> cppSubtopics = new ArrayList<>();
        cppSubtopics.add("C vs C++");
        cppSubtopics.add("C++ vs Java");
        cppSubtopics.add("Input/Output");
        cppSubtopics.add("Operators");
        cppSubtopics.add("Arrays & Strings");
        cppSubtopics.add("Functions");
        cppSubtopics.add("Pointers");
        cppSubtopics.add("Constructor & Destructor");
        cppSubtopics.add("Function Overloading");
        cppSubtopics.add("Operator Overloading");
        cppSubtopics.add("Exception Handling");
        cppSubtopics.add("C++ Library");

        List<String> javaSubtopics = new ArrayList<>();
        javaSubtopics.add("OOP Concepts");
        javaSubtopics.add("Operators");
        javaSubtopics.add("Input/Output");
        javaSubtopics.add("Arrays & Strings");
        javaSubtopics.add("Methods in Java");
        javaSubtopics.add("Constructors");
        javaSubtopics.add("Exception Handling");
        javaSubtopics.add("Inheritance and Abstract Class");
        javaSubtopics.add("Java Packages");
        javaSubtopics.add("Multithreading");
        javaSubtopics.add("File Handling");
        javaSubtopics.add("Collection in Java");

        List<String> pythonSubtopics = new ArrayList<>();
        pythonSubtopics.add("Variables");
        pythonSubtopics.add("Operators");
        pythonSubtopics.add("Data Types");
        pythonSubtopics.add("Control Flow");
        pythonSubtopics.add("Loops");
        pythonSubtopics.add("Functions");
        pythonSubtopics.add("Modules");
        pythonSubtopics.add("Exception Handling");
        pythonSubtopics.add("Libraries");

        List<String> sqlSubtopics = new ArrayList<>();
        sqlSubtopics.add("Clauses/Operators");
        sqlSubtopics.add("Functions");
        sqlSubtopics.add("SQL Queries");
        sqlSubtopics.add("Injection");
        sqlSubtopics.add("PL-SQL");
        sqlSubtopics.add("Joins");
        sqlSubtopics.add("MySql");

        // Map headers to their subtopics
        listHashMap.put(listDataHeader.get(0), cSubtopics);
        listHashMap.put(listDataHeader.get(1), cppSubtopics);
        listHashMap.put(listDataHeader.get(2), javaSubtopics);
        listHashMap.put(listDataHeader.get(3), pythonSubtopics);
        listHashMap.put(listDataHeader.get(4), sqlSubtopics);
    }
}
