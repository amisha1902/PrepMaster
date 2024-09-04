package com.example.interviewprep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.AlertDialog;
import de.hdodenhof.circleimageview.CircleImageView;

public class DashboardActivity extends AppCompatActivity {
    ImageView HR, DSA, Coding, Quants, DILR, Verbal;
    ImageButton Home, Profile, Settings, Options, TakeTest;
    CircleImageView Bot;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize the views
        HR = findViewById(R.id.hr);
        DSA = findViewById(R.id.dsa);
        Coding = findViewById(R.id.lang);
        Quants = findViewById(R.id.quants);
        DILR = findViewById(R.id.logical);
        Verbal = findViewById(R.id.verbal);
        Home = findViewById(R.id.homedash);
        Settings = findViewById(R.id.settings);
        Profile = findViewById(R.id.profile);
        Options = findViewById(R.id.options);
        TakeTest = findViewById(R.id.test);
        Bot = findViewById(R.id.bot);

        // Set the click listeners
        HR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, HRActivity.class);
                startActivity(i);
            }
        });
        Coding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, CodingActivity.class);
                startActivity(i);
            }
        });
        DSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, DSAActivity.class);
                startActivity(i);
            }
        });
        Quants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, QuantsActivity.class);
                startActivity(i);
            }
        });
        DILR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, DILRActivity.class);
                startActivity(i);
            }
        });
        Verbal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, VerbalActivity.class);
                startActivity(i);
            }
        });

        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, UsersProfileActivity.class);
                startActivity(i);
            }
        });

        // Settings button listener
        Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the custom dialog layout
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_settings, null);

                // Create the AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
                builder.setView(dialogView);

                // Find the button in the dialog layout
                Button btnSignOut = dialogView.findViewById(R.id.btn_signout);

                // Create and show the dialog
                AlertDialog dialog = builder.create();
                dialog.show();

                // Set the onClickListener for the sign-out button
                btnSignOut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Redirect to LoginActivity
                        Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
                        startActivity(intent);
                        // Optionally, finish the current activity
                        finish();
                    }
                });
            }
        });
    }
}
