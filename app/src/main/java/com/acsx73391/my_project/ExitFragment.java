package com.acsx73391.my_project;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExitFragment extends Fragment implements View.OnClickListener {
    private Button btnExit;

    private FirebaseAuth auth = FirebaseAuth.getInstance();


    public ExitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exit, container, false);
        btnExit = view.findViewById(R.id.exit);
        btnExit.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.exit) {
            exitApp();
        }
    }

    private void exitApp() {
        getActivity().moveTaskToBack(true);
        getActivity().finish();

    }
}
