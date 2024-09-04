package com.example.interviewprep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuantsActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHashMap;
    private ExpandableListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quants); // Assuming the layout is named activity_coding.xml
        listView = findViewById(R.id.lvQuants); // Replace with the correct ID if different

        // Prepare the list data
        initializeData();

        // Set the custom adapter
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHashMap);
        listView.setAdapter(listAdapter);
    }

    private void initializeData() {
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();

        // Adding headers (main topics)
        listDataHeader.add("Arithmetic");
        listDataHeader.add("Algebra");
        listDataHeader.add("Geometry");
        listDataHeader.add("Number Theory");
        listDataHeader.add("Probability");
        listDataHeader.add("Permutations and Combinations");
        listDataHeader.add("Data Interpretation");

        // Adding child data (subtopics)
        List<String> arithmeticSubtopics = new ArrayList<>();
        arithmeticSubtopics.add("Percentages");
        arithmeticSubtopics.add("Profit and Loss");
        arithmeticSubtopics.add("Simple and Compound Interest");
        arithmeticSubtopics.add("Ratio and Proportion");
        arithmeticSubtopics.add("Time and Work");
        arithmeticSubtopics.add("Speed, Distance, and Time");

        List<String> algebraSubtopics = new ArrayList<>();
        algebraSubtopics.add("Linear Equations");
        algebraSubtopics.add("Quadratic Equations");
        algebraSubtopics.add("Polynomials");
        algebraSubtopics.add("Inequalities");
        algebraSubtopics.add("Functions and Graphs");

        List<String> geometrySubtopics = new ArrayList<>();
        geometrySubtopics.add("Triangles");
        geometrySubtopics.add("Circles");
        geometrySubtopics.add("Quadrilaterals");
        geometrySubtopics.add("Mensuration");
        geometrySubtopics.add("Coordinate Geometry");

        List<String> numberTheorySubtopics = new ArrayList<>();
        numberTheorySubtopics.add("Divisibility Rules");
        numberTheorySubtopics.add("HCF and LCM");
        numberTheorySubtopics.add("Prime Numbers");
        numberTheorySubtopics.add("Modular Arithmetic");

        List<String> probabilitySubtopics = new ArrayList<>();
        probabilitySubtopics.add("Basic Probability");
        probabilitySubtopics.add("Conditional Probability");
        probabilitySubtopics.add("Bayes' Theorem");

        List<String> permutationsCombinationsSubtopics = new ArrayList<>();
        permutationsCombinationsSubtopics.add("Fundamental Principle of Counting");
        permutationsCombinationsSubtopics.add("Permutations");
        permutationsCombinationsSubtopics.add("Combinations");
        permutationsCombinationsSubtopics.add("Binomial Theorem");

        List<String> dataInterpretationSubtopics = new ArrayList<>();
        dataInterpretationSubtopics.add("Bar Graphs");
        dataInterpretationSubtopics.add("Pie Charts");
        dataInterpretationSubtopics.add("Line Graphs");
        dataInterpretationSubtopics.add("Tables");

        // Map headers to their subtopics
        listHashMap.put(listDataHeader.get(0), arithmeticSubtopics);
        listHashMap.put(listDataHeader.get(1), algebraSubtopics);
        listHashMap.put(listDataHeader.get(2), geometrySubtopics);
        listHashMap.put(listDataHeader.get(3), numberTheorySubtopics);
        listHashMap.put(listDataHeader.get(4), probabilitySubtopics);
        listHashMap.put(listDataHeader.get(5), permutationsCombinationsSubtopics);
        listHashMap.put(listDataHeader.get(6), dataInterpretationSubtopics);
    }
}