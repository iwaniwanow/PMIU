package com.example.asyncproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button taskOne;
    Button taskTwo;
    EditText editText;
    FragmentManager manager;
    public static final String PROGRESS_FRAGMENT_TAG = "progress";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        taskOne = findViewById(R.id.task1button);
        taskTwo = findViewById(R.id.task2button);
        manager = getSupportFragmentManager();

        taskOne.setOnClickListener(l -> {
            String userInput = editText.getText().toString();
            if (!userInput.isEmpty()) {
                textView.setVisibility(View.INVISIBLE);
                new Progress().execute(Integer.parseInt(editText.getText().toString()));
            }
        });

        taskTwo.setOnClickListener(l -> {
                Intent intent = new Intent(MainActivity.this,Task2.class);
                startActivity(intent);

        });

    }

    private class Progress extends AsyncTask<Integer, Integer, Void> {

        private taskOne_fragment taskOneFragment;

        protected void onPreExecute() {
            super.onPreExecute();
            taskOneFragment = taskOneFragment.newInstance();
            taskOneFragment.show(manager, PROGRESS_FRAGMENT_TAG);
        }


        protected Void doInBackground(Integer... integers) {
            while (integers[0] > 0) {
                publishProgress(integers[0]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                integers[0] -= 1;
            }
            return null;
        }


        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            taskOneFragment.setTextView(String.valueOf(values[0]));
        }


        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            taskOneFragment.dismiss();
            textView.setText("Success");
            textView.setTextColor(Color.GREEN);
            textView.setVisibility(View.VISIBLE);
        }
    }

}
