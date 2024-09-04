package com.example.interviewprep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class VerbalActivity extends AppCompatActivity {
    private ExpandableListView listView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHashMap;
    private ExpandableListAdapter listAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbal); // Assuming the layout is named activity_coding.xml
        listView = findViewById(R.id.lvVerbal); // Replace with the correct ID if different

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
        listDataHeader.add("Reading Comprehension");
        listDataHeader.add("Vocabulary");
        listDataHeader.add("Grammar");
        listDataHeader.add("Sentence Correction");
        listDataHeader.add("Paragraph Formation");
        listDataHeader.add("Critical Reasoning");
        listDataHeader.add("Synonyms and Antonyms");

        // Adding child data (subtopics)
        List<String> readingComprehensionSubtopics = new ArrayList<>();
        readingComprehensionSubtopics.add("Main Idea");
        readingComprehensionSubtopics.add("Detail Questions");
        readingComprehensionSubtopics.add("Inference Questions");
        readingComprehensionSubtopics.add("Vocabulary in Context");

        List<String> vocabularySubtopics = new ArrayList<>();
        vocabularySubtopics.add("Word Meanings");
        vocabularySubtopics.add("Contextual Usage");
        vocabularySubtopics.add("Roots and Affixes");
        vocabularySubtopics.add("Idioms and Phrases");

        List<String> grammarSubtopics = new ArrayList<>();
        grammarSubtopics.add("Parts of Speech");
        grammarSubtopics.add("Tenses");
        grammarSubtopics.add("Subject-Verb Agreement");
        grammarSubtopics.add("Punctuation");

        List<String> sentenceCorrectionSubtopics = new ArrayList<>();
        sentenceCorrectionSubtopics.add("Error Identification");
        sentenceCorrectionSubtopics.add("Sentence Improvement");
        sentenceCorrectionSubtopics.add("Sentence Rewriting");
        sentenceCorrectionSubtopics.add("Common Errors");

        List<String> paragraphFormationSubtopics = new ArrayList<>();
        paragraphFormationSubtopics.add("Topic Sentences");
        paragraphFormationSubtopics.add("Supporting Details");
        paragraphFormationSubtopics.add("Coherence and Cohesion");
        paragraphFormationSubtopics.add("Conclusion Sentences");

        List<String> criticalReasoningSubtopics = new ArrayList<>();
        criticalReasoningSubtopics.add("Argument Analysis");
        criticalReasoningSubtopics.add("Logical Fallacies");
        criticalReasoningSubtopics.add("Assumptions");
        criticalReasoningSubtopics.add("Strengthening and Weakening Arguments");

        List<String> synonymsAntonymsSubtopics = new ArrayList<>();
        synonymsAntonymsSubtopics.add("Synonyms");
        synonymsAntonymsSubtopics.add("Antonyms");
        synonymsAntonymsSubtopics.add("Word Usage");
        synonymsAntonymsSubtopics.add("Commonly Confused Words");

        // Map headers to their subtopics
        listHashMap.put(listDataHeader.get(0), readingComprehensionSubtopics);
        listHashMap.put(listDataHeader.get(1), vocabularySubtopics);
        listHashMap.put(listDataHeader.get(2), grammarSubtopics);
        listHashMap.put(listDataHeader.get(3), sentenceCorrectionSubtopics);
        listHashMap.put(listDataHeader.get(4), paragraphFormationSubtopics);
        listHashMap.put(listDataHeader.get(5), criticalReasoningSubtopics);
        listHashMap.put(listDataHeader.get(6), synonymsAntonymsSubtopics);
    }
}