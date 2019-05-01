package com.journaldev.androidjnibasics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    Button btnJNI, btnJNIStringArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        btnJNI = findViewById(R.id.btnJni);
        btnJNIStringArray = findViewById(R.id.btnJniStringArray);
        btnJNI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = sendYourName("Anupam", "Chugh");
                Toast.makeText(getApplicationContext(), "Result from JNI is " + result, Toast.LENGTH_LONG).show();
            }
        });

        btnJNIStringArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = stringArrayFromJNI();

                Toast.makeText(getApplicationContext(), "First element is "+strings[0], Toast.LENGTH_LONG).show();

            }
        });

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native String sendYourName(String firstName, String lastName);
    public native String[] stringArrayFromJNI();


}
