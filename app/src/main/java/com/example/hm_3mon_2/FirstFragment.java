package com.example.hm_3mon_2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstFragment extends Fragment {

    private EditText etFirst, etSecond;

    private Button btnFirst, btnSecond;
    static String first;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findId();
        onClick();
    }

    private void findId() {
        etFirst = requireActivity().findViewById(R.id.et_first);
        etSecond = requireActivity().findViewById(R.id.et_second);
        btnFirst = requireActivity().findViewById(R.id.btn_first);
        btnSecond = requireActivity().findViewById(R.id.btn_second);
    }

    private void onClick() {
//        btnFirst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!etFirst.getText().toString().isEmpty()) {
//                    navigateToSecondFragmentBtnFirst();
//                }
//            });
//         btnSecond.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick (View view){
//                if (!etSecond.getText().toString().isEmpty()) navigateToSecondFragmentBtnSecond();
//            });
//            }
//
        first = etFirst.getText().toString();
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToSecondFragmentBtnFirst();

            }
        });
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToSecondFragmentBtnSecond();
            }
        });


    }


    private void navigateToSecondFragmentBtnSecond() {
        String second = etSecond.getText().toString();

        FirstFragment firstFragment = new FirstFragment();

        Bundle bundle = new Bundle();
        bundle.putString("second", second);
        firstFragment.setArguments(bundle);

        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction().replace(R.id.tv_container, new TrerdFragment())
                .commit();
    }


    private void navigateToSecondFragmentBtnFirst() {
        SecondFragment firstFragment = new SecondFragment();

        Bundle bundle = new Bundle();
        bundle.putString("first", first);
        firstFragment.setArguments(bundle);

        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.tv_container, new SecondFragment()).addToBackStack(null)
                .commit();
    }
}