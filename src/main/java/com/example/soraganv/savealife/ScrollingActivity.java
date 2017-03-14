package com.example.soraganv.savealife;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ScrollingActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progressStatus = 0, CurrValue = 20;
    private TextView textView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        progressBar = (ProgressBar) findViewById(R.id.progressBar8);
        textView = (TextView) findViewById(R.id.textView4);
        progressBar.setScaleY(3f);
        // Start long running operation in a background thread
        Progress();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Number is copied to clipboard", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent i2 = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(i2);
                ClipboardManager clipboard = (ClipboardManager)
                        getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("simple text", "8147889980");
                clipboard.setPrimaryClip(clip);
            }
        });

    }

    public void Progress(){
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < CurrValue) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            textView.setText(progressStatus+"/"+progressBar.getMax());
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        //Just to display the progress slowly
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
