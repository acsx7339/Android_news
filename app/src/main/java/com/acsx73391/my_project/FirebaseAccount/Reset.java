package com.acsx73391.my_project.FirebaseAccount;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.acsx73391.my_project.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class Reset extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText input_email;
    public Button btnResetPass;
    public TextView btnBack;
    public RelativeLayout activity_forgot;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        input_email = findViewById(R.id.forgot_email);
        btnResetPass = findViewById(R.id.forgot_btn_reset);
        btnBack = findViewById(R.id.forgot_btn_back);
        activity_forgot = findViewById(R.id.activity_forgot);

        btnResetPass.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.forgot_btn_back) {
            
            startActivity(new Intent(this,Main2Activity.class));
            finish();
        } else if (v.getId() == R.id.forgot_btn_reset) {
            resetPassword(input_email.getText().toString());
        }
    }

    private void resetPassword(final String email) {
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            Snackbar snackbar = Snackbar.make(activity_forgot,"you can check email from: "+email,Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }else {

                            Snackbar snackbar = Snackbar.make(activity_forgot,"Failed to send email "+email,Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    }
                });
    }
}
