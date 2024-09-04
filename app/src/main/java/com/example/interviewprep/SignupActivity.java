package com.example.interviewprep;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class SignupActivity extends AppCompatActivity {
    private EditText etname, etage, etemail, etinstitution, etpass, etconpass;
    private CheckBox Checkbox;
    private static final String TAG = "SignupActivity";
    private Button Signup;
    private FirebaseAuth auth;
    private DatabaseReference referenceprofile;
    private DatePickerDialog picker;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize FirebaseAuth instance
        auth = FirebaseAuth.getInstance();

        // Initialize UI elements
        etname = findViewById(R.id.etfullname);
        etage = findViewById(R.id.etdob);
        etemail = findViewById(R.id.etsignupemail);
        etinstitution = findViewById(R.id.etsignupinstitution);
        etpass = findViewById(R.id.etsignuppassword);
        etconpass = findViewById(R.id.etsignupconpassword);
        Checkbox = findViewById(R.id.checkbox);
        TextView login = findViewById(R.id.tvlogin);
        Signup = findViewById(R.id.btnsignup);

        etage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final Calendar calendar = Calendar.getInstance();
               int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(SignupActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        etage.setText(dayOfMonth + "/" + (month+1)+ "/"+ year);
                    }
                }, year, month, day);
                picker.show();
            }
        });

        // Setup click listeners
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Fullname = etname.getText().toString();
                String Age = etage.getText().toString();
                String Email = etemail.getText().toString();
                String Institution = etinstitution.getText().toString();
                String Password = etpass.getText().toString();
                String ConPassword = etconpass.getText().toString();

                if (validateInputs(Fullname, Email, Age, Institution, Password, ConPassword)) {
                    registerUser(Fullname, Email, Age, Institution, Password);
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }

    private boolean validateInputs(String Fullname, String Email, String Age, String Institution, String Password, String ConPassword) {
        if (TextUtils.isEmpty(Fullname)) {
            etname.setError("Full name is required");
            etname.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(Email)) {
            etemail.setError("Email is required");
            etemail.requestFocus();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            etemail.setError("Valid email is required");
            etemail.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(Age)) {
            etage.setError("Age is required");
            etage.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(Institution)) {
            etinstitution.setError("Institution name is required");
            etinstitution.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(Password)) {
            etpass.setError("Password is required");
            etpass.requestFocus();
            return false;
        } else if (Password.length() < 6) {
            etpass.setError("Password should be at least 6 characters");
            etpass.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(ConPassword)) {
            etconpass.setError("Password confirmation is required");
            etconpass.requestFocus();
            return false;
        } else if (!Password.equals(ConPassword)) {
            etconpass.setError("Passwords do not match");
            etconpass.requestFocus();
            return false;
        }
        return true;
    }

    private void registerUser(String Fullname, String Email, String Age, String Institution, String Password) {
        auth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(SignupActivity.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            //Update display name of user
                            UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(Fullname).build();
                            firebaseUser.updateProfile(profileChangeRequest);
                            if (firebaseUser != null) {
                                Log.d(TAG, "User UID: " + firebaseUser.getUid());

                                // Initialize database reference
                                referenceprofile = FirebaseDatabase.getInstance().getReference("Registered Users");

                                // Create a new user details object
                                ReadWriteuserdetails writeuserdetails = new ReadWriteuserdetails(Email, Age, Institution, Password);

                                // Save user details in the database
                                referenceprofile.child(firebaseUser.getUid()).setValue(writeuserdetails)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    firebaseUser.sendEmailVerification();
                                                    Toast.makeText(SignupActivity.this, "User registered successfully. Please verify your email.", Toast.LENGTH_LONG).show();

                                                    // Redirect to LoginActivity
                                                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                                            Intent.FLAG_ACTIVITY_NEW_TASK);
                                                    startActivity(intent);
                                                    finish();
                                                } else {
                                                    Log.e(TAG, "Database write failed: " + task.getException());
                                                    Toast.makeText(SignupActivity.this, "User registration failed. Please try again.", Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        });
                            }
                        } else {
                            handleSignupException(task.getException());
                        }
                    }
                });
    }

    private void handleSignupException(Exception e) {
        if (e instanceof FirebaseAuthWeakPasswordException) {
            etpass.setError("Your password is too weak. Kindly create a stronger password.");
            etpass.requestFocus();
        } else if (e instanceof FirebaseAuthInvalidCredentialsException) {
            etemail.setError("Your email is invalid or already in use. Kindly re-enter.");
            etemail.requestFocus();
        } else if (e instanceof FirebaseAuthUserCollisionException) {
            etemail.setError("Email already registered.");
            etemail.requestFocus();
        } else {
            Log.e(TAG, e.getMessage());
            Toast.makeText(SignupActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
