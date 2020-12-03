package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.Submit);
        btn2 = findViewById(R.id.Retrieve);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Submit:
                Intent intent = new Intent(this.getApplicationContext(), AddBook.class);
                this.startActivity(intent);
                break;
            case R.id.Retrieve:
                Intent intent1 = new Intent(this.getApplicationContext(), RetrieveBook.class);
                this.startActivity(intent1);
                break;


        }

    }

}
