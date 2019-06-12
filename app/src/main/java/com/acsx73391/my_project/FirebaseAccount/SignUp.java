package com.acsx73391.my_project.FirebaseAccount;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.acsx73391.my_project.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    Button btnSignup;
    TextView btnLogin,btnForgotPass;
    TextInputEditText input_email,input_pass;
    RelativeLayout activity_sign_up;

    private FirebaseAuth auth;
    Snackbar snackbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        btnSignup = findViewById(R.id.signup_btn_register);
        btnLogin = findViewById(R.id.signup_btn_login);
        input_email = findViewById(R.id.signup_email);
        input_pass = findViewById(R.id.signup_password);

        btnSignup.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnForgotPass.setOnClickListener(this);

        activity_sign_up = findViewById(R.id.activity_sign_up);
        auth = FirebaseAuth.getInstance();


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.signup_btn_login) {
            startActivity(new Intent(SignUp.this, Main2Activity.class));
            finish();
        }else if (v.getId() == R.id.signup_btn_register) {
            signUpUser(input_email.getText().toString().trim(),input_pass.getText().toString().trim());
        }
    }

    private void signUpUser(String email, String password) {
        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()){
                            snackbar = Snackbar.make(activity_sign_up,"error:"+task.getException(),Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                        else {
                            snackbar = Snackbar.make(activity_sign_up,"Register success",Snackbar.LENGTH_LONG);
                            snackbar.show();
                            startActivity(new Intent(SignUp.this, Main2Activity.class));
                        }
                    }
                });
    }
    }

