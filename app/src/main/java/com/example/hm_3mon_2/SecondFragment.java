package com.example.hm_3mon_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    private TextView first, second;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findId();
        getBundle();
    }

    private void findId() {
        first = requireActivity().findViewById(R.id.text_second);
        second = requireActivity().findViewById(R.id.text_therd);
    }

    private void getBundle() {
        if (getArguments() != null){
            first.setText(getArguments().getString("first"));
            second.setText(getArguments().getString("second"));
        }
    }
}