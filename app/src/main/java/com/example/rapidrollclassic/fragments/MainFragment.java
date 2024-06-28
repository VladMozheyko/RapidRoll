package com.example.rapidrollclassic.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rapidrollclassic.MainActivity;
import com.example.rapidrollclassic.R;

public class MainFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        ImageButton settingsButton = view.findViewById(R.id.main_settings_btn);
        settingsButton.setOnClickListener(v -> {
            if (getActivity() != null) {
                ((MainActivity) getActivity()).openSettingsFragment();
            }
        });

        return view;
    }
}
