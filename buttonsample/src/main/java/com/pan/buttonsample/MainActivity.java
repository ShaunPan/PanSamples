package com.pan.buttonsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btn_1);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, R.string.Button_1, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void buttonTest(View view) {
        Toast.makeText(this, R.string.Button_2, Toast.LENGTH_SHORT).show();
    }
}
