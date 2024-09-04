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

public class DILRActivity extends AppCompatActivity {
    private ExpandableListView listView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHashMap;
    private ExpandableListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dilractivity); // Assuming the layout is named activity_coding.xml
        listView = findViewById(R.id.lvDILR); // Replace with the correct ID if different

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
        listDataHeader.add("Tables and Charts");
        listDataHeader.add("Caselets");
        listDataHeader.add("Venn Diagrams");
        listDataHeader.add("Games and Tournaments");
        listDataHeader.add("Linear and Circular Arrangements");
        listDataHeader.add("Puzzles");
        listDataHeader.add("Logical Deductions");

        // Adding child data (subtopics)
        List<String> tablesAndChartsSubtopics = new ArrayList<>();
        tablesAndChartsSubtopics.add("Data Tables");
        tablesAndChartsSubtopics.add("Bar Charts");
        tablesAndChartsSubtopics.add("Pie Charts");
        tablesAndChartsSubtopics.add("Line Graphs");
        tablesAndChartsSubtopics.add("Scatter Plots");
        tablesAndChartsSubtopics.add("Mixed Graphs");

        List<String> caseletsSubtopics = new ArrayList<>();
        caseletsSubtopics.add("Tabular Data");
        caseletsSubtopics.add("Paragraph-based Data");
        caseletsSubtopics.add("Mixed Data Sets");

        List<String> vennDiagramsSubtopics = new ArrayList<>();
        vennDiagramsSubtopics.add("Two-set Venn Diagrams");
        vennDiagramsSubtopics.add("Three-set Venn Diagrams");
        vennDiagramsSubtopics.add("Logical Deduction using Venn Diagrams");

        List<String> gamesAndTournamentsSubtopics = new ArrayList<>();
        gamesAndTournamentsSubtopics.add("League-based Tournaments");
        gamesAndTournamentsSubtopics.add("Knockout Tournaments");
        gamesAndTournamentsSubtopics.add("Game-based Puzzle Solving");
        gamesAndTournamentsSubtopics.add("Ranking-based Puzzles");

        List<String> linearAndCircularArrangementsSubtopics = new ArrayList<>();
        linearAndCircularArrangementsSubtopics.add("Simple Linear Arrangement");
        linearAndCircularArrangementsSubtopics.add("Complex Linear Arrangement");
        linearAndCircularArrangementsSubtopics.add("Circular Arrangement");
        linearAndCircularArrangementsSubtopics.add("Double Line-up Problems");

        List<String> puzzlesSubtopics = new ArrayList<>();
        puzzlesSubtopics.add("Seating Arrangements");
        puzzlesSubtopics.add("Grid-based Puzzles");
        puzzlesSubtopics.add("Scheduling Puzzles");
        puzzlesSubtopics.add("Logical Sequence and Series");

        List<String> logicalDeductionsSubtopics = new ArrayList<>();
        logicalDeductionsSubtopics.add("Syllogisms");
        logicalDeductionsSubtopics.add("Logical Connectives");
        logicalDeductionsSubtopics.add("Statement and Conclusion");
        logicalDeductionsSubtopics.add("Cause and Effect");
        logicalDeductionsSubtopics.add("Assertion and Reason");

        // Map headers to their subtopics
        listHashMap.put(listDataHeader.get(0), tablesAndChartsSubtopics);
        listHashMap.put(listDataHeader.get(1), caseletsSubtopics);
        listHashMap.put(listDataHeader.get(2), vennDiagramsSubtopics);
        listHashMap.put(listDataHeader.get(3), gamesAndTournamentsSubtopics);
        listHashMap.put(listDataHeader.get(4), linearAndCircularArrangementsSubtopics);
        listHashMap.put(listDataHeader.get(5), puzzlesSubtopics);
        listHashMap.put(listDataHeader.get(6), logicalDeductionsSubtopics);
    }
}