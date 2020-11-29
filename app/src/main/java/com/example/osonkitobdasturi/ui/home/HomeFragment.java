package com.example.osonkitobdasturi.ui.home;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.osonkitobdasturi.R;

import java.util.Random;

public class HomeFragment extends Fragment {
    Random random;
    String[] names;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        random = new Random();
        names = getResources().getStringArray(R.array.names);
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        final Button button = root.findViewById(R.id.btn_next);
        final Button button1 = root.findViewById(R.id.btn_copy);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_next:
                        int randomIndex = new Random().nextInt(names.length);
                        String randomName = names[randomIndex];
                        textView.setText(randomName);
                        break;
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_copy:
                        ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService (Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("label", textView.getText().toString());
                        clipboard.setPrimaryClip(clip);
                        Toast toast = Toast.makeText(getActivity(),
                                "Nusxa olindi !", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                }
            }
        });

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}