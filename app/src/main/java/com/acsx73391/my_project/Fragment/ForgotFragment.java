package com.acsx73391.my_project.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.acsx73391.my_project.FirebaseAccount.Main2Activity;
import com.acsx73391.my_project.R;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotFragment extends Fragment implements View.OnClickListener {

    private Button btnChangePass;

    private FirebaseAuth auth=FirebaseAuth.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_change_password,container,false);

        btnChangePass = view.findViewById(R.id.dashboard_btn_change_pass);
        btnChangePass.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.dashboard_btn_change_pass) {
            logoutUser();
    }
}

    private void logoutUser() {
        auth.signOut();
        if (auth.getCurrentUser() == null) {
            Intent intent = new Intent(getActivity(), Main2Activity.class);
            startActivity(intent);
        }
    }
}
