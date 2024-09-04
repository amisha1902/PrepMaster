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

public class HRActivity extends AppCompatActivity {
    private ExpandableListView listView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHashMap;
    private ExpandableListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hractivity); // Assuming the layout is named activity_coding.xml
        listView = findViewById(R.id.lvHR); // Replace with the correct ID if different

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
        listDataHeader.add("Self-Introduction");
        listDataHeader.add("Strengths and Weaknesses");
        listDataHeader.add("Career Goals");
        listDataHeader.add("Teamwork and Leadership");
        listDataHeader.add("Conflict Resolution");
        listDataHeader.add("Problem-Solving Skills");
        listDataHeader.add("Company Research");

        // Adding child data (subtopics)
        List<String> selfIntroductionSubtopics = new ArrayList<>();
        selfIntroductionSubtopics.add("Personal Background");
        selfIntroductionSubtopics.add("Professional Experience");
        selfIntroductionSubtopics.add("Educational Qualifications");
        selfIntroductionSubtopics.add("Achievements");

        List<String> strengthsWeaknessesSubtopics = new ArrayList<>();
        strengthsWeaknessesSubtopics.add("Key Strengths");
        strengthsWeaknessesSubtopics.add("Areas for Improvement");
        strengthsWeaknessesSubtopics.add("How to Improve Weaknesses");
        strengthsWeaknessesSubtopics.add("Examples of Strengths and Weaknesses");

        List<String> careerGoalsSubtopics = new ArrayList<>();
        careerGoalsSubtopics.add("Short-term Goals");
        careerGoalsSubtopics.add("Long-term Goals");
        careerGoalsSubtopics.add("Alignment with Company Goals");
        careerGoalsSubtopics.add("Career Development Plans");

        List<String> teamworkLeadershipSubtopics = new ArrayList<>();
        teamworkLeadershipSubtopics.add("Experience Working in Teams");
        teamworkLeadershipSubtopics.add("Leadership Roles Taken");
        teamworkLeadershipSubtopics.add("Examples of Teamwork Successes");
        teamworkLeadershipSubtopics.add("Challenges Faced in Leadership");

        List<String> conflictResolutionSubtopics = new ArrayList<>();
        conflictResolutionSubtopics.add("Past Conflicts and Resolutions");
        conflictResolutionSubtopics.add("Approach to Handling Disputes");
        conflictResolutionSubtopics.add("Examples of Conflict Management");
        conflictResolutionSubtopics.add("Techniques Used for Resolution");

        List<String> problemSolvingSkillsSubtopics = new ArrayList<>();
        problemSolvingSkillsSubtopics.add("Examples of Problem Solving");
        problemSolvingSkillsSubtopics.add("Analytical Skills Demonstrated");
        problemSolvingSkillsSubtopics.add("Creative Solutions Provided");
        problemSolvingSkillsSubtopics.add("Decision-Making Process");

        List<String> companyResearchSubtopics = new ArrayList<>();
        companyResearchSubtopics.add("Company Background");
        companyResearchSubtopics.add("Company Culture and Values");
        companyResearchSubtopics.add("Recent News and Developments");
        companyResearchSubtopics.add("Understanding the Job Role");

        // Map headers to their subtopics
        listHashMap.put(listDataHeader.get(0), selfIntroductionSubtopics);
        listHashMap.put(listDataHeader.get(1), strengthsWeaknessesSubtopics);
        listHashMap.put(listDataHeader.get(2), careerGoalsSubtopics);
        listHashMap.put(listDataHeader.get(3), teamworkLeadershipSubtopics);
        listHashMap.put(listDataHeader.get(4), conflictResolutionSubtopics);
        listHashMap.put(listDataHeader.get(5), problemSolvingSkillsSubtopics);
        listHashMap.put(listDataHeader.get(6), companyResearchSubtopics);
    }
}