package com.example.asyncproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class Task2 extends AppCompatActivity {

    TextView textView;
    private boolean isLogin;
    private int tasks;
    Button button;
    Random random;
    ProgressBar progressBar;
    private boolean isSuccess;
    final Object object = new Object();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.task2TextView);
        button = findViewById(R.id.task2button);
        button.setOnClickListener(l -> {
            tasks = 2;
            progressBar.setVisibility(ProgressBar.VISIBLE);
            textView.setVisibility(View.INVISIBLE);
            new Download().execute();
            new Login().execute();
        });
    }

    public void taskDone(){
       //    Context context =get
        progressBar.setVisibility(ProgressBar.INVISIBLE);
        textView.setVisibility(View.VISIBLE);
        if(isSuccess && isLogin){
            textView.setTextColor(Color.GREEN);
            textView.setText("Successful");
        }else {
            textView.setTextColor(Color.RED);
            textView.setText("Unsuccessful");
        }
    }

    public class Login extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Void... voids) {
             random = new Random(System.currentTimeMillis());
            try {
                Thread.sleep((random.nextInt(3) + 3) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return random.nextBoolean();
            //return null;
        }

        public void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            isLogin = aBoolean;

            synchronized (object) {
                tasks -= 1;
                if (tasks == 0) {
                    taskDone();
                }
            }
        }
    }





public class Download extends AsyncTask<Void, Void, Boolean> {


    @Override
    protected Boolean doInBackground(Void... voids) {
         random = new Random(System.currentTimeMillis());
        try {
            Thread.sleep((random.nextInt(4) + 2) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return random.nextBoolean();
        //return null;
    }

    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        isSuccess = aBoolean;

        synchronized (object) {
            tasks -= 1;
            if (tasks == 0) {
                taskDone();
            }
        }

    }
}


}
