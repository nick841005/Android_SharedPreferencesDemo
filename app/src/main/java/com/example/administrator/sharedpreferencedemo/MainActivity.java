package com.example.administrator.sharedpreferencedemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String data = "DATA";
    private static final String name = "NAME";
    private static final String account = "ACCOUNT";
    private static final String password = "PASSWORD";

    private SharedPreferences settings;
    private EditText etName = null;
    private EditText etAccount = null;
    private EditText etPassword = null;
    private TextView tvLog = null;
    private Button btnSave = null;
    private Button btnClear = null;
    private Button btnRead = null;
    private String msg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCompoment();

        msg = tvLog.getText().toString();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                tvLog.setText(msg + "Save Successfully!");
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etAccount.setText("");
                etPassword.setText("");
                tvLog.setText(msg);
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readData();
                tvLog.setText(msg + "Read Successfully!");
            }
        });
    }

    private void initCompoment() {
        etName = (EditText) findViewById(R.id.etName);
        etAccount = (EditText) findViewById(R.id.etAccount);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvLog = (TextView) findViewById(R.id.tvLog);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnRead = (Button) findViewById(R.id.btnRead);
    }

    private void saveData() {
        settings = getSharedPreferences(data, MODE_PRIVATE);
        settings.edit()
                .putString(name, etName.getText().toString())
                .putString(account, etAccount.getText().toString())
                .putString(password, etPassword.getText().toString())
                .commit();
    }

    private void readData() {
        settings = getSharedPreferences(data, MODE_PRIVATE);
        etName.setText(settings.getString(name,""));
        etAccount.setText(settings.getString(account,""));
        etPassword.setText(settings.getString(password,""));
    }
}
