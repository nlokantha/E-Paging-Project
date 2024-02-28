package com.example.e_pagingproject.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.e_pagingproject.R;
import com.example.e_pagingproject.databinding.FragmentMainBinding;
import com.example.e_pagingproject.models.User;


public class MainFragment extends Fragment {

    public MainFragment() {
        // Required empty public constructor
    }

    FragmentMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonUpdateBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.updateBoard();
            }
        });

        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String guestName = binding.editTextGuestName.getText().toString();
                String flightNumber = binding.editTextFlightNumber.getText().toString();
                String arrivalTime = binding.editTextArrivalTime.getText().toString();

                if (guestName.isEmpty()) {
                    Toast.makeText(getContext(), "Enter Guest Name ", Toast.LENGTH_SHORT).show();
                } else if (flightNumber.isEmpty()) {
                    Toast.makeText(getContext(), "Enter Flight Number ", Toast.LENGTH_SHORT).show();
                } else if (arrivalTime.isEmpty()) {
                    Toast.makeText(getContext(), "Enter Arrival Time ", Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User(guestName, flightNumber, arrivalTime);
                    mListener.saveUser(user);
                }
            }
        });

        binding.buttonDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoUserFragment();
            }
        });
    }

    MainListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mListener = (MainListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement MainListener ");
        }
    }

    public interface MainListener {
        void gotoUserFragment();

        void updateBoard();

        void saveUser(User user);
    }
}