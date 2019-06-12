package com.acsx73391.my_project.FirebaseAccount;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.acsx73391.my_project.DashBoard;
import com.acsx73391.my_project.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    EditText input_email,input_password;
    TextView btnsignup,btnForgotPass;
    RelativeLayout activity_main;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnLogin = findViewById(R.id.login_btn_login);
        input_email = findViewById(R.id.login_email);
        input_password = findViewById(R.id.login_password);
        btnsignup = findViewById(R.id.login_btn_signup);
        btnForgotPass = findViewById(R.id.login_btn_forgot_password);
        btnsignup.setOnClickListener(this);
        btnForgotPass.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

        activity_main = findViewById(R.id.activity_main2);
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(Main2Activity.this, DashBoard.class));
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_btn_forgot_password) {
            startActivity(new Intent(Main2Activity.this, Reset.class));
            finish();
        }else if (v.getId() == R.id.login_btn_signup) {
            startActivity(new Intent(Main2Activity.this, SignUp.class));
            finish();
        }else  if (v.getId() == R.id.login_btn_login) {
            loginUser(input_email.getText().toString().trim(),input_password.getText().toString().trim());
        }
    }
    private void loginUser(final String email, final String password) {
        auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Snackbar snackbar = Snackbar.make(activity_main,"Login failed ",Snackbar.LENGTH_SHORT);
                            snackbar.show();

                        }else if (email.isEmpty()&&email == null){
                            Snackbar snackbar = Snackbar.make(activity_main,"Login failed ",Snackbar.LENGTH_SHORT);
                            snackbar.show();
                        } else if (password.isEmpty()&&password == null) {
                            Snackbar snackbar = Snackbar.make(activity_main,"Login failed ",Snackbar.LENGTH_SHORT);
                            snackbar.show();
                        } else {
                            startActivity(new Intent(Main2Activity.this, DashBoard.class));
                        }
                    }
                });
    }

}
