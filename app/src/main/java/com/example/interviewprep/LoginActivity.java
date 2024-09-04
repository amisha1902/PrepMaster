package com.example.interviewprep;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private TextView signup, forgotpass;
    private EditText email, password;
   private Button Login, contwithgoogle;
   private ProgressBar Progressbar;
   private FirebaseAuth authProfile;
   private  static final String TAG = "LoginActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
forgotpass = findViewById(R.id.tvforgotpass);
email= findViewById(R.id.etloginemail);
password = findViewById(R.id.etloginpassword);
Login=findViewById(R.id.btnlogincontinue);
contwithgoogle= findViewById(R.id.btnlogingoogle);
Progressbar = findViewById(R.id.progressbar);
authProfile = FirebaseAuth.getInstance();
ImageView imageViewShowHidePwd = findViewById(R.id.imgpass);
imageViewShowHidePwd.setImageResource(R.drawable.ic_hide_pwd);
imageViewShowHidePwd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (password.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            imageViewShowHidePwd.setImageResource(R.drawable.ic_hide_pwd);
        }else {
            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            imageViewShowHidePwd.setImageResource(R.drawable.ic_show_pwd);

        }
    }
});
        signup = findViewById(R.id.tvloginsignup);
        Progressbar.setVisibility(View.GONE);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email= email.getText().toString();
                String Password=password.getText().toString();
                Login.setEnabled(false);
                if(TextUtils.isEmpty(Email)){
                    Progressbar.setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this, "Please enter your valid email", Toast.LENGTH_SHORT).show();
                    email.setError("Email is required");
                    email.requestFocus();
                    Login.setEnabled(true);
                } else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                    Progressbar.setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this,"Please re-enter your email", Toast.LENGTH_LONG).show();
                    email.setError("Valid email is required");
                    email.requestFocus(2000);
                    Login.setEnabled(true);
                } else if (TextUtils.isEmpty(Password)) {
                    Progressbar.setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this, "Please enter your password", Toast.LENGTH_LONG).show();
                    password.setError("Password is required");
                    password.requestFocus();
                    Login.setEnabled(true);
                }else {
                    Progressbar.setVisibility(View.VISIBLE);

                    loginUser(Email, Password);
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });
    }

    private void loginUser(String EMAIL, String PASS) {
        authProfile.signInWithEmailAndPassword(EMAIL, PASS).addOnCompleteListener(LoginActivity.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Progressbar.setVisibility(View.GONE);
//                Login.setEnabled(true);
                if (task.isSuccessful()){
                    FirebaseUser firebaseUser = authProfile.getCurrentUser();

                    if (firebaseUser.isEmailVerified()){
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                        finish();


                    }else{
                        firebaseUser.sendEmailVerification();
                        authProfile.signOut();
                        showAlertDialog();
                    }

                }else {
                    try {
                        throw  task.getException();
                    }catch (FirebaseAuthInvalidUserException e){
                         email.setError("User does not exists.");
                         email.requestFocus();
                    }  catch (FirebaseAuthInvalidCredentialsException e) {
                        String errorCode = ((FirebaseAuthInvalidCredentialsException) task.getException()).getErrorCode();
                        if (errorCode.equals("ERROR_WRONG_PASSWORD")) {
                            password.setError("Incorrect password. Please try again.");
                            password.requestFocus();
                        } else {
                            email.setError("Invalid credentials. Please check your email and password.");
                            email.requestFocus();
                        }}
                    catch (Exception e){
                        Log.e(TAG, e.getMessage());
                        Toast.makeText(LoginActivity.this, e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                    Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this );
        builder.setTitle("Email not verified");
        builder.setMessage("Please verify your email. You can't login without email verification.");
        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              Intent intent = new Intent(Intent.ACTION_MAIN);
              intent.addCategory(Intent.CATEGORY_APP_EMAIL);
              intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              startActivity(intent);
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

//    @Override
//    protected void onStart() {
//      super.onStart();
//       if (authProfile.getCurrentUser() != null){
//           Toast.makeText(LoginActivity.this,"Already logged in", Toast.LENGTH_LONG).show();
//
//           //Start user profile
//           startActivity(new Intent(LoginActivity.this, UsersProfileActivity.class));
//           finish();
//       }else {
//            Toast.makeText(LoginActivity.this,"Enter your credentials to login", Toast.LENGTH_LONG).show();
//
//       }
//   }
}
