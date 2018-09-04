package com.journaldev.androidexpressobasics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText inUsername, inNumber, inConfirmNumber;
    Button btnLogin;
    TextView txtLoginResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inUsername = findViewById(R.id.inUsername);
        inNumber = findViewById(R.id.inNumber);
        inConfirmNumber = findViewById(R.id.inConfirmNumber);

        btnLogin = findViewById(R.id.btnLogin);
        txtLoginResult = findViewById(R.id.txtLoginResult);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(inNumber.getText()))
                    Toast.makeText(getApplicationContext(), R.string.number_empty, Toast.LENGTH_SHORT).show();
                else if (!(inNumber.getText().toString().equals(inConfirmNumber.getText().toString())))
                    Toast.makeText(getApplicationContext(), R.string.toast_error, Toast.LENGTH_SHORT).show();
                else if (inUsername.getText().toString().trim().length() == 0)
                    Toast.makeText(getApplicationContext(), R.string.username_empty, Toast.LENGTH_SHORT).show();
                else
                    txtLoginResult.setText("Hello " + inUsername.getText().toString().trim());

            }
        });
    }
}
