package com.journaldev.androidautosizingtextview;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtAutoSizeTextViewDynamic = findViewById(R.id.autoTextViewDynamic);
        final TextView textView = findViewById(R.id.textView);
        EditText editText = findViewById(R.id.editText);
        EditText editTextWithPresetChanges = findViewById(R.id.editTextPreset);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                txtAutoSizeTextViewDynamic.setText(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        editTextWithPresetChanges.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(textView, getResources().getIntArray(R.array.autosize), TypedValue.COMPLEX_UNIT_SP);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                textView.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}
