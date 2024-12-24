package com.example.lab5;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AlertDialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class TestFragment extends Fragment {

    public TestFragment() {
        // Required empty public constructor
    }
    private Button buttonAnswer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        buttonAnswer = (Button) view.findViewById(R.id.buttonAnswer);
        String[] food={"Арбуз", "Яблоко", "Груша"};
        boolean[] food_c ={false, false, false};

        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Что НЕ является фруктом?")
                        .setMultiChoiceItems(food, food_c, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                food_c[i]=b;
                            }
                        })
                        .setPositiveButton("Проверить", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (food_c[0] && !food_c[1] && !food_c[2]){
                                    Toast mytost = Toast.makeText(getContext().getApplicationContext(), "Верно!", Toast.LENGTH_LONG);
                                    mytost.show();
                                }
                                else{
                                    Toast mytost = Toast.makeText(getContext().getApplicationContext(), "Неверно!", Toast.LENGTH_LONG);
                                    mytost.show();
                                }
                            }
                        })
                        .setCancelable(false);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}