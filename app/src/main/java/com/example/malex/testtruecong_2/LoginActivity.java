package com.example.malex.testtruecong_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class LoginActivity extends AppCompatActivity {
    private EditText text_name;
    private EditText text_password;
    private LinearLayout button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        text_name  = (EditText)findViewById(R.id.et_name);
        text_password  = (EditText)findViewById(R.id.et_password);
        button = (LinearLayout)findViewById(R.id.btn_login_ll);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });


    }
}
